/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase GR_ASIG creada en JPA que modela los datos que va a tener la entidad en la BD. */


package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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

		public GR_ASIGID (String curso_act,String referencia,String id_grupo){
			this.curso_act=curso_act;
			this.asig=referencia;
			this.group=id_grupo;
			
			

		}
		public GR_ASIGID (){
			}
		

		@Override
		public int hashCode() {
			return asig.hashCode() + group.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GR_ASIGID other = (GR_ASIGID) obj;
			if (asig == null) {
				if (other.asig != null)
					return false;
			} else if (!asig.equals(other.asig))
				return false;
			if (curso_act != other.curso_act)
				return false;
			if (group == null) {
				if (other.group != null)
					return false;
			} else if (!group.equals(other.group))
				return false;
			return true;
		}

		private static final long serialVersionUID = 1L;
		private String curso_act;
		private String asig;
		private String group;
		public String getCurso_act() {
			return curso_act;
		}


		public void setCurso_act(String curso_act) {
			this.curso_act = curso_act;
		}


		public String getAsig() {
			return asig;
		}


		public void setAsig(String asig) {
			this.asig = asig;
		}


		public String getGroup() {
			return group;
		}


		public void setGroup(String group) {
			this.group = group;
		}
		
		

	}

	@Id
	private String curso_act;

	private int oferta;

//--------------------------------------------------------------------------------------------------------------------//

	private static final long serialVersionUID = 1L;

//--------------------------------------------------------------------------------------------------------------------//

	/* Atributos de la entidad relacionado con relaciones (foreign key).*/
	@Id
	@ManyToOne
	private Grupo group;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	private Asignatura asig;
/*
	@JoinTable(
			name="rel_encuesta_grupo",
			joinColumns = @JoinColumn(name="Id_Encuesta",referencedColumnName = "Id_Encuesta",nullable = false),
			inverseJoinColumns =  {
			@JoinColumn(name ="curso_act",referencedColumnName = "curso_act",nullable = false),
			@JoinColumn(name ="asig",referencedColumnName = "asig",nullable = false),
			@JoinColumn(name ="group",referencedColumnName = "group",nullable = false)}

	)*/
	@ManyToMany(mappedBy = "asignacion")
	private List<Encuesta> encuestas;



//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */

	public GR_ASIG(){}

//--------------------------------------------------------------------------------------------------------------------//

	/* Getters, Setters, equals, hashcode y toString. */

	public String getCurso_act() {
		return curso_act;
	}
	public void setCurso_act(String curso_act) {
		this.curso_act = curso_act;
	}

	public List<Encuesta> getEncuestas() {
		return encuestas;
	}

	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
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
		return Objects.hash(curso_act, oferta, group, asig);
	}


//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GR_ASIG gr_asig = (GR_ASIG) o;
		return curso_act == gr_asig.curso_act && oferta == gr_asig.oferta && Objects.equals(group, gr_asig.group) && Objects.equals(asig, gr_asig.asig) ;
	}


//--------------------------------------------------------------------------------------------------------------------//


	@Override
	public String toString() {
		return "GR_ASIG{" +
				"curso_act=" + curso_act +
				", oferta=" + oferta +
				", group=" + group +
				", asig=" + asig +
				", encuesta="  +
				'}';
	}
}