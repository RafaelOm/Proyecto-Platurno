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
public class Usuario implements Serializable {

	@Id
	private String username;
	@Column(nullable = false)
	private String Password;
	private String Name;
	private String Surname;
	@Column(nullable = false)
	private String Dni;
	private String ValidationChain;
	@Column(nullable = false)
	private String emailInstitucional;
	private String telefono;
	private String numeroExpediente;

	public String getEmailInstitucional() {
		return emailInstitucional;
	}

	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}





	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	public String getSurname() {
		return this.Surname;
	}

	public void setSurname(String Surname) {
		this.Surname = Surname;
	}   
	public String getDni() {
		return this.Dni;
	}

	public void setDni(String Dni) {
		this.Dni = Dni;
	}   
	public String getValidationChain() {
		return this.ValidationChain;
	}

	public void setValidationChain(String ValidationChain) {
		this.ValidationChain = ValidationChain;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"username='" + username + '\'' +
				", Password='" + Password + '\'' +
				", Name='" + Name + '\'' +
				", Surname='" + Surname + '\'' +
				", Dni='" + Dni + '\'' +
				", ValidationChain='" + ValidationChain + '\'' +
				", emailInstitucional='" + emailInstitucional + '\'' +
				", telefono='" + telefono + '\'' +
				", numeroExpediente='" + numeroExpediente + '\'' +

				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(username, usuario.username) && Objects.equals(Password, usuario.Password) && Objects.equals(Name, usuario.Name) && Objects.equals(Surname, usuario.Surname) && Objects.equals(Dni, usuario.Dni) && Objects.equals(ValidationChain, usuario.ValidationChain) && Objects.equals(emailInstitucional, usuario.emailInstitucional) && Objects.equals(telefono, usuario.telefono) && Objects.equals(numeroExpediente, usuario.numeroExpediente) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, Password, Name, Surname, Dni, ValidationChain, emailInstitucional, telefono, numeroExpediente);
	}
}
