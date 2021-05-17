package es.uma.informatica.sii.ejb.practica.ejb.exceptions;

public class AlumnoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlumnoException() {
		super();
	}
	
	public AlumnoException( String msg ) {
		super(msg);
	}
	
}
