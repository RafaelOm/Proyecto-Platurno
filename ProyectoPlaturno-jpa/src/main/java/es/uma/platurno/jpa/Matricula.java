package es.uma.platurno.jpa;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity

public class Matricula implements Serializable {

	   
	@Id
	private Long Curso_Academico;
	
	private String Estado;
	private String Num_Archivo;
	private String Turno_Preferente;
	private Date Fecha_Matricula;
	private String Nuevo_Ingreso;
	private String Listado_de_Asignaturas;
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private java.util.List<Mat_Asig> mat_Asigs;


	@ManyToOne
	private Expediente expediente;

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente e) {
		this.expediente = e;
	}


	public Matricula() {
		super();
	}

	public Long getCurso_Academico() {
		return Curso_Academico;
	}

	public void setCurso_Academico(Long curso_Academico) {
		Curso_Academico = curso_Academico;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getNum_Archivo() {
		return Num_Archivo;
	}

	public void setNum_Archivo(String num_Archivo) {
		Num_Archivo = num_Archivo;
	}

	public String getTurno_Preferente() {
		return Turno_Preferente;
	}

	public void setTurno_Preferente(String turno_Preferente) {
		Turno_Preferente = turno_Preferente;
	}

	public Date getFecha_Matricula() {
		return Fecha_Matricula;
	}

	public void setFecha_Matricula(Date fecha_Matricula) {
		Fecha_Matricula = fecha_Matricula;
	}

	public String getNuevo_Ingreso() {
		return Nuevo_Ingreso;
	}

	public void setNuevo_Ingreso(String nuevo_Ingreso) {
		Nuevo_Ingreso = nuevo_Ingreso;
	}

	public String getListado_de_Asignaturas() {
		return Listado_de_Asignaturas;
	}

	public void setListado_de_Asignaturas(String listado_de_Asignaturas) {
		Listado_de_Asignaturas = listado_de_Asignaturas;
	}

	public java.util.List<Mat_Asig> getMat_Asigs() {
		return mat_Asigs;
	}

	public void setMat_Asigs(java.util.List<Mat_Asig> mat_Asigs) {
		this.mat_Asigs = mat_Asigs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Matricula matricula = (Matricula) o;
		return Objects.equals(Curso_Academico, matricula.Curso_Academico) && Objects.equals(Estado, matricula.Estado) && Objects.equals(Num_Archivo, matricula.Num_Archivo) && Objects.equals(Turno_Preferente, matricula.Turno_Preferente) && Objects.equals(Fecha_Matricula, matricula.Fecha_Matricula) && Objects.equals(Nuevo_Ingreso, matricula.Nuevo_Ingreso) && Objects.equals(Listado_de_Asignaturas, matricula.Listado_de_Asignaturas) && Objects.equals(mat_Asigs, matricula.mat_Asigs) && Objects.equals(expediente, matricula.expediente);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Curso_Academico, Estado, Num_Archivo, Turno_Preferente, Fecha_Matricula, Nuevo_Ingreso, Listado_de_Asignaturas, mat_Asigs, expediente);
	}

	@Override
	public String toString() {
		return "Matricula{" +
				"Curso_Academico=" + Curso_Academico +
				", Estado='" + Estado + '\'' +
				", Num_Archivo='" + Num_Archivo + '\'' +
				", Turno_Preferente='" + Turno_Preferente + '\'' +
				", Fecha_Matricula=" + Fecha_Matricula +
				", Nuevo_Ingreso='" + Nuevo_Ingreso + '\'' +
				", Listado_de_Asignaturas='" + Listado_de_Asignaturas + '\'' +
				", mat_Asigs=" + mat_Asigs +
				", e=" + expediente +
				'}';
	}
}
