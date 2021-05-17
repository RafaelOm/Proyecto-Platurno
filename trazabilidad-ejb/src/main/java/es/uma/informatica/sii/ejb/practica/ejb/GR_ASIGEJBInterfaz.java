package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import javax.ejb.Local;

@Local
public interface GR_ASIGEJBInterfaz {




    public GR_ASIG ReadGR_ASIG(Usuario u, int curso_act, String referencia, String id_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

    public void UpdateGR_ASIG(Usuario u, int curso_act, String referencia, String id_grupo, int oferta) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

    public void DeleteGR_ASIG(Usuario u, int curso_act, String referencia, String id_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;
}
