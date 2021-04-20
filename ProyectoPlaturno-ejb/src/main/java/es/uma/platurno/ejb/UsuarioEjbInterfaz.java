package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.Local;

@Local
public interface UsuarioEjbInterfaz {

    public void crearUsuarioFromCsvExcel(String Dni) throws PlaturnoException, CuentaExistenteException;
    public Usuario verUsuario(String username) throws CuentaInexistenceException;
    public void modificar(Usuario u) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void moficarClave(String username, String clave,String reClave) throws CuentaInexistenceException, ContrasenaigualException, ClavesDiferentesException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void eliminarUsuario(String username)throws PlaturnoException,CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;

}
