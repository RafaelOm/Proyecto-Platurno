package es.uma.platurno;

import javax.ejb.Local;

@Local
public interface MatriculaInterfaz {

	public void modificar();

	public void ver();
	
	public void eliminar();
	
}
