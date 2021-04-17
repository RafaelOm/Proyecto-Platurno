package es.uma.platurno;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Titulacion
 *
 */
@Entity

public class Titulacion implements Serializable {

	   
	@Id
	private String Codigo;
	private String Nombre;
	private String Creditos;
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private List<Expediente> expedientes;
	@OneToMany
	private List<Asignatura> asignatura;
	
	@ManyToMany
	@JoinTable(
			name = "Centro",
			joinColumns = @JoinColumn(
					name = "ID",
					referencedColumnName = "ID"
					),
			inverseJoinColumns = @JoinColumn(
					name = "Codigo",
					referencedColumnName = "Codigo"
					
					)
			)
	private List<Centro> lista_centros;

	public Titulacion() {
		super();
	}   
	public String getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(String Codigo) {
		this.Codigo = Codigo;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(String Creditos) {
		this.Creditos = Creditos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
		result = prime * result + ((lista_centros == null) ? 0 : lista_centros.hashCode());
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
		Titulacion other = (Titulacion) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (Creditos == null) {
			if (other.Creditos != null)
				return false;
		} else if (!Creditos.equals(other.Creditos))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		if (lista_centros == null) {
			if (other.lista_centros != null)
				return false;
		} else if (!lista_centros.equals(other.lista_centros))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Titulacion [Codigo=" + Codigo + ", Nombre=" + Nombre + ", Creditos=" + Creditos + ", expedientes="
				+ expedientes + ", asignatura=" + asignatura + ", lista_centros=" + lista_centros + "]";
	}
	
   
}
