
package es.uma.platurno;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */

@Entity
public class GR_ASIG implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int curso_act;
	@Column(nullable = false)
	private int oferta;
	
	@ManyToOne
	private Grupo group;
	@ManyToOne
    private Asignatura asig;
	

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
	
	
	public int getCurso_act() {
		return curso_act;
	}
	public void setCurso_act(int curso_act) {
		this.curso_act = curso_act;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asig == null) ? 0 : asig.hashCode());
		result = prime * result + curso_act;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((lista_encuestas == null) ? 0 : lista_encuestas.hashCode());
		result = prime * result + oferta;
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
		GR_ASIG other = (GR_ASIG) obj;
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
		if (lista_encuestas == null) {
			if (other.lista_encuestas != null)
				return false;
		} else if (!lista_encuestas.equals(other.lista_encuestas))
			return false;
		if (oferta != other.oferta)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GR_ASIG [curso_act=" + curso_act + ", oferta=" + oferta + ", group=" + group + ", asig=" + asig
				+ ", lista_encuestas=" + lista_encuestas + "]";
	}
	
	
}