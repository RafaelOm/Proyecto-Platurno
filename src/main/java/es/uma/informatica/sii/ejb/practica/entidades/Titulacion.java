package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Entity implementation class for Entity: Titulacion
 *
 */
@Entity

public class Titulacion implements Serializable {


	@Id
	@Column(name="CodigoTitulacion")
	private String Codigo;
	private String Nombre;
	private String Creditos;
	private static final long serialVersionUID = 1L;


	@JoinTable(
			name="rel_centro_titulacion",
			joinColumns = @JoinColumn(name ="idCentro",nullable = false),
			inverseJoinColumns = @JoinColumn(name="CodigoTitulacion",nullable = false)

	)
	@ManyToMany( fetch = FetchType.EAGER)
	private List<Centro> centros;

	@OneToMany
	private List<Expediente>expedientes;
	@OneToMany
	private List<Asignatura>asignaturas;

	@JoinTable(
			name="rel_optativas_titulacion",
			joinColumns = @JoinColumn(name ="Referencia",nullable = false),
			inverseJoinColumns = @JoinColumn(name="CodigoTitulacion",nullable = false)

	)
	@ManyToMany
	private List<Optativa> optativas;

	@OneToMany
	private List<Grupo> grupos;

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}

	public List<Optativa> getOptativas() {
		return optativas;
	}

	public void setOptativas(List<Optativa> optativas) {
		this.optativas = optativas;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Titulacion that = (Titulacion) o;
		return Objects.equals(Codigo, that.Codigo) && Objects.equals(Nombre, that.Nombre) && Objects.equals(Creditos, that.Creditos) && Objects.equals(centros, that.centros);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Codigo, Nombre, Creditos, centros);
	}

	public List<Centro> getCentros() {
		return centros;
	}

	public void setCentros(List<Centro> centros) {
		this.centros = centros;
	}

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



}
