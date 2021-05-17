package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class ValidacionIncorrectaException extends Exception{
    public ValidacionIncorrectaException(){

    }
    public ValidacionIncorrectaException(String cadena){
        super(cadena);
    }
}
