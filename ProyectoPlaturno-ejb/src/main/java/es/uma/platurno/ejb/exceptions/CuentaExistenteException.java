package es.uma.platurno.ejb.exceptions;

public class CuentaExistenteException extends Exception{

    public CuentaExistenteException(){

    }
    public CuentaExistenteException(String cadena){
        super(cadena);
    }
}
