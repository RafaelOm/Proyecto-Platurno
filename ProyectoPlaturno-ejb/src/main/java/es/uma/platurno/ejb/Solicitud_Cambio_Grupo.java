package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.GR_ASIG_GrupoNoExisteException;
import es.uma.platurno.jpa.GR_ASIG;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Solicitud_Cambio_Grupo implements Solicitud_Cambio_Grupo_Interfaz{

	@PersistenceContext(unitName = "AgendaEE-EntidadesPU")
    private EntityManager em;
	
	public void generarSolicitud(GR_ASIG antiguo, GR_ASIG nuevo) throws GR_ASIG_GrupoNoExisteException {
		
		GR_ASIG n = em.find(GR_ASIG.class, antiguo.getCurso_act());
		
		if ( n == null ) {
			throw new GR_ASIG_GrupoNoExisteException("Error, grupo actual no encontrado.\n");
		}
		
		em.getTransaction().begin();
		
		n = em.merge(nuevo);
		
		em.remove(n);
		
		em.getTransaction().commit();
		
		
	}

}
