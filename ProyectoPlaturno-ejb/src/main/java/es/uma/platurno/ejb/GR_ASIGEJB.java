package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.GR_ASIG;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class GR_ASIGEJB
 */
@Stateless
@LocalBean
public class GR_ASIGEJB implements GR_ASIGEJBInterfaz {
    @PersistenceContext(unitName = "ProyectoPlaturno.GrupoF")
    private EntityManager em;
    private Autenticacion auth;

    /**
     * Default constructor. 
     */
    public GR_ASIGEJB() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public GR_ASIG ReadGR_ASIG(Usuario u, int curso_act, String referencia, String id_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {

        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        GR_ASIG bd = em.find(GR_ASIG.class, new GR_ASIG.GR_ASIGID(curso_act,referencia,id_grupo));
        if(bd==null){
            throw new GR_ASIG_GrupoNoExisteException();
        }
        return bd;
    }

    @Override
    public void UpdateGR_ASIG(Usuario u, int curso_act, String referencia, String id_grupo, int oferta) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
        GR_ASIG bd = ReadGR_ASIG(u,curso_act, referencia, id_grupo);
        bd.setOferta(oferta);
        em.merge(bd);
    }

    @Override
    public void DeleteGR_ASIG(Usuario u, int curso_act, String referencia, String id_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {
        GR_ASIG bd = ReadGR_ASIG(u,curso_act, referencia, id_grupo);
        em.remove(bd);
    }
}
