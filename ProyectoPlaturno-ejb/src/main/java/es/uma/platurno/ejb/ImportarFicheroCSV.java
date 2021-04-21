package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.CuentaExistenteException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public class ImportarFicheroCSV implements IFCSV_Interface{

	@PersistenceContext(unitName = "AgendaEE-EntidadesPU")
    private EntityManager em;
	
	
	// Leemos el csv
	//INDEX:
	//0.DNI
	//1.
	
	//parsing a CSV file into Scanner class constructor  
	public void leerCSV(File pathToCsv) throws FileNotFoundException {
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

		try {
			String row;
			while ( ( row=csvReader.readLine() ) != null) {

			    String[] data = row.split(";");
			    
			    UsuarioEjb u = new UsuarioEjb(data[0]);
			    AlumnoEjb al = new AlumnoEjb(data[1], data[2], data[3], data[6],Integer.parseInt( data[9] ), data[8], data[10], data[11], Integer.parseInt(data[12]),data[3], data[7]);
			    /* ExpedienteEJB X = new ExpedienteEJB(data[5], data[16], data[17], Integer.valueOf(data[18]), Integer.valueOf(data[19]),  Integer.valueOf(data[20]),  Integer.valueOf(data[21]),  Integer.valueOf(data[22]), data[23]);
			    Matricula_ejb ma = new Matricula_ejb (data[13], data[14], data[15]);
			    
                

			    em.persist(X);
			    em.persist(ma);
			    */

			}
			csvReader.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuentaExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlaturnoException e) {
			e.printStackTrace();
		}

	}


	
	
}
