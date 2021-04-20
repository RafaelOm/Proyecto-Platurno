package es.uma.platurno.ejb;

import java.util.List;

public interface ListadoAlumnosInterface {
	public List<Alumno> getAlumnosList();
	public List<Alumno> getAlumnosListFiltered(List<String> l);
}
