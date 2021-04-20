package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.ExpedienteNoExisteException;
import es.uma.platurno.jpa.Expediente;

import javax.ejb.Local;

@Local
public interface ExpedienteInterfaz {

    public Expediente ReadExpediente(String id) throws ExpedienteNoExisteException;

    public void UpdateExpediente(Expediente F ) throws ExpedienteNoExisteException;

    public void DeleteExpediente(String id) throws ExpedienteNoExisteException;


}
