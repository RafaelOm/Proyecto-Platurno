package es.uma.platurno.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import es.uma.platurno.ejb.exceptions.ExpedienteNoExisteException;
import es.uma.platurno.jpa.Expediente;

import javax.persistence.Column;
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
    public void UpdateExpediente(String id,String Activo,
    		Double NotaMPr,
    		Double CreditosSup,
    		Double CreditosFB,
            Double CreditosOP,
            Double CreditosOB,
            Double CreditosCF,
            Double CreditosPE,
            Double CreditosTF,
            String N_Archivo) throws ExpedienteNoExisteException {
        Expediente exbd = em.find(Expediente.class, id);
        if(exbd == null){
            throw new ExpedienteNoExisteException();
        }
        exbd.setActivo(Activo);
        exbd.setNotaMPr(NotaMPr);
        exbd.setCreditosSup(CreditosSup);
        exbd.setCreditosFB(CreditosFB);
        exbd.setCreditosOP(CreditosOP);
        exbd.setCreditosOB(CreditosOB);
        exbd.setCreditosCF(CreditosCF);
        exbd.setCreditosPE(CreditosPE);
        exbd.setCreditosTF(CreditosTF);
        exbd.setN_Archivo(N_Archivo);
        em.merge(exbd);
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
