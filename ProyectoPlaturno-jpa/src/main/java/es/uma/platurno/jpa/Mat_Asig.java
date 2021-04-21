/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Mat_Asig creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Entity implementation class for Entity: Mat_Asig
 *
 */
@Entity
@IdClass(Mat_Asig.Mat_Asig_Id.class)
public class Mat_Asig implements Serializable {
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public static class Mat_Asig_Id implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private Long matricula;
		private String asignatura;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
			result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
			Mat_Asig_Id other = (Mat_Asig_Id) obj;
			if (asignatura == null) {
				if (other.asignatura != null)
					return false;
			} else if (!asignatura.equals(other.asignatura))
				return false;
			if (matricula == null) {
				if (other.matricula != null)
					return false;
			} else if (!matricula.equals(other.matricula))
				return false;
			return true;
		}
		
	
		
		
	}
	@Id
	@ManyToOne
	private Asignatura asignatura; 
	
	@Id
	@ManyToOne
	private Matricula matricula;
	
	@ManyToOne
	private Grupo grupo;

	public void setGrupo(Grupo grupo){
		this.grupo = grupo;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Mat_Asig other = (Mat_Asig) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mat_Asig [asignatura=" + asignatura + ", matricula=" + matricula + ", grupo=" + grupo + "]";
	}

	private static final long serialVersionUID = 1L;

	public Mat_Asig() {
		super();
	}
   
}
