package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.eliminarMatriculaException;
import es.uma.platurno.ejb.exceptions.modificarMatriculaException;
import es.uma.platurno.ejb.exceptions.verMatriculaException;
import es.uma.platurno.jpa.*;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Session Bean implementation class Matricula
 */
@Stateless
@Local
public  class Matricula_ejb implements MatriculaInterfaz {

    private Matricula mat;
    private EntityManager em;
    private EntityTransaction tx;

    public Matricula_ejb(){

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
        tx.begin();
        Matricula m = em.find(Matricula.class, mat.getCurso_Academico());
        if(m!=null) {
            throw new verMatriculaException("Matricula no encontrada.");
        } else {
            // La matricula que queremos saldra por pantalla.
            System.out.println(m.toString());
        }
        tx.commit();
    }

    @Override
    public void eliminar(Matricula mat) throws eliminarMatriculaException {
        tx.begin();
        Matricula m = em.find(Matricula.class, mat.getCurso_Academico());
        if(m==null) {
            throw new eliminarMatriculaException("Matricula no encontrada.");
        } else {
            // Eliminamos de la base de datos la matricula.
            em.remove(m);
        }
        tx.commit();
    }

}
