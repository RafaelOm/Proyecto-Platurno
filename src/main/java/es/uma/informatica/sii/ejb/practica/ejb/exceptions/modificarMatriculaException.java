package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class modificarMatriculaException extends Exception{
    public modificarMatriculaException(){
        super();
    }

    public modificarMatriculaException(String motivo){
        super(motivo);
    }
}
