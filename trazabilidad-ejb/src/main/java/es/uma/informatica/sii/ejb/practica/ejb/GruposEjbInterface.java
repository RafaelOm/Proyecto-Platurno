package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Local;

@Local
public interface GruposEjbInterface {
    public Asignatura verGrupo(Usuario u, String ref) throws GrupoInexistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException;
    public void modificarGrupo(Usuario u, Grupo a) throws GrupoInexistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, ViolacionDeSeguridadException;
    public void eliminarGrupo(Usuario u, Grupo a) throws GrupoInexistenteException, ViolacionDeSeguridadException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public List<Grupo> getAll();
    public void crearGrupo(Grupo nueva,Usuario Usuario) throws GrupoInexistenteException;

}
