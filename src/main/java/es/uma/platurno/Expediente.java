package es.uma.platurno;

import java.io.Serializable;
import java.lang.String;
import java.util.*;

import javax.persistence.*;


@Entity

public class Expediente implements Serializable {

	   
	@Id
	private String IdExpediente;
	private String Activo;
	private String NotaMPr;
	private Integer CreditosSup;
	private Integer CreditosFB;
	private Integer CreditosOP;
	private Integer CreditosOB;
	private Integer CreditosCF;
	private Integer CreditosPE;
	private Integer CreditosTF;
	@Column(nullable = false)
	private String N_Archivo;

	@ManyToOne
    private Titulacion titulacion;
	
	@ManyToOne
    private Alumno alumno;
	
	@OneToMany
	private List<Encuesta> encuestas;
	
	@OneToMany
	private List<Matricula> matriculas;
	
	private static final long serialVersionUID = 1L;

	public Expediente() {
		super();
	}   
	public String getId_Expediente() {
		return this.IdExpediente;
	}

	public void setId_Expediente(String s) {
		this.Activo = s;
	}   
	public String getActivo() {
		return this.Activo;
	}

	public void setActivo(String s) {
		this.Activo = s;
	}   
	
	public String getNotaMPr() {
		return this.NotaMPr;
	}

	public void setNotaMPr(String NotaMPr) {
		this.NotaMPr = NotaMPr;
	}   
	
	public Integer getCreditosSup() {
		return this.CreditosSup;
	}

	public void setCreditosSup(Integer CreditosSup) {
		this.CreditosSup = CreditosSup;
	}   
	
	public Integer getCreditosFB() {
		return this.CreditosFB;
	}

	public void setCreditosFB(Integer CreditosFB) {
		this.CreditosFB = CreditosFB;
	}   
	
	public Integer getCreditosOP() {
		return this.CreditosOP;
	}

	public void setCreditosOP(Integer CreditosOP) {
		this.CreditosOP = CreditosOP;
	}   
	
	public Integer getCreditosOB() {
		return this.CreditosOB;
	}

	public void setCreditosOB(Integer CreditosOB) {
		this.CreditosOB = CreditosOB;
	}   
	
	public Integer getCreditosCF() {
		return this.CreditosCF;
	}

	public void setCreditosCF(Integer CreditosCF) {
		this.CreditosCF = CreditosCF;
	}   
	
	public Integer getCreditosPE() {
		return this.CreditosPE;
	}

	public void setCreditosPE(Integer CreditosPE) {
		this.CreditosPE = CreditosPE;
	}   
	
	public Integer getCreditosTF() {
		return this.CreditosTF;
	}

	public void setCreditosTF(Integer CreditosTF) {
		this.CreditosTF = CreditosTF;
	}   
	public String getN_Archivo() {
		return this.N_Archivo;
	}

	public void setN_Archivo(String N_Archivo) {
		this.N_Archivo = N_Archivo;
	}   
	
	public Alumno getAlumno() {
		return this.alumno;
	}
	
	public void setAlumno(Alumno al) {
		this.alumno = al;
	}
	
	public Titulacion getTitulacion() {
		return this.titulacion;
	}
	
	public void setTitulacion(Titulacion t) {
		this.titulacion = t;
	}
	
	public List<Encuesta> getEncuestas() {
		return this.encuestas;
	}
	
	public void setEncuestas(List<Encuesta> t) {
		this.encuestas = t;
	}
	
	public List<Matricula> getMatriculas() {
		return this.matriculas;
	}
	
	public void setMatriculas(List<Matricula> t) {
		this.matriculas = t;
	}
	
   
}
