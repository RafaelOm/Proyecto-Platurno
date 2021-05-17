package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class ClavesDiferentesException extends Exception{

    public ClavesDiferentesException(){

    }
    public ClavesDiferentesException(String cadena){

        super(cadena);
    }
}
