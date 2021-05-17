package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;
@Local
@Stateless
public class EncuestaEJB implements EncuestaInterfaceEJB {

	@PersistenceContext(unitName = "abc")
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
