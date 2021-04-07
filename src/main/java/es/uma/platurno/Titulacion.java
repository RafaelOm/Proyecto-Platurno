package es.uma.platurno;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Titulacion
 *
 */
@Entity

public class Titulacion implements Serializable {

	   
	@Id
	private String Codigo;
	private String Nombre;
	private String Creditos;
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private List<Expediente> expedientes;
	@OneToMany
	private List<Asignatura> asignatura;
	
	@ManyToMany
	@JoinTable(
			name = "Centro",
			joinColumns = @JoinColumn(
					name = "ID",
					referencedColumnName = "ID"
					),
			inverseJoinColumns = @JoinColumn(
					name = "Codigo",
					referencedColumnName = "Codigo"
					
					)
			)
	private List<Centro> lista_centros;

	public Titulacion() {
		super();
	}   
	public String getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(String Codigo) {
		this.Codigo = Codigo;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(String Creditos) {
		this.Creditos = Creditos;
	}
   
}
