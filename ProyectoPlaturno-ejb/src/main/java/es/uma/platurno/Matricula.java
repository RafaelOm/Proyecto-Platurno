package es.uma.platurno;
import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class Matricula
 */
@Stateless
@LocalBean
public class Matricula implements MatriculaInterfaz {
	
	private Matricula mat;

	private EntityManager em;
	private EntityTransaction tx;
	
	public Matricula() {
		mat = null;
    }
	
	public Matricula(Matricula mat) {
		this.mat = mat;
	}
	
	public Matricula(List<Objects> parameters) {
		this.mat = new Matricula(parameters);
	}
	
	public Matricula getMatricula() {
		return this.mat;
	}
	
	
	public void setMatricula(List<Objects> parameters) {
		this.mat = new Matricula(parameters);
	}
	
	
// Al modificar se le pasa una lista de parametros de matricula para modificar dicha matricula.
	@Override
	public void modificar(Matricula mat) {
		tx.begin();
		// Miro si la matricula esta en la base de datos 
		Matricula m = em.find(Matricula.class, mat.Curso_Academico);
		if(m!=null) {
			throw new RuntimeException("Argumentos invalidos.");
		} else {
			m.setEstado(mat.estado);
			m.setNum_Archivo(mat.num_Archivo);
			m.setTurno_Preferente(mat.turno_Preferente);
			m.setFecha_Matricula(mat.fecha_Matricula);
			m.setNuevo_Ingreso(mat.nuevo_Ingreso);
			m.setListado_de_Asignaturas(mat.listado_de_Asignaturas);
		}
		em.merge(m);
		tx.commit();
	}

	@Override
	public void ver(Matricula mat) {
		tx.begin();
		Matricula m = em.find(Matricula.class, mat.Curso_Academico);
		if(m!=null) {
			throw new RuntimeException("Matricula no encontrada.");
		} else {
			System.out.println(m.toString());
		}
		tx.commit();
	}
	
	@Override 
	public void eliminar(Matricula mat) {
		tx.begin();
		Matricula m = em.find(Matricula.class, mat.Curso_Academico);
		if(m==null) {
			throw new RuntimeException("Matricula no encontrada.");
		} else {
			em.remove(m);
		}
		tx.commit();
	}
	
}
