/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.trazabilidad.backing;


import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Named;

import es.uma.informatica.sii.ejb.practica.ejb.Autenticacion;
import es.uma.informatica.sii.ejb.practica.ejb.AutenticacionInterfaz;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaYaValidadaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ValidacionIncorrectaException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Secretaria;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author francis
 */
@Named(value = "loginSecretaria")
@RequestScoped
public class LoginSecretaria {
	 private static final Logger LOGGER = Logger.getLogger(LoginSecretaria.class.getCanonicalName());

	
	
    @Inject
    private AutenticacionInterfaz negocio;

    @Inject
    private InfoSesion sesion;

    private Secretaria usuario;

    /**
     * Creates a new instance of login
     */
    public LoginSecretaria() {
        usuario = new Secretaria();
    }

    public Secretaria getUsuario() {
        return usuario;
    }

    public void setUsuario(Secretaria usuario) {
        this.usuario = usuario;
    }

    public String entrar() {
    	LOGGER.info("LOGIN SECRETARIA PULSADO");
        try {
            negocio.compruebaLogin(usuario);
            sesion.setUsuario(negocio.compruebaLogin(usuario));
            return "vistaSecretaria.xhtml";

        } catch (CuentaInexistenceException e) {
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La cuenta no existe"));
        } catch (PasswordErroneaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (CuentaInactivaException e) {
           // FacesMessage fm = new FacesMessage("La cuenta existe pero no está activa");
            //FacesContext.getCurrentInstance().addMessage("login:user", fm);
            return "activa.xhtml";
        } catch (PlaturnoException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }
    
    public String validar() {
    	
             try {
				
		         negocio.validarCuenta(usuario, usuario.getValidationChain());
			} catch (PlaturnoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  catch (CuentaInexistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  catch (CuentaYaValidadaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ValidacionIncorrectaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
             return "index.xhtml";


    }
    
   public String nombrecompleto() {
	   return usuario.getNombre()+" "+usuario.getApellido();
   }
    
}
