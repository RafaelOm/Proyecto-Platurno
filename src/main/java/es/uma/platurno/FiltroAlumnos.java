package es.uma.platurno;
import java.util.*;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class FiltroMatriculas {
	private List<Matricula> lista;
   
    private EntityManager em;
	
	public FiltroMatriculas() {
		lista = null;
	}
	
	public FiltroMatriculas(List<Matricula> list) {
		lista = list;
	}
	
	public void setListaMatriculas(List<Matricula> list) {
		this.lista = list;
	}
	
	public List<Matricula> getListaMatriculas(){
		return this.lista;
	}
	
	// Filtro (1er parametro Asignaturas, 2o parametro Titulacion, 3er parametro Cursos)
	public List<Matricula> filtroListaMatriculas(List<List<String>> parametros){
		List<Matricula> lista = null;
		if(parametros == null) {
			lista = this.lista;
		} else {
			List<String> asignaturas_referencias = parametros.get(0);
			List<String> titulacion_codigo       = parametros.get(1);
			List<String> cursos_matriculas       = parametros.get(2);
			
			 
			
		}
		
		return lista;
	}
}
