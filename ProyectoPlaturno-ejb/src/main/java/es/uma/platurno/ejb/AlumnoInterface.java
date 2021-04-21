package es.uma.platurno.ejb;

import es.uma.platurno.jpa.Alumno;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.IOException;


@Local
public interface AlumnoInterface {
       
	public void leerAlumno(Alumno a);
       
    public void eliminarAlumno(Alumno a);
    
    public void modificarAlumno(Alumno a) throws IOException;
    
}
