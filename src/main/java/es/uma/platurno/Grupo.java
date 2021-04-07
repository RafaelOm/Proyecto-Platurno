package es.uma.platurno;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/*
 * Entity implementation class for Entity: Alumno
 *
 */

@Entity

public class Grupo implements Serializable {
	
	@Id
	private String id;
	@Column (nullable = false)
	private int Curso;
	@Column (nullable = false)
	private String Letra;
	@Column (nullable = false)
	private String Turno;
	@Column (nullable = false)
	private String Ingles;
	@Column (nullable = false)
	private String visible;
	private String asignar;
	private int Plazas;
	private String letra1;
	
	@OneToMany
	private List<Grupo> grupos;
	@OneToMany
	private List<Mat_Asig> mat_asig;
	@OneToMany
	private List<Clase> clase;
	@OneToMany
	private List<GR_ASIG> grupos_asig;
	@ManyToOne
	private Titulacion titulo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCurso() {
		return Curso;
	}
	public void setCurso(int curso) {
		Curso = curso;
	}
	public String getLetra() {
		return Letra;
	}
	public void setLetra(String letra) {
		Letra = letra;
	}
	public String getTurno() {
		return Turno;
	}
	public void setTurno(String turno) {
		Turno = turno;
	}
	public String getIngles() {
		return Ingles;
	}
	public void setIngles(String ingles) {
		Ingles = ingles;
	}
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}
	public String getAsignar() {
		return asignar;
	}
	public void setAsignar(String asignar) {
		this.asignar = asignar;
	}
	public int getPlazas() {
		return Plazas;
	}
	public void setPlazas(int plazas) {
		Plazas = plazas;
	}
	public String getLetra1() {
		return letra1;
	}
	public void setLetra1(String letra1) {
		this.letra1 = letra1;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public List<Mat_Asig> getMat_asig() {
		return mat_asig;
	}
	public void setMat_asig(List<Mat_Asig> mat_asig) {
		this.mat_asig = mat_asig;
	}
	public List<Clase> getClase() {
		return clase;
	}
	public void setClase(List<Clase> clase) {
		this.clase = clase;
	}
	public List<GR_ASIG> getGrupos_asig() {
		return grupos_asig;
	}
	public void setGrupos_asig(List<GR_ASIG> grupos_asig) {
		this.grupos_asig = grupos_asig;
	}
	public Titulacion getTitulo() {
		return titulo;
	}
	public void setTitulo(Titulacion titulo) {
		this.titulo = titulo;
	}
	
	
	
	
}