/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Clase creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity implementation class for Entity: Clase
 *
 */

/* Entidad que representa a la entidad Clase. Usamos la interfaz serializable
 * para poder mandar los datos a la BD.*/
@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {

	/* Atributos de la entidad, donde name es el nombre que va a tener el atributo en la BD y
       nullable simboliza los atributos que son obligatorios en la BD. Ademas como tenemos una clave primaria
       compuesta, tenemos que usar una clase estatica para emular el ID. */

	public static class ClaseId implements Serializable{

		private static final long serialVersionUID = 1L;
		private String dia;
		private String horaInicio;
		private String grupo;
		public ClaseId() {
			super();
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dia == null) ? 0 : dia.hashCode());
			result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
			result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
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
			ClaseId other = (ClaseId) obj;
			if (dia == null) {
				if (other.dia != null)
					return false;
			} else if (!dia.equals(other.dia))
				return false;
			if (grupo == null) {
				if (other.grupo != null)
					return false;
			} else if (!grupo.equals(other.grupo))
				return false;
			if (horaInicio == null) {
				if (other.horaInicio != null)
					return false;
			} else if (!horaInicio.equals(other.horaInicio))
				return false;
			return true;
		}
		
		
	}

	   
	@Id
	@Column (name = "Dia")
	private String dia;
	
	@Id
	@Column (name = "Hora_Inicio")
	private String horaInicio;

	@Column (name = "Hora_Fin")
	private String horaFin;

//--------------------------------------------------------------------------------------------------------------------//

	private static final long serialVersionUID = 1L;

//--------------------------------------------------------------------------------------------------------------------//

	/* Atributos de la entidad relacionado con relaciones (foreign key).*/

	@ManyToOne
	private Asignatura asignatura;
	
	@Id
	@ManyToOne
	private Grupo grupo;

//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */

	public Clase() {
		super();
	}

//--------------------------------------------------------------------------------------------------------------------//

	/* Getters, Setters, equals, hashcode y toString. */

	public String getDia() {
		return this.dia;
	}

	public void setDia(String Dia) {
		this.dia = Dia;
	}   
	public String getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(String HoraInicio) {
		this.horaInicio = HoraInicio;
	}   
	public String getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(String HoraFin) {
		this.horaFin = HoraFin;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((horaFin == null) ? 0 : horaFin.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		return result;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clase other = (Clase) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (horaFin == null) {
			if (other.horaFin != null)
				return false;
		} else if (!horaFin.equals(other.horaFin))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
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

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public String toString() {
		return "Clase [Dia=" + dia + ", HoraInicio=" + horaInicio + ", HoraFin=" + horaFin + ", asignatura="
				+ asignatura + ", grupo=" + grupo + "]";
	}
   
}
