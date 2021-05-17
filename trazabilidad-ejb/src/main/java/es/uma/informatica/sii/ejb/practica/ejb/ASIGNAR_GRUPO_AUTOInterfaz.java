package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import javax.ejb.Local;



@Local
public interface ASIGNAR_GRUPO_AUTOInterfaz {

    void ASIGNAR(Usuario u, Expediente ex) throws EncuestaNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;
}
