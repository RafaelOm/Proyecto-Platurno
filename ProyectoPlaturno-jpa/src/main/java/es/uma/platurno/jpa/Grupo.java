/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Grupo creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/*
 * Entity implementation class for Entity: Alumno
 *
 */

@Entity

public class Grupo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@ManyToOne
	private Grupo grupo;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Curso;
		result = prime * result + ((Ingles == null) ? 0 : Ingles.hashCode());
		result = prime * result + ((Letra == null) ? 0 : Letra.hashCode());
		result = prime * result + Plazas;
		result = prime * result + ((Turno == null) ? 0 : Turno.hashCode());
		result = prime * result + ((asignar == null) ? 0 : asignar.hashCode());
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		result = prime * result + ((grupos_asig == null) ? 0 : grupos_asig.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((letra1 == null) ? 0 : letra1.hashCode());
		result = prime * result + ((mat_asig == null) ? 0 : mat_asig.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((visible == null) ? 0 : visible.hashCode());
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
		Grupo other = (Grupo) obj;
		if (Curso != other.Curso)
			return false;
		if (Ingles == null) {
			if (other.Ingles != null)
				return false;
		} else if (!Ingles.equals(other.Ingles))
			return false;
		if (Letra == null) {
			if (other.Letra != null)
				return false;
		} else if (!Letra.equals(other.Letra))
			return false;
		if (Plazas != other.Plazas)
			return false;
		if (Turno == null) {
			if (other.Turno != null)
				return false;
		} else if (!Turno.equals(other.Turno))
			return false;
		if (asignar == null) {
			if (other.asignar != null)
				return false;
		} else if (!asignar.equals(other.asignar))
			return false;
		if (clase == null) {
			if (other.clase != null)
				return false;
		} else if (!clase.equals(other.clase))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		if (grupos_asig == null) {
			if (other.grupos_asig != null)
				return false;
		} else if (!grupos_asig.equals(other.grupos_asig))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (letra1 == null) {
			if (other.letra1 != null)
				return false;
		} else if (!letra1.equals(other.letra1))
			return false;
		if (mat_asig == null) {
			if (other.mat_asig != null)
				return false;
		} else if (!mat_asig.equals(other.mat_asig))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (visible == null) {
			if (other.visible != null)
				return false;
		} else if (!visible.equals(other.visible))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", Curso=" + Curso + ", Letra=" + Letra + ", Turno=" + Turno + ", Ingles=" + Ingles
				+ ", visible=" + visible + ", asignar=" + asignar + ", Plazas=" + Plazas + ", letra1=" + letra1
				+ ", grupos=" + grupos + ", grupo=" + grupo + ", mat_asig=" + mat_asig + ", clase=" + clase
				+ ", grupos_asig=" + grupos_asig + ", titulo=" + titulo + "]";
	}
	
	
	
	
}