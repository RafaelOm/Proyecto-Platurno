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
import es.uma.informatica.sii.ejb.practica.ejb.ExpedienteInterfaz;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ExpedienteNoExisteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Usuario;

@Named(value = "expedienteBean")//Expediente
@SessionScoped
public class ListaExpedientes implements Serializable{

	private static final long serialVersionUID = 1L;
	 private static final Logger LOGGER = Logger.getLogger(ListaExpedientes.class.getCanonicalName());

 @Inject
	private AutenticacionInterfaz negocio;	
 @Inject
 private ExpedienteInterfaz ItemEJB;//UsuarioEJB
	
	
private   List<Expediente> datos=new LinkedList<Expediente>();
private   List<Expediente> seleccionadas=new LinkedList<Expediente>();
private Expediente ExpedienteSeleccionada;
private int test=0;
private Expediente ExpedienteItem;//nuevoExpediente
private Expediente usuario;

  

public ListaExpedientes() {
	   	ExpedienteItem=new Expediente();
	   	usuario =new Expediente();
   }
   
   public List<Expediente> getRelleno(){
	   
		   /*for (int i = 3; i < 20; i++) {
			    Expediente dato = new Expediente();
			    dato.setValor(Integer.toString(i));;
			    dato.setNombre("nombre" + i);
			    dato.setTurno("Tarde");
			    dato.setGrupo("A,B");
			    datos.add(dato);
		   
			 }*/
		   datos=ItemEJB.getAll(); //
		   test=1;
	   
	   
	   
	   return datos;
	   
   }
   
   
   public Expediente getExpedienteItem() {
	return ExpedienteItem;
}

public void setExpedienteItem(Expediente ExpedienteItem) {
	this.ExpedienteItem = ExpedienteItem;
}

public List<Expediente> getSeleccionadas(){
	   return seleccionadas;
   }

   public List<Expediente> getDatos() {
      return datos;
   }
   public Expediente getUsuario() {
		return usuario;
	}

	public void setUsuario(Expediente usuario) {
		this.usuario = usuario;
	}
   public void setDatos(LinkedList<Expediente> datos) {
      this.datos = datos;
   }
   /*
   public String removeValor(Expediente valor) {
	      datos.remove(valor);
	      seleccionadas.add(valor);
	      return "vistaExpediente.xhtml?";
	   }
   public String devuelve(Expediente valor) {
	      datos.add(valor);
	      seleccionadas.remove(valor);
	      return "vistaExpediente.xhtml?";
	   }
   */

   public boolean selecionada(Expediente valor) {
	   if(seleccionadas.indexOf(valor)!=-1) {
		   return true;
	   }else {
		   return false;
	   }
	   
	   
   }

   public void crearExpediente(Usuario user) {
	   
	   LOGGER.info("HOLA XD");
	  
		try {
			ItemEJB.crearExpediente(ExpedienteItem,user);
		} catch (ExpedienteNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		} //METODO
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Expediente CREADA");
		message.setDetail("TEST");
		FacesContext.getCurrentInstance().addMessage(null, message);

	   
	   
   }
   public void eliminaExpediente(Expediente expediente_parametro, Usuario user) { //Param
	   
	   LOGGER.info("HOLA XD");
	  
		try {
			ItemEJB.DeleteExpediente(user,expediente_parametro.getExpediente());
		} catch (ExpedienteNoExisteException e) {
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
		} //Metodo add user
		
		
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Expediente ELIMINADA");
		message.setDetail(expediente_parametro.getExpediente()); //METODO
		FacesContext.getCurrentInstance().addMessage(null, message);

	   
	   
   }
   
 public void modificarExpediente(Usuario user) {
	   
	   LOGGER.info("MODIFICAR Expediente PULSADO");
	   
		   LOGGER.info("------------"+ExpedienteItem.toString());
      
			try {
				ItemEJB.UpdateExpediente(ExpedienteItem.getExpediente(), ExpedienteItem.getActivo(), ExpedienteItem.getNotampr(), ExpedienteItem.getCreditosSup(), ExpedienteItem.getCreditosFB(), ExpedienteItem.getCreditosOP(), ExpedienteItem.getCreditosOB(), ExpedienteItem.getCreditosCF(), ExpedienteItem.getCreditosPE(), ExpedienteItem.getCreditosTF(), ExpedienteItem.getN_archivo());
			} catch (ExpedienteNoExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Expediente MODIFICADA");
		message.setDetail(ExpedienteItem.getExpediente());
		FacesContext.getCurrentInstance().addMessage(null, message);
		
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		
		

	   
	   
   }

public Expediente getExpedienteSeleccionada() {
	return ExpedienteSeleccionada;
}

public void setExpedienteSeleccionada(Expediente ExpedienteSeleccionada) {
	this.ExpedienteSeleccionada = ExpedienteSeleccionada;
	
	LOGGER.info("Expediente SELECIONADA PARA EDITAR"+ExpedienteSeleccionada.toString());
}
   
   
  
   
   
}

