package es.uma.platurno.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ListadoAlumnos implements ListadoAlumnosInterface {
	
    @PersistenceContext(unitName = "Platurno-Asignatura")
    private EntityManager em;
    
    @Override
	  public List<AlumnoEjb> getAlumnosList() {
	      Query q = em.createQuery("SELECT a FROM ALUMNOS a");
	      return q.getResultList();
	  }
	  
	  /*
	   * Index:
	   * 0: ID
	   * 1: DNI
	   * 2: Nombre
	   * 3: Apellido1
	   * 4: Apellido2
	   * 5: Email Institucional
	   * 6: Email Personal
	   * 7: Telefono
	   * 8: Movil
	   * 9: Direccion
	   * 10: Localidad
	   * 11: Provincia
	   * 12: Codigo Postal
	   */
	  @Override
	  public List<AlumnoEjb> getAlumnosListFiltered(List<String> filtros) {
		  if(filtros==null) {
			  return getAlumnosList();
		  }
		  
		  String finalQuery = "SELECT a FROM ALUMNOS a WHERE ";
		  String idd = filtros.get(0);
		  HashMap<String, String> mp = new HashMap<String, String>();
		  
		  if(idd!=null) {
			  finalQuery += "ID = :idd AND ";
			  mp.put("idd", idd);
		  }
		  String dni = filtros.get(1);
		  if(dni!=null) {
			  finalQuery += "DNI = :dni AND ";
			  mp.put("dni", dni);
		  }
		  
		  String nombre = filtros.get(2).toLowerCase();
		  if(nombre!=null) {
			  finalQuery += "NOMBRE = :nombre AND ";
			  mp.put("nombre", nombre);
		  }
		  
		  String apellido1 = filtros.get(3).toLowerCase();
		  if(apellido1!=null) {

			  finalQuery += "APELLIDO1 = :apellido1 AND ";
			  mp.put("apellido1", apellido1);
		  }
		  
		  String apellido2 = filtros.get(4).toLowerCase();
		  if(apellido2!=null) {
			  finalQuery += "APELLIDO2 = :apellido2 AND ";
			  mp.put("apellido2", apellido2);
		  }
		  
		  String emailsInst = filtros.get(5).toLowerCase();
		  if(emailsInst!=null) {
			  finalQuery += "EMAIL_INSTITUCIONAL = :emailsinst AND ";
			  mp.put("emailsinst", emailsInst);
		  }
		  
		  String emailPersonal = filtros.get(6).toLowerCase();
		  if(emailPersonal!=null) {
			  finalQuery += "EMAIL_PERSONAL = :emailpersonal AND ";
			  mp.put("emailpersonal", emailPersonal);
		  }
		  
		  String tlf = filtros.get(7).toLowerCase();
		  if(tlf!=null) {
			  finalQuery += "TELEFONO = :telefono AND ";
			  mp.put("telefono", tlf);
		  }
		  
		  String movil = filtros.get(8).toLowerCase();
		  if(movil!=null) {
			  finalQuery += "MOVIL = :movil AND ";
			  mp.put("movil", movil);
		  }
		  
		  String dir = filtros.get(9).toLowerCase();
		  if(dir!=null) {
			  finalQuery += "DIRECCION = :dir AND ";
			  mp.put("dir", dir);
		  }
		  
		  
		  String localidad = filtros.get(10).toLowerCase();
		  if(localidad!=null) {
			  finalQuery += "LOCALIDAD = :localidad AND ";
			  mp.put("localidad", localidad);
		  }
		  
		  String provincia = filtros.get(11).toLowerCase();
		  if(localidad!=null) {
			  finalQuery += "PROVINCIA = :provincia AND ";
			  mp.put("provincia", provincia);
		  }
		  
		  String codPostal = filtros.get(12).toLowerCase();
		  if(localidad!=null) {
			  finalQuery += "CP = :codpostal AND ";
			  mp.put("codpostal", codPostal);
		  }
		  		  finalQuery += "TRUE";
		  
		  Query q = em.createQuery(finalQuery);
		  for(Entry<String, String> e:mp.entrySet()) {
			  q.setParameter(e.getKey(), e.getValue());
		  }
	      return q.getResultList();
	  }
}
