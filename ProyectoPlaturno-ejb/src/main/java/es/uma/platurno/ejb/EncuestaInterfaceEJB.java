package es.uma.platurno.ejb;

import javax.ejb.Local;

import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.Usuario;

@Local
public interface EncuestaInterfaceEJB {
	void crearEncuesta(Usuario u, java.sql.Date fechaEnvio, String texto) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
	
}
