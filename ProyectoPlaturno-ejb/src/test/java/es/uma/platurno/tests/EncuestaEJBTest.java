package es.uma.platurno.tests;

import es.uma.informatica.sii.anotaciones.Requisitos;
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
		
		private static final String ENCUESTAEJB = "java:global/classes/EncuestaEJB!es.uma.platurno.ejb.EncuestaInterfaceEJB";
		private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";
		
		private EncuestaInterfaceEJB encuestaEjb;
		
		@Before
		public void setup() throws NamingException, javax.naming.NamingException {
			encuestaEjb = (EncuestaInterfaceEJB) TestSuite.ctx.lookup(ENCUESTAEJB);
			
			BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		}
		
		@Requisitos({"RF-10"})
		@Ignore
		@Test
		public void testCrearEncuesta(){
			
			try {
				Secretaria s = new Secretaria("Rafael","prueba", 125L);
				encuestaEjb.crearEncuesta(s, new java.sql.Date(Calendar.getInstance().getTime().getTime()), "¿Quieres elegir este horario?");
				
			}catch(Exception ex) {
				ex.printStackTrace();
				fail("testCrearEncuesta: LANZO UNA EXCEPCION");
			}
			
		}
					
}

