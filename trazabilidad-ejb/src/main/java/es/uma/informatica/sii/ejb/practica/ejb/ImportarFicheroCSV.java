package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
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
	private UsuarioEjbInterfaz alumnoEjb;
	
	 private static final Logger LOGGER = Logger.getLogger(ImportarFicheroCSV.class.getCanonicalName());
	
	
	 /* 
	  *     0        1          2           3           4        5         6
	  * DOCUMENTO;NOMBRE;1º APELLIDO;2º APELLIDO;Nº EXPEDIENTE;GRADO;Nº ARCHIVO;
	  *     7                   8              9      10            11
	  * EMAIL_INSTITUCIONAL;EMAIL_PERSONAL;TELEFONO;MOVIL;DIRECCION_NOTIFICACION;
	  *           12                     13                 14             15
	  * LOCALIDAD_NOTIFICACION;PROVINCIA_NOTIFICACION;CP_NOTIFICACION;FECHA_MATRICULA;
	  * 16                       17          18
	  * TURNO_PREFERENTE;GRUPOS_ASIGNADOS;NOTA_MEDIA;
	  *          19              20         21          22         23        24           25
	  * CREDITOS_SUPERADOS;CREDITOS_FB;CREDITOS_OB;CREDITOS_OP;CREDITOS_CF;CREDITOS_PE; CREDITOS_TF
	  * 
	  */

	//parsing a CSV file into Scanner class constructor  
	 
	 
	public void leerCSV(File pathToCsv) throws FileNotFoundException {
		BufferedReader csvReader=null;
		
		try {
			csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(pathToCsv),"UTF-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	
  
		
		try {
            String row;
            int cont = 0;
            while ((row = csvReader.readLine()) != null) {

                if (cont > 3) {
                    String[] data = row.split(";");
                    
                    
                    /* 
               	  *     0        1          2           3           4        5         
               	  * DOCUMENTO;NOMBRE;1º APELLIDO;2º APELLIDO;Nº EXPEDIENTE;Nº ARCHIVO;
               	  *     6                   7              8      9            10
               	  * EMAIL_INSTITUCIONAL;EMAIL_PERSONAL;TELEFONO;MOVIL;DIRECCION_NOTIFICACION;
               	  *           11                     12                 13             14
               	  * LOCALIDAD_NOTIFICACION;PROVINCIA_NOTIFICACION;CP_NOTIFICACION;FECHA_MATRICULA;
               	  * 15                       16          17
               	  * TURNO_PREFERENTE;GRUPOS_ASIGNADOS;NOTA_MEDIA;
               	  *          18              19         20          21         22        23           24
               	  * CREDITOS_SUPERADOS;CREDITOS_FB;CREDITOS_OB;CREDITOS_OP;CREDITOS_CF;CREDITOS_PE; CREDITOS_TF
               	  * 
               	  */
                    
                  Alumno a = new Alumno();
                  a.setDni(data[0]);
                  a.setNombre(data[1]);
                  a.setApellido1(data[2]);
                  a.setApellido2(data[3]);
                  a.setEmail_institucional(data[6]);
                  a.setEmail_personal(data[7]);
                  a.setTelefono(data[8]);
                  a.setMovil(data[9]);
                  a.setProvincia(data[12]);
                  a.setLocalidad(data[11]);
                  a.setDireccion(data[10]);
                 
                  
                  List<Expediente> expedientes=new ArrayList<>();
                  
                  
                  //Creamos Expediente
                  Expediente e =new Expediente();
                  e.setExpediente(data[4]);
                  e.setN_archivo(data[5]);
                  e.setNotampr(Double.parseDouble(data[17]));
                  e.setCreditosSup(Double.parseDouble(data[18]));
                  e.setCreditosFB(Double.parseDouble(data[19]));
                  e.setCreditosOB(Double.parseDouble(data[20]));
                  e.setCreditosOP(Double.parseDouble(data[21]));
                  e.setCreditosCF(Double.parseDouble(data[22]));
                  e.setCreditosPE(Double.parseDouble(data[23]));
                  e.setCreditosTF(Double.parseDouble(data[24]));
                  em.persist(e);
                  expedientes.add(e);
                  
                  a.setExpedientes(expedientes);
                  
          try {
			alumnoEjb.crearUsuarioFromCsvExcel(a);
		} catch (PlaturnoException | CuentaExistenteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
                    
                    
     

                    
                    for(int i=0;i<data.length;i++){
                        System.out.print(i+": "+data[i]+", ");
                        LOGGER.info(i+": "+data[i]+", ");
                        
                    }
                   LOGGER.info("\n");
  


                }else{
                    cont++;
                }


            }
            csvReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void leerCSVGrAsig(File pathToCsv) throws FileNotFoundException, AsignaturaInexsistenteException, GrupoInexistenteException{
		
BufferedReader csvReader=null;
		
		try {
			csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(pathToCsv),"UTF-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	
  
		
		try {
            String row;
            int cont = 0;
            while ((row = csvReader.readLine()) != null) {

                if (cont > 3) {
                    String[] data = row.split(";");
                    
                    GR_ASIG grasig =new GR_ASIG();
                    
                    Asignatura a = em.find(Asignatura.class, data[0]);
                    
                    if(a==null) {
                    	throw new AsignaturaInexsistenteException(data[0]);
                    }
                    grasig.setAsig(a);
                    grasig.setCurso_act(data[2]);
                    
                    Grupo g = em.find(Grupo.class, data[1]);
                    
                    if(g==null) {
                    	throw new GrupoInexistenteException(data[1]);
                    }
                  grasig.setGroup(g);
                  em.persist(grasig);
                  
         
                 
                    
                    for(int i=0;i<data.length;i++){
                        System.out.print(i+": "+data[i]+", ");
                        LOGGER.info(i+": "+data[i]+", ");
                        
                    }
                   LOGGER.info("\n");
  


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
