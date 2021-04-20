package es.uma.platurno.ejb.exceptions;

public class eliminarMatriculaException extends Exception{
    public eliminarMatriculaException(){
        super();
    }

    public eliminarMatriculaException(String motivo){
        super(motivo);
    }
}
