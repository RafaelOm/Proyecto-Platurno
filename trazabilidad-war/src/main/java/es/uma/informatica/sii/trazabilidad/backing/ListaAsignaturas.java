package es.uma.informatica.sii.trazabilidad.backing;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.ejb.practica.ejb.AsignaturasEjbInterfaz;
import es.uma.informatica.sii.ejb.practica.ejb.AutenticacionInterfaz;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;

@Named(value = "asignaturaBean")
@SessionScoped
public class ListaAsignaturas implements Serializable{

	private static final long serialVersionUID = 1L;

 @Inject
	private AutenticacionInterfaz negocio;	
 @Inject
 private AsignaturasEjbInterfaz asignatura;
	
	
private   List<Asignatura> datos=new LinkedList<Asignatura>();
private   List<Asignatura> seleccionadas=new LinkedList<Asignatura>();
private int test=0;

   public ListaAsignaturas() {

   }
   
   public List<Asignatura> getRelleno(){
	   if(test==0) {
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
	   }
	   
	   
	   return datos;
	   
   }
   public List<Asignatura> getSeleccionadas(){
	   return seleccionadas;
   }

   public List<Asignatura> getDatos() {
      return datos;
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
}