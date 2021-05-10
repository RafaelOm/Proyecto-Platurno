package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class CuentaInactivaException extends Exception{
    public CuentaInactivaException(){

    }
    public CuentaInactivaException(String cadena){
        super(cadena);
    }
}
