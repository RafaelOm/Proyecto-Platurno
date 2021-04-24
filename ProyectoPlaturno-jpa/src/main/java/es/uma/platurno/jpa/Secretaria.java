/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Secretaria creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Secretaria extends Usuario{
    /**
	 * 
	 */
	@Id		 
	private Long identificador;
	
	public Long getId() {
		return this.identificador;
	}
	public void setId(Long id) {
		this.identificador=id;
	}
	private static final long serialVersionUID = 1L;
	public Secretaria(String Username, String Password,Long id) {
		super(Username, Password,id);
		this.identificador=id;
	}
    public Secretaria() {
    	super();
    }

	//private String idUma;

}
