package es.uma.platurno.ejb.exceptions;

public class PlaturnoException extends Exception {
    public PlaturnoException(){

    }
    public PlaturnoException(String cadena){
        super(cadena);
    }
}
