package es.uma.platurno.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Properties;
import java.util.logging.Logger;

public class AsignaturaEjbTest {
	
	private static final Logger LOG = Logger.getLogger(AsignaturaEjbTest.class.getCanonicalName());

	private static final String PRODUCTOS_EJB = "java:global/classes/AsignaturasEjb";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "src/test/resources/META-INF/domain.xml";
	//private static final String LOTES_EJB = "java:global/classes/LotesEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrazabilidadTest";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	

	
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	/*
	@Before
	public void setup() throws NamingException  {
		gestionLotes = (GestionLotes) ctx.lookup(LOTES_EJB);
		gestionProductos = (GestionProductos) ctx.lookup(PRODUCTOS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
*/

	
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

}
