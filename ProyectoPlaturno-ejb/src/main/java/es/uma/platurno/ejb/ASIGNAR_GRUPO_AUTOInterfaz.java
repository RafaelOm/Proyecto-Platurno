package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.EncuestaNoExisteException;
import es.uma.platurno.jpa.Expediente;

import javax.ejb.Local;



@Local
public interface ASIGNAR_GRUPO_AUTOInterfaz {

    void ASIGNAR (Expediente e) throws EncuestaNoExisteException;
}
