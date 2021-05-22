package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class AsignaturasEjb
 */

//Metodo realizado por Rafael Ordoñez Molina
@Stateless
public class AsignaturasEjb implements AsignaturasEjbInterfaz {

    @PersistenceContext(unitName = "abc")
    private EntityManager em;
    @Inject
    private AutenticacionInterfaz auth;
    private static final Logger LOGGER = Logger.getLogger(AsignaturasEjb.class.getCanonicalName());
    /**
     * Default constructor. 
     */
    public AsignaturasEjb() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Asignatura verAsignatura(Usuario u, String ref) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException {
        //////Check if user is authenticated in the system  ////////////

        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        Asignatura asig= em.find(Asignatura.class,ref);
        if(asig==null){
            throw new AsignaturaInexsistenteException();
        }
        System.out.println(asig.toString());
        return asig;
    }

    @Override
    public void modificarAsignatura(Usuario u,Asignatura asignatura) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, ViolacionDeSeguridadException {
        //////Check if user is authenticated in the system  ////////////

        auth.compruebaLogin(u);
        auth.checkSecretariaRole(u);
        ////////////////////////////////////////////////////////////////

        Asignatura asig =em.find(Asignatura.class,asignatura.getReferencia());
        if(asig==null){
            throw new AsignaturaInexsistenteException();
        }
        
        em.merge(asignatura);

    }

    @Override
    public void eliminarAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, ViolacionDeSeguridadException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException {
        //////Check if user is authenticated in the system  ////////////

        auth.compruebaLogin(u);
        auth.checkSecretariaRole(u);
        ////////////////////////////////////////////////////////////////
        Asignatura asig= em.find(Asignatura.class,a.getReferencia());
        if(asig==null){
            throw new AsignaturaInexsistenteException();
        }
     //   em.merge(a);
        em.remove(em.merge(a));
    }
    
    @Override
    public List<Asignatura> getAll() {
    	/*
    	Asignatura asig =new Asignatura();
		asig.setReferencia("1234");
		asig.setNombre("CALCULO");
		asig.setOfertada("POR DESGRACIA");
		asig.setCreditos(6);
		asig.setCodigo(103);
		//asig.setTitulacion(tit);
		em.persist(asig);
		
		Asignatura asig1 =new Asignatura();
		asig1.setReferencia("123");
		asig1.setNombre("REDED");
		asig1.setOfertada("SI");
		asig1.setCreditos(6);
		asig1.setCodigo(206);
		em.persist(asig1);
		*/
    	
    	Query query =em.createQuery("SELECT a FROM Asignatura a");
    	List<Asignatura> asignaturas =query.getResultList();
    	LOGGER.info(asignaturas.toString());
		return  asignaturas;
    	
    }
}
