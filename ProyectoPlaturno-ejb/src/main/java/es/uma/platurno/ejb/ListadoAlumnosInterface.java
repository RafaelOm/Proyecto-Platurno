package es.uma.platurno.ejb;

import java.util.List;

public interface ListadoAlumnosInterface {
	public List<AlumnoEjb> getAlumnosList();
	public List<AlumnoEjb> getAlumnosListFiltered(List<String> l);
}
