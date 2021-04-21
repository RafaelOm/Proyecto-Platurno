package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.CuentaInactivaException;
import es.uma.platurno.ejb.exceptions.CuentaInexistenceException;
import es.uma.platurno.ejb.exceptions.PasswordErroneaException;
import es.uma.platurno.ejb.exceptions.PlaturnoException;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.Local;
import java.io.IOException;


@Local
public interface AlumnoInterface {
       
	public void leerAlumno(Usuario a) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
       
    public void eliminarAlumno(Usuario a) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
    
    public void modificarAlumno(Usuario a) throws IOException, PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
    
}
