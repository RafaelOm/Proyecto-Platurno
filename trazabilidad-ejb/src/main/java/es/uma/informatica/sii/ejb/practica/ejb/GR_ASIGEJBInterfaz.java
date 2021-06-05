package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GR_ASIGEJBInterfaz {




    public GR_ASIG ReadGR_ASIG(Usuario u, String curso_act, String referencia, String id_grupo) throws GR_ASIG_GrupoNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

	List<GR_ASIG> getAll();

	void UpdateGR_ASIG(Usuario u, GR_ASIG asignar_grupo) throws GR_ASIG_GrupoNoExisteException,
			PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

	void DeleteGR_ASIG(Usuario u, GR_ASIG asignar_grupo) throws GR_ASIG_GrupoNoExisteException,
			PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

	void crearGR_ASIG(GR_ASIG asignar_grupo, Usuario usuario) throws GrupoInexistenteException;
}
