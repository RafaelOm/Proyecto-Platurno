package es.uma.platurno.ejb;

import javax.ejb.Local;

import es.uma.platurno.ejb.exceptions.TitulacionInexistente;
import es.uma.platurno.jpa.Titulacion;

@Local
public interface TitulacionesEjbInterface {
	    public Titulacion verTitulacion(String cod) throws TitulacionInexistente;
	    public void modificarTitulacion(String cod,String nombre,Integer creditos) throws TitulacionInexistente;
	    public void eliminarTitulacion(String referencia) throws TitulacionInexistente;
}
