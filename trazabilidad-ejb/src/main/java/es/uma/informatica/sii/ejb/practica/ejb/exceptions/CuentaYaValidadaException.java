package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class CuentaYaValidadaException extends Exception{
    public CuentaYaValidadaException(){

    }
    public CuentaYaValidadaException(String cadena){
        super(cadena);
    }
}
