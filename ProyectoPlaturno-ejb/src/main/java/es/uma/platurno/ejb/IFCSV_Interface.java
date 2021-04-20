package es.uma.platurno.ejb;

import java.io.File;
import java.io.FileNotFoundException;

public interface IFCSV_Interface {

	public void leerCSV(File pathToCsv) throws FileNotFoundException;
	
}
