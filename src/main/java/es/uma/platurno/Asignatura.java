package es.uma.platurno;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String referencia;
    @Column (nullable = false)
    private Integer codigo;
    @Column (nullable = false)
    private Integer creditos;
    @Column (nullable = false)
    private String ofertada;
    @Column (nullable = false)
    private String nombre;
	private String curso;
	private String caracter;
	private String duracion;
	private String idiomas;
	private Integer cred_prac;
	
	@Embedded
	private Optativa optativa;
	
	@OneToMany
	private List<Mat_Asig>mat_asigs;
	@ManyToOne
    private Titulacion titulacion;
	
    @OneToMany
    private List<Clase> clases;
    
    @ManyToMany 
    @JoinTable(
            name = "Mat_Asig",
            joinColumns = @JoinColumn(
                    name = "asig_Ref",
                    referencedColumnName = "referencia"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "matric_ca",
                    referencedColumnName = "curso_academico"
            )
    )
    private List<Matricula> matriculas;
    @ManyToMany 
    @JoinTable(
            name = "Gr_Asig",
            joinColumns = @JoinColumn(
                    name = "asig_Ref",
                    referencedColumnName = "referencia"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "grupo_Id",
                    referencedColumnName = "id"
            )
    )
    private List<Grupo> grupos; 
	
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public List<Clase> getClases() {
		return clases;
	}
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getReferencia() {
		return referencia;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public Integer getCreditos() {
		return creditos;
	}
	public String getOfertada() {
		return ofertada;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCurso() {
		return curso;
	}
	public String getCaracter() {
		return caracter;
	}
	public String getDuracion() {
		return duracion;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public Integer getCred_prac() {
		return cred_prac;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	public void setOfertada(String ofertada) {
		this.ofertada = ofertada;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	public void setCred_prac(Integer cred_prac) {
		this.cred_prac = cred_prac;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracter == null) ? 0 : caracter.hashCode());
		result = prime * result + ((clases == null) ? 0 : clases.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((cred_prac == null) ? 0 : cred_prac.hashCode());
		result = prime * result + ((creditos == null) ? 0 : creditos.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		result = prime * result + ((idiomas == null) ? 0 : idiomas.hashCode());
		result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((ofertada == null) ? 0 : ofertada.hashCode());
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (caracter == null) {
			if (other.caracter != null)
				return false;
		} else if (!caracter.equals(other.caracter))
			return false;
		if (clases == null) {
			if (other.clases != null)
				return false;
		} else if (!clases.equals(other.clases))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (cred_prac == null) {
			if (other.cred_prac != null)
				return false;
		} else if (!cred_prac.equals(other.cred_prac))
			return false;
		if (creditos == null) {
			if (other.creditos != null)
				return false;
		} else if (!creditos.equals(other.creditos))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		if (idiomas == null) {
			if (other.idiomas != null)
				return false;
		} else if (!idiomas.equals(other.idiomas))
			return false;
		if (matriculas == null) {
			if (other.matriculas != null)
				return false;
		} else if (!matriculas.equals(other.matriculas))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (ofertada == null) {
			if (other.ofertada != null)
				return false;
		} else if (!ofertada.equals(other.ofertada))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Asignatura [referencia=" + referencia + ", codigo=" + codigo + ", creditos=" + creditos + ", ofertada="
				+ ofertada + ", nombre=" + nombre + ", curso=" + curso + ", caracter=" + caracter + ", duracion="
				+ duracion + ", idiomas=" + idiomas + ", cred_prac=" + cred_prac + ", optativa=" + optativa
				+ ", mat_asigs=" + mat_asigs + ", titulacion=" + titulacion + ", clases=" + clases + ", matriculas="
				+ matriculas + ", grupos=" + grupos + "]";
	}

	
	
}
