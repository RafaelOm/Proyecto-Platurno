package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import javax.ejb.Local;
import java.io.IOException;


@Local
public interface AlumnoInterface {
       
	public void leerAlumno(Usuario a) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
       
    public void eliminarAlumno(Usuario a) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
    
    public void modificarAlumno(Usuario a) throws IOException, PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
    
}
