package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class ImportarFicheroCSV implements IFCSV_Interface{

	@PersistenceContext(unitName = "abc")
    private EntityManager em;
	
	@Inject
	private AlumnoInterface alumnoEjb;
	
	 private static final Logger LOGGER = Logger.getLogger(ImportarFicheroCSV.class.getCanonicalName());
	
	
	// Leemos el csv
	//INDEX:
	//0.DNI
	//1.
	
	//parsing a CSV file into Scanner class constructor  
	public void leerCSV(File pathToCsv) throws FileNotFoundException {
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
  
		
		try {
            String row;
            int cont = 0;
            while ((row = csvReader.readLine()) != null) {

                if (cont > 3) {
                    String[] data = row.split(";");
                    
                    
                    
                /*
                UsuarioEjb u = new UsuarioEjb(data[0]);
                AlumnoEjb al = new AlumnoEjb(data[1], data[2], data[3], data[6],Integer.parseInt( data[9] ), data[8], data[10], data[11], Integer.parseInt(data[12]),data[3], data[7]);
                ExpedienteEJB X = new ExpedienteEJB();

                    Double CreditosSup = Double.parseDouble(data[18]);
                    Double CreditosFB = Double.parseDouble(data[19]);
                    Double CREDITOS_OB = Double.parseDouble(data[20]);
                    Double CREDITOS_OP = Double.parseDouble(data[21]);
                    Double CREDITOS_CF = Double.parseDouble(data[22]);
                    Double CredPE = Double.parseDouble(data[23]);
                    Double CREDITOS_TF = Double.parseDouble(data[24]);
                    Double NotaMd = Double.parseDouble(data[16]);
                */

                    
                    for(int i=0;i<data.length;i++){
                        System.out.print(i+": "+data[i]+", ");
                        LOGGER.info(i+": "+data[i]+", ");
                        
                    }
                   LOGGER.info("\n");
                /*
                X.UpdateExpediente(data[4],"true" , NotaMd, CreditosSup, CreditosFB, CREDITOS_OP,  CREDITOS_OB, CREDITOS_CF, CredPE, CREDITOS_TF, data[5]);
                Matricula_ejb ma = new Matricula_ejb (data[13], data[14], data[15]);



                em.persist(X);
                em.persist(ma);

                 */


                }else{
                    cont++;
                }


            }
            csvReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
	}



	
	
}
