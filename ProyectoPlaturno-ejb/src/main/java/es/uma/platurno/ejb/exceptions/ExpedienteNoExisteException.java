package es.uma.platurno.ejb.exceptions;

public class ExpedienteNoExisteException extends Exception {

    public ExpedienteNoExisteException(){

    }

    public ExpedienteNoExisteException(String e){
        super(e);
    }
}
