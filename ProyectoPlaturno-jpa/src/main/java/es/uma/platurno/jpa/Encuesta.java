package es.uma.platurno.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity

public class Encuesta implements Serializable {




	@Id
	private String id_Encuesta;
	@Column (nullable = false)
	private Date Fecha_de_Envio;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Expediente expediente;

	public void setId_Encuesta(String id_Encuesta) {
		this.id_Encuesta = id_Encuesta;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public void setGrupos(List<GR_ASIG> grupos) {
		this.grupos = grupos;
	}

	@ManyToMany
	@JoinTable(
            name = "EncuestaGrAsignaturas",
            joinColumns = @JoinColumn(
                    name = "CursoAc",
                    referencedColumnName = "CursoAc"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "Fecha_de_Envio",
                    referencedColumnName = "Fecha_de_Envio"
            )
    )
    private List<GR_ASIG> grupos;

	public List<GR_ASIG> getGrupos() {
		return grupos;
	}

	public Encuesta() {
		super();
	}   
	public Date getFecha_de_Envio() {
		return this.Fecha_de_Envio;
	}

	public void setFecha_de_Envio(Date Fecha_de_Envio) {
		this.Fecha_de_Envio = Fecha_de_Envio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Fecha_de_Envio == null) ? 0 : Fecha_de_Envio.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		return result;
	}
	public String getId_Encuesta() {
		return id_Encuesta;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Encuesta other = (Encuesta) obj;
		if (Fecha_de_Envio == null) {
			if (other.Fecha_de_Envio != null)
				return false;
		} else if (!Fecha_de_Envio.equals(other.Fecha_de_Envio))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Encuesta [Fecha_de_Envio=" + Fecha_de_Envio + ", expediente=" + expediente + ", grupos=" + grupos + "]";
	}
	
   
}
