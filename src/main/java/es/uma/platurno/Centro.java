package es.uma.platurno;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Centro
 *
 */
@Entity

public class Centro implements Serializable {

	   
	@Id
	private String ID;
	private String Nombre;
	private String Direccion;
	private String TLF_Conserjeria;
	private static final long serialVersionUID = 1L;

	public Centro() {
		super();
	}   
	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}   
	public String getTLF_Conserjeria() {
		return this.TLF_Conserjeria;
	}

	public void setTLF_Conserjeria(String TLF_Conserjeria) {
		this.TLF_Conserjeria = TLF_Conserjeria;
	}
   
}
