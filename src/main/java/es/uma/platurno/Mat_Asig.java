package es.uma.platurno;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mat_Asig
 *
 */
@Entity
@IdClass(Mat_Asig.Mat_Asig_Id.class)
public class Mat_Asig implements Serializable {
	

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

	
	
	
	
	private static final long serialVersionUID = 1L;

	public Mat_Asig() {
		super();
	}
   
}
