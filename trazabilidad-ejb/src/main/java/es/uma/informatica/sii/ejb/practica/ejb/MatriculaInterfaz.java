package es.uma.informatica.sii.ejb.practica.ejb;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import es.uma.informatica.sii.ejb.practica.entidades.*;

import java.util.List;

import javax.ejb.Local;

@Local
public interface MatriculaInterfaz {

    void modificar(Usuario u,Matricula mat) throws modificarMatriculaException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

    void ver(Usuario u,Matricula mat) throws verMatriculaException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

    void eliminar(Usuario u,Matricula mat) throws eliminarMatriculaException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

	void crearMatricula(Matricula nueva, Usuario usuario) throws PlaturnoException, CuentaInactivaException,
			CuentaInexistenceException, PasswordErroneaException, MatriculaNoExiteException;
            
    List<Matricula> getAll();
}
