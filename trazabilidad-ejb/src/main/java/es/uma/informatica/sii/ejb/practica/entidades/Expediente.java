/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Expediente creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.informatica.sii.ejb.practica.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* Entidad que representa a la entidad Expediente. Usamos la interfaz serializable
 * para poder mandar los datos a la BD. */
@Entity
@Table(name = "Expediente")
public class Expediente implements Serializable {

	/* Atributos de la entidad, donde name es el nombre que va a tener el atributo en la BD y
	nullable simboliza los atributos que son obligatorios en la BD. */
	@Id
	@Column(name = "Expediente")
	private String expediente;

	@Column(name = "Activo")
	private String activo;

	@Column(name = "NotaMPr")
	private Double notampr;

	@Column(name = "CreditosSup")
	private Double creditosSup;

	@Column(name = "CreditosFB")
	private Double creditosFB;

	@Column(name = "CreditosOP")
	private Double creditosOP;

	@Column(name = "CreditosOB")
	private Double creditosOB;

	@Column(name = "CreditosCF")
	private Double creditosCF;

	@Column(name = "CreditosPE")
	private Double creditosPE;

	@Column(name = "CreditosTF")
	private Double creditosTF;
	
	@Column(name = "N_Archivo", nullable = false)
	private String n_archivo;

//--------------------------------------------------------------------------------------------------------------------//

	private static final long serialVersionUID = 1L;

//--------------------------------------------------------------------------------------------------------------------//

	/* Atributos de la entidad relacionado con relaciones (foreign key).*/

	@ManyToOne
	//@JoinColumn(name = "Titulacion_FK")
    private Titulacion titulacion;

	@ManyToOne
	private Alumno alumno;

	@OneToMany
	private List<Encuesta>encuentasAsociadas;




//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */

	public Expediente() {
	}

//--------------------------------------------------------------------------------------------------------------------//
public String getExpediente() {
	return expediente;
}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Double getNotampr() {
		return notampr;
	}

	public void setNotampr(Double notampr) {
		this.notampr = notampr;
	}

	public Double getCreditosSup() {
		return creditosSup;
	}

	public void setCreditosSup(Double creditosSup) {
		this.creditosSup = creditosSup;
	}

	public Double getCreditosFB() {
		return creditosFB;
	}

	public void setCreditosFB(Double creditosFB) {
		this.creditosFB = creditosFB;
	}

	public Double getCreditosOP() {
		return creditosOP;
	}

	public void setCreditosOP(Double creditosOP) {
		this.creditosOP = creditosOP;
	}

	public Double getCreditosOB() {
		return creditosOB;
	}

	public void setCreditosOB(Double creditosOB) {
		this.creditosOB = creditosOB;
	}

	public Double getCreditosCF() {
		return creditosCF;
	}

	public void setCreditosCF(Double creditosCF) {
		this.creditosCF = creditosCF;
	}

	public Double getCreditosPE() {
		return creditosPE;
	}

	public void setCreditosPE(Double creditosPE) {
		this.creditosPE = creditosPE;
	}

	public Double getCreditosTF() {
		return creditosTF;
	}

	public void setCreditosTF(Double creditosTF) {
		this.creditosTF = creditosTF;
	}

	public String getN_archivo() {
		return n_archivo;
	}

	public void setN_archivo(String n_archivo) {
		this.n_archivo = n_archivo;
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


	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "Expediente{" +
				"expediente='" + expediente + '\'' +
				", activo='" + activo + '\'' +
				", notampr=" + notampr +
				", creditosSup=" + creditosSup +
				", creditosFB=" + creditosFB +
				", creditosOP=" + creditosOP +
				", creditosOB=" + creditosOB +
				", creditosCF=" + creditosCF +
				", creditosPE=" + creditosPE +
				", creditosTF=" + creditosTF +
				", n_archivo='" + n_archivo + '\'' +
				", titulacion=" + titulacion +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Expediente that = (Expediente) o;
		return Objects.equals(expediente, that.expediente) && Objects.equals(activo, that.activo) && Objects.equals(notampr, that.notampr) && Objects.equals(creditosSup, that.creditosSup) && Objects.equals(creditosFB, that.creditosFB) && Objects.equals(creditosOP, that.creditosOP) && Objects.equals(creditosOB, that.creditosOB) && Objects.equals(creditosCF, that.creditosCF) && Objects.equals(creditosPE, that.creditosPE) && Objects.equals(creditosTF, that.creditosTF) && Objects.equals(n_archivo, that.n_archivo) && Objects.equals(titulacion, that.titulacion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(expediente, activo, notampr, creditosSup, creditosFB, creditosOP, creditosOB, creditosCF, creditosPE, creditosTF, n_archivo, titulacion);
	}
}
