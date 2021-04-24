package es.uma.platurno.tests;

import static org.junit.Assert.fail;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import es.uma.platurno.ejb.*;
import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Expediente;
import org.glassfish.grizzly.http.server.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.platurno.jpa.Alumno;
import es.uma.platurno.jpa.Asignatura;
import es.uma.platurno.jpa.GR_ASIG;

public class ExpedienteEJB_Test {
    private static final String EXPEDIENTEEJB = "/ProyectoPlaturno-ejb/src/main/java/es/uma/platurno/ejb/ExpedienteInterfaz.java";
   
    private static final String USUARIOEJB = "java:global/classes/UsuarioEjb!es.uma.platurno.ejb.UsuarioEjbInterfaz";
    private static final String AUTENTICACION = "java:global/classes/Autenticacion!es.uma.platurno.ejb.AutenticacionInterfaz";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";



    private ExpedienteEJB ExpEjb;
    private Solicitud_Cambio_Grupo_Interfaz scg;
    private UsuarioEjbInterfaz UsuarioEjb;
    private AutenticacionInterfaz auth;
    private AsignaturasEjbInterfaz asignaturaEjb;




    @Before
    public void setup() throws NamingException, javax.naming.NamingException {
        ExpEjb = (ExpedienteEJB) TestSuite.ctx.lookup(EXPEDIENTEEJB);
        UsuarioEjb = (UsuarioEjbInterfaz) TestSuite.ctx.lookup(USUARIOEJB);
        auth = (AutenticacionInterfaz) TestSuite.ctx.lookup(AUTENTICACION);
        BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
    }
    @Ignore
    @Test
    public void testCompruebaExpediente() throws  CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException{
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

        Expediente ex = new Expediente();
        ex.setId_Expediente("11111");
        ex.setActivo("SI");
        ex.setNotaMPr(1);
        ex.setCreditosSup(1.0);
        ex.setCreditosFB(1.0);
        ex.setCreditosOP(1.0);
        ex.setCreditosOB(1.0);
        ex.setCreditosCF(1.0);
        ex.setCreditosPE(1.0);
        ex.setCreditosTF(1.0);
        ex.setN_Archivo("aaaa");


        try {
            auth.compruebaLogin(a);
        } catch (PlaturnoException | CuentaInactivaException | CuentaInexistenceException
                | PasswordErroneaException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        try {
            ExpEjb.ReadExpediente(a,ex.getId_Expediente());
        } catch (ExpedienteNoExisteException e) {
            // TODO Auto-generated catch block
            fail("Error, grupo no encontrado");
            e.printStackTrace();
        } catch (PlaturnoException e) {
            e.printStackTrace();
        }

        try {
            ExpEjb.UpdateExpediente(ex.getId_Expediente(),"SI",2.0,2.0,
                    2.0,2.0,2.0,2.0,2.0,2.0,"bbb");
        } catch (ExpedienteNoExisteException e) {
            e.printStackTrace();
        }

        try {
            ExpEjb.DeleteExpediente(a,ex.getId_Expediente());
        } catch (ExpedienteNoExisteException e) {
            e.printStackTrace();
        } catch (PlaturnoException e) {
            e.printStackTrace();
        }
    }


}

