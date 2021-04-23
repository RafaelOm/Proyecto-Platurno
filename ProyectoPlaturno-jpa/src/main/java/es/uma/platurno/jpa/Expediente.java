/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Expediente creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
	//@JoinColumn(name = "Alumno_FK")
    private Alumno alumno;
	
	@OneToMany
	//@JoinColumn(name = "Encuesta_FK")
	private List<Encuesta> encuesta;
	
	@OneToMany
	//@JoinColumn(name = "Matricula_FK")
	private List<Matricula> matricula;

//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */

	public Expediente() {
	}

//--------------------------------------------------------------------------------------------------------------------//

	/* Getters, Setters, equals, hashcode y toString. */

	public String getId_Expediente() {
		return this.expediente;
	}

	public void setId_Expediente(String s) {
		this.activo = s;
	}   
	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String s) {
		this.activo = s;
	}   
	
	public double getNotaMPr() {
		return this.notampr;
	}

	public void setNotaMPr(double notaMPr2) {
		this.notampr = notaMPr2;
	}   
	
	public double getCreditosSup() {
		return this.creditosSup;
	}

	public void setCreditosSup(Double CreditosSup) {
		this.creditosSup = CreditosSup;
	}   
	
	public double getCreditosFB() {
		return this.creditosFB;
	}

	public void setCreditosFB(Double CreditosFB) {
		this.creditosFB = CreditosFB;
	}   
	
	public double getCreditosOP() {
		return this.creditosOP;
	}

	public void setCreditosOP(Double CreditosOP) {
		this.creditosOP = CreditosOP;
	}   
	
	public double getCreditosOB() {
		return this.creditosOB;
	}

	public void setCreditosOB(Double CreditosOB) {
		this.creditosOB = CreditosOB;
	}   
	
	public double getCreditosCF() {
		return this.creditosCF;
	}

	public void setCreditosCF(Double CreditosCF) {
		this.creditosCF = CreditosCF;
	}   
	
	public double getCreditosPE() {
		return this.creditosPE;
	}

	public void setCreditosPE(Double CreditosPE) {
		this.creditosPE = CreditosPE;
	}   
	
	public double getCreditosTF() {
		return this.creditosTF;
	}

	public void setCreditosTF(Double CreditosTF) {
		this.creditosTF = CreditosTF;
	}   
	public String getN_Archivo() {
		return this.n_archivo;
	}

	public void setN_Archivo(String N_Archivo) {
		this.n_archivo = N_Archivo;
	}   
	
	public Alumno getAlumno() {
		return this.alumno;
	}
	
	public void setAlumno(Alumno al) {
		this.alumno = al;
	}
	
	public Titulacion getTitulacion() {
		return this.titulacion;
	}
	
	public void setTitulacion(Titulacion t) {
		this.titulacion = t;
	}
	
	public List<Encuesta> getEncuesta() {
		return this.encuesta;
	}
	
	public void setEncuesta(List<Encuesta> t) {
		this.encuesta = t;
	}
	
	public List<Matricula> getMatricula() {
		return this.matricula;
	}
	
	public void setMatricula(List<Matricula> t) {
		this.matricula = t;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activo == null) ? 0 : activo.hashCode());
		result = prime * result + ((creditosCF < 0) ? 0 : creditosCF.hashCode());
		result = prime * result + ((creditosFB == null) ? 0 : creditosFB.hashCode());
		result = prime * result + ((creditosOB == null) ? 0 : creditosOB.hashCode());
		result = prime * result + ((creditosOP == null) ? 0 : creditosOP.hashCode());
		result = prime * result + ((creditosPE == null) ? 0 : creditosPE.hashCode());
		result = prime * result + ((creditosSup == null) ? 0 : creditosSup.hashCode());
		result = prime * result + ((creditosTF == null) ? 0 : creditosTF.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result + ((n_archivo == null) ? 0 : n_archivo.hashCode());
		result = prime * result + ((notampr == null) ? 0 : notampr.hashCode());
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((encuesta == null) ? 0 : encuesta.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
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
		Expediente other = (Expediente) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (creditosCF == null) {
			if (other.creditosCF != null)
				return false;
		} else if (!creditosCF.equals(other.creditosCF))
			return false;
		if (creditosFB == null) {
			if (other.creditosFB != null)
				return false;
		} else if (!creditosFB.equals(other.creditosFB))
			return false;
		if (creditosOB == null) {
			if (other.creditosOB != null)
				return false;
		} else if (!creditosOB.equals(other.creditosOB))
			return false;
		if (creditosOP == null) {
			if (other.creditosOP != null)
				return false;
		} else if (!creditosOP.equals(other.creditosOP))
			return false;
		if (creditosPE == null) {
			if (other.creditosPE != null)
				return false;
		} else if (!creditosPE.equals(other.creditosPE))
			return false;
		if (creditosSup == null) {
			if (other.creditosSup != null)
				return false;
		} else if (!creditosSup.equals(other.creditosSup))
			return false;
		if (creditosTF == null) {
			if (other.creditosTF != null)
				return false;
		} else if (!creditosTF.equals(other.creditosTF))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (n_archivo == null) {
			if (other.n_archivo != null)
				return false;
		} else if (!n_archivo.equals(other.n_archivo))
			return false;
		if (notampr == null) {
			if (other.notampr != null)
				return false;
		} else if (!notampr.equals(other.notampr))
			return false;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (encuesta == null) {
			if (other.encuesta != null)
				return false;
		} else if (!encuesta.equals(other.encuesta))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		return true;
	}

//--------------------------------------------------------------------------------------------------------------------//

	@Override
	public String toString() {
		return "Expediente [IdExpediente=" + expediente + ", Activo=" + activo + ", NotaMPr=" + notampr
				+ ", CreditosSup=" + creditosSup + ", CreditosFB=" + creditosFB + ", CreditosOP=" + creditosOP
				+ ", CreditosOB=" + creditosOB + ", CreditosCF=" + creditosCF + ", CreditosPE=" + creditosPE
				+ ", CreditosTF=" + creditosTF + ", N_Archivo=" + n_archivo + ", titulacion=" + titulacion + ", alumno="
				+ alumno + ", encuestas=" + encuesta + ", matriculas=" + matricula + "]";
	}
	
   
}
