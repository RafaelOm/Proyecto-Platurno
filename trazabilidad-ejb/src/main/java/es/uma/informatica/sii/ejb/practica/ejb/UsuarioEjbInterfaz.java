package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;
import javax.ejb.Local;

@Local
public interface UsuarioEjbInterfaz {

    public void crearUsuarioFromCsvExcel(Alumno al) throws PlaturnoException, CuentaExistenteException;
    public Usuario verUsuario(Usuario u) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void modificar(Usuario u) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void moficarClave(Usuario u) throws CuentaInexistenceException, ContrasenaigualException, ClavesDiferentesException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void eliminarUsuario(Usuario user, Usuario Secretaria)throws PlaturnoException,CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException, ViolacionDeSeguridadException;

}
