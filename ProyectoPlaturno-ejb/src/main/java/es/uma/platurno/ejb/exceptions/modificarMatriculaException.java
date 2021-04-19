package es.uma.platurno.ejb.exceptions;

public class modificarMatriculaException extends Exception{
    public modificarMatriculaException(){
        super();
    }

    public modificarMatriculaException(String motivo){
        super(motivo);
    }
}
