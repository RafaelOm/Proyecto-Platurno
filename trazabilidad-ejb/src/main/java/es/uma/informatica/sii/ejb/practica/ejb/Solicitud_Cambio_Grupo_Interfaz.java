package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

@Local
public interface Solicitud_Cambio_Grupo_Interfaz {
	
	public void generarSolicitud(GR_ASIG antiguo, GR_ASIG nuevo,Usuario u) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException;
	
}
