package es.uma.platurno;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Optativa {
	@Column (nullable = false)
	private String plazas;
	private String mencion;
	@Id
	@Embedded
	private Asignatura asig_opt;
	
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
	public Asignatura getAsig_opt() {
		return asig_opt;
	}
	public void setAsig_opt(Asignatura asig_opt) {
		this.asig_opt = asig_opt;
	}
}
