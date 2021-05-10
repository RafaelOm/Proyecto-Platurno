package es.uma.informatica.sii.ejb.practica.ejb.exceptions;



public class MatriculaEJBException extends Exception{
    public MatriculaEJBException(){
        super();
    }

    public MatriculaEJBException(String motivoError){
        super(motivoError);
    }
}
