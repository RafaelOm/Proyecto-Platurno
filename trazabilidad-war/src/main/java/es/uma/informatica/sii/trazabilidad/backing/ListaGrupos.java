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
import es.uma.informatica.sii.ejb.practica.ejb.GruposEjb;

import es.uma.informatica.sii.ejb.practica.ejb.GruposEjbInterface;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.GrupoInexistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.Usuario;

@Named(value = "grupoBean")//Grupo
@SessionScoped
public class ListaGrupos implements Serializable{

	private static final long serialVersionUID = 1L;
	 private static final Logger LOGGER = Logger.getLogger(ListaGrupos.class.getCanonicalName());

 @Inject
	private AutenticacionInterfaz negocio;	
 @Inject
 private GruposEjbInterface ItemEJB;//UsuarioEJB
	
	
private   List<Grupo> datos=new LinkedList<Grupo>();
private   List<Grupo> seleccionadas=new LinkedList<Grupo>();
private Grupo GrupoSeleccionada;
private int test=0;
private Grupo GrupoItem;//nuevoGrupo
private Grupo usuario;

  

public ListaGrupos() {
	   	GrupoItem=new Grupo();
	   	usuario =new Grupo();
   }
   
   public List<Grupo> getRelleno(){
	   
		   /*for (int i = 3; i < 20; i++) {
			    Grupo dato = new Grupo();
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
   
   
   public Grupo getGrupoItem() {
	return GrupoItem;
}

public void setGrupoItem(Grupo GrupoItem) {
	this.GrupoItem = GrupoItem;
}

public List<Grupo> getSeleccionadas(){
	   return seleccionadas;
   }

   public List<Grupo> getDatos() {
      return datos;
   }
   public Grupo getUsuario() {
		return usuario;
	}

	public void setUsuario(Grupo usuario) {
		this.usuario = usuario;
	}
   public void setDatos(LinkedList<Grupo> datos) {
      this.datos = datos;
   }
   /*
   public String removeValor(Grupo valor) {
	      datos.remove(valor);
	      seleccionadas.add(valor);
	      return "vistaGrupo.xhtml?";
	   }
   public String devuelve(Grupo valor) {
	      datos.add(valor);
	      seleccionadas.remove(valor);
	      return "vistaGrupo.xhtml?";
	   }
   */

   public boolean selecionada(Grupo valor) {
	   if(seleccionadas.indexOf(valor)!=-1) {
		   return true;
	   }else {
		   return false;
	   }
	   
	   
   }

   public void crearGrupo(Usuario user) {
	   
	   LOGGER.info("HOLA XD");
	   
		try {
			ItemEJB.crearGrupo(GrupoItem,user);
		} catch (GrupoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //METODO
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Grupo CREADA");
		message.setDetail("TEST");
		FacesContext.getCurrentInstance().addMessage(null, message);

	   
	   
   }
   public void eliminaGrupo(Grupo Grupo_parametro, Usuario Secretaria) { //Param
	   
	   LOGGER.info("HOLA XD");
	  
		try {
			ItemEJB.eliminarGrupo(Secretaria,Grupo_parametro);
		} catch (GrupoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ViolacionDeSeguridadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuentaInexistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuentaInactivaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlaturnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PasswordErroneaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Metodo
		
		
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Grupo ELIMINADA");
		message.setDetail(Secretaria.getUsername()); //METODO
		FacesContext.getCurrentInstance().addMessage(null, message);
	
	   
	   
   }
   
 public void modificarGrupo(Usuario user) {
	   
	   LOGGER.info("MODIFICAR Grupo PULSADO");
	  
		   LOGGER.info("------------"+GrupoItem.toString());
		try {
			ItemEJB.modificarGrupo(user,GrupoItem);
		} catch (GrupoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PasswordErroneaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuentaInexistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuentaInactivaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlaturnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ViolacionDeSeguridadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //METODO
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Grupo MODIFICADA");
		message.setDetail(user.getUsername());
		FacesContext.getCurrentInstance().addMessage(null, message);
		
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		
		

	   
	   
   }

public Grupo getGrupoSeleccionada() {
	return GrupoSeleccionada;
}

public void setGrupoSeleccionada(Grupo GrupoSeleccionada) {
	this.GrupoSeleccionada = GrupoSeleccionada;
	
	LOGGER.info("Grupo SELECIONADA PARA EDITAR"+GrupoSeleccionada.toString());
}
   
   
  
   
   
}


