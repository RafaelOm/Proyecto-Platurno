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

import es.uma.informatica.sii.ejb.practica.ejb.AsignaturasEjb;
import es.uma.informatica.sii.ejb.practica.ejb.AsignaturasEjbInterfaz;
import es.uma.informatica.sii.ejb.practica.ejb.AutenticacionInterfaz;
import es.uma.informatica.sii.ejb.practica.ejb.GruposEjbInterface;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.AsignaturaInexsistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.GrupoInexistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ViolacionDeSeguridadException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.Usuario;

@Named(value = "grupoBean")
@SessionScoped
public class ListaGrupos implements Serializable{

	private static final long serialVersionUID = 1L;
	 private static final Logger LOGGER = Logger.getLogger(ListaAsignaturas.class.getCanonicalName());

 @Inject
	private AutenticacionInterfaz negocio;	
 @Inject
 private GruposEjbInterface grupo;
	
	
private   List<Grupo> datos=new LinkedList<Grupo>();
private   List<Grupo> seleccionadas=new LinkedList<Grupo>();
private int test=0;
private Grupo nuevogrupo;

private Alumno usuario;

  

public ListaGrupos() {
		nuevogrupo=new Grupo();
	   	usuario =new Alumno();
   }
   
   public List<Grupo> getRelleno(){
	   
		   /*for (int i = 3; i < 20; i++) {
			    Asignatura dato = new Asignatura();
			    dato.setValor(Integer.toString(i));;
			    dato.setNombre("nombre" + i);
			    dato.setTurno("Tarde");
			    dato.setGrupo("A,B");
			    datos.add(dato);
		   
			 }*/
		   datos=grupo.getAll();
		   test=1;
	   
	   
	   
	   return datos;
	   
   }
   
   public Grupo getNuevogrupo() {
		return nuevogrupo;
	}

	public void setNuevogrupo(Grupo nuevogrupo) {
		this.nuevogrupo = nuevogrupo;
	}
 
public List<Grupo> getSeleccionadas(){
	   return seleccionadas;
   }

   public List<Grupo> getDatos() {
      return datos;
   }
   public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Alumno usuario) {
		this.usuario = usuario;
	}
   public void setDatos(LinkedList<Grupo> datos) {
      this.datos = datos;
   }
   public String removeValor(Grupo valor) {
	      datos.remove(valor);
	      seleccionadas.add(valor);
	      return "vistaAlumno.xhtml?";
	   }
   public String devuelve(Grupo valor) {
	      datos.add(valor);
	      seleccionadas.remove(valor);
	      return "vistaAlumno.xhtml?";
	   }
   
   public boolean selecionada(Grupo valor) {
	   if(seleccionadas.indexOf(valor)!=-1) {
		   return true;
	   }else {
		   return false;
	   }
	   
	   
   }
   public void crearGrupo(Usuario user) {
	   try {
		grupo.crearGrupo(nuevogrupo,user);
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("ASIGNATURA CREADA");
		message.setDetail("TEST");
		FacesContext.getCurrentInstance().addMessage(null, message);
	} catch (GrupoInexistenteException e) {
		e.printStackTrace();
	}
	   
	   
   }
   public void eliminarGrupo(Usuario user,Grupo valor) {
	   
	   LOGGER.info("HOLA XD");
	   try {
		grupo.eliminarGrupo(user, valor);
		
		
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("GRUPO ELIMINADO");
		message.setDetail(valor.getTitulo().getNombre());
		FacesContext.getCurrentInstance().addMessage(null, message);
	} catch (GrupoInexistenteException e) {
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
	}
	   
	   
   }
  
   
   
}