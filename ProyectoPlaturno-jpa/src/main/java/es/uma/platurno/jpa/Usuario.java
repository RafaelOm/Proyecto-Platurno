/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Usuario creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements Serializable {

	@Id //@GeneratedValue
	protected Long identificador;
	@Column(unique = true)
	private String username;
	@Column(nullable = false)
	private String Password;
	@Column(nullable = false)
	private String ValidationChain;

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getValidationChain() {
		return ValidationChain;
	}

	public void setValidationChain(String validationChain) {
		ValidationChain = validationChain;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(identificador, usuario.identificador) && Objects.equals(username, usuario.username) && Objects.equals(Password, usuario.Password) && Objects.equals(ValidationChain, usuario.ValidationChain);
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador, username, Password, ValidationChain);
	}
}
