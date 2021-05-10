package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

@Local
public interface EncuestaInterfaceEJB {
	void crearEncuesta(Usuario u, java.sql.Date fechaEnvio, String texto) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
	
}
