package es.uma.platurno.ejb.exceptions;

public class ViolacionDeSeguridadException extends Exception{
    public ViolacionDeSeguridadException(){

    }

    public ViolacionDeSeguridadException(String e){
        super(e);
    }
}
