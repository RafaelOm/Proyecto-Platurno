package es.uma.platurno.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.Objects;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements Serializable {

	@Id @GeneratedValue
	private Long identificador;
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
