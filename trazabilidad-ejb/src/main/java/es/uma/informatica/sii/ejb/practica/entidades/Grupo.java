/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Grupo creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/*
 * Entity implementation class for Entity: Alumno
 *
 */

/* Entidad que representa a la entidad Grupo. Usamos la interfaz serializable
 * para poder mandar los datos a la BD.*/
@Entity
public class Grupo implements Serializable {

	/* Atributos de la entidad, donde name es el nombre que va a tener el atributo en la BD y
       nullable simboliza los atributos que son obligatorios en la BD. */
	@Id
	@Column (name = "ID")
	private String id;

	@Column (name = "Curso")
	private int curso;

	@Column (name = "Letra")
	private String letra;

	@Column (name = "Turno", nullable = false)
	private String turno;

	@Column (name = "Ingles", nullable = false)
	private String ingles;

	@Column (name = "Visible")
	private String visible;

	@Column (name = "Asignar")
	private String asignar;

	@Column (name = "Plazas")
	private int plazas;

	@Column (name = "Letra1")
	private String letra1;

//--------------------------------------------------------------------------------------------------------------------//

	private static final long serialVersionUID = 1L;

//--------------------------------------------------------------------------------------------------------------------//

	/* Atributos de la entidad relacionado con relaciones (foreign key).*/

	//@OneToMany
	//private List<Grupo> grupos;


	//@ManyToOne
	//private Grupo grupo;


	@ManyToOne
	private Titulacion titulo;

//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */

	public Grupo(){}

//--------------------------------------------------------------------------------------------------------------------//

	/* Getters, Setters, equals, hashcode y toString. */

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getIngles() {
		return ingles;
	}
	public void setIngles(String ingles) {
		this.ingles = ingles;
	}
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}
	public String getAsignar() {
		return asignar;
	}
	public void setAsignar(String asignar) {
		this.asignar = asignar;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	public String getLetra1() {
		return letra1;
	}
	public void setLetra1(String letra1) {
		this.letra1 = letra1;
	}





	public Titulacion getTitulo() {
		return titulo;
	}
	public void setTitulo(Titulacion titulo) {
		this.titulo = titulo;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + curso;
		result = prime * result + ((ingles == null) ? 0 : ingles.hashCode());
		result = prime * result + ((letra == null) ? 0 : letra.hashCode());
		result = prime * result + plazas;
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
		result = prime * result + ((asignar == null) ? 0 : asignar.hashCode());



		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((letra1 == null) ? 0 : letra1.hashCode());

		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((visible == null) ? 0 : visible.hashCode());
		return result;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (curso != other.curso)
			return false;
		if (ingles == null) {
			if (other.ingles != null)
				return false;
		} else if (!ingles.equals(other.ingles))
			return false;
		if (letra == null) {
			if (other.letra != null)
				return false;
		} else if (!letra.equals(other.letra))
			return false;
		if (plazas != other.plazas)
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		if (asignar == null) {
			if (other.asignar != null)
				return false;
		} else if (!asignar.equals(other.asignar))
			return false;



		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (letra1 == null) {
			if (other.letra1 != null)
				return false;
		} else if (!letra1.equals(other.letra1))
			return false;

		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (visible == null) {
			if (other.visible != null)
				return false;
		} else if (!visible.equals(other.visible))
			return false;
		return true;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", Curso=" + curso + ", Letra=" + letra + ", Turno=" + turno + ", Ingles=" + ingles
				+ ", visible=" + visible + ", asignar=" + asignar + ", Plazas=" + plazas + ", letra1=" + letra1
				+ ", grupos="  + ", grupo="  + ", mat_asig="  + ", clase="
				+ ", grupos_asig="  + ", titulo=" + titulo + "]";
	}
	
	
	
	
}