package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class MatriculaNoExiteException extends Exception{

    public MatriculaNoExiteException(){
        
    }

    public MatriculaNoExiteException(String e){
        super(e);
    }
}
