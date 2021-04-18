package es.uma.platurno.ejb.exceptions;

public class ClavesDiferentesException extends Exception{

    public ClavesDiferentesException(){

    }
    public ClavesDiferentesException(String cadena){

        super(cadena);
    }
}
