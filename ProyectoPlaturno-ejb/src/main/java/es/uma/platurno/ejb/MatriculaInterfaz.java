package es.uma.platurno.ejb;
import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.*;
import javax.ejb.Local;

@Local
public interface MatriculaInterfaz {

    void modificar(Usuario u,Matricula mat) throws modificarMatriculaException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

    void ver(Usuario u,Matricula mat) throws verMatriculaException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

    void eliminar(Usuario u,Matricula mat) throws eliminarMatriculaException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

}
