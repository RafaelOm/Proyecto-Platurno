/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.trazabilidad.backing;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriBuilder;



import es.uma.informatica.sii.ejb.practica.ejb.AutenticacionInterfaz;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaYaValidadaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ValidacionIncorrectaException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;


/**
 *
 * @author francis
 */
@Named(value = "registro")
@RequestScoped
public class Registro {
	
	private static final String PARAM_VALIDACION="codigoValidacion";
	private static final String PARAM_CUENTA = "cuenta";

    //@Inject
    @EJB
    private AutenticacionInterfaz auth;

    private Alumno usuario;
    private String repass;

    private String cuenta;
    private String codigoValidacion;

    private boolean validacionOK;

    private boolean registroOK;

    private String mensajeValidacion;
    
    private Long id=100L;
    
    public boolean isRegistroOK() {
        return registroOK;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public Registro() {
        usuario = new Alumno();
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public Alumno getUsuario() {
        return usuario;
    }
    

    public void setUsuario(Alumno usuario) {
        this.usuario = usuario;
    }
    
    public void setName(String nombre) {
        usuario.setNombre(nombre);
    }

    public String registrarUsuario() throws PlaturnoException {
        try {
        	
            if (!usuario.getPassword().equals(repass)) {
                FacesMessage fm = new FacesMessage("Las contraseñas deben coincidir");
                FacesContext.getCurrentInstance().addMessage("registro:repass", fm);
                return null;
            }

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
            		.getExternalContext()
            		.getRequest();
            
            String thisUri = request.getRequestURL().toString();
            
            int ultimaBarra = thisUri.lastIndexOf('/');
            if (ultimaBarra < 0) {
            	FacesMessage fm = new FacesMessage("Error interno de URL");
                FacesContext.getCurrentInstance().addMessage(null, fm);
                return null;
            }
            
          
            
            String uriBuilder = usuario.getUsername()+" "+usuario.getValidationChain();
        
           
            auth.registrarUsuario(usuario, uriBuilder);
            
           
            
            registroOK = true;
            return "exitoRegistro.xhtml";
            
        } catch (CuentaExistenteException e) {
            FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta");
            FacesContext.getCurrentInstance().addMessage("registro:user", fm);
            
        } 
        return null;
    }

    public String validarCuenta() throws CuentaInexistenceException, CuentaYaValidadaException, ValidacionIncorrectaException {
      
		try {
            if (cuenta != null && codigoValidacion != null) {
                auth.validarCuenta(usuario, codigoValidacion);
            }
            mensajeValidacion = "La validación ha sido correcta, ahora puede acceder con este usuario.";
            validacionOK = true;
        } catch (PlaturnoException e) {
            mensajeValidacion = "Ha habido un error con la validación, compruebe que la URL es correcta.";
            validacionOK = false;
        }
        return null;
    }

    public String getMensajeValidacion() {
        return mensajeValidacion;
    }

    public boolean isValidacionOK() {
        return validacionOK;
    }
    
    public String registro() {
    	return "registroUsuario.xhtml";
    }
    public String login() {
    	return "login.xhtml";
    }

}
