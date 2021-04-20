package es.uma.platurno.ejb;

import es.uma.platurno.GrupoError;
import es.uma.platurno.ejb.exceptions.UserException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Solicitud_Cambio_Grupo implements Solicitud_Cambio_Grupo_Interfaz{

	@PersistenceContext(unitName = "AgendaEE-EntidadesPU")
    private EntityManager em;
	private String grupoOriginal;
	private String grupoDeseado;
	private String motivo;
	private UsuarioEjb user;
	/* 2 Solicitudes seran iguales si ambas vienen del mismo Usuario */
	/* Suponemos que la solictud va ligada a un Usuario, por ende llamamos al metodo 
	   de Uusario equals() para prevenir solicitudes duplicadas........*/
	public Solicitud_Cambio_Grupo(String go, String gd, String msg, UsuarioEjb u) throws UserException {
		if ( go != null ) {
			if( gd != null ) {
				if ( msg != null ) { //Version beta -> mejora? consulta directa a la base de datos para comprobar las solicitudes?
					if ( user.equals(u) ) {
						/*
						 * OJO, se debe suponer que un Usuario solo puedde solicitar un
						 * cambio de turno/solicitud, si no se resuelve la anterior no 
						 * puede solicitar otra? -> Preguntar
						 */
						if( validateData(go, gd, msg, u) ) {
							generarSolicitud(go, gd, msg, u);
						}
					} else {
						throw new UserException("Error, Solicitud duplicada");
					}
				} else {
					throw new GrupoError("Error, motivo de la solicitud vacio o sin rellenar.");
				}
			} else {
				throw new GrupoError("Error, grupo deseado no indicado.");
			}
			
		} else  {
			throw new GrupoError("Error, grupo original no indicado.");
		}
	}

	@SuppressWarnings("null")
	private void generarSolicitud(String go, String gd, String msg, AlumnoEjb u) {
		
		Solicitud_Cambio_Grupo sol = em.find(Solicitud_Cambio_Grupo.class, u.getDni());
		
		if ( sol != null ) {
			throw new GrupoError();
		}
		
		sol.setGrupoDeseado(gd);
		sol.setGrupoOriginal(go);
		sol.setMotivo(msg);
		sol.setUser(u);
		
		em.persist(sol);
		
		em.getTransaction().commit();
		
	}

	public UsuarioEjb getUser() {
		return user;
	}

	public void setUser(UsuarioEjb user) {
		this.user = user;
	}

	private boolean validateData(String go, String gd, String msg, UsuarioEjb u) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getGrupoOriginal() {
		return grupoOriginal;
	}

	public void setGrupoOriginal(String grupoOriginal) {
		this.grupoOriginal = grupoOriginal;
	}

	public String getGrupoDeseado() {
		return grupoDeseado;
	}

	public void setGrupoDeseado(String grupoD) {
		this.grupoDeseado = grupoD;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	
	
	
	
	
}
