/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Secretaria creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Secretaria extends Usuario{
    /**
	 * 
	 */
	private String dni;
	private String nombre;
	private String Apellido;
	private String email;


    public Secretaria() {
    	super();
    }

	//private String idUma;


	@Override
	public String toString() {
		return "Secretaria{" +
				"dni='" + dni + '\'' +
				", nombre='" + nombre + '\'' +
				", Apellido='" + Apellido + '\'' +
				", email='" + email + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Secretaria that = (Secretaria) o;
		return Objects.equals(dni, that.dni) && Objects.equals(nombre, that.nombre) && Objects.equals(Apellido, that.Apellido) && Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), dni, nombre, Apellido, email);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
