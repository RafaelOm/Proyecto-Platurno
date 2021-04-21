package es.uma.platurno.ejb;

import java.io.File;
import java.io.FileNotFoundException;

import es.uma.platurno.ejb.exceptions.ExpedienteNoExisteException;

public interface IFCSV_Interface {

	public void leerCSV(File pathToCsv) throws FileNotFoundException, ExpedienteNoExisteException;
	
}
