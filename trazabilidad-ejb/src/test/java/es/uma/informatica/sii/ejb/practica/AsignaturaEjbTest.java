package es.uma.informatica.sii.ejb.practica;

import es.uma.informatica.sii.ejb.practica.*;
import es.uma.informatica.sii.ejb.practica.ejb.*;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import es.uma.informatica.sii.ejb.practica.entidades.*;

import org.glassfish.grizzly.http.server.naming.NamingException;
import org.junit.*;
import es.uma.informatica.sii.anotaciones.Requisitos;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Properties;
import java.util.logging.Logger;

public class AsignaturaEjbTest {
	
	private static final Logger LOG = Logger.getLogger(AsignaturaEjbTest.class.getCanonicalName());

	private static final String ASIGNATURAEJB = "java:global/classes/AsignaturasEjb!es.uma.informatica.sii.ejb.practica.ejb.AsignaturasEjbInterfaz";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String USUARIOEJB = "java:global/classes/AlumnoEjb!es.uma.informatica.sii.ejb.practica.ejb.AlumnoInterface";
	private static final String AUTENTICACION = "java:global/classes/Autenticacion!es.uma.informatica.sii.ejb.practica.ejb.AutenticacionInterfaz";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrazabilidadTest";
	

	private AsignaturasEjbInterfaz asignaturaEjb;
	private AlumnoInterface UsuarioEjb;
	private AutenticacionInterfaz auth;
	private static EJBContainer ejbContainer;
	private static Context ctx;


	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@Before
	public void setup() throws NamingException, javax.naming.NamingException {
		asignaturaEjb = (AsignaturasEjbInterfaz) ctx.lookup(ASIGNATURAEJB);
		UsuarioEjb = (AlumnoInterface) ctx.lookup(USUARIOEJB);
		 auth = (AutenticacionInterfaz) ctx.lookup(AUTENTICACION);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Ignore
	@Requisitos({"RF-02"})
	@Test
	public void verAsignaturaTest() {
		Alumno al=new Alumno();
		al.setIdentificador(3L);
		al.setUsername("PEPE");
		al.setPassword("1234");
		al.setEmail_personal("sd");
		al.setEmail_institucional("iferjeir");
		al.setMovil("234");

		
		Titulacion t = new Titulacion();
		t.setCodigo(Integer.toString(25));
		t.setCreditos(Integer.toString(240));
		t.setNombre("Informatica");

		Asignatura asig =new Asignatura();
		asig.setReferencia("1234");
		asig.setNombre("CALCULO");
		asig.setOfertada("POR DESGRACIA");
		asig.setCreditos(6);
		asig.setCodigo(103);
		asig.setTitulacion(t);
		
		
		try {
			
			asignaturaEjb.verAsignatura(al, "1234");
			
		} catch (AsignaturaInexsistenteException | PasswordErroneaException | CuentaInexistenceException | CuentaInactivaException | PlaturnoException e) {
			// TODO Auto-generated catch block
			fail("ERROR EN TEST " + e.toString());
			e.printStackTrace();
		}
		
	}

	@Ignore
	@Requisitos({"RF-02"})
	@Test
	public void modificarAsignaturaTest() {
	//	Alumno a = new Alumno("Pepe","pepiot",1L);

		Secretaria s = new Secretaria();
		s.setDni("1234");
		s.setUsername("RAFAEL");
		s.setPassword("jeje");
		s.setIdentificador(1L);
		//s.setIdentificador(125L);
		/*
		Titulacion t = new Titulacion();
		t.setCodigo(Integer.toString(25));
		t.setCreditos(Integer.toString(240));
		t.setNombre("Informatica");*/
		
		Asignatura asig= new Asignatura();
		asig.setReferencia("1234");
		asig.setNombre("CALCULO2");
		asig.setOfertada("POR DESGRACIA");
		asig.setCreditos(6);
		asig.setCodigo(103);

		//fail("modificar asignaturaaaaa");
		try {
			asignaturaEjb.modificarAsignatura(s,asig);
			Asignatura asigNew= asignaturaEjb.verAsignatura(s, "1234");			
			assertEquals("CALCULO2", asigNew.getNombre());
			
		} catch (AsignaturaInexsistenteException | PasswordErroneaException | CuentaInexistenceException
				| CuentaInactivaException | PlaturnoException |ViolacionDeSeguridadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ERROR EN TEST " + e.toString());
		} 
		
	}
	@Ignore
	@Requisitos({"RF-02"})
	@Test
	public void eliminarAsignaturaTest() {
		//Alumno a = new Alumno("Pepe","pepiot",1L);


		Secretaria s = new Secretaria();
		s.setDni("1234");
		s.setUsername("RAFAEL");
		s.setPassword("jeje");
		s.setIdentificador(1L);
		
		/*Titulacion t = new Titulacion();
		t.setCodigo(Integer.toString(25));
		t.setCreditos(Integer.toString(240));
		t.setNombre("Informatica");*/
		
		Asignatura asig= new Asignatura();
		asig.setReferencia("1234");
		asig.setNombre("CALCULO2");
		asig.setOfertada("POR DESGRACIA");
		asig.setCreditos(6);
		asig.setCodigo(103);
		
		try {
			asignaturaEjb.eliminarAsignatura(s, asig);
						
		} catch (AsignaturaInexsistenteException | PasswordErroneaException | CuentaInexistenceException
				| CuentaInactivaException | PlaturnoException |ViolacionDeSeguridadException e) {
			fail("ERROR EN TEST " + e.toString());
		} 
		
		try {
			Asignatura anew = asignaturaEjb.verAsignatura(s, "1234");
			
		}catch (AsignaturaInexsistenteException | PasswordErroneaException | CuentaInexistenceException
				| CuentaInactivaException | PlaturnoException e) {
			fail("OKAY "+ e.toString());
		}
	}
	@Ignore
	@Test 
	public void TestRegistro() {
		Alumno al=new Alumno();
		al.setUsername("MANOLO");
		al.setPassword("1234");
		al.setEmail_personal("sd");
		al.setEmail_institucional("iferjeir");
		al.setMovil("234");
		
		
			try {
				auth.registrarUsuario(al, null);
			} catch (PlaturnoException | CuentaExistenteException e) {
				// TODO Auto-generated catch block
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
