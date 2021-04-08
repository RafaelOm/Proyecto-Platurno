package es.uma.platurno;

import java.io.Serializable;
import java.lang.String;
import java.util.*;

import javax.persistence.*;


@Entity

public class Expediente implements Serializable {

	   
	@Id
	private String IdExpediente;
	private String Activo;
	private String NotaMPr;
	private Integer CreditosSup;
	private Integer CreditosFB;
	private Integer CreditosOP;
	private Integer CreditosOB;
	private Integer CreditosCF;
	private Integer CreditosPE;
	private Integer CreditosTF;
	@Column(nullable = false)
	private String N_Archivo;

	@ManyToOne
    private Titulacion titulacion;
	
	@ManyToOne
    private Alumno alumno;
	
	@OneToMany
	private List<Encuesta> encuestas;
	
	@OneToMany
	private List<Matricula> matriculas;
	
	private static final long serialVersionUID = 1L;

	public Expediente() {
		super();
	}   
	public String getId_Expediente() {
		return this.IdExpediente;
	}

	public void setId_Expediente(String s) {
		this.Activo = s;
	}   
	public String getActivo() {
		return this.Activo;
	}

	public void setActivo(String s) {
		this.Activo = s;
	}   
	
	public String getNotaMPr() {
		return this.NotaMPr;
	}

	public void setNotaMPr(String NotaMPr) {
		this.NotaMPr = NotaMPr;
	}   
	
	public Integer getCreditosSup() {
		return this.CreditosSup;
	}

	public void setCreditosSup(Integer CreditosSup) {
		this.CreditosSup = CreditosSup;
	}   
	
	public Integer getCreditosFB() {
		return this.CreditosFB;
	}

	public void setCreditosFB(Integer CreditosFB) {
		this.CreditosFB = CreditosFB;
	}   
	
	public Integer getCreditosOP() {
		return this.CreditosOP;
	}

	public void setCreditosOP(Integer CreditosOP) {
		this.CreditosOP = CreditosOP;
	}   
	
	public Integer getCreditosOB() {
		return this.CreditosOB;
	}

	public void setCreditosOB(Integer CreditosOB) {
		this.CreditosOB = CreditosOB;
	}   
	
	public Integer getCreditosCF() {
		return this.CreditosCF;
	}

	public void setCreditosCF(Integer CreditosCF) {
		this.CreditosCF = CreditosCF;
	}   
	
	public Integer getCreditosPE() {
		return this.CreditosPE;
	}

	public void setCreditosPE(Integer CreditosPE) {
		this.CreditosPE = CreditosPE;
	}   
	
	public Integer getCreditosTF() {
		return this.CreditosTF;
	}

	public void setCreditosTF(Integer CreditosTF) {
		this.CreditosTF = CreditosTF;
	}   
	public String getN_Archivo() {
		return this.N_Archivo;
	}

	public void setN_Archivo(String N_Archivo) {
		this.N_Archivo = N_Archivo;
	}   
	
	public Alumno getAlumno() {
		return this.alumno;
	}
	
	public void setAlumno(Alumno al) {
		this.alumno = al;
	}
	
	public Titulacion getTitulacion() {
		return this.titulacion;
	}
	
	public void setTitulacion(Titulacion t) {
		this.titulacion = t;
	}
	
	public List<Encuesta> getEncuestas() {
		return this.encuestas;
	}
	
	public void setEncuestas(List<Encuesta> t) {
		this.encuestas = t;
	}
	
	public List<Matricula> getMatriculas() {
		return this.matriculas;
	}
	
	public void setMatriculas(List<Matricula> t) {
		this.matriculas = t;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Activo == null) ? 0 : Activo.hashCode());
		result = prime * result + ((CreditosCF == null) ? 0 : CreditosCF.hashCode());
		result = prime * result + ((CreditosFB == null) ? 0 : CreditosFB.hashCode());
		result = prime * result + ((CreditosOB == null) ? 0 : CreditosOB.hashCode());
		result = prime * result + ((CreditosOP == null) ? 0 : CreditosOP.hashCode());
		result = prime * result + ((CreditosPE == null) ? 0 : CreditosPE.hashCode());
		result = prime * result + ((CreditosSup == null) ? 0 : CreditosSup.hashCode());
		result = prime * result + ((CreditosTF == null) ? 0 : CreditosTF.hashCode());
		result = prime * result + ((IdExpediente == null) ? 0 : IdExpediente.hashCode());
		result = prime * result + ((N_Archivo == null) ? 0 : N_Archivo.hashCode());
		result = prime * result + ((NotaMPr == null) ? 0 : NotaMPr.hashCode());
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((encuestas == null) ? 0 : encuestas.hashCode());
		result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
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
		Expediente other = (Expediente) obj;
		if (Activo == null) {
			if (other.Activo != null)
				return false;
		} else if (!Activo.equals(other.Activo))
			return false;
		if (CreditosCF == null) {
			if (other.CreditosCF != null)
				return false;
		} else if (!CreditosCF.equals(other.CreditosCF))
			return false;
		if (CreditosFB == null) {
			if (other.CreditosFB != null)
				return false;
		} else if (!CreditosFB.equals(other.CreditosFB))
			return false;
		if (CreditosOB == null) {
			if (other.CreditosOB != null)
				return false;
		} else if (!CreditosOB.equals(other.CreditosOB))
			return false;
		if (CreditosOP == null) {
			if (other.CreditosOP != null)
				return false;
		} else if (!CreditosOP.equals(other.CreditosOP))
			return false;
		if (CreditosPE == null) {
			if (other.CreditosPE != null)
				return false;
		} else if (!CreditosPE.equals(other.CreditosPE))
			return false;
		if (CreditosSup == null) {
			if (other.CreditosSup != null)
				return false;
		} else if (!CreditosSup.equals(other.CreditosSup))
			return false;
		if (CreditosTF == null) {
			if (other.CreditosTF != null)
				return false;
		} else if (!CreditosTF.equals(other.CreditosTF))
			return false;
		if (IdExpediente == null) {
			if (other.IdExpediente != null)
				return false;
		} else if (!IdExpediente.equals(other.IdExpediente))
			return false;
		if (N_Archivo == null) {
			if (other.N_Archivo != null)
				return false;
		} else if (!N_Archivo.equals(other.N_Archivo))
			return false;
		if (NotaMPr == null) {
			if (other.NotaMPr != null)
				return false;
		} else if (!NotaMPr.equals(other.NotaMPr))
			return false;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (encuestas == null) {
			if (other.encuestas != null)
				return false;
		} else if (!encuestas.equals(other.encuestas))
			return false;
		if (matriculas == null) {
			if (other.matriculas != null)
				return false;
		} else if (!matriculas.equals(other.matriculas))
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
		return "Expediente [IdExpediente=" + IdExpediente + ", Activo=" + Activo + ", NotaMPr=" + NotaMPr
				+ ", CreditosSup=" + CreditosSup + ", CreditosFB=" + CreditosFB + ", CreditosOP=" + CreditosOP
				+ ", CreditosOB=" + CreditosOB + ", CreditosCF=" + CreditosCF + ", CreditosPE=" + CreditosPE
				+ ", CreditosTF=" + CreditosTF + ", N_Archivo=" + N_Archivo + ", titulacion=" + titulacion + ", alumno="
				+ alumno + ", encuestas=" + encuestas + ", matriculas=" + matriculas + "]";
	}
	
   
}
