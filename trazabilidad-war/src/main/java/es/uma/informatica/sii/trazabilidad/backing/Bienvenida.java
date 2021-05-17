package es.uma.informatica.sii.trazabilidad.backing;

import javax.inject.Named;

@Named
@RequestScoped
public class Bienvenida {
	
	public String getSaludo() {
		return "Bienvenidos a la pagina de prueba";
	}

}
