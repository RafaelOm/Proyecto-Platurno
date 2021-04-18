package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;

import javax.ejb.Local;

@Local
public interface UsuarioEjbInterfaz {

    public void verUsuario(String username) throws CuentaInexistenceException;
    public void modificarNombreyAppelidoUsuario(String username,String name,String surname) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void modificarTelefonoUsuario(String username,String telefono) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void moficarClave(String username, String clave,String reClave) throws CuentaInexistenceException, ContrasenaigualException, ClavesDiferentesException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void eliminarUsuario(String username)throws PlaturnoException,CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;

}
