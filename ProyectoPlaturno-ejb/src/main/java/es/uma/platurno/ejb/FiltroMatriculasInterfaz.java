package es.uma.platurno.ejb;

import es.uma.platurno.jpa.Matricula;

import java.util.List;

public interface FiltroMatriculasInterfaz {
    public List<Matricula> filtroListaMatriculas(List<List<String>> parametros);

    public List<Matricula> filtrarPorAsignaturas(List<String> asignatura);

    public List<Matricula> filtrarPorTitulacion(List<String> titulacion);

    public List<Matricula> filtrarPorCursos(List<String> curso);
}
