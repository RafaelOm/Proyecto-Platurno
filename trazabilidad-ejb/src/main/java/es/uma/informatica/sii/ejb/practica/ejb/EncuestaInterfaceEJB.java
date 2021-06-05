package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

@Local
public interface EncuestaInterfaceEJB {
	void crearEncuesta(Encuesta enc,Usuario u) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
	
}
