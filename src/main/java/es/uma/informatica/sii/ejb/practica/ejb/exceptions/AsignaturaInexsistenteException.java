package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class AsignaturaInexsistenteException extends Exception{

    public AsignaturaInexsistenteException(){

    }
    public AsignaturaInexsistenteException(String cadena){

        super(cadena);
    }
}
