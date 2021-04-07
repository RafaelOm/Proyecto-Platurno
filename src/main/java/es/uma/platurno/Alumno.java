package es.uma.platurno;

import java.util.List;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */
@Entity

public class Alumno implements Serializable {

	   
	@Id
	private String id_dni;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String email_personal;
	private String email_institucional;
	private String telefono;
	private String movil;
	private String direccion;
	private String provincia;
	private String localidad;
	private String CP;
	private static final long serialVersionUID = 1L;
	
	@OneToMany (mappedBy ="alumno")
	private List<Expediente> expedientes;

	public Alumno() {
		super();
	}   
	public String getId_dni() {
		return this.id_dni;
	}

	public void setId_dni(String id_dni) {
		this.id_dni = id_dni;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getApellido1() {
		return this.Apellido1;
	}

	public void setApellido1(String Apellido1) {
		this.Apellido1 = Apellido1;
	}   
	public String getApellido2() {
		return this.Apellido2;
	}

	public void setApellido2(String Apellido2) {
		this.Apellido2 = Apellido2;
	}   
	public String getEmail_personal() {
		return this.email_personal;
	}

	public void setEmail_personal(String email_personal) {
		this.email_personal = email_personal;
	}   
	public String getEmail_institucional() {
		return this.email_institucional;
	}

	public void setEmail_institucional(String email_institucional) {
		this.email_institucional = email_institucional;
	}   
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}   
	public String getMovil() {
		return this.movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}   
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}   
	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}   
	public String getCP() {
		return this.CP;
	}

	public void setCP(String CP) {
		this.CP = CP;
	}
   
}
