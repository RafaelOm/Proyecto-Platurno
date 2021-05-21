package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;

/**
 * Session Bean implementation class UsuarioEjb
 */

//Metodo realizado por Rafael Ordoñez Molina
@Stateless
public class UsuarioEjb implements UsuarioEjbInterfaz {
    @PersistenceContext(unitName = "abc")
    private EntityManager em;
    private Autenticacion auth;
    /**
     * Default constructor. 
     */

    public UsuarioEjb() {
    }

    public UsuarioEjb( String Dni) throws PlaturnoException, CuentaExistenteException {
        crearUsuarioFromCsvExcel(Dni);
    }


    //Proceso realizado por la aplicacion al realizar la accion de importar datos un usuario de secretaria
    @Override
    public void crearUsuarioFromCsvExcel(String dni) throws PlaturnoException, CuentaExistenteException {

        Usuario user=new Usuario();
        user.setUsername(dni);
        user.setPassword(generateRandomPassword(10));
        String u =null;
        auth.registrarUsuario(user,u);


    }

    @Override
    public Usuario verUsuario(Usuario u) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException {
        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        Usuario user =em.find(Usuario.class,u.getIdentificador());
        if(user==null){
            throw new CuentaInexistenceException();
        }
        System.out.println(user.toString());
        return user;
    }

    @Override
    public void modificar(Usuario u) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException {
        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        Usuario user =em.find(Usuario.class,u.getIdentificador());
        if(user==null){
            throw new CuentaInexistenceException();
        }
        user.setUsername(u.getUsername());
        em.merge(user);



    }



    @Override
    public void moficarClave(Usuario u) throws CuentaInexistenceException, ContrasenaigualException, ClavesDiferentesException, CuentaInactivaException, PlaturnoException, PasswordErroneaException {
        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////
        Usuario user =em.find(Usuario.class,u.getIdentificador());

        if(user==null){
            throw new CuentaInexistenceException();
        }

        if(user.getPassword().equals(u.getPassword())){
            throw new ContrasenaigualException();
        }
        user.setPassword(u.getPassword());
        em.merge(user);

    }

    @Override
    public void eliminarUsuario(Usuario u, Usuario Secretaria) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException, ViolacionDeSeguridadException {
        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(Secretaria);
        auth.checkSecretariaRole(Secretaria);
        ////////////////////////////////////////////////////////////////
        Usuario user =em.find(Usuario.class,u.getIdentificador());
        em.remove(em.merge(user));

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
