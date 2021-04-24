package es.uma.platurno.tests;

import es.uma.platurno.ejb.*;
import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.Alumno;
import org.glassfish.grizzly.http.server.naming.NamingException;
import org.junit.*;
import static org.junit.Assert.fail;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Properties;
import java.util.logging.Logger;

public class ListadoAlumnosTest {
	
	private static final String LISTADOALUM = "java:global/classes/ListadoAlumnos!es.uma.platurno.ejb.ListadoAlumnosInterface";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";
	
	private ListadoAlumnosInterface listadoEjb;
	

	

	@Before
	public void setup() throws NamingException, javax.naming.NamingException {
		//asignaturaEjb = (AsignaturasEjb) ctx.lookup(ASIGNATURAEJB);
		listadoEjb = (ListadoAlumnosInterface) TestSuite.ctx.lookup(LISTADOALUM);
		
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF-08"})
	@Ignore
	@Test
	public void testCompruebaListado(){
		
		
		Alumno a = new Alumno("Pepe","pepiot",1L);
		
		try {
			listadoEjb.getAlumnosList(a);
			
		}catch(PlaturnoException|CuentaInactivaException|CuentaInexistenceException| PasswordErroneaException ex) {
			ex.printStackTrace();
			fail("testCompruebaListado: LANZO UNA EXCEPCION");
		}
		
		
	}
	
	@Test
	public void testCompruebaFiltros(){
		
		Alumno a = new Alumno("Pepe","pepiot",1L);

		try {

			if(listadoEjb.getAlumnosListFiltered(a, new String[] {null, "12345", null, null, null, null, null, null, null, null, null, null, null}).size() == 0) {
				throw new CuentaInexistenceException();
			}
			
		}catch(PlaturnoException|CuentaInactivaException|CuentaInexistenceException| PasswordErroneaException ex) {
			ex.printStackTrace();
			fail("testCompruebaFiltros: LANZO UNA EXCEPCION");
		}

	}


}