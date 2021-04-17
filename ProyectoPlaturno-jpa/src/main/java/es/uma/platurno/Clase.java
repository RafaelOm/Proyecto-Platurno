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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dia == null) ? 0 : Dia.hashCode());
		result = prime * result + ((HoraFin == null) ? 0 : HoraFin.hashCode());
		result = prime * result + ((HoraInicio == null) ? 0 : HoraInicio.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
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
		Clase other = (Clase) obj;
		if (Dia == null) {
			if (other.Dia != null)
				return false;
		} else if (!Dia.equals(other.Dia))
			return false;
		if (HoraFin == null) {
			if (other.HoraFin != null)
				return false;
		} else if (!HoraFin.equals(other.HoraFin))
			return false;
		if (HoraInicio == null) {
			if (other.HoraInicio != null)
				return false;
		} else if (!HoraInicio.equals(other.HoraInicio))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Clase [Dia=" + Dia + ", HoraInicio=" + HoraInicio + ", HoraFin=" + HoraFin + ", asignatura="
				+ asignatura + ", grupo=" + grupo + "]";
	}
   
}
