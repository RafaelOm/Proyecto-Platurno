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
	
	private static final Logger LOG = Logger.getLogger(AutenticacionEjbTest.class.getCanonicalName());
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "src/test/resources/META-INF/domain.xml";
	private static final String USUARIOEJB = "java:global/classes/UsuarioEjb!es.uma.platurno.ejb.UsuarioEjbInterfaz";
	private static final String AUTENTICACION = "java:global/classes/Autenticacion!es.uma.platurno.ejb.AutenticacionInterfaz";
	private static final String LISTADOALUM = "java:global/classes/ListadoAlumnos!es.uma.platurno.ejb.ListadoAlumnosInterface";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;

	private UsuarioEjbInterfaz usuarioEjb;
	private ListadoAlumnosInterface listadoEjb;
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
		usuarioEjb = (UsuarioEjbInterfaz) ctx.lookup(USUARIOEJB);
		auth = (AutenticacionInterfaz) ctx.lookup(AUTENTICACION);
		listadoEjb = (ListadoAlumnosInterface) ctx.lookup(LISTADOALUM);
		
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
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
		
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

}