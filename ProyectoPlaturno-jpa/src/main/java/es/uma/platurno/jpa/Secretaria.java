/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Secretaria creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.Entity;

@Entity
public class Secretaria extends Usuario{
    public Secretaria(String Username, String Password) {
		super(Username, Password,1L);
		// TODO Auto-generated constructor stub
	}
    public Secretaria() {
    	super();
    }

	//private String idUma;

}
