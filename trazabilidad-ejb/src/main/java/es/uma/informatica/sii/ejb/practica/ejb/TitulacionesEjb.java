package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;


@Stateless
public class TitulacionesEjb implements TitulacionesEjbInterface {
    @PersistenceContext(unitName = "abc")
	private EntityManager em;
 
    
    private static final Logger LOGGER = Logger.getLogger(AsignaturasEjb.class.getCanonicalName());
    
    public List<Titulacion> getAll() {

    	
    	Query query =em.createQuery("SELECT a FROM Titulacion a");
    	List<Titulacion> titulacion =query.getResultList();
    	LOGGER.info("LECTURA DE BD "+titulacion.toString());
		return  titulacion;
    	
    }
    
 public void crearTitulacion(Titulacion nueva, Usuario usuario) throws TitulacionInexistente{
    	

  
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
	public void modificarTitulacion(Integer cod, String nombre, Integer creditos) throws TitulacionInexistente {
		Titulacion t =em.find(Titulacion.class,cod);
        if(t==null){
            throw new TitulacionInexistente();
        }
        t.setCodigo(Integer.toString(cod));
        t.setNombre(nombre);
        t.setCreditos(Integer.toString(creditos));
        
        em.merge(t);

	}

	@Override
	public void eliminarTitulacion(String cod) throws TitulacionInexistente {
        Titulacion t= em.find(Titulacion.class,cod);
        if(t==null){
            throw new TitulacionInexistente();
        }
        em.remove(t);
	}

}
