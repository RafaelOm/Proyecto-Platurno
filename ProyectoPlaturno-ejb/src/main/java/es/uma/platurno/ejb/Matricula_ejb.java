package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.*;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.sql.Date;

/**
 * Session Bean implementation class Matricula
 */
@Stateless
@Local
public  class Matricula_ejb implements MatriculaInterfaz {

    private Matricula mat;
    @PersistenceContext(unitName = "Matricula")
    private EntityManager em;



    public Matricula_ejb(){

    }

    public Matricula_ejb(String dato1, String dato2, String dato3){

        mat = new Matricula();
        mat.setFecha_Matricula(Date.valueOf(dato2));
        mat.setTurno_Preferente(dato3);
    }

    public Matricula_ejb(String id) throws MatriculaEJBException {
        Matricula mat = em.find(Matricula.class, id);
        if(mat == null){
            throw new MatriculaEJBException("Matricula no encontrada en la BD.");
        }
    }

    // Al modificar se le pasa una lista de parametros de matricula para modificar dicha matricula.
    @Override
    public void modificar(Matricula mat) throws modificarMatriculaException {

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
    public void ver(Matricula mat) throws verMatriculaException {

        Matricula m = em.find(Matricula.class, mat.getCurso_Academico());
        if(m!=null) {
            throw new verMatriculaException("Matricula no encontrada.");
        } else {
            // La matricula que queremos saldra por pantalla.
            System.out.println(m.toString());
        }

    }

    @Override
    public void eliminar(Matricula mat) throws eliminarMatriculaException {

        Matricula m = em.find(Matricula.class, mat.getCurso_Academico());
        if(m==null) {
            throw new eliminarMatriculaException("Matricula no encontrada.");
        } else {
            // Eliminamos de la base de datos la matricula.
            em.remove(m);
        }

    }

}