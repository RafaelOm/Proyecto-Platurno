package es.uma.platurno.tests;

import es.uma.platurno.ejb.AsignaturasEjb;
import es.uma.platurno.ejb.Autenticacion;
import es.uma.platurno.ejb.*;
import es.uma.platurno.ejb.exceptions.ClavesDiferentesException;
import es.uma.platurno.ejb.exceptions.ContrasenaigualException;
import es.uma.platurno.ejb.exceptions.CuentaExistenteException;
import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.CuentaYaValidadaException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.ejb.exceptions.ValidacionIncorrectaException;
import es.uma.platurno.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.platurno.jpa.Alumno;
import es.uma.platurno.jpa.Asignatura;
import es.uma.platurno.jpa.Secretaria;
import es.uma.platurno.jpa.Usuario;
import org.glassfish.grizzly.http.server.naming.NamingException;
import org.junit.*;

import static org.junit.Assert.fail;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.ws.rs.core.UriBuilder;

import java.util.Properties;
import java.util.logging.Logger;

public class UsuarioEjbTest {
	
	private static final Logger LOG = Logger.getLogger(UsuarioEjbTest.class.getCanonicalName());

	
	private static final String USUARIOEJB = "java:global/classes/UsuarioEjb!es.uma.platurno.ejb.UsuarioEjbInterfaz";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";
	

	//private AsignaturasEjb asignaturaEjb;
	private UsuarioEjbInterfaz UsuarioEjb;
	

	


	@Before
	public void setup() throws NamingException, javax.naming.NamingException {
		//asignaturaEjb = (AsignaturasEjb) ctx.lookup(ASIGNATURAEJB);
		UsuarioEjb = (UsuarioEjbInterfaz) TestSuite.ctx.lookup(USUARIOEJB);

		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Ignore
	@Test
	public void crearUsuarioFromCsvTest() {
		
		try {
			UsuarioEjb.crearUsuarioFromCsvExcel("1234");
		} catch (PlaturnoException | CuentaExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ERROR EN TEST");
		}
		
	}
	@Ignore
	@Test
	public void verUsuarioTest() {
		
		Alumno a = new Alumno("Pepe","pepiot",1L);

		a.setDni("12345");
		a.setNombre("MANOLO");
		a.setApellido1("ESCOBAR");
		a.setApellido2("NOSE");
		a.setEmail_institucional("manolito@uma.es");
		a.setEmail_personal("manolomanolo@gmail.com");
		a.setTelefono("333333");
		a.setMovil("645353");
		a.setDireccion("Avenida malaga 24 ");
		a.setLocalidad("MADRID");
		a.setProvincia("COMUNIDAD DE MADRID");
		a.setCP("29000");

		try {
			UsuarioEjb.verUsuario(a);
		} catch (CuentaInexistenceException | CuentaInactivaException | PlaturnoException
				| PasswordErroneaException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			fail("Test en error");
		}
		
		
		
	}
	@Ignore
	@Test
	public void modificarUsuarioTest() {
		
		Alumno a = new Alumno("Pepe","pepiot",1L);

		a.setDni("12345");
		a.setNombre("MANOLO");
		a.setApellido1("ESCOBAR");
		a.setApellido2("NOSE");
		a.setEmail_institucional("manolito@uma.es");
		a.setEmail_personal("manolomanolo@gmail.com");
		a.setTelefono("333333");
		a.setMovil("645353");
		a.setDireccion("Avenida malaga 24 ");
		a.setLocalidad("MADRID");
		a.setProvincia("COMUNIDAD DE MADRID");
		a.setCP("29000");
		
		try {
			UsuarioEjb.modificar(a);
		} catch (CuentaInexistenceException | CuentaInactivaException | PlaturnoException
				| PasswordErroneaException e) {
			
			e.printStackTrace();
			fail("ERROR NO DEBERIA DE LANZAR NINGUNA EXCEPCION");
		}
		
	}
	
	@Ignore
	@Test
	public void modificarClaveTest() {
		Alumno a = new Alumno("Pepe","pepiot",1L);

		a.setDni("12345");
		a.setNombre("MANOLO");
		a.setApellido1("ESCOBAR");
		a.setApellido2("NOSE");
		a.setEmail_institucional("manolito@uma.es");
		a.setEmail_personal("manolomanolo@gmail.com");
		a.setTelefono("333333");
		a.setMovil("645353");
		a.setDireccion("Avenida malaga 24 ");
		a.setLocalidad("MADRID");
		a.setProvincia("COMUNIDAD DE MADRID");
		a.setCP("29000");
		
		try {
			UsuarioEjb.moficarClave(a);
		} catch (CuentaInexistenceException | ContrasenaigualException | ClavesDiferentesException
				| CuentaInactivaException | PlaturnoException | PasswordErroneaException e) {
			// TODO Auto-generated catch block
			fail("ERROR NO DEBERIA DE LANZAR NINGUNA EXCEPCION");
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void eliminarUsuarioTest() {
		Alumno a = new Alumno("Pepe","pepiot",1L);

		a.setDni("12345");
		a.setNombre("MANOLO");
		a.setApellido1("ESCOBAR");
		a.setApellido2("NOSE");
		a.setEmail_institucional("manolito@uma.es");
		a.setEmail_personal("manolomanolo@gmail.com");
		a.setTelefono("333333");
		a.setMovil("645353");
		a.setDireccion("Avenida malaga 24 ");
		a.setLocalidad("MADRID");
		a.setProvincia("COMUNIDAD DE MADRID");
		a.setCP("29000");
		
		Secretaria s = new Secretaria("Rafael","prueba",125L);
		try {
			UsuarioEjb.eliminarUsuario(a, s);
		} catch (PlaturnoException | CuentaInactivaException | CuentaInexistenceException | PasswordErroneaException
				| ViolacionDeSeguridadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ERROR NO DEBERIA DE LANZAR NINGUNA EXCEPCION");
		}
		
		
	}
	
	
	
	
	


}
