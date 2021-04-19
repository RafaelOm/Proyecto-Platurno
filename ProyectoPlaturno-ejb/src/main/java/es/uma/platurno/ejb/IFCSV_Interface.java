package es.uma.platurno;

import java.io.File;
import java.io.FileNotFoundException;

public interface IFCSV_Interface {

	public void leerCSV(File pathToCsv) throws FileNotFoundException;
	
}
