package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AsignaturasEjbInterfaz {
    public Asignatura verAsignatura(Usuario u, String ref) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException;
    public void modificarAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, ViolacionDeSeguridadException;
    public void eliminarAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, ViolacionDeSeguridadException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public List<Asignatura> getAll();
    public void crearAsignatura(Asignatura nueva,Usuario Usuario) throws AsignaturaInexsistenteException;

}
