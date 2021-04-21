package es.uma.platurno.ejb;

import java.io.File;
import java.io.FileNotFoundException;

import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.ExpedienteNoExisteException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.platurno.jpa.Usuario;

public interface IFCSV_Interface {

	public void leerCSV(File pathToCsv, Usuario U) throws FileNotFoundException, ExpedienteNoExisteException, CuentaInexistenceException, ViolacionDeSeguridadException, PlaturnoException, CuentaInactivaException, PasswordErroneaException;
	
}
