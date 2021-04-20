package es.uma.platurno.ejb;

import es.uma.platurno.jpa.Alumno;

import java.io.IOException;

public interface AlumnoInterface {
       
	public void leerAlumno(Alumno a);
       
    public void eliminarAlumno(Alumno a);
    
    public void modificarAlumno(Alumno a) throws IOException;
    
}
