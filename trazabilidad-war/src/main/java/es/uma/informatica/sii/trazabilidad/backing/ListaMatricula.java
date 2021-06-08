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
import es.uma.informatica.sii.ejb.practica.ejb.MatriculaInterfaz;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ExpedienteNoExisteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.MatriculaNoExiteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.eliminarMatriculaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.modificarMatriculaException;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Usuario;

@Named(value = "matriculaBean")//Matricula
@SessionScoped
public class ListaMatricula implements Serializable{

	private static final long serialVersionUID = 1L;
	 private static final Logger LOGGER = Logger.getLogger(ListaMatricula.class.getCanonicalName());

 @Inject
	private AutenticacionInterfaz negocio;	
 @Inject
 private MatriculaInterfaz ItemEJB;//UsuarioEJB
 @Inject
 private ExpedienteInterfaz expedienteEJB;//UsuarioEJB
	
	
private   List<Matricula> datos=new LinkedList<Matricula>();
private   List<Matricula> seleccionadas=new LinkedList<Matricula>();
private Matricula matriculaSeleccionada;
private int test=0;
private Matricula matriculaItem;//nuevoMatricula
private Matricula usuario;
private String expediente;

  


public ListaMatricula() {
	   	matriculaItem=new Matricula();
	   	usuario =new Matricula();
   }
   
   public List<Matricula> getRelleno(){
	   
		   /*for (int i = 3; i < 20; i++) {
			    Matricula dato = new Matricula();
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
   
   
   public Matricula getmatriculaItem() {
	return matriculaItem;
}

public void setmatriculaItem(Matricula matriculaItem) {
	this.matriculaItem = matriculaItem;
}

public List<Matricula> getSeleccionadas(){
	   return seleccionadas;
   }

   public List<Matricula> getDatos() {
      return datos;
   }
   public Matricula getUsuario() {
		return usuario;
	}

	public void setUsuario(Matricula usuario) {
		this.usuario = usuario;
	}
   public void setDatos(LinkedList<Matricula> datos) {
      this.datos = datos;
   }
   /*
   public String removeValor(Matricula valor) {
	      datos.remove(valor);
	      seleccionadas.add(valor);
	      return "vistaMatricula.xhtml?";
	   }
   public String devuelve(Matricula valor) {
	      datos.add(valor);
	      seleccionadas.remove(valor);
	      return "vistaMatricula.xhtml?";
	   }
   */

   public boolean selecionada(Matricula valor) {
	   if(seleccionadas.indexOf(valor)!=-1) {
		   return true;
	   }else {
		   return false;
	   }
	   
	   
   }

   public void crearMatricula(Usuario user) {
	   
	   LOGGER.info("HOLA XD");
	 
		try {
			Expediente aux =expedienteEJB.ReadExpediente(expediente);
			matriculaItem.setIdExpediente(aux);
			ItemEJB.crearMatricula(matriculaItem,user);
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
		} catch (MatriculaNoExiteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //METODO
 catch (ExpedienteNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Matricula CREADA");
		message.setDetail("TEST");
		FacesContext.getCurrentInstance().addMessage(null, message);
	
	   
	   
   }
   public void eliminaMatricula(Matricula matricula_parametro, Usuario Secretaria) { //Param
	   
	   LOGGER.info("HOLA XD");
	  
		try {
			ItemEJB.eliminar(Secretaria,matricula_parametro);
		} catch (eliminarMatriculaException e) {
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
		message.setSummary("Matricula ELIMINADA");
		
		FacesContext.getCurrentInstance().addMessage(null, message);

	   
	   
   }
   
 public void modificarMatricula(Usuario user) {
	   
	   LOGGER.info("MODIFICAR Matricula PULSADO");
	  
		   LOGGER.info("------------"+matriculaItem.toString());
		try {
			ItemEJB.modificar(user,matriculaItem);
		} catch (modificarMatriculaException e) {
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
		} //METODO
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Matricula MODIFICADA");
		message.setDetail(user.getUsername());
		FacesContext.getCurrentInstance().addMessage(null, message);
		
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		

	   
   }

public Matricula getmatriculaSeleccionada() {
	return matriculaSeleccionada;
}

public void setmatriculaSeleccionada(Matricula matriculaSeleccionada) {
	this.matriculaSeleccionada = matriculaSeleccionada;
	
	LOGGER.info("Matricula SELECIONADA PARA EDITAR"+matriculaSeleccionada.toString());
}
public String getExpediente() {
	return expediente;
}

public void setExpediente(String expediente) {
	this.expediente = expediente;
}



   
   
  
   
   
}


