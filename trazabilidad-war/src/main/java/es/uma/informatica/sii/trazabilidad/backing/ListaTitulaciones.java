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
import es.uma.informatica.sii.ejb.practica.ejb.TitulacionesEjbInterface;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.TitulacionInexistente;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;
import es.uma.informatica.sii.ejb.practica.entidades.Usuario;

@Named(value = "titulacionBean")//Titulacion
@SessionScoped
public class ListaTitulaciones implements Serializable{

	private static final long serialVersionUID = 1L;
	 private static final Logger LOGGER = Logger.getLogger(ListaTitulaciones.class.getCanonicalName());

 @Inject
	private AutenticacionInterfaz negocio;	
 
 @Inject
 private TitulacionesEjbInterface ItemEJB;//UsuarioEJB
	
	
private   List<Titulacion> datos=new LinkedList<Titulacion>();
private   List<Titulacion> seleccionadas=new LinkedList<Titulacion>();
private Titulacion titulacionSeleccionada;
private int test=0;
private Titulacion titulacionItem;//nuevoTitulacion
private Titulacion usuario;

  

public ListaTitulaciones() {
	   	titulacionItem=new Titulacion();
	   	usuario =new Titulacion();
   }
   
   public List<Titulacion> getRelleno(){
	   
		   /*for (int i = 3; i < 20; i++) {
			    Titulacion dato = new Titulacion();
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
   
   
   public Titulacion gettitulacionItem() {
	return titulacionItem;
}

public void settitulacionItem(Titulacion titulacionItem) {
	this.titulacionItem = titulacionItem;
}

public List<Titulacion> getSeleccionadas(){
	   return seleccionadas;
   }

   public List<Titulacion> getDatos() {
      return datos;
   }
   public Titulacion getUsuario() {
		return usuario;
	}

	public void setUsuario(Titulacion usuario) {
		this.usuario = usuario;
	}
   public void setDatos(LinkedList<Titulacion> datos) {
      this.datos = datos;
   }
   /*
   public String removeValor(Titulacion valor) {
	      datos.remove(valor);
	      seleccionadas.add(valor);
	      return "vistaTitulacion.xhtml?";
	   }
   public String devuelve(Titulacion valor) {
	      datos.add(valor);
	      seleccionadas.remove(valor);
	      return "vistaTitulacion.xhtml?";
	   }
   */

   public boolean selecionada(Titulacion valor) {
	   if(seleccionadas.indexOf(valor)!=-1) {
		   return true;
	   }else {
		   return false;
	   }
	   
	   
   }

   public void crearTitulacion(Usuario user) {
	   
	   LOGGER.info("HOLA XD");
	  
		try {
			ItemEJB.crearTitulacion(titulacionItem,user);
		} catch (TitulacionInexistente e) {
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
   public void eliminaTitulacion(Titulacion titulacion_parametro,Usuario user) { //Param
	   
	   LOGGER.info("HOLA XD");
	   
		try {
			ItemEJB.eliminarTitulacion(user,titulacion_parametro.getCodigo());
		} catch (TitulacionInexistente e) {
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
		} //Metodo
		
		
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Titulacion ELIMINADA");
		
		FacesContext.getCurrentInstance().addMessage(null, message);

	   
	   
   }
   
 public void modificarTitulacion(Usuario user) {
	   
	   LOGGER.info("MODIFICAR Titulacion PULSADO");
	
		   LOGGER.info("------------"+titulacionItem.toString());
		try {
			ItemEJB.modificarTitulacion(user,titulacionItem.getCodigo(),titulacionItem.getNombre(),titulacionItem.getCreditos());
		} catch (TitulacionInexistente e) {
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
		message.setSummary("Titulacion MODIFICADA");
		message.setDetail(titulacionItem.getNombre());
		FacesContext.getCurrentInstance().addMessage(null, message);
		
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		
		

	   
	   
   }

public Titulacion gettitulacionSeleccionada() {
	return titulacionSeleccionada;
}

public void settitulacionSeleccionada(Titulacion titulacionSeleccionada) {
	this.titulacionSeleccionada = titulacionSeleccionada;
	
	LOGGER.info("Titulacion SELECIONADA PARA EDITAR"+titulacionSeleccionada.toString());
}
   
   
  
   
   
}