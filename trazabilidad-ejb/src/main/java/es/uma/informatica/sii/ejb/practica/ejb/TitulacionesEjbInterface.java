package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

@Local
public interface TitulacionesEjbInterface {
	    
	    public List<Titulacion> getAll();
		void crearTitulacion(Titulacion nueva, Usuario usuario) throws TitulacionInexistente, PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
		void modificarTitulacion(Usuario usuario, String cod, String nombre, String creditos)
				throws TitulacionInexistente, PlaturnoException, CuentaInactivaException, CuentaInexistenceException,
				PasswordErroneaException;
		void eliminarTitulacion(Usuario usuario, String cod) throws TitulacionInexistente, PlaturnoException,
				CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
		Titulacion verTitulacion(String cod) throws TitulacionInexistente;
}
