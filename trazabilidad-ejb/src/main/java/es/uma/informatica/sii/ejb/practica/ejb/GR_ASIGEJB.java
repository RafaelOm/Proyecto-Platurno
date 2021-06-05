package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class GR_ASIGEJB
 */
@Stateless
public class GR_ASIGEJB implements GR_ASIGEJBInterfaz {

    @PersistenceContext(unitName = "abc")
    private EntityManager em;
    @Inject
    private AutenticacionInterfaz auth;
    private static final Logger LOGGER = Logger.getLogger(GR_ASIGEJB.class.getCanonicalName());

    /**
     * Default constructor. 
     */
    public GR_ASIGEJB() {
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public List<GR_ASIG> getAll() {
    	
    	Query query =em.createQuery("SELECT g FROM GR_ASIG g");
    	List<GR_ASIG> GR_ASIGs =query.getResultList();
    	
    	LOGGER.info("LECTURA DE BD GR_ASIG "+GR_ASIGs.toString());
		return  GR_ASIGs;
    	
    }
    @Override
    public GR_ASIG ReadGR_ASIG(Usuario u, String curso_act, String referencia, String id_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {

        //////Check if user is authenticated in the system  ////////////
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        GR_ASIG bd = em.find(GR_ASIG.class, new GR_ASIG.GR_ASIGID(curso_act,referencia,id_grupo));
        if(bd==null){
            throw new GR_ASIG_GrupoNoExisteException();
        }
        return bd;
    }

    @Override
    public void UpdateGR_ASIG(Usuario u, GR_ASIG asignar_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
    	auth.compruebaLogin(u);
    	GR_ASIG bd = em.find(GR_ASIG.class,  new GR_ASIG.GR_ASIGID(asignar_grupo.getCurso_act(),asignar_grupo.getAsig().getReferencia(),asignar_grupo.getGroup().getId()));
    	if(bd==null){
            throw new GR_ASIG_GrupoNoExisteException();
        }
        em.merge(bd);
    }

  
	@Override
    public void DeleteGR_ASIG(Usuario u, GR_ASIG asignar_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
    	auth.compruebaLogin(u);
    	GR_ASIG bd = em.find(GR_ASIG.class,  new GR_ASIG.GR_ASIGID(asignar_grupo.getCurso_act(),asignar_grupo.getAsig().getReferencia(),asignar_grupo.getGroup().getId()));
    	if(bd==null){
            throw new GR_ASIG_GrupoNoExisteException();
        }
        em.remove(em.merge(bd));
    }
	
	 @Override
	    public void crearGR_ASIG(GR_ASIG nuevo,Usuario usuario) throws GrupoInexistenteException {
	    	
	    	try {
				auth.checkSecretariaRole(usuario);
			} catch (CuentaInexistenceException | ViolacionDeSeguridadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	    		LOGGER.info("CREAR-GRUPO: PARAMETRO "+nuevo.toString()+" - USER TEST: " + usuario.toString());
	    
	        GR_ASIG bd = em.find(GR_ASIG.class,  new GR_ASIG.GR_ASIGID(nuevo.getCurso_act(),nuevo.getAsig().getReferencia(),nuevo.getGroup().getId()));
	    	
	    	if(bd!=null) {
	    		throw new GrupoInexistenteException("EL GRUPO YA EXISTE, USUARIO SECRETARIA");
	    	}
	    		LOGGER.info("CREAR-GRUPO: "+nuevo.toString());
	    	em.persist(nuevo);
	    	
	    	
	    }
}
