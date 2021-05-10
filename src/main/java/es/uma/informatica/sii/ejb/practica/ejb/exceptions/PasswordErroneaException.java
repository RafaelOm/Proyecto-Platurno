package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class PasswordErroneaException extends Exception {
    public PasswordErroneaException(){

    }
    public PasswordErroneaException(String cadena){
        super(cadena);
    }
}
