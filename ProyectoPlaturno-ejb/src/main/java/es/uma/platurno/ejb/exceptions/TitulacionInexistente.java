package es.uma.platurno.ejb.exceptions;

public class TitulacionInexistente extends Exception {
		public TitulacionInexistente(){

	    }
	    public TitulacionInexistente(String msg){
	        super(msg);
	    }
}

