
package es.uma.platurno;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * Entity implementation class for Entity: Alumno
 *
 */

@Entity
public class GR_ASIG implements Serializable {
	
	@Id
	private int curso_act;
	@Colum (nullable = false)
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
					referencedColumnNmae = "Fecha de Envio"
					),
			inverseJoinColumns = @JoinColumn(
					name = "curso_act",
					referencedColumnName = "curso_act"
					
					)
			)
	
	
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
	
	
}