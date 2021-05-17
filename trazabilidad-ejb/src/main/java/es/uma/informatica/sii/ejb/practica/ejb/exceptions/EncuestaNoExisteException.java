package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class EncuestaNoExisteException extends Exception{

    public EncuestaNoExisteException(){

    }

    public EncuestaNoExisteException(String e){
        super(e);
    }
}
