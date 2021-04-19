package es.uma.platurno.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ASIGNAR_GRUPO_AUTO
 */
@Stateless
@LocalBean
public class ASIGNAR_GRUPO_AUTO implements ASIGNAR_GRUPO_AUTOInterfaz {
    @PersistenceContext(unitName = "AgendaEE-EntidadesPU")
    private EntityManager em;
    /**
     * Default constructor. 
     */
    public ASIGNAR_GRUPO_AUTO() {
        // TODO Auto-generated constructor stub
    }

}
