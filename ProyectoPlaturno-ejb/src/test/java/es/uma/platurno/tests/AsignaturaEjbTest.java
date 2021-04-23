package es.uma.platurno.tests;

import es.uma.platurno.ejb.AsignaturasEjb;
import es.uma.platurno.ejb.Autenticacion;
import es.uma.platurno.ejb.*;
import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.Alumno;
import es.uma.platurno.jpa.Asignatura;
import es.uma.platurno.jpa.Usuario;
import org.glassfish.grizzly.http.server.naming.NamingException;
import org.junit.*;

import static org.junit.Assert.fail;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Properties;
import java.util.logging.Logger;

public class AsignaturaEjbTest {
	
	private static final Logger LOG = Logger.getLogger(AsignaturaEjbTest.class.getCanonicalName());

	private static final String ASIGNATURAEJB = "java:global/classes/AsignaturasEjb";
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
	public void testCompruebaUsuario(){
		
		

		Alumno a = new Alumno();
		a.setIdentificador(1L);
		a.setUsername("mEscobar");
		a.setPassword("manolito");
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
			fail("LANZO UNA EXCEPCION");
		}


	}


	
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

}
