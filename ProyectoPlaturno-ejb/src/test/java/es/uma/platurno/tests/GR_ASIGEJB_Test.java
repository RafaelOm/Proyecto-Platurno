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

public class GR_ASIGEJB_Test {
    private static final String GR_ASIGEJB = "/ProyectoPlaturno-ejb/src/main/java/es/uma/platurno/ejb/GR_ASIGEJBInterfaz.java";
    private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
    private static final String CONFIG_FILE = "src/test/resources/META-INF/domain.xml";
    private static final String USUARIOEJB = "java:global/classes/UsuarioEjb!es.uma.platurno.ejb.UsuarioEjbInterfaz";
    private static final String AUTENTICACION = "java:global/classes/Autenticacion!es.uma.platurno.ejb.AutenticacionInterfaz";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";

    private static EJBContainer ejbContainer;
    private static Context ctx;

    private GR_ASIGEJB gr_asigejb;
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
        gr_asigejb = (GR_ASIGEJB) ctx.lookup(GR_ASIGEJB);
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

        Asignatura asig =new Asignatura();
        asig.setReferencia("146");

        Encuesta encuesta = new Encuesta();
        encuesta.setId_Encuesta("asasasa");

        Grupo grupo = new Grupo();
        grupo.setId("123");

        GR_ASIG gr_asig = new GR_ASIG();
        gr_asig.setAsig(asig);
        gr_asig.setOferta(2);
        gr_asig.setCurso_act(2);
        List<Encuesta> encuestaList = null;
        gr_asig.setEncuesta(encuesta);
        gr_asig.setGroup(grupo);


        try {
            auth.compruebaLogin(a);
        } catch (PlaturnoException | CuentaInactivaException | CuentaInexistenceException
                | PasswordErroneaException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        try {
            gr_asigejb.ReadGR_ASIG(a,gr_asig.getCurso_act(),asig.getReferencia(),grupo.getId());
        } catch (GR_ASIG_GrupoNoExisteException e) {
            e.printStackTrace();
        } catch (PlaturnoException e) {
            e.printStackTrace();
        }

        try {
            gr_asigejb.UpdateGR_ASIG(a,gr_asig.getCurso_act(),asig.getReferencia(),grupo.getId(),3);
        } catch (GR_ASIG_GrupoNoExisteException e) {
            e.printStackTrace();
        } catch (PlaturnoException e) {
            e.printStackTrace();
        }

        try {
            gr_asigejb.DeleteGR_ASIG(a,gr_asig.getCurso_act(),asig.getReferencia(),grupo.getId());
        } catch (GR_ASIG_GrupoNoExisteException e) {
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

