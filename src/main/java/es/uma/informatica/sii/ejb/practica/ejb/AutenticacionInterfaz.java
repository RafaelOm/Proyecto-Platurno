package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.core.UriBuilder;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;
//Autor: Rafael Ordoñez Molina

@Local
public interface AutenticacionInterfaz  {
    public void registrarUsuario(Usuario u, UriBuilder uribuilder) throws PlaturnoException, CuentaExistenteException;
    public void validarCuenta(Usuario u, String validacion) throws PlaturnoException, CuentaInexistenceException, CuentaYaValidadaException, ValidacionIncorrectaException;
    public void compruebaLogin(Usuario u) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
    public void checkSecretariaRole(Usuario u) throws CuentaInexistenceException, ViolacionDeSeguridadException;

}
