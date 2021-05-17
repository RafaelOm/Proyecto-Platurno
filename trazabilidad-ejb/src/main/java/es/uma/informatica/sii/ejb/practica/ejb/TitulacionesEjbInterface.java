package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

@Local
public interface TitulacionesEjbInterface {
	    public Titulacion verTitulacion(String cod) throws TitulacionInexistente;
	    public void modificarTitulacion(Integer cod,String nombre,Integer creditos) throws TitulacionInexistente;
	    public void eliminarTitulacion(String referencia) throws TitulacionInexistente;
}
