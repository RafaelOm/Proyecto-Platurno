package es.uma.platurno.ejb.exceptions;

public class GrupoError extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GrupoError() {
		super();
	}
	
	public GrupoError( String msg ) {
		super(msg);
	}
	
}
