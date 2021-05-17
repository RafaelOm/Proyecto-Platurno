package es.uma.informatica.sii.trazabilidad.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.ejb.practica.ejb.Autenticacion;

@Named
@RequestScoped
public class Saludo {
	
	//@Inject
	//Autenticacion auth;
	
	public String getSaludo() {
		return "Bienvenidos a la pagina de prueba";
	}

}
