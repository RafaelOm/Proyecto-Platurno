package es.uma.platurno.ejb.exceptions;

public class ContrasenaigualException extends Exception{
    public ContrasenaigualException(){

    }
    public ContrasenaigualException(String cadena){
        super(cadena);
    }
}
