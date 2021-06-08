package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 * Session Bean implementation class Expediente
 */
@Stateless
public class ExpedienteEJB implements ExpedienteInterfaz {
    @PersistenceContext(unitName = "abc")
    private EntityManager em;
   
    @Inject
    private AutenticacionInterfaz auth;
    private static final Logger LOGGER = Logger.getLogger(ExpedienteEJB.class.getCanonicalName());
    /**
     * Default constructor. 
     */
    public ExpedienteEJB() {

    }

    @Override
    public List<Expediente> getAll() {
    	
    	
    	Query query =em.createQuery("SELECT a FROM Expediente a");
    	List<Expediente> Expediente =query.getResultList();
    	LOGGER.info("LECTURA DE BD "+Expediente.toString());
		return  Expediente;
    	
    }
    @Override
    public void crearExpediente(Expediente nueva, Usuario usuario) throws ExpedienteNoExisteException, PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException{
    	
    	auth.compruebaLogin(usuario);
    	  
		LOGGER.info("CREAR- Expediente: PARAMETRO"+nueva.toString()+"USER TEST: "+usuario.toString());

	Expediente e =em.find(Expediente.class, nueva.getExpediente());
	
	if(e!=null) {
		throw new ExpedienteNoExisteException("Expediente ya existe");
	}
		LOGGER.info("CREAR- Expediente: "+nueva.toString());
	em.persist(nueva);
	
	
}

    @Override
    public Expediente ReadExpediente( String id) throws ExpedienteNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
        
       
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
        LOGGER.info("ESTOY EN UPDATE EXPEDIENTE EJB");
        exbd.setActivo(Activo);
        exbd.setNotampr(NotaMPr);
        exbd.setCreditosSup(CreditosSup);
        exbd.setCreditosFB(CreditosFB);
        exbd.setCreditosOP(CreditosOP);
        exbd.setCreditosOB(CreditosOB);
        exbd.setCreditosCF(CreditosCF);
        exbd.setCreditosPE(CreditosPE);
        exbd.setCreditosTF(CreditosTF);
        exbd.setN_archivo(N_Archivo);
        em.merge(exbd);
       
    }

    @Override
    public void DeleteExpediente(Usuario u, String id) throws ExpedienteNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
        auth.compruebaLogin(u);
        Expediente exbd = em.find(Expediente.class, id);
        if(exbd == null){
            throw new ExpedienteNoExisteException();
        }

        em.remove(exbd);
    }




}