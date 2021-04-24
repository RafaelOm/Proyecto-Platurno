package es.uma.platurno.tests;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import es.uma.platurno.ejb.*;
import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.*;
import org.glassfish.grizzly.http.server.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ASIGNAR_GRUPO_AUTO_Test {
    private static final String ASIGNAR_GRUPO_EJB = "/ProyectoPlaturno-ejb/src/main/java/es/uma/platurno/ejb/ASIGNAR_GRUPO_AUTOInterfaz.java";
    private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
    private static final String CONFIG_FILE = "src/test/resources/META-INF/domain.xml";
    private static final String USUARIOEJB = "java:global/classes/UsuarioEjb!es.uma.platurno.ejb.UsuarioEjbInterfaz";
    private static final String AUTENTICACION = "java:global/classes/Autenticacion!es.uma.platurno.ejb.AutenticacionInterfaz";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";

    private static EJBContainer ejbContainer;
    private static Context ctx;

    private ASIGNAR_GRUPO_AUTO asignar_grupo_auto;
    private Solicitud_Cambio_Grupo_Interfaz scg;
    private UsuarioEjbInterfaz UsuarioEjb;
    private AutenticacionInterfaz auth;
    private AsignaturasEjbInterfaz asignaturaEjb;



    @BeforeClass
    public static void setUpClass() {
        Properties properties = new Properties();
        properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
        ejbContainer = EJBContainer.createEJBContainer(properties);
        ctx = ejbContainer.getContext();
    }

    @Before
    public void setup() throws NamingException, javax.naming.NamingException {
        asignar_grupo_auto = (ASIGNAR_GRUPO_AUTO) ctx.lookup(ASIGNAR_GRUPO_EJB);
        UsuarioEjb = (UsuarioEjbInterfaz) ctx.lookup(USUARIOEJB);
        auth = (AutenticacionInterfaz) ctx.lookup(AUTENTICACION);
        BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
    }

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

        Titulacion t= new Titulacion();
        t.setCreditos(240);
        t.setCodigo(23);
        t.setNombre("Ingenieria Informatica");

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
        ex.setTitulacion(t);


        try {
            auth.compruebaLogin(a);
        } catch (PlaturnoException | CuentaInactivaException | CuentaInexistenceException
                | PasswordErroneaException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        try {
            asignar_grupo_auto.ASIGNAR(a,ex);
        } catch (EncuestaNoExisteException e) {
            e.printStackTrace();
        } catch (PlaturnoException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }
}

