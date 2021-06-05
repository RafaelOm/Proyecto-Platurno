package es.uma.informatica.sii.trazabilidad.backing;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;


import es.uma.informatica.sii.ejb.practica.ejb.AutenticacionInterfaz;
import es.uma.informatica.sii.ejb.practica.ejb.EncuestaInterfaceEJB;
import es.uma.informatica.sii.ejb.practica.ejb.GR_ASIGEJBInterfaz;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.GR_ASIG_GrupoNoExisteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.GR_ASIG;
import es.uma.informatica.sii.ejb.practica.entidades.GR_ASIG;
import es.uma.informatica.sii.ejb.practica.entidades.Usuario;

@Named(value = "gr_asigBean")//GR_ASIG
@SessionScoped
public class ListaGR_ASIG implements Serializable{

	private static final long serialVersionUID = 1L;
	 private static final Logger LOGGER = Logger.getLogger(ListaGR_ASIG.class.getCanonicalName());

 @Inject
	private AutenticacionInterfaz negocio;	
 @Inject
 private GR_ASIGEJBInterfaz ItemEJB;//UsuarioEJB
 
 @Inject
 private EncuestaInterfaceEJB encuestaEJB;
	
	
private   List<GR_ASIG> datos=new LinkedList<GR_ASIG>();
private   List<GR_ASIG> seleccionadas=new LinkedList<GR_ASIG>();
private GR_ASIG GR_ASIGSeleccionada;
private int cont=0;
private GR_ASIG gr_ASIG_ITEM;//nuevoGR_ASIG
private GR_ASIG usuario;

  

public ListaGR_ASIG() {
	   	gr_ASIG_ITEM=new GR_ASIG();
	   	usuario =new GR_ASIG();
   }
   
   public List<GR_ASIG> getRelleno(){
	   
	   
		   datos=ItemEJB.getAll(); //
		   cont=1;
	   
	   
	   
	   return datos;
	   
   }
   
   
   public GR_ASIG getgr_ASIG_ITEM() {
	return gr_ASIG_ITEM;
}

public void setgr_ASIG_ITEM(GR_ASIG gr_ASIG_ITEM) {
	this.gr_ASIG_ITEM = gr_ASIG_ITEM;
}

public List<GR_ASIG> getSeleccionadas(){
	   return seleccionadas;
   }

   public List<GR_ASIG> getDatos() {
      return datos;
   }
   public GR_ASIG getUsuario() {
		return usuario;
	}

	public void setUsuario(GR_ASIG usuario) {
		this.usuario = usuario;
	}
   public void setDatos(LinkedList<GR_ASIG> datos) {
      this.datos = datos;
   }
   
   public String removeValor(GR_ASIG valor) {
	      datos.remove(valor);
	      seleccionadas.add(valor);
	      return "vistaAlumno.xhtml?";
	   }
   public String devuelve(GR_ASIG valor) {
	      datos.add(valor);
	      seleccionadas.remove(valor);
	      return "vistaAlumno.xhtml?";
	   }

   
   
   public boolean selecionada(GR_ASIG valor) {
	   if(seleccionadas.indexOf(valor)!=-1) {
		   return true;
	   }else {
		   return false;
	   }
	   
	   
   }


   public void eliminaGR_ASIG(GR_ASIG GR_ASIG_parametro,Usuario user) { //Param
	   
	   LOGGER.info("HOLA XD");
	  
		try {
			ItemEJB.DeleteGR_ASIG(user,GR_ASIG_parametro);
		} catch (GR_ASIG_GrupoNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PasswordErroneaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuentaInactivaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuentaInexistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlaturnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Metodo
		
		
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("GR_ASIG ELIMINADA");
		message.setDetail(user.getUsername()); //METODO
		FacesContext.getCurrentInstance().addMessage(null, message);

	   
	   
   }


public GR_ASIG getGR_ASIGSeleccionada() {
	return GR_ASIGSeleccionada;
}

public void setGR_ASIGSeleccionada(GR_ASIG GR_ASIGSeleccionada) {
	this.GR_ASIGSeleccionada = GR_ASIGSeleccionada;
	
	LOGGER.info("GR_ASIG SELECIONADA PARA EDITAR"+GR_ASIGSeleccionada.toString());
}

public void enviar(Usuario user) {
	Alumno a=(Alumno)user;
	Expediente exp=a.getExpedientes().get(0);
	
	Encuesta enc= new Encuesta();
	enc.setExpediente(exp);
	enc.setGrAsig(seleccionadas);
	enc.setFecha_de_Envio(new java.sql.Date(System.currentTimeMillis()));
	
	LOGGER.info("-----------------ENCUESTA RELLENA: "+enc.toString());
	
	try {
		encuestaEJB.crearEncuesta(enc, user);
	} catch (PlaturnoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (CuentaInactivaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (CuentaInexistenceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (PasswordErroneaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
   
}
   
  
   
 

