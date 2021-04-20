package es.uma.platurno.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import es.uma.platurno.ejb.exceptions.ExpedienteNoExisteException;
import es.uma.platurno.jpa.Expediente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * Session Bean implementation class Expediente
 */
@Stateless
@LocalBean
public class ExpedienteEJB implements ExpedienteInterfaz {
    @PersistenceContext(unitName = "Expediente")
    private EntityManager em;

    /**
     * Default constructor. 
     */
    public ExpedienteEJB() {

    }

    @Override
    public Expediente ReadExpediente(String id) throws ExpedienteNoExisteException {
        Expediente exbd = em.find(Expediente.class, id);
        if(exbd == null){
            throw new ExpedienteNoExisteException();
        }

        return exbd;
    }

    @Override
    public void UpdateExpediente(Expediente ex) throws ExpedienteNoExisteException {
        em.merge(ex);
    }


    @Override
    public void DeleteExpediente(String id) throws ExpedienteNoExisteException{
        Expediente exbd = em.find(Expediente.class, id);
        if(exbd == null){
            throw new ExpedienteNoExisteException();
        }

        em.remove(exbd);
    }
}
