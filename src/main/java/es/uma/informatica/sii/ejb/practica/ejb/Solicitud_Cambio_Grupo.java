package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class Solicitud_Cambio_Grupo implements Solicitud_Cambio_Grupo_Interfaz{

	@PersistenceContext(unitName = "abc")
    private EntityManager em;


	@Override
	public void generarSolicitud(GR_ASIG antiguo, GR_ASIG nuevo, Usuario U) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException {
		
		GR_ASIG n = em.find(GR_ASIG.class, antiguo.getCurso_act());
		
		Autenticacion au = new Autenticacion();
		

			au.compruebaLogin(U);
			

		
		if ( n == null ) {
			throw new GR_ASIG_GrupoNoExisteException("Error, grupo actual no encontrado.\n");
		}
		
		em.getTransaction().begin();
		
		n = em.merge(nuevo);
		
		em.remove(n);
		
		em.getTransaction().commit();
		
		
	}


}
