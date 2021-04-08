package es.uma.platurno;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clase
 *
 */
@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {
	
	public static class ClaseId implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String HoraInicio;
		private String Dia;
		private String grupo;
	}

	   
	@Id
	private String Dia;   
	
	@Id
	private String HoraInicio;
	
	private String HoraFin;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Asignatura asignatura;
	
	@Id
	@ManyToOne
	private Grupo grupo;

	public Clase() {
		super();
	}   
	public String getDia() {
		return this.Dia;
	}

	public void setDia(String Dia) {
		this.Dia = Dia;
	}   
	public String getHoraInicio() {
		return this.HoraInicio;
	}

	public void setHoraInicio(String HoraInicio) {
		this.HoraInicio = HoraInicio;
	}   
	public String getHoraFin() {
		return this.HoraFin;
	}

	public void setHoraFin(String HoraFin) {
		this.HoraFin = HoraFin;
	}
   
}
