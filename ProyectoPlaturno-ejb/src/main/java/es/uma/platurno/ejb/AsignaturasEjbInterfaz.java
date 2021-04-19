package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.AsignaturaInexsistenteException;
import es.uma.platurno.jpa.Asignatura;

import javax.ejb.Local;

@Local
public interface AsignaturasEjbInterfaz {
    public Asignatura verAsignatura(String referencia) throws AsignaturaInexsistenteException;
    public void modificarAsignatura(String referencia,Integer Codigo,Integer Creditos,
                                    String ofertada,String nombre,String curso,
                                    String caracter, String duracion, String Idiomas, Integer credPract) throws AsignaturaInexsistenteException;
    public void eliminarAsignatura(String referencia) throws AsignaturaInexsistenteException;


}
