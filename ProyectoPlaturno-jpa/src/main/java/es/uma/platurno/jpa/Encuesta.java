/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Encuesta creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */

/* Entidad que representa a la entidad Clase. Usamos la interfaz serializable
 * para poder mandar los datos a la BD.*/
@Entity
public class Encuesta implements Serializable {

	/* Atributos de la entidad, donde name es el nombre que va a tener el atributo en la BD y
   nullable simboliza los atributos que son obligatorios en la BD.  */

	@Id@GeneratedValue
	@Column (name = "Id_Encuesta")
	private String id_Encuesta;

	@Column (name = "Texto")
	private String texto;
	
	@Column (name = "Fecha_De_Envio", nullable = false)
	private Date fecha_De_Envio;


//--------------------------------------------------------------------------------------------------------------------//

	private static final long serialVersionUID = 1L;

//--------------------------------------------------------------------------------------------------------------------//

	/* Atributos de la entidad relacionado con relaciones (foreign key). PREGUNTA CHICANO */

	@ManyToOne
	private Expediente expediente;

/*
	@JoinTable(
			name="rel_encuesta_grupo",
			joinColumns = {
					@JoinColumn(name ="curso_act",referencedColumnName = "curso_act",nullable = false),
					@JoinColumn(name ="asig",referencedColumnName = "asig",nullable = false),
					@JoinColumn(name ="group",referencedColumnName = "group",nullable = false)},
			inverseJoinColumns = @JoinColumn(name="Id_Encuesta",referencedColumnName = "Id_Encuesta",nullable = false)

	)*/
	@ManyToMany
	private List<GR_ASIG> GrAsig;


//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */

	public Encuesta() {
		super();
	}

//--------------------------------------------------------------------------------------------------------------------//

	/* Getters, Setters, equals, hashcode y toString. */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getFecha_de_Envio() {
		return this.fecha_De_Envio;
	}
	public String getTexto() {
		return texto;
	}

	public List<GR_ASIG> getGrAsig() {
		return GrAsig;
	}

	public void setGrAsig(List<GR_ASIG> grAsig) {
		this.GrAsig = grAsig;
	}

	public void setId_Encuesta(String id_Encuesta) {
		this.id_Encuesta = id_Encuesta;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}


	public void setFecha_de_Envio(Date Fecha_de_Envio) {
		this.fecha_De_Envio = Fecha_de_Envio;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha_De_Envio == null) ? 0 : fecha_De_Envio.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());

		return result;
	}
	public String getId_Encuesta() {
		return id_Encuesta;
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
		Encuesta other = (Encuesta) obj;
		if (fecha_De_Envio == null) {
			if (other.fecha_De_Envio != null)
				return false;
		} else if (!fecha_De_Envio.equals(other.fecha_De_Envio))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;

		return true;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public String toString() {
		return "Encuesta [Fecha_de_Envio=" + fecha_De_Envio + ", expediente=" + expediente + ", grupos=" + "]";
	}
	
   
}
