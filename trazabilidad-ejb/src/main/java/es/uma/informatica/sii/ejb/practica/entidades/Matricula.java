/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Matricula creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity
@IdClass(Matricula.MatriculaID.class)
public class Matricula implements Serializable {


	public static class MatriculaID implements Serializable{
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		private Long Curso_Academico;
		private String IdExpediente;

		public Long getCurso_Academico() {
			return Curso_Academico;
		}

		public void setCurso_Academico(Long curso_Academico) {
			Curso_Academico = curso_Academico;
		}

		public String getIdExpediente() {
			return IdExpediente;
		}

		public void setIdExpediente(String idExpediente) {
			IdExpediente = idExpediente;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			MatriculaID that = (MatriculaID) o;
			return Objects.equals(Curso_Academico, that.Curso_Academico) && Objects.equals(IdExpediente, that.IdExpediente);
		}

		@Override
		public int hashCode() {
			return Objects.hash(Curso_Academico, IdExpediente);
		}
	}
	@Id
	protected Long Curso_Academico;

	@Id
	@ManyToOne
	private Expediente IdExpediente;


	@OneToMany
	private List<Mat_Asig> matAsig;

	private String Estado;
	private String Num_Archivo;
	private String Turno_Preferente;
	private String Fecha_Matricula;
	private String Nuevo_Ingreso;
	private String Listado_de_Asignaturas;
	private static final long serialVersionUID = 1L;





	public Expediente getIdExpediente() {
		return IdExpediente;
	}

	public void setIdExpediente(Expediente idExpediente) {
		IdExpediente = idExpediente;
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

	public String getFecha_Matricula() {
		return Fecha_Matricula;
	}

	public void setFecha_Matricula(String fecha_Matricula) {

		
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

	public List<Mat_Asig> getMatAsig() {
		return matAsig;
	}

	public void setMatAsig(List<Mat_Asig> matAsig) {
		this.matAsig = matAsig;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + ((Fecha_Matricula == null) ? 0 : Fecha_Matricula.hashCode());
		result = prime * result + ((Listado_de_Asignaturas == null) ? 0 : Listado_de_Asignaturas.hashCode());
		result = prime * result + ((Nuevo_Ingreso == null) ? 0 : Nuevo_Ingreso.hashCode());
		result = prime * result + ((Num_Archivo == null) ? 0 : Num_Archivo.hashCode());
		result = prime * result + ((Turno_Preferente == null) ? 0 : Turno_Preferente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (Curso_Academico == null) {
			if (other.Curso_Academico != null)
				return false;
		} else if (!Curso_Academico.equals(other.Curso_Academico))
			return false;
		if (Estado == null) {
			if (other.Estado != null)
				return false;
		} else if (!Estado.equals(other.Estado))
			return false;
		if (Fecha_Matricula == null) {
			if (other.Fecha_Matricula != null)
				return false;
		} else if (!Fecha_Matricula.equals(other.Fecha_Matricula))
			return false;
		if (Listado_de_Asignaturas == null) {
			if (other.Listado_de_Asignaturas != null)
				return false;
		} else if (!Listado_de_Asignaturas.equals(other.Listado_de_Asignaturas))
			return false;
		if (Nuevo_Ingreso == null) {
			if (other.Nuevo_Ingreso != null)
				return false;
		} else if (!Nuevo_Ingreso.equals(other.Nuevo_Ingreso))
			return false;
		if (Num_Archivo == null) {
			if (other.Num_Archivo != null)
				return false;
		} else if (!Num_Archivo.equals(other.Num_Archivo))
			return false;
		if (Turno_Preferente == null) {
			if (other.Turno_Preferente != null)
				return false;
		} else if (!Turno_Preferente.equals(other.Turno_Preferente))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Matricula [Curso_Academico=" + Curso_Academico + ", Estado=" + Estado + ", Num_Archivo=" + Num_Archivo
				+ ", Turno_Preferente=" + Turno_Preferente + ", Fecha_Matricula=" + Fecha_Matricula + ", Nuevo_Ingreso="
				+ Nuevo_Ingreso + ", Listado_de_Asignaturas=" + Listado_de_Asignaturas + ", mat_Asigs="
				+ "]";
	}   
	
   
}
