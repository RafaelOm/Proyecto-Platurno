package es.uma.platurno.tests;

import static org.junit.Assert.fail;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.glassfish.grizzly.http.server.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.platurno.ejb.AsignaturasEjb;
import es.uma.platurno.ejb.AsignaturasEjbInterfaz;
import es.uma.platurno.ejb.AutenticacionInterfaz;
import es.uma.platurno.ejb.Solicitud_Cambio_Grupo_Interfaz;
import es.uma.platurno.ejb.UsuarioEjbInterfaz;
import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.GR_ASIG_GrupoNoExisteException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.Alumno;
import es.uma.platurno.jpa.Asignatura;
import es.uma.platurno.jpa.GR_ASIG;

public class CG_Ejb_Test {
	private static final String ASIGNATURAEJB = "/ProyectoPlaturno-ejb/src/main/java/es/uma/platurno/ejb/Solicitud_Cambio_Grupo_Interfaz.java"; 
	private static final String Cambio_Grupo = "/ProyectoPlaturno-ejb/src/main/java/es/uma/platurno/ejb/Solicitud_Cambio_Grupo_Interfaz.java"; 

	private static final String USUARIOEJB = "java:global/classes/UsuarioEjb!es.uma.platurno.ejb.UsuarioEjbInterfaz";
	private static final String AUTENTICACION = "java:global/classes/Autenticacion!es.uma.platurno.ejb.AutenticacionInterfaz";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";
	


	//private AsignaturasEjb asignaturaEjb;
	private Solicitud_Cambio_Grupo_Interfaz scg;
	private UsuarioEjbInterfaz UsuarioEjb;
	private AutenticacionInterfaz auth;
	private AsignaturasEjbInterfaz asignaturaEjb;
	



	@Before
	public void setup() throws NamingException, javax.naming.NamingException {
		asignaturaEjb = (AsignaturasEjb) TestSuite.ctx.lookup(ASIGNATURAEJB);
		scg = (Solicitud_Cambio_Grupo_Interfaz) TestSuite.ctx.lookup(Cambio_Grupo);
		UsuarioEjb = (UsuarioEjbInterfaz) TestSuite.ctx.lookup(USUARIOEJB);
		 auth = (AutenticacionInterfaz) TestSuite.ctx.lookup(AUTENTICACION);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Ignore
	@Test
	public void testCompruebaSCG() throws  CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException{
		Alumno a = new Alumno("Pepe","pepiot",1L);

		Asignatura as = new Asignatura();
		
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
		
		GR_ASIG old = new GR_ASIG(), nuevo = new GR_ASIG();
		
		old.setGroup(old.getGroup());
		
		old.setCurso_act(old.getCurso_act());
		
		old.setAsig(as);
		
		nuevo.setGroup(nuevo.getGroup());
		
		nuevo.setCurso_act(nuevo.getCurso_act());
		
		old.setAsig(as);
		
		try {
			auth.compruebaLogin(a);
		} catch (PlaturnoException | CuentaInactivaException | CuentaInexistenceException
				| PasswordErroneaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			scg.generarSolicitud( old, nuevo, a);
		} catch (GR_ASIG_GrupoNoExisteException e) {
			// TODO Auto-generated catch block
			fail("Error, grupo no encontrado");
			e.printStackTrace();
		}

	}


}
