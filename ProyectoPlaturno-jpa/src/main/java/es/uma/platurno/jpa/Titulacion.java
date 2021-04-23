/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Titulacion creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entity implementation class for Entity: Titulacion
 *
 */
@Entity

public class Titulacion implements Serializable {

	   
	@Id @Column(nullable =false)
	private Integer Codigo;
	@Column(name="Nombre")
	private String Nombre;
	private Integer Creditos;
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private List<Expediente> expedientes;
	@OneToMany
	private List<Asignatura> asignatura;
	
	/*
	@ManyToMany
	@JoinTable(
			name = "Centro",
			joinColumns = @JoinColumn(
					name = "ID",
					referencedColumnName = "ID"
					),inverseJoinColumns = @JoinColumn(
					name = "Codigo",
					nullable =false,
					referencedColumnName = "Codigo"
					
					)
			)
	private List<Centro> lista_centros;
	*/
	
	@ManyToOne 
	private Centro c;
	

	


	public Titulacion() {
		super();
	}   
	public Integer getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Integer Codigo) {
		this.Codigo = Codigo;
	}   
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre= nombre;
	}   
	public Integer getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(Integer Creditos) {
		this.Creditos = Creditos;
	}
	
   
}
