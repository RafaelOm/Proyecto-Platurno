package es.uma.platurno.ejb.exceptions;

import es.uma.platurno.ejb.Matricula_ejb;

public class MatriculaEJBException extends Exception{
    public MatriculaEJBException(){
        super();
    }

    public MatriculaEJBException(String motivoError){
        super(motivoError);
    }
}
