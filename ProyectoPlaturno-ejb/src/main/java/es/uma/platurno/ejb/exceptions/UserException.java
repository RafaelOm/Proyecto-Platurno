package es.uma.platurno.ejb.exceptions;

public class UserException extends Exception{
    public UserException(){
        super();
    }

    public UserException(String motivo){
        super(motivo);
    }
}
