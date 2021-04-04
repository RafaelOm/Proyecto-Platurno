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
   
}
