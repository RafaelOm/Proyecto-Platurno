package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;
import javax.ejb.Local;
import javax.ejb.Stateless;
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
    private Autenticacion auth;



    public Matricula_ejb(){

    }

    public Matricula_ejb(String dato1,String dato2,String dato3){

    }


    // Al modificar se le pasa una lista de parametros de matricula para modificar dicha matricula.
    @Override
    public void modificar(Usuario u,Matricula mat) throws modificarMatriculaException, PasswordErroneaException,
            CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        // Miro si la matricula esta en la base de datos
        Matricula m = em.find(Matricula.class, mat.getCurso_Academico());
        if(m!=null) {
            throw new modificarMatriculaException("Argumentos invalidos.");
        } else {
            // Cambiamos todos los atributos aunque se sobreescriban.
            m.setEstado(mat.getEstado());
            m.setNum_Archivo(mat.getNum_Archivo());
            m.setTurno_Preferente(mat.getTurno_Preferente());
            m.setFecha_Matricula(mat.getFecha_Matricula());
            m.setNuevo_Ingreso(mat.getNuevo_Ingreso());
            m.setListado_de_Asignaturas(mat.getListado_de_Asignaturas());
        }
        em.merge(m);

    }

    @Override
    public void ver(Usuario u,Matricula mat) throws verMatriculaException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////
        Matricula m = em.find(Matricula.class, mat.getCurso_Academico());
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
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////
        Matricula m = em.find(Matricula.class, mat.getCurso_Academico());
        if(m==null) {
            throw new eliminarMatriculaException("Matricula no encontrada.");
        } else {
            // Eliminamos de la base de datos la matricula.
            em.remove(m);
        }

    }

}