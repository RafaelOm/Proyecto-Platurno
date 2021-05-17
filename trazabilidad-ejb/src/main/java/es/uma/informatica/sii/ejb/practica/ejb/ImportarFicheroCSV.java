package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class ImportarFicheroCSV implements IFCSV_Interface{

	@PersistenceContext(unitName = "abc")
    private EntityManager em;
	
	
	// Leemos el csv
	//INDEX:
	//0.DNI
	//1.
	
	//parsing a CSV file into Scanner class constructor  
	public void leerCSV(File pathToCsv, Usuario U) throws FileNotFoundException, ExpedienteNoExisteException, CuentaInexistenceException, ViolacionDeSeguridadException, PlaturnoException, CuentaInactivaException, PasswordErroneaException {
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        
		Autenticacion au = new Autenticacion();
		
		au.compruebaLogin(U);
		au.checkSecretariaRole(U);
		
		
		try {
			String row;
			while ( ( row=csvReader.readLine() ) != null) {

			    String[] data = row.split(";");
			    
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
			    
			   X.UpdateExpediente(data[4],"true" , NotaMd, CreditosSup, CreditosFB, CREDITOS_OP,  CREDITOS_OB, CREDITOS_CF, CredPE, CREDITOS_TF, data[5]);
			    Matricula_ejb ma = new Matricula_ejb (data[13], data[14], data[15]);
			    
                

			    em.persist(X);
			    em.persist(ma);
			    

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
