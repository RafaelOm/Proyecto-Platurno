package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.GR_ASIG_GrupoNoExisteException;
import es.uma.platurno.jpa.GR_ASIG;

import javax.ejb.Local;

@Local
public interface GR_ASIGEJBInterfaz {



    GR_ASIG ReadGR_ASIG(int curso_act, int referencia, int id_grupo) throws GR_ASIG_GrupoNoExisteException;


    void UpdateGR_ASIG(int curso_act, int referencia, int id_grupo, int oferta) throws GR_ASIG_GrupoNoExisteException;

    void DeleteGR_ASIG(int curso_act, int referencia, int id_grupo) throws GR_ASIG_GrupoNoExisteException;
}
