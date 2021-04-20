package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.ExpedienteNoExisteException;
import es.uma.platurno.jpa.Expediente;

import javax.ejb.Local;

@Local
public interface ExpedienteInterfaz {

    public Expediente ReadExpediente(String id) throws ExpedienteNoExisteException;

    public void UpdateExpediente(String id,String Activo,
                                 String NotaMPr,
                                 Integer CreditosSup,
                                 Integer CreditosFB,
                                 Integer CreditosOP,
                                 Integer CreditosOB,
                                 Integer CreditosCF,
                                 Integer CreditosPE,
                                 Integer CreditosTF,
                                 String N_Archivo) throws ExpedienteNoExisteException;

    public void DeleteExpediente(String id) throws ExpedienteNoExisteException;


}
