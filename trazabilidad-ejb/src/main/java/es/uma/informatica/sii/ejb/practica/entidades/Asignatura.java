/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Asignatura creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


/* Entidad que representa a la entidad Asignatura. Usamos la interfaz serializable
 *  para poder mandar los datos a la BD. */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Asignatura implements Serializable {

	/* Atributos de la entidad, donde name es el nombre que va a tener el atributo en la BD y
    nullable simboliza los atributos que son obligatorios en la BD. */

	@Id
	@Column(name = "Referencia")
	private String referencia;

	@Column (name = "Codigo", nullable = false)
	private Integer codigo;

	@Column (name="Creditos", nullable = false)
	private Integer creditos;

	@Column (name = "Ofertada", nullable = false)
	private String ofertada;

	@Column (name = "Nombre", nullable = false)
	private String nombre;

	@Column (name = "Curso")
	private String curso;

	@Column (name = "Caracter")
	private String caracter;

	@Column (name = "Duracion")
	private String duracion;

	@Column (name = "Idiomas")
	private String idiomas;

	@Column (name = "Cred_Prac")
	private Integer cred_prac;

//--------------------------------------------------------------------------------------------------------------------//

	private static final long serialVersionUID = 1L;

//--------------------------------------------------------------------------------------------------------------------//

	/* Atributos de la entidad relacionado con relaciones (foreign key).*/



	@ManyToOne
	private Titulacion titulacion;

	@OneToMany(cascade = CascadeType.ALL)
	private List<GR_ASIG> grLista;


//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */

	public Asignatura(){}

//--------------------------------------------------------------------------------------------------------------------//

	/* Getters, Setters, equals, hashcode y toString. */

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public String getOfertada() {
		return ofertada;
	}

	public void setOfertada(String ofertada) {
		this.ofertada = ofertada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public Integer getCred_prac() {
		return cred_prac;
	}

	public void setCred_prac(Integer cred_prac) {
		this.cred_prac = cred_prac;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}


//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Asignatura that = (Asignatura) o;
		return Objects.equals(referencia, that.referencia) && Objects.equals(codigo, that.codigo) && Objects.equals(creditos, that.creditos) && Objects.equals(ofertada, that.ofertada) && Objects.equals(nombre, that.nombre) && Objects.equals(curso, that.curso) && Objects.equals(caracter, that.caracter) && Objects.equals(duracion, that.duracion) && Objects.equals(idiomas, that.idiomas) && Objects.equals(cred_prac, that.cred_prac) && Objects.equals(titulacion, that.titulacion);
	}

	@Override
	public int hashCode() {
		return referencia.hashCode();
	}

//--------------------------------------------------------------------------------------------------------------------//


	@Override
	public String toString() {
		return "Asignatura{" +
				"referencia='" + referencia + '\'' +
				", codigo=" + codigo +
				", creditos=" + creditos +
				", ofertada='" + ofertada + '\'' +
				", nombre='" + nombre + '\'' +
				", curso='" + curso + '\'' +
				", caracter='" + caracter + '\'' +
				", duracion='" + duracion + '\'' +
				", idiomas='" + idiomas + '\'' +
				", cred_prac=" + cred_prac +
				", titulacion=" + titulacion +
				'}';
	}
}