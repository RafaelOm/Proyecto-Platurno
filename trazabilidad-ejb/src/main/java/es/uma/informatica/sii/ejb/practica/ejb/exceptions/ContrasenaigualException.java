package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class ContrasenaigualException extends Exception{
    public ContrasenaigualException(){

    }
    public ContrasenaigualException(String cadena){
        super(cadena);
    }
}
