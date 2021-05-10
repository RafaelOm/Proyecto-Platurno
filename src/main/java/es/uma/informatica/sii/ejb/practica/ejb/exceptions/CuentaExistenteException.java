package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class CuentaExistenteException extends Exception{

    public CuentaExistenteException(){

    }
    public CuentaExistenteException(String cadena){
        super(cadena);
    }
}
