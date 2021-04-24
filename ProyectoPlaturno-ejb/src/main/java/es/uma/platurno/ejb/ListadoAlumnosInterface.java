package es.uma.platurno.ejb;

import java.util.List;

import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.Local;

@Local
public interface ListadoAlumnosInterface {
	public List<AlumnoEjb> getAlumnosList(Usuario u) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
	public List<AlumnoEjb> getAlumnosListFiltered(Usuario u, String[] l) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
}
