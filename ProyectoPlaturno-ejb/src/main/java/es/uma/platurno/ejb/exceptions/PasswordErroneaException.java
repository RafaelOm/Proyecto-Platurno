package es.uma.platurno.ejb.exceptions;

public class PasswordErroneaException extends Exception {
    public PasswordErroneaException(){

    }
    public PasswordErroneaException(String cadena){
        super(cadena);
    }
}
