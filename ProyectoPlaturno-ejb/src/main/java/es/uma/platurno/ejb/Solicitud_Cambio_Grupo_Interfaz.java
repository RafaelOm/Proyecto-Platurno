package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.GR_ASIG_GrupoNoExisteException;
import es.uma.platurno.jpa.*;

public interface Solicitud_Cambio_Grupo_Interfaz {
	
	public void generarSolicitud(GR_ASIG antiguo, GR_ASIG nuevo,Usuario u) throws GR_ASIG_GrupoNoExisteException;
	
}
