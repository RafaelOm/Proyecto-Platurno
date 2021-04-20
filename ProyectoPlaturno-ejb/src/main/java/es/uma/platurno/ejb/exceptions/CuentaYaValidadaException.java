package es.uma.platurno.ejb.exceptions;

public class CuentaYaValidadaException extends Exception{
    public CuentaYaValidadaException(){

    }
    public CuentaYaValidadaException(String cadena){
        super(cadena);
    }
}
