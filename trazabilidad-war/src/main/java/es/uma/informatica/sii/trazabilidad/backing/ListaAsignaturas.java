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
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.AsignaturaInexsistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Usuario;

@Named(value = "asignaturaBean")
@SessionScoped
public class ListaAsignaturas implements Serializable{

	private static final long serialVersionUID = 1L;
	 private static final Logger LOGGER = Logger.getLogger(ListaAsignaturas.class.getCanonicalName());

 @Inject
	private AutenticacionInterfaz negocio;	
 @Inject
 private AsignaturasEjbInterfaz asignatura;
	
	
private   List<Asignatura> datos=new LinkedList<Asignatura>();
private   List<Asignatura> seleccionadas=new LinkedList<Asignatura>();
private int test=0;
private Asignatura nuevaasig;
private Alumno usuario;

  

public ListaAsignaturas() {
	   	nuevaasig=new Asignatura();
	   	usuario =new Alumno();
   }
   
   public List<Asignatura> getRelleno(){
	   
		   /*for (int i = 3; i < 20; i++) {
			    Asignatura dato = new Asignatura();
			    dato.setValor(Integer.toString(i));;
			    dato.setNombre("nombre" + i);
			    dato.setTurno("Tarde");
			    dato.setGrupo("A,B");
			    datos.add(dato);
		   
			 }*/
		   datos=asignatura.getAll();
		   test=1;
	   
	   
	   
	   return datos;
	   
   }
   
   
   public Asignatura getNuevaasig() {
	return nuevaasig;
}

public void setNuevaasig(Asignatura nuevaasig) {
	this.nuevaasig = nuevaasig;
}

public List<Asignatura> getSeleccionadas(){
	   return seleccionadas;
   }

   public List<Asignatura> getDatos() {
      return datos;
   }
   public Alumno getUsuario() {
		return usuario;
	}

	public void setUsuario(Alumno usuario) {
		this.usuario = usuario;
	}
   public void setDatos(LinkedList<Asignatura> datos) {
      this.datos = datos;
   }
   public String removeValor(Asignatura valor) {
	      datos.remove(valor);
	      seleccionadas.add(valor);
	      return "vistaAlumno.xhtml?";
	   }
   public String devuelve(Asignatura valor) {
	      datos.add(valor);
	      seleccionadas.remove(valor);
	      return "vistaAlumno.xhtml?";
	   }
   
   public boolean selecionada(Asignatura valor) {
	   if(seleccionadas.indexOf(valor)!=-1) {
		   return true;
	   }else {
		   return false;
	   }
	   
	   
   }
   public void crearAsignatura(Usuario user) {
	   
	   LOGGER.info("HOLA XD");
	   try {
		asignatura.crearAsignatura(nuevaasig,user);
	} catch (AsignaturaInexsistenteException e) {
		e.printStackTrace();
	}
	   
	   
   }
  
   
   
}