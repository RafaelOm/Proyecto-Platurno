package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import javax.ejb.Local;

@Local
public interface AsignaturasEjbInterfaz {
    public Asignatura verAsignatura(Usuario u, String ref) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException;
    public void modificarAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, ViolacionDeSeguridadException;
    public void eliminarAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, ViolacionDeSeguridadException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;


}
