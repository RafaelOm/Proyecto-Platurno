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

@Stateless
public class GruposEjb implements GruposEjbInterface {

    @PersistenceContext(unitName = "abc")
    private EntityManager em;
    @Inject
    private AutenticacionInterfaz auth;
    private static final Logger LOGGER = Logger.getLogger(GruposEjb.class.getCanonicalName());
    /**
     * Default constructor. 
     */
    public GruposEjb() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Asignatura verGrupo(Usuario u, String ref) throws PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, GrupoInexistenteException {
        //////Check if user is authenticated in the system  ////////////

        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        Asignatura asig= em.find(Asignatura.class,ref);
        if(asig==null){
            throw new GrupoInexistenteException();
        }
        System.out.println(asig.toString());
        return asig;
    }

    @Override
    public void modificarGrupo(Usuario u,Grupo grupo) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, ViolacionDeSeguridadException, GrupoInexistenteException, PasswordErroneaException {
        //////Check if user is authenticated in the system  ////////////

        auth.compruebaLogin(u);
        auth.checkSecretariaRole(u);
        ////////////////////////////////////////////////////////////////

        Asignatura grup =em.find(Asignatura.class,grupo.getId());
        if(grup==null){
            throw new GrupoInexistenteException();
        }
        
        em.merge(grupo);

    }

    @Override
    public void eliminarGrupo(Usuario u, Grupo g) throws ViolacionDeSeguridadException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException, GrupoInexistenteException {
        //////Check if user is authenticated in the system  ////////////

        auth.compruebaLogin(u);
        auth.checkSecretariaRole(u);
        ////////////////////////////////////////////////////////////////
        Grupo gr= em.find(Grupo.class,g.getId());
        if(gr==null){
            throw new GrupoInexistenteException();
        }
     //   em.merge(a);
        em.remove(em.merge(g));
    }
    
    @Override
    public List<Grupo> getAll() {
    	
    	Query query =em.createQuery("SELECT g FROM Grupo g");
    	List<Grupo> grupos =query.getResultList();
    	
    	LOGGER.info("LECTURA DE BD Grupo "+grupos.toString());
		return  grupos;
    	
    }
    @Override
    public void crearGrupo(Grupo nuevo,Usuario usuario) throws GrupoInexistenteException {
    	
    	try {
			auth.checkSecretariaRole(usuario);
		} catch (CuentaInexistenceException | ViolacionDeSeguridadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    		LOGGER.info("CREAR-GRUPO: PARAMETRO "+nuevo.toString()+" - USER TEST: " + usuario.toString());
    
    	Grupo g =em.find(Grupo.class, nuevo.getId());
    	
    	if(g!=null) {
    		throw new GrupoInexistenteException("EL GRUPO YA EXISTE, USUARIO SECRETARIA");
    	}
    		LOGGER.info("CREAR-GRUPO: "+nuevo.toString());
    	em.persist(nuevo);
    	
    	
    }
}
