package es.uma.platurno.ejb.exceptions;

public class CuentaInactivaException extends Exception{
    public CuentaInactivaException(){

    }
    public CuentaInactivaException(String cadena){
        super(cadena);
    }
}
