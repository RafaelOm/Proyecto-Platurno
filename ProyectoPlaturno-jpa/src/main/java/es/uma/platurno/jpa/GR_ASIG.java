/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase GR_ASIG creada en JPA que modela los datos que va a tener la entidad en la BD. */


package es.uma.platurno.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entity implementation class for Entity: Alumno
 *
 */

/* Entidad que representa a la entidad Gr_Asig. Usamos la interfaz serializable
 * para poder mandar los datos a la BD.*/
@Entity
@Table(name = "Gr_Asig")
@IdClass(GR_ASIG.GR_ASIGID.class)
public class GR_ASIG implements Serializable {

	/* Atributos de la entidad, donde name es el nombre que va a tener el atributo en la BD y
       nullable simboliza los atributos que son obligatorios en la BD. Ademas como tenemos una clave primaria
       compuesta, tenemos que usar una clase estatica para emular el ID. */

	public static class GR_ASIGID implements Serializable{

		public GR_ASIGID (int curso_act,String referencia,String id_grupo){
			this.curso_act=curso_act;
			this.asig=referencia;
			this.group=id_grupo;

		}

		private static final long serialVersionUID = 1L;
		private int curso_act;
		private String asig;
		private String group;

	}

	@Id
	@Column (name = "CursoAc")
	private int curso_act;

	@Column(name = "Oferta")
	private int oferta;

//--------------------------------------------------------------------------------------------------------------------//

	private static final long serialVersionUID = 1L;

//--------------------------------------------------------------------------------------------------------------------//

	/* Atributos de la entidad relacionado con relaciones (foreign key).*/
	@Id
	@ManyToOne
	@JoinColumn(name = "Gr_Asig esta en ")
	private Grupo group;

	@Id
	@ManyToOne
    @JoinColumn(name = "Gr_Asig tiene ")
	private Asignatura asig;

	/*
	@ManyToMany
	@JoinTable(
			name = "Encuesta",
			joinColumns = @JoinColumn(
					name = "referencia",
					referencedColumnName = "Fecha_de_Envio"
					),
			inverseJoinColumns = @JoinColumn(
					name = "curso_act",
					referencedColumnName = "curso_act"
					
					)
			)
	private List<Encuesta> lista_encuestas;
*/

	@ManyToOne
	@JoinColumn(name = "Gr_asig encuesta")
	private Encuesta encuesta;

//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */

	public GR_ASIG(){}

//--------------------------------------------------------------------------------------------------------------------//

	/* Getters, Setters, equals, hashcode y toString. */

	public int getCurso_act() {
		return curso_act;
	}
	public void setCurso_act(int curso_act) {
		this.curso_act = curso_act;
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public int getOferta() {
		return oferta;
	}
	public void setOferta(int oferta) {
		this.oferta = oferta;
	}
	public Grupo getGroup() {
		return group;
	}
	public void setGroup(Grupo group) {
		this.group = group;
	}
	public Asignatura getAsig() {
		return asig;
	}
	public void setAsig(Asignatura asig) {
		this.asig = asig;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public int hashCode() {
		return Objects.hash(curso_act, oferta, group, asig, encuesta);
	}


//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GR_ASIG gr_asig = (GR_ASIG) o;
		return curso_act == gr_asig.curso_act && oferta == gr_asig.oferta && Objects.equals(group, gr_asig.group) && Objects.equals(asig, gr_asig.asig) && Objects.equals(encuesta, gr_asig.encuesta);
	}


//--------------------------------------------------------------------------------------------------------------------//


	@Override
	public String toString() {
		return "GR_ASIG{" +
				"curso_act=" + curso_act +
				", oferta=" + oferta +
				", group=" + group +
				", asig=" + asig +
				", encuesta=" + encuesta +
				'}';
	}
}