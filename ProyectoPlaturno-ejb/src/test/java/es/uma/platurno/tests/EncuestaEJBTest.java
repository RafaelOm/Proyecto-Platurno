package es.uma.platurno.tests;

import es.uma.platurno.ejb.*;
import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.Alumno;
import es.uma.platurno.jpa.Secretaria;

import org.glassfish.grizzly.http.server.naming.NamingException;
import org.junit.*;
import static org.junit.Assert.fail;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Logger;

public class EncuestaEJBTest {
		
		private static final Logger LOG = Logger.getLogger(AutenticacionEjbTest.class.getCanonicalName());
		private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
		private static final String CONFIG_FILE = "src/test/resources/META-INF/domain.xml";

		private static final String ENCUESTAEJB = "java:global/classes/EncuestaEJB!es.uma.platurno.ejb.EncuestaInterfaceEJB";
		private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";
		
		private static EJBContainer ejbContainer;
		private static Context ctx;

		private EncuestaInterfaceEJB encuestaEjb;
		

		
		@BeforeClass
		public static void setUpClass() {
			Properties properties = new Properties();
			properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
			ejbContainer = EJBContainer.createEJBContainer(properties);
			ctx = ejbContainer.getContext();
		}

		@Before
		public void setup() throws NamingException, javax.naming.NamingException {
			encuestaEjb = (EncuestaInterfaceEJB) ctx.lookup(ENCUESTAEJB);
			
			BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		}
		
		@Test
		public void testCrearEncuesta(){
			
			try {
				Secretaria s = new Secretaria("Rafael","prueba");
				encuestaEjb.crearEncuesta(s, new java.sql.Date(Calendar.getInstance().getTime().getTime()), "¿Quieres elegir este horario?");
				
			}catch(Exception ex) {
				ex.printStackTrace();
				fail("testCrearEncuesta: LANZO UNA EXCEPCION");
			}
			
			
		}
					
		@AfterClass
		public static void tearDownClass() {
			if (ejbContainer != null) {
				ejbContainer.close();
			}
		}

}

