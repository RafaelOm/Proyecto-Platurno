package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;


@Stateless
public class TitulacionesEjb implements TitulacionesEjbInterface {
    @PersistenceContext(unitName = "abc")
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