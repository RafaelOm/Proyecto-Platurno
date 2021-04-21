package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.GR_ASIG_GrupoNoExisteException;
import es.uma.platurno.jpa.GR_ASIG;

public interface Solicitud_Cambio_Grupo_Interfaz {
	
	public void generarSolicitud(GR_ASIG antiguo, GR_ASIG nuevo) throws GR_ASIG_GrupoNoExisteException;
	
}
