package es.uma.platurno.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.platurno.jpa.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Session Bean implementation class Matricula
 */
@Stateless
@LocalBean
public class Matricula implements MatriculaInterfaz {
    @PersistenceContext(unitName = "Platurno-Usuario")
    private EntityManager em;


    /**
     * Default constructor. 
     */
    public Matricula() {
        // TODO Auto-generated constructor stub
        Alumno a = new Alumno();
        Clase c =new Clase();

        //QUERY 1
        Query query =em.createQuery("select m from Matricula m where m.Listado_de_Asignaturas LIKE '%PARAMETRO%'");
        List<es.uma.platurno.jpa.Matricula> matriculas=query.getResultList();


        //QUERY 2
        //obtenemos expedientes donde se cuple dicha titulacion
        Query qexpedientes = em.createQuery("select e from Expediente e where e.titulacion.Codigo='PARAMETRO' ") ;
        List<es.uma.platurno.jpa.Expediente>expedientes=qexpedientes.getResultList();

        //obtenemos matriculas
        Query qmatriculas =em.createQuery("select m from Matricula m ");
        List<es.uma.platurno.jpa.Matricula> matriculas2=query.getResultList();


        List<es.uma.platurno.jpa.Matricula> res=new ArrayList<es.uma.platurno.jpa.Matricula>();
        for(es.uma.platurno.jpa.Matricula m: matriculas2){
            for(Expediente e: expedientes){
                if(m.getExpediente().equals(e)){
                    res.add(m);
                }
            }

        }
    	
    }

}
