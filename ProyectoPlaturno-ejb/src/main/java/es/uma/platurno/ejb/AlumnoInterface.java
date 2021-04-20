package es.uma.platurno.ejb;

import java.io.IOException;

public interface AlumnoInterface {
       
	public void leerAlumno(String dni);
       
    public void eliminarAlumno(String dni); 
    
    public void modificarAlumno(String dni) throws IOException;
    
}
