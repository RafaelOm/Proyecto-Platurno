package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class CuentaInexistenceException extends Exception {

    public CuentaInexistenceException(){

    }
    public CuentaInexistenceException(String cadena){
        super(cadena);
    }
}
