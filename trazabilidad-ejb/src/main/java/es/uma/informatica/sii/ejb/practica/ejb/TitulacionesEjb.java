package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;


@Stateless
public class TitulacionesEjb implements TitulacionesEjbInterface {
    @PersistenceContext(unitName = "abc")
    private EntityManager em;
    
    
    @Inject
    private AutenticacionInterfaz auth;
    
	
 
    
    private static final Logger LOGGER = Logger.getLogger(TitulacionesEjb.class.getCanonicalName());
    
    @Override
    public List<Titulacion> getAll() {
    	
    	
    	Query query =em.createQuery("SELECT t FROM Titulacion t");
    	List<Titulacion> titulacion =query.getResultList();
    	LOGGER.info("TITULACION --------- "+titulacion.toString());
		return  titulacion;
    	
    }
    
    @Override

 public void crearTitulacion(Titulacion nueva, Usuario usuario) throws TitulacionInexistente, PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException{
    	
    	auth.compruebaLogin(usuario);
  
    		LOGGER.info("CREAR- Titulacion: PARAMETRO"+nueva.toString()+"USER TEST: "+usuario.toString());
    
    	Titulacion t =em.find(Titulacion.class, nueva.getCodigo());
    	
    	if(t!=null) {
    		throw new TitulacionInexistente("La titulación ya existe.");
    	}
    		LOGGER.info("CREAR- Titulacion: "+nueva.toString());
    	em.persist(nueva);
    	
    	
    }
 
 
	@Override
	
	public Titulacion verTitulacion(String cod) throws TitulacionInexistente {
		
	
		Titulacion tit= em.find(Titulacion.class,cod);
        if(tit==null){
            throw new TitulacionInexistente("La titulación solicitada no existe.");
        }
        return tit;
	}

	@Override
	public void modificarTitulacion(Usuario usuario,String cod, String nombre, String creditos) throws TitulacionInexistente, PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
		
		auth.compruebaLogin(usuario);
		Titulacion t =em.find(Titulacion.class,cod);
        if(t==null){
            throw new TitulacionInexistente();
        }
        t.setCodigo(cod);
        t.setNombre(nombre);
        t.setCreditos(creditos);
        
        em.merge(t);

	}

	@Override

	public void eliminarTitulacion(Usuario usuario, String cod) throws TitulacionInexistente, PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
		auth.compruebaLogin(usuario);
        Titulacion t= em.find(Titulacion.class,cod);
        if(t==null){
            throw new TitulacionInexistente();
        }
        em.remove(em.merge(t));
	}

}
