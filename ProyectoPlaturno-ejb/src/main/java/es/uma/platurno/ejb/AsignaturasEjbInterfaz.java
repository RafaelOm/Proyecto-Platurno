package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Asignatura;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.Local;

@Local
public interface AsignaturasEjbInterfaz {
    public Asignatura verAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException;
    public void modificarAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, PasswordErroneaException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, ViolacionDeSeguridadException;
    public void eliminarAsignatura(Usuario u, Asignatura a) throws AsignaturaInexsistenteException, ViolacionDeSeguridadException, CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;


}
