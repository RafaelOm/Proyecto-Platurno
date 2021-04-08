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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido1 == null) ? 0 : Apellido1.hashCode());
		result = prime * result + ((Apellido2 == null) ? 0 : Apellido2.hashCode());
		result = prime * result + ((CP == null) ? 0 : CP.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((email_institucional == null) ? 0 : email_institucional.hashCode());
		result = prime * result + ((email_personal == null) ? 0 : email_personal.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
		result = prime * result + ((id_dni == null) ? 0 : id_dni.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((movil == null) ? 0 : movil.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Alumno other = (Alumno) obj;
		if (Apellido1 == null) {
			if (other.Apellido1 != null)
				return false;
		} else if (!Apellido1.equals(other.Apellido1))
			return false;
		if (Apellido2 == null) {
			if (other.Apellido2 != null)
				return false;
		} else if (!Apellido2.equals(other.Apellido2))
			return false;
		if (CP == null) {
			if (other.CP != null)
				return false;
		} else if (!CP.equals(other.CP))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (email_institucional == null) {
			if (other.email_institucional != null)
				return false;
		} else if (!email_institucional.equals(other.email_institucional))
			return false;
		if (email_personal == null) {
			if (other.email_personal != null)
				return false;
		} else if (!email_personal.equals(other.email_personal))
			return false;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		if (id_dni == null) {
			if (other.id_dni != null)
				return false;
		} else if (!id_dni.equals(other.id_dni))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (movil == null) {
			if (other.movil != null)
				return false;
		} else if (!movil.equals(other.movil))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Alumno [id_dni=" + id_dni + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1 + ", Apellido2="
				+ Apellido2 + ", email_personal=" + email_personal + ", email_institucional=" + email_institucional
				+ ", telefono=" + telefono + ", movil=" + movil + ", direccion=" + direccion + ", provincia="
				+ provincia + ", localidad=" + localidad + ", CP=" + CP + ", expedientes=" + expedientes + "]";
	}
	
   
}
