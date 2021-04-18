package es.uma.platurno.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import es.uma.platurno.jpa.*;

/**
 * Session Bean implementation class Matricula
 */
@Stateless
@LocalBean
public class Matricula implements MatriculaInterfaz {

    /**
     * Default constructor. 
     */
    public Matricula() {
        // TODO Auto-generated constructor stub
        Alumno a = new Alumno();
        Clase c =new Clase();


    	
    }

}
