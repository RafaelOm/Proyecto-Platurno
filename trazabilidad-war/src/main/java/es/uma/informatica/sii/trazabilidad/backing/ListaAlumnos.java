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
import es.uma.informatica.sii.ejb.practica.ejb.UsuarioEjbInterfaz;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Secretaria;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Usuario;

@Named(value = "alumnoBean")//alumno
@SessionScoped
public class ListaAlumnos implements Serializable{

	private static final long serialVersionUID = 1L;
	 private static final Logger LOGGER = Logger.getLogger(ListaAlumnos.class.getCanonicalName());

 @Inject
	private AutenticacionInterfaz negocio;	
 @Inject
 private UsuarioEjbInterfaz Alumno;//UsuarioEJB
	
	
private   List<Alumno> datos=new LinkedList<Alumno>();
private   List<Alumno> seleccionadas=new LinkedList<Alumno>();
private Alumno AlumnoSeleccionada;
private int test=0;
private Alumno alumnoItem;//nuevoalumno
private Alumno usuario;

  

public ListaAlumnos() {
	   	alumnoItem=new Alumno();
	   	usuario =new Alumno();
   }
   
   public List<Alumno> getRelleno(){
	   
		   /*for (int i = 3; i < 20; i++) {
			    Alumno dato = new Alumno();
			    dato.setValor(Integer.toString(i));;
			    dato.setNombre("nombre" + i);
			    dato.setTurno("Tarde");
			    dato.setGrupo("A,B");
			    datos.add(dato);
		   
			 }*/
		   datos=Alumno.getAll(); //
		   test=1;
	   
	   
	   
	   return datos;
	   
   }
   
   
   public Alumno getalumnoItem() {
	return alumnoItem;
}

public void setalumnoItem(Alumno alumnoItem) {
	this.alumnoItem = alumnoItem;
}

public List<Alumno> getSeleccionadas(){
	   return seleccionadas;
   }

   public List<Alumno> getDatos() {
      return datos;
   }
   public Alumno getUsuario() {
		return usuario;
	}

	public void setUsuario(Alumno usuario) {
		this.usuario = usuario;
	}
   public void setDatos(LinkedList<Alumno> datos) {
      this.datos = datos;
   }
   /*
   public String removeValor(Alumno valor) {
	      datos.remove(valor);
	      seleccionadas.add(valor);
	      return "vistaAlumno.xhtml?";
	   }
   public String devuelve(Alumno valor) {
	      datos.add(valor);
	      seleccionadas.remove(valor);
	      return "vistaAlumno.xhtml?";
	   }
   */

   public boolean selecionada(Alumno valor) {
	   if(seleccionadas.indexOf(valor)!=-1) {
		   return true;
	   }else {
		   return false;
	   }
	   
	   
   }

   public void crearAlumno(Secretaria user) {
	   
	   LOGGER.info("HOLA XD");
	   
		try {
			Alumno.crearUsuarioFromCsvExcel(alumnoItem);
		} catch (PlaturnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuentaExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //METODO
		
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Alumno CREADA");
		message.setDetail("TEST");
		FacesContext.getCurrentInstance().addMessage(null, message);
	
	   
	   
   }
   public void eliminaAlumno(Usuario u,Usuario Secretaria) { //Param
	   
	   LOGGER.info("HOLA XD");
	  
		try {
			Alumno.eliminarUsuario(u, Secretaria);
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
		} catch (ViolacionDeSeguridadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Metodo
		
		
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Alumno ELIMINADA");
		message.setDetail(u.getUsername()); //METODO
		FacesContext.getCurrentInstance().addMessage(null, message);
	
	   
	   
   }
   
 public void modificarAsig(Usuario user) {
	   
	   LOGGER.info("MODIFICAR Alumno PULSADO");
	   
		   LOGGER.info("------------"+alumnoItem.toString());
		try {
			Alumno.modificar(alumnoItem);
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
		} //METODO
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Alumno MODIFICADA");
		message.setDetail(alumnoItem.getNombre());
		FacesContext.getCurrentInstance().addMessage(null, message);
		
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		
		

	   
	   
   }

public Alumno getAlumnoSeleccionada() {
	return AlumnoSeleccionada;
}

public void setAlumnoSeleccionada(Alumno AlumnoSeleccionada) {
	this.AlumnoSeleccionada = AlumnoSeleccionada;
	
	LOGGER.info("Alumno SELECIONADA PARA EDITAR"+AlumnoSeleccionada.toString());
}
   
   
  
   
   
}