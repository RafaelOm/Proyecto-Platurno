package es.uma.platurno.ejb.exceptions;

public class CuentaInexistenceException extends Exception {

    public CuentaInexistenceException(){

    }
    public CuentaInexistenceException(String cadena){
        super(cadena);
    }
}
