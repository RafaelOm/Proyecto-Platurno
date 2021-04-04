package es.uma.platurno;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Clase
 *
 */ 
public class ClasePK  implements Serializable {   
   
	         
	private String Dia;         
	private String HoraInicio;
	private static final long serialVersionUID = 1L;

	public ClasePK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ClasePK)) {
			return false;
		}
		ClasePK other = (ClasePK) o;
		return true
			&& (getDia() == null ? other.getDia() == null : getDia().equals(other.getDia()))
			&& (getHoraInicio() == null ? other.getHoraInicio() == null : getHoraInicio().equals(other.getHoraInicio()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getDia() == null ? 0 : getDia().hashCode());
		result = prime * result + (getHoraInicio() == null ? 0 : getHoraInicio().hashCode());
		return result;
	}
   
   
}
