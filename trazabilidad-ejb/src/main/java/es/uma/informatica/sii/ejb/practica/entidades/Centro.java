package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Entity implementation class for Entity: Centro
 *
 */
@Entity

public class Centro implements Serializable {


	@Id
	@Column(name="idCentro")
	private String ID;
	private String Nombre;
	private String Direccion;
	private String TLF_Conserjeria;
	private static final long serialVersionUID = 1L;

	@JoinTable(
			name="rel_centro_titulacion",
			joinColumns = @JoinColumn(name ="CodigoTitulacion",nullable = false),
			inverseJoinColumns = @JoinColumn(name="idCentro",nullable = false)

	)

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Titulacion> titulaciones;

	public List<Titulacion> getTitulaciones() {
		return titulaciones;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Centro centro = (Centro) o;
		return Objects.equals(ID, centro.ID) && Objects.equals(Nombre, centro.Nombre) && Objects.equals(Direccion, centro.Direccion) && Objects.equals(TLF_Conserjeria, centro.TLF_Conserjeria) && Objects.equals(titulaciones, centro.titulaciones);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, Nombre, Direccion, TLF_Conserjeria, titulaciones);
	}

	public void setTitulaciones(List<Titulacion> titulaciones) {
		this.titulaciones = titulaciones;
	}

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



}
