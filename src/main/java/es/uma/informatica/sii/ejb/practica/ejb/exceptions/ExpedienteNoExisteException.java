package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class ExpedienteNoExisteException extends Exception {

    public ExpedienteNoExisteException(){

    }

    public ExpedienteNoExisteException(String e){
        super(e);
    }
}
