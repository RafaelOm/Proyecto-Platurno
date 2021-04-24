package es.uma.platurno.tests;

import es.uma.informatica.sii.anotaciones.Requisitos;
import es.uma.platurno.ejb.*;
import es.uma.platurno.jpa.*;
import org.glassfish.grizzly.http.server.naming.NamingException;
import org.junit.*;

import static org.junit.Assert.fail;
import java.sql.Date;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Properties;
import java.util.logging.Logger;
import es.uma.platurno.ejb.exceptions.*;

public class MatriculaEjbTest {

    private static final Logger LOG = Logger.getLogger(MatriculaEjbTest.class.getCanonicalName());
    private static final String MATRICULAEJB = "java:global/classes/Matricula_ejb!es.uma.platurno.ejb.MatriculaInterfaz";

    private static final String USUARIOEJB = "java:global/classes/UsuarioEjb!es.uma.platurno.ejb.UsuarioEjbInterfaz";
    private static final String AUTENTICACION = "java:global/classes/Autenticacion!es.uma.platurno.ejb.AutenticacionInterfaz";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "Trazabilidad";


    //private AsignaturasEjb asignaturaEjb;
    private UsuarioEjbInterfaz UsuarioEjb;
    private AutenticacionInterfaz auth;
    private MatriculaInterfaz mat_ejb;

    @PersistenceContext(unitName = "ProyectoPlaturno.GrupoF")
    private EntityManager em;



    @Before
    public void setup() throws NamingException, javax.naming.NamingException {
        //asignaturaEjb = (AsignaturasEjb) ctx.lookup(ASIGNATURAEJB);
        UsuarioEjb = (UsuarioEjbInterfaz) TestSuite.ctx.lookup(USUARIOEJB);
        auth = (AutenticacionInterfaz) TestSuite.ctx.lookup(AUTENTICACION);
        BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
    }
    
    @Requisitos({"RF-07"})
    @Ignore
    @Test
    public void testCompruebaVerMatricula(){
        Matricula mat = new Matricula();
        Alumno al = new Alumno();
        // Atributos
        Date fecha = new Date(2010, 8, 31);
        mat.setFecha_Matricula(fecha);
        mat.setTurno_Preferente("Turno Preferente 2");
        mat.setCurso_Academico(2010L);
 
        al.setIdentificador(10L);
 
        try{
            mat_ejb.ver(al,mat);
        } catch (PasswordErroneaException | CuentaInactivaException | CuentaInexistenceException | PlaturnoException
                | verMatriculaException e) {
            fail("Lanzamos una excepcion.");
        }
 
    }
 
    @Requisitos({"RF-07"})
    @Ignore
    @Test
    public void testCompruebaModificarMatricula(){
        Matricula mat = new Matricula();
        Alumno al = new Alumno();
        // Atributos
        Date fecha = new Date(2010, 8, 31);
        mat.setFecha_Matricula(fecha);
        mat.setTurno_Preferente("Turno Preferente 2");
        mat.setCurso_Academico(2010L);
 
        al.setIdentificador(10L);
 
        try{
            mat_ejb.modificar(al,mat);
        } catch (PasswordErroneaException | CuentaInactivaException | CuentaInexistenceException | PlaturnoException
                |  modificarMatriculaException e) {
            fail("Lanzamos una excepcion.");
        }
 
    }
 
    @Requisitos({"RF-07"})
    @Ignore
    @Test
    public void testCompruebaEliminarMatricula(){
        Matricula mat = new Matricula();
        Alumno al = new Alumno();
        // Atributos
        Date fecha = new Date(2010, 8, 31);
        mat.setFecha_Matricula(fecha);
        mat.setTurno_Preferente("Turno Preferente 2");
        mat.setCurso_Academico(2010L);
 
        al.setIdentificador(10L);
 
        try{
            mat_ejb.eliminar(al,mat);
        } catch (PasswordErroneaException | CuentaInactivaException | CuentaInexistenceException | PlaturnoException
                | eliminarMatriculaException e) {
            fail("Lanzamos una excepcion.");
        }
 
    }



}
