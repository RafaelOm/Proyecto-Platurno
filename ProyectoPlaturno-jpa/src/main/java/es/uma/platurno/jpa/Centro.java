/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Centro creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entity implementation class for Entity: Centro
 *
 */

/* Entidad que representa a la entidad Centro. Usamos la interfaz serializable
 * para poder mandar los datos a la BD.*/
@Entity
@Table(name = "Centro")
public class Centro implements Serializable {

	/* Atributos de la entidad, donde name es el nombre que va a tener el atributo en la BD y
       nullable simboliza los atributos que son obligatorios en la BD. */
	   
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "Nombre", unique = true)
	private String nombre;

	@Column(name = "Direccion", nullable = false)
	private String direccion;

	@Column(name = "TLF_Conserjeria")
	private String tlf_conserjeria;

//--------------------------------------------------------------------------------------------------------------------//

	private static final long serialVersionUID = 1L;

//--------------------------------------------------------------------------------------------------------------------//

	/* Atributos de la entidad relacionado con relaciones (foreign key).*/

	@ManyToMany
	@JoinTable(
	            name = "Centro_Titulacion",
	            joinColumns = @JoinColumn(
	                    name = "Centro",
	                    referencedColumnName = "codigo"
	            ),
	            inverseJoinColumns = @JoinColumn(
	                    name = "Titulacion",
	                    referencedColumnName = "id"
	            )
	    )
	private List<Titulacion> grupo;
	
	public List<Titulacion> getTitulaciones(){
		return grupo;
	}
	public void setTitulaciones(List<Titulacion> titulaciones) {
		grupo=titulaciones;
		
	}

//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */
	public Centro() {

	}

//--------------------------------------------------------------------------------------------------------------------//

	/* Getters, Setters, equals, hashcode y toString. */

	public String getId() {
		return this.id;
	}

	public void setId(String ID) {
		this.id = ID;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String Direccion) {
		this.direccion = Direccion;
	}   
	public String getTLF_Conserjeria() {
		return this.tlf_conserjeria;
	}

	public void setTLF_Conserjeria(String TLF_Conserjeria) {
		this.tlf_conserjeria = TLF_Conserjeria;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tlf_conserjeria == null) ? 0 : tlf_conserjeria.hashCode());
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
		Centro other = (Centro) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tlf_conserjeria == null) {
			if (other.tlf_conserjeria != null)
				return false;
		} else if (!tlf_conserjeria.equals(other.tlf_conserjeria))
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
		return "Centro [ID=" + id + ", Nombre=" + nombre + ", Direccion=" + direccion + ", TLF_Conserjeria="
				+ tlf_conserjeria + ", grupos=" + grupo + "]";
	}
	
   
}
