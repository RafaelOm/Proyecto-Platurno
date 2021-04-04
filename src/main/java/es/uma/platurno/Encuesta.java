package es.uma.platurno;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity

public class Encuesta implements Serializable {

	   
	@Id
	private Date Fecha_de_Envio;
	private static final long serialVersionUID = 1L;

	public Encuesta() {
		super();
	}   
	public Date getFecha_de_Envio() {
		return this.Fecha_de_Envio;
	}

	public void setFecha_de_Envio(Date Fecha_de_Envio) {
		this.Fecha_de_Envio = Fecha_de_Envio;
	}
   
}
