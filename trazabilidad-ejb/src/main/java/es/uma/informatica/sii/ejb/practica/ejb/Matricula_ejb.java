package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Session Bean implementation class Matricula
 */
@Stateless
@Local
public class Matricula_ejb implements MatriculaInterfaz {

    @PersistenceContext(unitName = "abc")
    private EntityManager em;
    @Inject
    private AutenticacionInterfaz auth;
    private static final Logger LOGGER = Logger.getLogger(Matricula_ejb.class.getCanonicalName());


    public Matricula_ejb(){

    }

    public Matricula_ejb(String dato1,String dato2,String dato3){

    }

@Override
    public List<Matricula> getAll() {
  
    	
    	Query query =em.createQuery("SELECT a FROM Matricula a");
    	List<Matricula> Matricula =query.getResultList();
    	LOGGER.info("LECTURA DE BD "+Matricula.toString());
		return  Matricula;
    	
    }
@Override
public void crearMatricula(Matricula nueva, Usuario usuario) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException, MatriculaNoExiteException{
    	
    	auth.compruebaLogin(usuario);
  
    		LOGGER.info("CREAR- Matricula: PARAMETRO"+nueva.toString()+"USER TEST: "+usuario.toString());
    
    		Matricula.MatriculaID id = new Matricula.MatriculaID();
    		id.setCurso_Academico(nueva.getCurso_Academico());
    		id.setIdExpediente(nueva.getIdExpediente().getExpediente());
    		
    	Matricula t =em.find(Matricula.class, id);
    	
    	if(t!=null) {
    		throw new MatriculaNoExiteException("La Matricula ya existe.");
    	}
    		LOGGER.info("CREAR- Matricula: "+nueva.toString());
    	em.merge(nueva);
    	
    	
    }
    
    // Al modificar se le pasa una lista de parametros de matricula para modificar dicha matricula.
    @Override
    public void modificar(Usuario u,Matricula mat) throws modificarMatriculaException, PasswordErroneaException,
            CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
        //////Check if user is authenticated in the system  ////////////
        
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        // Miro si la matricula esta en la base de datos

		Matricula.MatriculaID id = new Matricula.MatriculaID();
		id.setCurso_Academico(mat.getCurso_Academico());
		id.setIdExpediente(mat.getIdExpediente().getExpediente());
        Matricula m = em.find(Matricula.class, id);
        LOGGER.info("MODIFICAR- Matricula: "+mat.toString());
        if(m==null) {
            throw new modificarMatriculaException("Argumentos invalidos.");
        } else {
            // Cambiamos todos los atributos aunque se sobreescriban.
            m.setEstado(mat.getEstado());
            m.setNum_Archivo(mat.getNum_Archivo());
            m.setTurno_Preferente(mat.getTurno_Preferente());
            m.setFecha_Matricula(mat.getFecha_Matricula().toString());
            m.setNuevo_Ingreso(mat.getNuevo_Ingreso());
            m.setListado_de_Asignaturas(mat.getListado_de_Asignaturas());
        }
        em.merge(m);

    }

    @Override
    public void ver(Usuario u,Matricula mat) throws verMatriculaException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
        //////Check if user is authenticated in the system  ////////////
        
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////
        Matricula.MatriculaID id = new Matricula.MatriculaID();
		id.setCurso_Academico(mat.getCurso_Academico());
		id.setIdExpediente(mat.getIdExpediente().getExpediente());
        Matricula m = em.find(Matricula.class, id);
        if(m!=null) {
            throw new verMatriculaException("Matricula no encontrada.");
        } else {
            // La matricula que queremos saldra por pantalla.
            System.out.println(m.toString());
        }

    }

    @Override
    public void eliminar(Usuario u,Matricula mat) throws eliminarMatriculaException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
        //////Check if user is authenticated in the system  ////////////
        
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////
        Matricula.MatriculaID id = new Matricula.MatriculaID();
		id.setCurso_Academico(mat.getCurso_Academico());
		id.setIdExpediente(mat.getIdExpediente().getExpediente());
        Matricula m = em.find(Matricula.class, id);
        if(m==null) {
            throw new eliminarMatriculaException("Matricula no encontrada.");
        } else {
            // Eliminamos de la base de datos la matricula.
            em.remove(em.merge(m));
        }

    }

}