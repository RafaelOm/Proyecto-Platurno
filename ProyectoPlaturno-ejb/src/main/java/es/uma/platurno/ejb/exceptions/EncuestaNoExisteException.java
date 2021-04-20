package es.uma.platurno.ejb.exceptions;

public class EncuestaNoExisteException extends Exception{

    public EncuestaNoExisteException(){

    }

    public EncuestaNoExisteException(String e){
        super(e);
    }
}
