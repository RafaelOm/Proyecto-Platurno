package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;
@Local
@Stateless
public class EncuestaEJB implements EncuestaInterfaceEJB {

	@PersistenceContext(unitName = "abc")
	private EntityManager em;
	
	@Inject
	private AutenticacionInterfaz auth;
	
  
        
	public EncuestaEJB(){
    }

	
	
	public void crearEncuesta(Encuesta encuesta,Usuario u) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
		
        auth.compruebaLogin(u);
		em.persist(encuesta);
	}
}
