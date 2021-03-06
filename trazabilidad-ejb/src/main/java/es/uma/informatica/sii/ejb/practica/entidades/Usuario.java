/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Usuario creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class 	Usuario implements Serializable {

	/**
	 * 
	 */
	
	public Usuario(String Username,String Password,Long id) {
		super();
		
		this.username=Username;
		this.Password=Password;
		this.identificador=id;
		
		//crearUsuario( Username, Password, id);
		
	}

	
	
	public Usuario() {
		
	}
	private static final long serialVersionUID = 1L;
	//@Id @GeneratedValue
	protected Long identificador;
	
	@XmlTransient
	@JsonbTransient
	//@Column(unique = true)
	@Id
	private String username;
	@XmlTransient
	@JsonbTransient
	@Column(nullable = false)
	private String Password;
	@XmlTransient
	@JsonbTransient
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
