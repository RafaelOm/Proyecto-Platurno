package es.uma.platurno;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ImportarFicheroCSV implements IFCSV_Interface{

	@PersistenceContext(unitName = "AgendaEE-EntidadesPU")
    private EntityManager em;
	
	
	// Leemos el csv
	
	//parsing a CSV file into Scanner class constructor  
	public void leerCSV(File pathToCsv) throws FileNotFoundException {
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
		String row;
		try {
			row = csvReader.readLine();
			while ( ( row ) != null) {				
			    String[] data = row.split(";");
			    
			    UsuarioEjb u = new UsuarioEjb(data[0],data[3], data[7]);
			    Alumno al = new Alumno(data[1], data[2], data[3], data[6],Integer.parseInt( data[9] ), data[8], data[10], data[11], Integer.parseInt(data[12]));
			    Expediente X = new Expediente(data[5], data[16], data[17], data[18], data[19], data[20], data[21], data[22], data[23]);
			    Matricula ma = new Matricula(data[13], data[14], data[15]);
			    
			    em.persist(u);
			    em.persist(al);
			    em.persist(X);
			    em.persist(ma);
			    
			    em.getTransaction().commit();
			}
			csvReader.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuentaExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	
}
