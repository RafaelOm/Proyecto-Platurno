package es.uma.platurno.tests;

import es.uma.platurno.ejb.AsignaturasEjb;
import es.uma.platurno.ejb.Autenticacion;
import es.uma.platurno.ejb.*;
import es.uma.platurno.ejb.exceptions.AsignaturaInexsistenteException;
import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.platurno.jpa.Alumno;
import es.uma.platurno.jpa.Asignatura;
import es.uma.platurno.jpa.Secretaria;
import es.uma.platurno.jpa.Titulacion;
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

	private static final String ASIGNATURAEJB = "java:global/classes/AsignaturasEjb!es.uma.platurno.ejb.AsignaturasEjbInterfaz";

	private static final String USUARIOEJB = "java:global/classes/UsuarioEjb!es.uma.platurno.ejb.UsuarioEjbInterfaz";
	private static final String AUTENTICACION = "java:global/classes/Autenticacion!es.uma.platurno.ejb.AutenticacionInterfaz";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";
	

	private AsignaturasEjb asignaturaEjb;
	private UsuarioEjbInterfaz UsuarioEjb;
	private AutenticacionInterfaz auth;
	

	


	@Before
	public void setup() throws NamingException, javax.naming.NamingException {
		asignaturaEjb = (AsignaturasEjb) TestSuite.ctx.lookup(ASIGNATURAEJB);
		UsuarioEjb = (UsuarioEjbInterfaz) TestSuite.ctx.lookup(USUARIOEJB);
		 auth = (AutenticacionInterfaz) TestSuite.ctx.lookup(AUTENTICACION);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Ignore
	@Test
	public void verAsignaturaTest() {
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
		
		Titulacion t = new Titulacion();
		t.setCodigo(25);
		t.setCreditos(240);
		t.setNombre("Informatica");
		
		Asignatura asig= new Asignatura();
		asig.setCodigo(20);
		asig.setTitulacion(t);
		asig.setReferencia("1233454");
		
		
		try {
			asignaturaEjb.verAsignatura(a,asig );
		} catch (AsignaturaInexsistenteException | PasswordErroneaException | CuentaInexistenceException
				| CuentaInactivaException | PlaturnoException e) {
			// TODO Auto-generated catch block
			fail("ERROR EN TEST");
			e.printStackTrace();
		}
		
	}
	
	@Ignore
	@Test
	public void modificarAsiganturaTest() {
		Alumno a = new Alumno("Pepe","pepiot",1L);


		Secretaria s = new Secretaria("Rafael","prueba",125L);
		
		Titulacion t = new Titulacion();
		t.setCodigo(25);
		t.setCreditos(240);
		t.setNombre("Informatica");
		
		Asignatura asig= new Asignatura();
		asig.setCodigo(20);
		asig.setTitulacion(t);
		asig.setReferencia("1233454");
		
		
		try {
			asignaturaEjb.modificarAsignatura(s,asig);
		} catch (AsignaturaInexsistenteException | PasswordErroneaException | CuentaInexistenceException
				| CuentaInactivaException | PlaturnoException |ViolacionDeSeguridadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ERROR EN TEST");
		} 
		
	}
	@Ignore
	@Test
	public void eliminarAsignaturaTest() {
		Alumno a = new Alumno("Pepe","pepiot",1L);


		Secretaria s = new Secretaria("Rafael","prueba",125L);
		
		Titulacion t = new Titulacion();
		t.setCodigo(25);
		t.setCreditos(240);
		t.setNombre("Informatica");
		
		Asignatura asig= new Asignatura();
		asig.setCodigo(20);
		asig.setTitulacion(t);
		asig.setReferencia("1233454");
		
		
		try {
			asignaturaEjb.eliminarAsignatura(s,asig);
		} catch (AsignaturaInexsistenteException | PasswordErroneaException | CuentaInexistenceException
				| CuentaInactivaException | PlaturnoException |ViolacionDeSeguridadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ERROR EN TEST");
		} 
		
	}
	


	


}
