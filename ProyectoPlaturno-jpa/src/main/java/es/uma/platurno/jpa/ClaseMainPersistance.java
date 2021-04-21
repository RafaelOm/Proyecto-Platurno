/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase ClaseMainPersistance que compila el codigo y genera SQL. */

package es.uma.platurno.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClaseMainPersistance {


	    public static void main(String[] args) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoPlaturno.GrupoF");

	        EntityManager em =emf.createEntityManager();
	        em.close();
	        emf.close();
	}

}
