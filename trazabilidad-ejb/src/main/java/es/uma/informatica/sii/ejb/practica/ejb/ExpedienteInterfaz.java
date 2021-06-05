package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.*;
import  es.uma.informatica.sii.ejb.practica.entidades.*;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ExpedienteInterfaz {

    public Expediente ReadExpediente(Usuario u, String id) throws ExpedienteNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;

    public void UpdateExpediente(String id,String Activo,
    		Double NotaMPr,
                                 Double CreditosSup,
                                 Double CreditosFB,
                                 Double CreditosOP,
                                 Double CreditosOB,
                                 Double CreditosCF,
                                 Double CreditosPE,
                                 Double CreditosTF,
                                 String N_Archivo) throws ExpedienteNoExisteException;

    public void DeleteExpediente(Usuario u,String id) throws ExpedienteNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException;
    public List<Expediente> getAll();
    public void crearExpediente(Expediente nueva, Usuario usuario) throws ExpedienteNoExisteException, PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException;
}
