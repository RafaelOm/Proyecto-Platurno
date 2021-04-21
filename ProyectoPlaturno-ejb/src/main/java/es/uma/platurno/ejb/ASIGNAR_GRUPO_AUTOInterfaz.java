package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Expediente;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.Local;



@Local
public interface ASIGNAR_GRUPO_AUTOInterfaz {

    void ASIGNAR(Usuario u, Expediente ex) throws EncuestaNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;
}
