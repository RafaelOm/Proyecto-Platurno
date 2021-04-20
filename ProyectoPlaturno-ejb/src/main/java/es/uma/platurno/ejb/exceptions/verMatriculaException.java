package es.uma.platurno.ejb.exceptions;

public class verMatriculaException extends Exception{
    public verMatriculaException(){
        super();
    }

    public verMatriculaException(String motivo){
        super(motivo);
    }
}
