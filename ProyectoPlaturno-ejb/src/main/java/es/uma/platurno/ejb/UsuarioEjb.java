package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Matricula;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URL;
import java.security.SecureRandom;

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

    public UsuarioEjb( String Dni, String email, String telefono) throws PlaturnoException, CuentaExistenteException {
        crearUsuarioFromCsvExcel(Dni,email,telefono);
    }


    @Override
    public void crearUsuarioFromCsvExcel( String Dni, String email, String telefono) throws PlaturnoException, CuentaExistenteException {
        Autenticacion a =new Autenticacion();
        Usuario user = em.find(Usuario.class, Dni);
        if(user!=null){
            throw new CuentaExistenteException("La cuenta con DNI: "+Dni+"ya existe en el sistema");
        }
        user=new Usuario();
        user.setUsername(Dni);
        user.setPassword(generateRandomPassword(10));
        user.setDni(Dni);
        user.setEmailInstitucional(email);

        UriBuilder u =null;
        a.registrarUsuario(user,u);

    }

    @Override
    public Usuario verUsuario(String username) throws CuentaInexistenceException {

        Usuario user =em.find(Usuario.class,username);
        if(user==null){
            throw new CuentaInexistenceException();
        }
        System.out.println(user.toString());
        return user;
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
        em.remove(em.merge(u));

    }

    // Method to generate a random alphanumeric password of a specific length
    public  String generateRandomPassword(int len)
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
