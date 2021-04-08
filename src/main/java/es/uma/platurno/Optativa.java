package es.uma.platurno;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Embeddable
public class Optativa extends Asignatura{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column (nullable = false)
	private String plazas;
	private String mencion;
	public String getPlazas() {
		return plazas;
	}
	public void setPlazas(String plazas) {
		this.plazas = plazas;
	}
	public String getMencion() {
		return mencion;
	}
	public void setMencion(String mencion) {
		this.mencion = mencion;
	}
	
	
	
	//private Asignatura asig_opt;
	

	 
}
