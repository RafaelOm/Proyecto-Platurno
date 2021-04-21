package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.EncuestaNoExisteException;
import es.uma.platurno.jpa.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Session Bean implementation class ASIGNAR_GRUPO_AUTO
 */
@Stateless
@LocalBean
public class ASIGNAR_GRUPO_AUTO implements ASIGNAR_GRUPO_AUTOInterfaz {
    @PersistenceContext(unitName = "AgendaEE-EntidadesPU")
    private EntityManager em;
    /**
     * Default constructor.
     */
    public ASIGNAR_GRUPO_AUTO() {
        // TODO Auto-generated constructor stub
    }


    @Override
    public void ASIGNAR(Expediente ex) throws EncuestaNoExisteException {

        String IDex = ex.getId_Expediente();
        Query qEncuesta = em.createQuery("select e.encuestas from Expediente e where e.IdExpediente = :IDexpediente ");
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
            List<GR_ASIG> gr_asigs = enc.getGrupos();
            for(GR_ASIG ga : gr_asigs){

                Asignatura asig = ga.getAsig();

                Grupo grup = ga.getGroup();


                Query qMatricula = em.createQuery("select Matricula from Expediente e where e.IdExpediente = :ID_ENC");
                qMatricula.setParameter("ID_ENC",id);
                List<Matricula> matriculas = qMatricula.getResultList();


                //List<Matricula> matriculas = ex.getMatriculas();

                for (Matricula m : matriculas) {
                    List<Mat_Asig> lista_mat = m.getMat_Asigs();
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
