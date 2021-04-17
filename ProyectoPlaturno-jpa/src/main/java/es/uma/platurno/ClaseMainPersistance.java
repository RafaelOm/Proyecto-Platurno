package es.uma.platurno;

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
