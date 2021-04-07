package es.uma.platurno;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity

public class Matricula implements Serializable {

	   
	@Id
	private long Curso_Academico;
	private String Estado;
	private String Num_Archivo;
	private String Turno_Preferente;
	private Date Fecha_Matricula;
	private String Nuevo_Ingreso;
	private String Listado_de_Asignaturas;
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private java.util.List<Mat_Asig> mat_Asigs;

	public Matricula() {
		super();
	}   
	public long getCurso_Academico() {
		return this.Curso_Academico;
	}

	public void setCurso_Academico(long Curso_Academico) {
		this.Curso_Academico = Curso_Academico;
	}   
	public String getEstado() {
		return this.Estado;
	}

	public void setEstado(String Estado) {
		this.Estado = Estado;
	}   
	public String getNum_Archivo() {
		return this.Num_Archivo;
	}

	public void setNum_Archivo(String Num_Archivo) {
		this.Num_Archivo = Num_Archivo;
	}   
	public String getTurno_Preferente() {
		return this.Turno_Preferente;
	}

	public void setTurno_Preferente(String Turno_Preferente) {
		this.Turno_Preferente = Turno_Preferente;
	}   
	public Date getFecha_Matricula() {
		return this.Fecha_Matricula;
	}

	public void setFecha_Matricula(Date Fecha_Matricula) {
		this.Fecha_Matricula = Fecha_Matricula;
	}   
	public String getNuevo_Ingreso() {
		return this.Nuevo_Ingreso;
	}

	public void setNuevo_Ingreso(String Nuevo_Ingreso) {
		this.Nuevo_Ingreso = Nuevo_Ingreso;
	}   
	public String getListado_de_Asignaturas() {
		return this.Listado_de_Asignaturas;
	}

	public void setListado_de_Asignaturas(String Listado_de_Asignaturas) {
		this.Listado_de_Asignaturas = Listado_de_Asignaturas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Curso_Academico ^ (Curso_Academico >>> 32));
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
		if (Curso_Academico != other.Curso_Academico)
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
   
}
