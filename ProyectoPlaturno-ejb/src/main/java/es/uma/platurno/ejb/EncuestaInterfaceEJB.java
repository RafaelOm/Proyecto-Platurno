package es.uma.platurno.ejb;

import javax.ejb.Local;

@Local
public interface EncuestaInterfaceEJB {
    public void crearEncuesta(java.sql.Date fechaEnvio, String texto);
	
}
