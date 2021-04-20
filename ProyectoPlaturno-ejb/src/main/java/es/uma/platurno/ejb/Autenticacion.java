package es.uma.platurno.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Random;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.*;

/**
 * Session Bean implementation class Autenticacion
 */
@Stateless
@LocalBean
public class Autenticacion implements AutenticacionInterfaz  {
    @PersistenceContext(unitName = "Platurno-Autenticacion")
    private EntityManager em;
    private static final int TAM_CADENA_VALIDACION = 64;
    private static final Logger LOGGER = Logger.getLogger(Autenticacion.class.getCanonicalName());

    /**
     * Default constructor. 
     */
    public Autenticacion() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void registrarUsuario(Usuario u, UriBuilder uribuilder) throws PlaturnoException, CuentaExistenteException {
        Usuario user =em.find(Usuario.class,u.getUsername());
        if(user!=null){
            throw new CuentaExistenteException("El usuario: "+user.getUsername()+" ya esta registrado, si no" +
                    "recuerda su clave puede recuperarla gratuitamente");
        }
        user.setValidationChain(randomTokenValidator());//Cadena para validar la cuenta
        em.persist(user);
        URI uriValidacion=uribuilder.build(u.getUsername(),u.getValidationChain());
        LOGGER.info(uriValidacion.toString());//Guarda la cadena de validacion en los logs de la aplicacion,
        //en un futuro puede ser enviada por email


    }


    @Override
    public void validarCuenta(String username, String validacion) throws PlaturnoException, CuentaInexistenceException, CuentaYaValidadaException, ValidacionIncorrectaException {
        Usuario user =em.find(Usuario.class,username);
        if(user==null){
            throw new CuentaInexistenceException();
        }
        if(user.getValidationChain()==null){
            throw new CuentaYaValidadaException();
        }
        if(!user.getValidationChain().equals(validacion)){
            throw new ValidacionIncorrectaException();
        }
        //La cuenta es validad al eliminar la cadena de verificacion
        user.setValidationChain(null);

    }

    @Override
    public void compruebaLogin(Usuario u) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
        Usuario user =em.find(Usuario.class, u.getUsername());
        if(user==null) {
            throw new CuentaInexistenceException();
        }
        if(user.getValidationChain()!=null) {
            throw new CuentaInactivaException();
        }

        if(!user.getPassword().equals(u.getPassword())) {
            throw new PasswordErroneaException();
        }

    }

    @Override
    public void logOut(Usuario u) throws PlaturnoException {

    }

    //Method from https://github.com/jfrchicanog/AgendaWeb.git
    private String randomTokenValidator() {
        Random rnd = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TAM_CADENA_VALIDACION; i++) {
            int v = rnd.nextInt(62);
            if (v < 26) {
                sb.append((char) ('a' + v));
            } else if (v < 52) {
                sb.append((char) ('A' + v - 26));
            } else {
                sb.append((char) ('0' + v - 52));
            }
        }

        return sb.toString();

    }
}
