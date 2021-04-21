package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.GR_ASIG_GrupoNoExisteException;
import es.uma.platurno.jpa.GR_ASIG;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.Local;

@Local
public interface Solicitud_Cambio_Grupo_Interfaz {
	
	public void generarSolicitud(GR_ASIG antiguo, GR_ASIG nuevo, Usuario U) throws GR_ASIG_GrupoNoExisteException;
	
}
