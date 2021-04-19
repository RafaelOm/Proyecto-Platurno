package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.AsignaturaInexsistenteException;
import es.uma.platurno.jpa.Asignatura;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class AsignaturasEjb
 */
@Stateless
@LocalBean
public class AsignaturasEjb implements AsignaturasEjbInterfaz {

    @PersistenceContext(unitName = "Platurno-Asignatura")
    private EntityManager em;
    /**
     * Default constructor. 
     */
    public AsignaturasEjb() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Asignatura verAsignatura(String referencia) throws AsignaturaInexsistenteException {
        Asignatura asig= em.find(Asignatura.class,referencia);
        if(asig==null){
            throw new AsignaturaInexsistenteException();
        }
        System.out.println(asig.toString());
        return asig;
    }

    @Override
    public void modificarAsignatura(String referencia, Integer Codigo, Integer Creditos,
                                    String ofertada, String nombre, String curso, String caracter, String duracion, String Idiomas, Integer credPract) throws AsignaturaInexsistenteException {
        Asignatura asig =em.find(Asignatura.class,referencia);
        if(asig==null){
            throw new AsignaturaInexsistenteException();
        }
        asig.setCodigo(Codigo);
        asig.setCreditos(Creditos);
        asig.setOfertada(ofertada);
        asig.setNombre(nombre);
        asig.setCurso(curso);
        asig.setCaracter(caracter);
        asig.setDuracion(duracion);
        asig.setIdiomas(Idiomas);
        asig.setCred_prac(credPract);
        em.merge(asig);

    }

    @Override
    public void eliminarAsignatura(String referencia) throws AsignaturaInexsistenteException {
        Asignatura asig= em.find(Asignatura.class,referencia);
        if(asig==null){
            throw new AsignaturaInexsistenteException();
        }
        em.remove(em.merge(asig));
    }
}
