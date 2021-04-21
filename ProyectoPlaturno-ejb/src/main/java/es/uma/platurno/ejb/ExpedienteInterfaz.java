package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.ExpedienteNoExisteException;
import es.uma.platurno.jpa.Expediente;

import javax.ejb.Local;

@Local
public interface ExpedienteInterfaz {

    public Expediente ReadExpediente(String id) throws ExpedienteNoExisteException;

    public void UpdateExpediente(String id,String Activo,
    		Double NotaMPr,
                                 Double CreditosSup,
                                 Double CreditosFB,
                                 Double CreditosOP,
                                 Double CreditosOB,
                                 Double CreditosCF,
                                 Double CreditosPE,
                                 Double CreditosTF,
                                 String N_Archivo) throws ExpedienteNoExisteException;

    public void DeleteExpediente(String id) throws ExpedienteNoExisteException;


}
