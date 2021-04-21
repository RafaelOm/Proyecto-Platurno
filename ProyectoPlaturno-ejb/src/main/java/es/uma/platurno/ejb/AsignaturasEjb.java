package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Alumno;
import es.uma.platurno.jpa.Asignatura;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class AsignaturasEjb
 */
@Stateless
@LocalBean
public class AsignaturasEjb implements AsignaturasEjbInterfaz {

    @PersistenceContext(unitName = "Platurno-Asignatura")
    private EntityManager em;
    private Autenticacion auth;
    /**
     * Default constructor. 
     */
    public AsignaturasEjb() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Asignatura verAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException {
        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        Asignatura asig= em.find(Asignatura.class,a.getReferencia());
        if(asig==null){
            throw new AsignaturaInexsistenteException();
        }
        System.out.println(asig.toString());
        return asig;
    }

    @Override
    public void modificarAsignatura(Usuario u,Asignatura asignatura) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, ViolacionDeSeguridadException {
        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        auth.checkSecretariaRole(u);
        ////////////////////////////////////////////////////////////////

        Asignatura asig =em.find(Asignatura.class,asignatura.getReferencia());
        if(asig==null){
            throw new AsignaturaInexsistenteException();
        }

        em.merge(asig);

    }

    @Override
    public void eliminarAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, ViolacionDeSeguridadException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException {
        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        auth.checkSecretariaRole(u);
        ////////////////////////////////////////////////////////////////
        Asignatura asig= em.find(Asignatura.class,a.getReferencia());
        if(asig==null){
            throw new AsignaturaInexsistenteException();
        }
        em.remove(em.merge(asig));
    }
}
