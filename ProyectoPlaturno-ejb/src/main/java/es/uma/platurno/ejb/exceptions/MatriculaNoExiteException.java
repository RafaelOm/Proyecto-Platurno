package es.uma.platurno.ejb.exceptions;

public class MatriculaNoExiteException extends Exception{

    public MatriculaNoExiteException(){
        
    }

    public MatriculaNoExiteException(String e){
        super(e);
    }
}
