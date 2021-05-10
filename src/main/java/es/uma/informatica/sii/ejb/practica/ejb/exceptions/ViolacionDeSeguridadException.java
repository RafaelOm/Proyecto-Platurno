package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class ViolacionDeSeguridadException extends Exception{
    public ViolacionDeSeguridadException(){

    }

    public ViolacionDeSeguridadException(String e){
        super(e);
    }
}
