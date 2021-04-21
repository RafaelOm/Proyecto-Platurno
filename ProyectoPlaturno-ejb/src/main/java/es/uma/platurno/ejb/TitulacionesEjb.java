package es.uma.platurno.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.platurno.ejb.exceptions.TitulacionInexistente;
import es.uma.platurno.jpa.Titulacion;

public class TitulacionesEjb implements TitulacionesEjbInterface {
	@PersistenceContext(unitName = "Platurno-Asignatura")
	private EntityManager em;
	 
	@Override
	public Titulacion verTitulacion(String cod) throws TitulacionInexistente {
		Titulacion tit= em.find(Titulacion.class,cod);
        if(tit==null){
            throw new TitulacionInexistente("La titulación solicitada no existe.");
        }
        return tit;
	}

	@Override
	public void modificarTitulacion(String cod, String nombre, Integer creditos) throws TitulacionInexistente {
		Titulacion t =em.find(Titulacion.class,cod);
        if(t==null){
            throw new TitulacionInexistente();
        }
        t.setCodigo(cod);
        t.setNombre(nombre);
        t.setCreditos(creditos.toString());
        
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
