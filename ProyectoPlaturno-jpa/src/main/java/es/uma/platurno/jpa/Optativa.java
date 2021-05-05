/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Optativa  creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Optativa extends Asignatura{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String plazas;
	private String mencion;


	@JoinTable(
			name="rel_optativas_titulacion",
			joinColumns = @JoinColumn(name ="CodigoTitulacion",nullable = false),
			inverseJoinColumns = @JoinColumn(name="Referencia",nullable = false)

	)
	@ManyToMany
	private List<Titulacion> titulaciones;

	public List<Titulacion> getTitulaciones() {
		return titulaciones;
	}

	public void setTitulaciones(List<Titulacion> titulaciones) {
		this.titulaciones = titulaciones;
	}

	public String getPlazas() {
		return plazas;
	}
	public void setPlazas(String plazas) {
		this.plazas = plazas;
	}
	public String getMencion() {
		return mencion;
	}
	public void setMencion(String mencion) {
		this.mencion = mencion;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mencion == null) ? 0 : mencion.hashCode());
		result = prime * result + ((plazas == null) ? 0 : plazas.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Optativa other = (Optativa) obj;
		if (mencion == null) {
			if (other.mencion != null)
				return false;
		} else if (!mencion.equals(other.mencion))
			return false;
		if (plazas == null) {
			if (other.plazas != null)
				return false;
		} else if (!plazas.equals(other.plazas))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Optativa [plazas=" + plazas + ", mencion=" + mencion + "]";
	}
	
	
	
	
	

	 
}
