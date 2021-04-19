package es.uma.platurno.ejb;
import es.uma.platurno.ejb.exceptions.eliminarMatriculaException;
import es.uma.platurno.ejb.exceptions.modificarMatriculaException;
import es.uma.platurno.ejb.exceptions.verMatriculaException;
import es.uma.platurno.jpa.*;
import javax.ejb.Local;

@Local
public interface MatriculaInterfaz {

    void modificar(Matricula mat) throws modificarMatriculaException;

    void ver(Matricula mat) throws verMatriculaException;

    void eliminar(Matricula mat) throws eliminarMatriculaException;

}
