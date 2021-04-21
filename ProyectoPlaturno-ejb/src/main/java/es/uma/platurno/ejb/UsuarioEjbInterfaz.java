package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Usuario;

import javax.ejb.Local;

@Local
public interface UsuarioEjbInterfaz {

    public void crearUsuarioFromCsvExcel(String Dni) throws PlaturnoException, CuentaExistenteException;
    public Usuario verUsuario(Usuario u) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void modificar(Usuario u) throws CuentaInexistenceException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void moficarClave(Usuario u) throws CuentaInexistenceException, ContrasenaigualException, ClavesDiferentesException, CuentaInactivaException, PlaturnoException, PasswordErroneaException;
    public void eliminarUsuario(Usuario user, Usuario Secretaria)throws PlaturnoException,CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException, ViolacionDeSeguridadException;

}
