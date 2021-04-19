package es.uma.platurno.ejb.exceptions;

public class AsignaturaInexsistenteException extends Exception{

    public AsignaturaInexsistenteException(){

    }
    public AsignaturaInexsistenteException(String cadena){

        super(cadena);
    }
}
