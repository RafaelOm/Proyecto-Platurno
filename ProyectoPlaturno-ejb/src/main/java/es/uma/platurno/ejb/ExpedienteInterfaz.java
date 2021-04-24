package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Expediente;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.Local;

@Local
public interface ExpedienteInterfaz {

    public Expediente ReadExpediente(Usuario u, String id) throws ExpedienteNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

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

    public void DeleteExpediente(Usuario u,String id) throws ExpedienteNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;


}
