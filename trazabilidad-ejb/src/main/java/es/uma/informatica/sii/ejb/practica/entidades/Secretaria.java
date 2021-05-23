/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Secretaria creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Secretaria extends Usuario {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String dni;
	private String nombre;
	private String apellido;
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
				", Apellido='" + apellido + '\'' +
				", email='" + email + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Secretaria that = (Secretaria) o;
		return Objects.equals(dni, that.dni) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		return super.identificador.hashCode();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
