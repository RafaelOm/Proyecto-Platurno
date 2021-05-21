package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

/**
 * Session Bean implementation class Autenticacion
 */

//Metodo realizado por Rafael Ordoñez Molina
@Stateless
public class Autenticacion implements AutenticacionInterfaz  {
    @PersistenceContext(unitName = "abc")
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
    public void registrarUsuario(Usuario u, String cadena) throws PlaturnoException, CuentaExistenteException {
    	
    	Alumno user = em.find(Alumno.class, u.getUsername());
     
        
        if(user!=null){
            throw new CuentaExistenteException("El usuario: "+u.getUsername()+" ya esta registrado, si no" +
                    "recuerda su clave puede recuperarla gratuitamente");
        }

        u.setValidationChain(randomTokenValidator());//Cadena para validar la cuenta
        em.persist(u);
        cadena=cadena+u.getUsername()+"   "+u.getValidationChain();
        
        
        LOGGER.info(cadena);//Guarda la cadena de validacion en los logs de la aplicacion,
        //en un futuro puede ser enviada por email


    }


    @Override
    public void validarCuenta(Usuario u, String validacion) throws PlaturnoException, CuentaInexistenceException, CuentaYaValidadaException, ValidacionIncorrectaException {
    	 LOGGER.info(u.toString()+"VALIDACION "+validacion);
    	Alumno user = em.find(Alumno.class, u.getUsername());
     

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
        em.merge(user);
       

    }

    @Override
    public Usuario compruebaLogin(Usuario u) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
                    
                    Usuario user=em.find(Alumno.class,u.getUsername());
                    if(user==null) {
                        throw new CuentaInexistenceException();
                    }
                    if(user.getValidationChain()!=null) {
                        throw new CuentaInactivaException();
                    }

                    if(!user.getPassword().equals(u.getPassword())) {
                        throw new PasswordErroneaException(user.getPassword() + ":" + u.getPassword());
                    }
                    
                    return user;
    }



    @Override
    public void checkSecretariaRole(Usuario u) throws CuentaInexistenceException, ViolacionDeSeguridadException {
        Usuario bd=em.find(Usuario.class,u.getUsername());
        if(bd==null){
            throw new CuentaInexistenceException("EL USUARIO NO EXISTE");
        }

        if(!(bd instanceof Secretaria)){
           throw new ViolacionDeSeguridadException("ERROR ::::VIOLACION DE SEGURIDAD:::: El usuario: "+u.getUsername()+
                   " No dispone de permisos para realizar la accion solicitada");
        }

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
