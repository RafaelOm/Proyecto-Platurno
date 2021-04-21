package es.uma.platurno.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.platurno.jpa.Encuesta;

@Local
@Stateless
public class EncuestaEJB implements EncuestaInterfaceEJB {
	
	@PersistenceContext(unitName = "Platurno")
	private EntityManager em;
	
	public EncuestaEJB()
    {
    }

	public EncuestaEJB(java.sql.Date fechaEnvio, String texto) {
		crearEncuesta(fechaEnvio, texto);
	}
	
	public void crearEncuesta(java.sql.Date fechaEnvio, String texto) {
		 Encuesta enc = new Encuesta();
		 enc.setFecha_de_Envio(fechaEnvio);
		 enc.setTexto(texto);
		 em.persist(enc);
	}
}
