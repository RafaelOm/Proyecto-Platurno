package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.GR_ASIG;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.Local;

@Local
public interface GR_ASIGEJBInterfaz {




    GR_ASIG ReadGR_ASIG(Usuario u, int curso_act, String referencia, String id_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

    void UpdateGR_ASIG(Usuario u, int curso_act, String referencia, String id_grupo, int oferta) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

    void DeleteGR_ASIG(Usuario u, int curso_act, String referencia, String id_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;
}
