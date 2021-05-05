package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Session Bean implementation class ASIGNAR_GRUPO_AUTO
 */
@Stateless
public class ASIGNAR_GRUPO_AUTO implements ASIGNAR_GRUPO_AUTOInterfaz {
    @PersistenceContext(unitName = "ProyectoPlaturno.GrupoF")
    private EntityManager em;

    private Autenticacion auth;

    /**
     * Default constructor.
     */
    public ASIGNAR_GRUPO_AUTO() {
        // TODO Auto-generated constructor stub
    }


    @Override
    public void ASIGNAR(Usuario u, Expediente ex) throws EncuestaNoExisteException, PasswordErroneaException, CuentaInactivaException, CuentaInexistenceException, PlaturnoException {

        //////Check if user is authenticated in the system  ////////////
        auth=new Autenticacion();
        auth.compruebaLogin(u);
        ////////////////////////////////////////////////////////////////

        String IDex = ex.getExpediente();
        Query qEncuesta = em.createQuery("select e.encuentasAsociadas from Expediente e where e.expediente = :IDexpediente ");
        qEncuesta.setParameter("IDexpediente",IDex);
        List<Encuesta> encuestas = qEncuesta.getResultList();

        if(encuestas==null){
            throw new EncuestaNoExisteException();
        }

        for(Encuesta enc : encuestas) {
            String id = enc.getId_Encuesta();
            /*
            String id = enc.getId_Encuesta();
            Query qGR_ASIG = em.createQuery("select e.grupos from Encuesta e where e.id_Encuesta= :ID_ENC");
            qGR_ASIG.setParameter("ID_ENC",id);
            List<GR_ASIG> gr_asigs = qGR_ASIG.getResultList();
             */
            List<GR_ASIG> gr_asigs = new LinkedList<>();
            for(GR_ASIG ga : gr_asigs){

                Asignatura asig = ga.getAsig();

                Grupo grup = ga.getGroup();


                Query qMatricula = em.createQuery("select Matricula from Expediente e where e.expediente = :ID_ENC");
                qMatricula.setParameter("ID_ENC",id);
                List<Matricula> matriculas = qMatricula.getResultList();


                //List<Matricula> matriculas = ex.getMatriculas();

                for (Matricula m : matriculas) {
                    List<Mat_Asig> lista_mat = m.getMatAsig();
                    for(Mat_Asig lma : lista_mat){
                        lma.setGrupo(grup);
                        lma.setAsignatura(asig);
                        em.merge(lma);
                    }
                }
            }


        }
    }
}
