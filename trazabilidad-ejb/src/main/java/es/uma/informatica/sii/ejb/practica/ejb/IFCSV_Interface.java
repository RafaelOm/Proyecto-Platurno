package es.uma.informatica.sii.ejb.practica.ejb;

import java.io.File;
import java.io.FileNotFoundException;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

@Local
public interface IFCSV_Interface {

	public void leerCSV(File pathToCsv, Usuario U) throws FileNotFoundException, ExpedienteNoExisteException, CuentaInexistenceException, ViolacionDeSeguridadException, PlaturnoException, CuentaInactivaException, PasswordErroneaException;
	
}
