package es.uma.platurno.tests;

import es.uma.platurno.ejb.AsignaturasEjb;
import es.uma.platurno.ejb.Autenticacion;
import es.uma.platurno.ejb.*;
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

public class AutenticacionEjbTest {
	
	private static final Logger LOG = Logger.getLogger(AutenticacionEjbTest.class.getCanonicalName());

	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "src/test/resources/META-INF/domain.xml";
	private static final String USUARIOEJB = "java:global/classes/UsuarioEjb!es.uma.platurno.ejb.UsuarioEjbInterfaz";
	private static final String AUTENTICACION = "java:global/classes/Autenticacion!es.uma.platurno.ejb.AutenticacionInterfaz";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;

	//private AsignaturasEjb asignaturaEjb;
	private UsuarioEjbInterfaz UsuarioEjb;
	private AutenticacionInterfaz auth;
	

	
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@Before
	public void setup() throws NamingException, javax.naming.NamingException {
		//asignaturaEjb = (AsignaturasEjb) ctx.lookup(ASIGNATURAEJB);
		UsuarioEjb = (UsuarioEjbInterfaz) ctx.lookup(USUARIOEJB);
		 auth = (AutenticacionInterfaz) ctx.lookup(AUTENTICACION);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Test
	public void testCompruebaUsuarioLogeado(){
		
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
		try{
			auth.compruebaLogin(a);

		} catch (PasswordErroneaException  |CuentaInactivaException|CuentaInexistenceException |PlaturnoException e) {
			e.printStackTrace();
			fail("LANZO UNA EXCEPCION");
				
		}


	}
	@Test
	public void testCompruebaUsuarioNoExistente(){
		
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
		try{
			auth.compruebaLogin(a);

		} catch (PasswordErroneaException  |CuentaInactivaException |PlaturnoException e) {
			e.printStackTrace();
			fail("LANZO UNA EXCEPCION");
				
		}catch(CuentaInexistenceException e){
			//TEST PASS
		}


	}
	@Test
	public void testCuentaInactivaException(){
		
		Alumno a = new Alumno("Pepe","pepiot",1L);
		a.setValidationChain("ESTO ES UN TOKEN DE PRUEBA");
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
			auth.compruebaLogin(a);
		} catch (PlaturnoException  | CuentaInexistenceException| PasswordErroneaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("TEST ERRONEO");
		}catch(CuentaInactivaException e) {
				//TEST PASS
		}

	}
	
	@Test
	public void testCuentaExistenteEnRegistro(){
		
		
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
			UriBuilder uribuilder= UriBuilder.fromUri("UriTest");
			auth.registrarUsuario(a, uribuilder);
		} catch (PlaturnoException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ERROR EN TEST CUENTA EXISTENTE");
		}catch(CuentaExistenteException e) {
			//TEST PASSS
		}
	

	}
	
	@Test
	public void validarCuentaTest() {
		
		Alumno a = new Alumno("Pepe","pepiot",4L);

		a.setDni("dni4");
		a.setNombre("MANOLO");
		a.setValidationChain("ESTO ES UN TOKEN DE PRUEBA");
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
			auth.validarCuenta(a, "ESTO ES UN TOKEN DE PRUEBA");
		} catch (PlaturnoException | CuentaInexistenceException | CuentaYaValidadaException
				| ValidacionIncorrectaException e) {
			fail("TEST EN ESTADO DE ERROR");
			e.printStackTrace();
		}
		
		
	}
	
	@Test 
	public void chekAlumnoRoleTest() {
		
		Alumno a = new Alumno("Pepe","pepiot",4L);

		a.setDni("dni4");
		a.setNombre("MANOLO");
		a.setValidationChain("ESTO ES UN TOKEN DE PRUEBA");
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
			auth.checkSecretariaRole(a);
		} catch (CuentaInexistenceException e) {
			// TODO Auto-generated catch block
			fail("TEST EN ERROR");
			e.printStackTrace();
		}catch(ViolacionDeSeguridadException e) {
			//OK
		}
		
	}
	
	@Test 
	public void chekSecretariaRoleTest() {
		
	Secretaria s = new Secretaria("Rafael","prueba",125L);
	
	try {
		auth.checkSecretariaRole(s);
	} catch (CuentaInexistenceException | ViolacionDeSeguridadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		fail("ERROR");
	}
	
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

}
