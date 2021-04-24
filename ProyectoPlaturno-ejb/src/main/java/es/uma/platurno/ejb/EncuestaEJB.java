package es.uma.platurno.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.Encuesta;
import es.uma.platurno.jpa.Usuario;

@Local
@Stateless
public class EncuestaEJB implements EncuestaInterfaceEJB {
	
	@PersistenceContext(unitName = "ProyectoPlaturno.GrupoF")
	private EntityManager em;
	
	
	private Autenticacion auth;
	
  
        
	public EncuestaEJB()
    {
    }

	public EncuestaEJB(Usuario u, java.sql.Date fechaEnvio, String texto) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
		crearEncuesta(u, fechaEnvio, texto);
	}
	
	public void crearEncuesta(Usuario u, java.sql.Date fechaEnvio, String texto) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
		auth=new Autenticacion();
        auth.compruebaLogin(u);
		Encuesta enc = new Encuesta();
		enc.setFecha_de_Envio(fechaEnvio);
		enc.setTexto(texto);
		em.persist(enc);
	}
}
