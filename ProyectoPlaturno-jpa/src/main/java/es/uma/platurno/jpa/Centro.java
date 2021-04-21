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
@Entity

public class Centro implements Serializable {

	   
	@Id
	private String ID;
	private String Nombre;
	private String Direccion;
	private String TLF_Conserjeria;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	 @JoinTable(
	            name = "CentroTitulacion",
	            joinColumns = @JoinColumn(
	                    name = "Codigo",
	                    referencedColumnName = "Codigo"
	            ),
	            inverseJoinColumns = @JoinColumn(
	                    name = "Id",
	                    referencedColumnName = "ID"
	            )
	    )
	    private List<Grupo> grupos; 

	public Centro() {
		super();
	}   
	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}   
	public String getTLF_Conserjeria() {
		return this.TLF_Conserjeria;
	}

	public void setTLF_Conserjeria(String TLF_Conserjeria) {
		this.TLF_Conserjeria = TLF_Conserjeria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((TLF_Conserjeria == null) ? 0 : TLF_Conserjeria.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
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
		Centro other = (Centro) obj;
		if (Direccion == null) {
			if (other.Direccion != null)
				return false;
		} else if (!Direccion.equals(other.Direccion))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (TLF_Conserjeria == null) {
			if (other.TLF_Conserjeria != null)
				return false;
		} else if (!TLF_Conserjeria.equals(other.TLF_Conserjeria))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Centro [ID=" + ID + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", TLF_Conserjeria="
				+ TLF_Conserjeria + ", grupos=" + grupos + "]";
	}
	
   
}
