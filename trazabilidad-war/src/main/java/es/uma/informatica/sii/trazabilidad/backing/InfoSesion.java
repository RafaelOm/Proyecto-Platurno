/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uma.informatica.sii.trazabilidad.backing;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.ejb.practica.ejb.AutenticacionInterfaz;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.entidades.Usuario;

/**
 *
 * @author francis
 */
@Named(value = "infoSesion")
@SessionScoped
public class InfoSesion implements Serializable {

    @Inject
    private AutenticacionInterfaz negocio;
    private Usuario usuario;
    
    /**
     * Creates a new instance of InfoSesion
     */
    public InfoSesion() {
    }

    public synchronized void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public synchronized Usuario getUsuario() {
        return usuario;
    }
    /*
    public synchronized List<Contacto> getContactos()
    {
        if (usuario != null)
        {
            return usuario.getContactos();
        }
        return null;
    }*/
    
    public synchronized String invalidarSesion()
    {
        if (usuario != null)
        {
            usuario = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "login.xhtml";
    }
    
    public synchronized void refrescarUsuario()
    {
      
        if (usuario != null)
        {
            try {
				usuario = negocio.compruebaLogin(usuario);
				
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
			}
            //System.out.println(usuario.getContactos().size());
        } 
        }
    
    }
    

