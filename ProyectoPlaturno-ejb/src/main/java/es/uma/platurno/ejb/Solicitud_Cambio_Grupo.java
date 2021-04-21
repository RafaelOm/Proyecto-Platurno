package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.GR_ASIG_GrupoNoExisteException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.GR_ASIG;
import es.uma.platurno.jpa.Usuario;
import org.graalvm.compiler.lir.LIRInstruction;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Local
@Stateless
public class Solicitud_Cambio_Grupo implements Solicitud_Cambio_Grupo_Interfaz{

	@PersistenceContext(unitName = "Platurno")
    private EntityManager em;
	
	public void generarSolicitud(GR_ASIG antiguo, GR_ASIG nuevo, Usuario U) throws GR_ASIG_GrupoNoExisteException {
		
		GR_ASIG n = em.find(GR_ASIG.class, antiguo.getCurso_act());
		
		Autenticacion au = new Autenticacion();
		
		try {
			au.compruebaLogin(U);
			
		} catch (PlaturnoException | CuentaInactivaException | CuentaInexistenceException
				| PasswordErroneaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if ( n == null ) {
			throw new GR_ASIG_GrupoNoExisteException("Error, grupo actual no encontrado.\n");
		}
		
		em.getTransaction().begin();
		
		n = em.merge(nuevo);
		
		em.remove(n);
		
		em.getTransaction().commit();
		
		
	}

}
