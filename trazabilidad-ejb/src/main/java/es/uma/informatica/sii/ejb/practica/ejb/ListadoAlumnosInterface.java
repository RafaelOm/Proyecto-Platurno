package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import javax.ejb.Local;

@Local
public interface ListadoAlumnosInterface {
	public List<AlumnoEjb> getAlumnosList(Usuario u) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
	public List<AlumnoEjb> getAlumnosListFiltered(Usuario u, String[] l) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
}
