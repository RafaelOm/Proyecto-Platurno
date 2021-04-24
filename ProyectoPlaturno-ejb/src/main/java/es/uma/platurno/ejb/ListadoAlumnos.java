package es.uma.platurno.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.Usuario;

@Local
@Stateless
public class ListadoAlumnos implements ListadoAlumnosInterface {
	
	private Autenticacion auth;
	
    @PersistenceContext(unitName = "ProyectoPlaturno.GrupoF")
    private EntityManager em;
    
    @Override
	  public List<AlumnoEjb> getAlumnosList(Usuario u) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
    	auth=new Autenticacion();
        auth.compruebaLogin(u);
	      Query q = em.createQuery("SELECT a FROM Alumno a");
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
	  public List<AlumnoEjb> getAlumnosListFiltered(Usuario u, String[] filtros) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
		  auth=new Autenticacion();
	      auth.compruebaLogin(u);
		  if(filtros==null) {
			  return getAlumnosList(u);
		  }
		  
		  String finalQuery = "SELECT a FROM Alumno a WHERE ";
		  String idd = filtros[0];
		  HashMap<String, String> mp = new HashMap<String, String>();
		  
		  if(idd!=null) {
			  finalQuery += "ID = :idd AND ";
			  mp.put("idd", idd);
		  }
		  String dni = filtros[1];
		  if(dni!=null) {
			  finalQuery += "DNI = :dni AND ";
			  mp.put("dni", dni);
		  }
		  
		  String nombre = filtros[2];
		  if(nombre!=null) {
			  finalQuery += "NOMBRE = :nombre AND ";
			  mp.put("nombre", nombre);
		  }
		  
		  String apellido1 = filtros[3];
		  if(apellido1!=null) {

			  finalQuery += "APELLIDO1 = :apellido1 AND ";
			  mp.put("apellido1", apellido1);
		  }
		  
		  String apellido2 = filtros[4];
		  if(apellido2!=null) {
			  finalQuery += "APELLIDO2 = :apellido2 AND ";
			  mp.put("apellido2", apellido2);
		  }
		  
		  String emailsInst = filtros[5];
		  if(emailsInst!=null) {
			  finalQuery += "EMAIL_INSTITUCIONAL = :emailsinst AND ";
			  mp.put("emailsinst", emailsInst);
		  }
		  
		  String emailPersonal = filtros[6];
		  if(emailPersonal!=null) {
			  finalQuery += "EMAIL_PERSONAL = :emailpersonal AND ";
			  mp.put("emailpersonal", emailPersonal);
		  }
		  
		  String tlf = filtros[7];
		  if(tlf!=null) {
			  finalQuery += "TELEFONO = :telefono AND ";
			  mp.put("telefono", tlf);
		  }
		  
		  String movil = filtros[8];
		  if(movil!=null) {
			  finalQuery += "MOVIL = :movil AND ";
			  mp.put("movil", movil);
		  }
		  
		  String dir = filtros[9];
		  if(dir!=null) {
			  finalQuery += "DIRECCION = :dir AND ";
			  mp.put("dir", dir);
		  }
		  
		  
		  String localidad = filtros[10];
		  if(localidad!=null) {
			  finalQuery += "LOCALIDAD = :localidad AND ";
			  mp.put("localidad", localidad);
		  }
		  
		  String provincia = filtros[11];
		  if(localidad!=null) {
			  finalQuery += "PROVINCIA = :provincia AND ";
			  mp.put("provincia", provincia);
		  }
		  
		  String codPostal = filtros[12];
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
