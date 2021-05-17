package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class verMatriculaException extends Exception{
    public verMatriculaException(){
        super();
    }

    public verMatriculaException(String motivo){
        super(motivo);
    }
}
