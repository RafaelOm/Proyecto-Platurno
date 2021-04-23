/* Trabajo realizado por el grupo Ingenieros a lo Bestia 3A Ingenieria Informatica.
 Clase Centro creada en JPA que modela los datos que va a tener la entidad en la BD. */

package es.uma.platurno.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entity implementation class for Entity: Centro
 *
 */

/* Entidad que representa a la entidad Centro. Usamos la interfaz serializable
 * para poder mandar los datos a la BD.*/
@Entity
@Table(name = "Centro")
public class Centro implements Serializable {

	/* Atributos de la entidad, donde name es el nombre que va a tener el atributo en la BD y
       nullable simboliza los atributos que son obligatorios en la BD. */
	   
	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "Nombre", unique = true)
	private String nombre;

	@Column(name = "Direccion", nullable = false)
	private String direccion;

	@Column(name = "TLF_Conserjeria")
	private String tlf_conserjeria;

//--------------------------------------------------------------------------------------------------------------------//

	private static final long serialVersionUID = 1L;

//--------------------------------------------------------------------------------------------------------------------//

	/* Atributos de la entidad relacionado con relaciones (foreign key).*/
	/*
	@ManyToMany
	@JoinTable(
	            name = "Centro_Titulacion",
	            joinColumns = @JoinColumn(
	                    name = "Centro",
	                    referencedColumnName = "codigo"
	            ),
	            inverseJoinColumns = @JoinColumn(
	                    name = "Titulacion",
	                    referencedColumnName = "id"
	            )
	    )
	private List<Titulacion> grupo;
	*/
	
	@OneToMany
	private List<Titulacion> titulaciones;
	
	public List<Titulacion> getTitulaciones(){
		return titulaciones;
	}
	public void setTitulaciones(List<Titulacion> titulaciones) {
		titulaciones=titulaciones;
		
	}

//--------------------------------------------------------------------------------------------------------------------//

	/* Constructor vacio, los bean (ejb) seran los que se encarguen de cambiarle los valores */
	public Centro() {

	}

//--------------------------------------------------------------------------------------------------------------------//

	/* Getters, Setters, equals, hashcode y toString. */

	public int getId() {
		return this.id;
	}

	public void setId(int ID) {
		this.id = ID;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String Direccion) {
		this.direccion = Direccion;
	}   
	public String getTLF_Conserjeria() {
		return this.tlf_conserjeria;
	}

	public void setTLF_Conserjeria(String TLF_Conserjeria) {
		this.tlf_conserjeria = TLF_Conserjeria;
	}


	
   
}
