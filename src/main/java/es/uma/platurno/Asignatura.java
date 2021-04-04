package TodosPosetPosibles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Embeddable
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

	
}
