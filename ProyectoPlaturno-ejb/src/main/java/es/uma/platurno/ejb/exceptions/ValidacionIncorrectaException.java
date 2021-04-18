package es.uma.platurno.ejb.exceptions;

public class ValidacionIncorrectaException extends Exception{
    public ValidacionIncorrectaException(){

    }
    public ValidacionIncorrectaException(String cadena){
        super(cadena);
    }
}
