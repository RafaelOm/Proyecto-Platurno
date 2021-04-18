package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Matricula;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UsuarioEjb
 */
@Stateless
@LocalBean
public class UsuarioEjb implements UsuarioEjbInterfaz {
    @PersistenceContext(unitName = "Platurno-Usuario")
    private EntityManager em;
    /**
     * Default constructor. 
     */
    public UsuarioEjb() {

    }


    @Override
    public void verUsuario(String username) throws CuentaInexistenceException {

        Usuario user =em.find(Usuario.class,username);
        if(user==null){
            throw new CuentaInexistenceException();
        }
        System.out.println(user.toString());
    }

    @Override
    public void modificarNombreyAppelidoUsuario(String username, String name, String surname) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException {
        Usuario user =em.find(Usuario.class,username);
        Autenticacion a =new Autenticacion();
        a.compruebaLogin(user);
        if(user==null){
            throw new CuentaInexistenceException();
        }
        user.setName(name);
        user.setSurname(surname);
        em.merge(user);



    }

    @Override
    public void modificarTelefonoUsuario(String username, String telefono) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException {
        Usuario user =em.find(Usuario.class,username);
        Autenticacion a =new Autenticacion();
        a.compruebaLogin(user);
        if(user==null){
            throw new CuentaInexistenceException();
        }
        user.setTelefono(telefono);
        em.merge(user);
    }

    @Override
    public void moficarClave(String username, String clave, String reClave) throws CuentaInexistenceException, ContrasenaigualException, ClavesDiferentesException, CuentaInactivaException, PlaturnoException, PasswordErroneaException {

        Usuario user =em.find(Usuario.class,username);
        Autenticacion a =new Autenticacion();
        a.compruebaLogin(user);
        if(user==null){
            throw new CuentaInexistenceException();
        }
        if(!clave.equals(reClave)){
            throw new ClavesDiferentesException();
        }
        if(user.getPassword().equals(clave)){
            throw new ContrasenaigualException();
        }
        user.setPassword(clave);

    }

    @Override
    public void eliminarUsuario(String username) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
        Autenticacion a =new Autenticacion();
        Usuario u =em.find(Usuario.class,username);
        a.compruebaLogin(u);
        em.remove(em.merge(a));

    }
}
