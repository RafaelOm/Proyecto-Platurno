package es.uma.platurno.ejb;
import java.util.*;
import es.uma.platurno.jpa.*;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local
public  class FiltroMatriculas implements FiltroMatriculasInterfaz{
    @PersistenceContext(unitName = "ProyectoPlaturno.GrupoF")
    private static EntityManager em;
    private static List<Matricula> lista;


    public FiltroMatriculas(){

    }

    @Override
    // Filtro (1er parametro Asignaturas, 2o parametro Titulacion, 3er parametro Cursos)
    public List<Matricula> filtroListaMatriculas(List<List<String>> parametros){
        List<Matricula> lista1, lista2, lista3, listaFin= null;
        if(parametros == null) {
            Query q = em.createQuery("SELECT m FROM Matricula m");
            listaFin = q.getResultList();
        } else {
            lista1 = filtrarPorAsignaturas(parametros.get(0));
            lista2 = filtrarPorTitulacion(parametros.get(1));
            lista3 = filtrarPorCursos(parametros.get(2));

            for (int i = 0; i<lista1.size();i++){
                for (int j = i; i< lista2.size();j++){
                    for (int k = j; j< lista3.size();k++){
                        if (lista1.get(i).equals(lista2.get(j).equals(lista3.get(k)))){
                            listaFin.add(lista1.get(i));
                        }
                    }
                }
            }


        }

        return listaFin;
    }

    @Override
    // 1er parametro, lista de 1 elemento (Listado de asignaturas String, ordenado como en la base de datos)
    public  List<Matricula> filtrarPorAsignaturas(List<String> asignatura){
            List<Matricula> listaFiltrada = new ArrayList<Matricula>();
            if(asignatura == null || asignatura.size() == 0){
                Query m = em.createQuery("SELECT m FROM Matricula m");
                listaFiltrada = m.getResultList();
            } else {
                String lista_asig = asignatura.get(0);
                Query m = em.createQuery("SELECT m FROM Matricula m where m.Listado_de_Asignaturas LIKE '%:lista%' ");
                m.setParameter("lista", lista_asig);
                listaFiltrada = m.getResultList();
                }
            return listaFiltrada;
    }

    @Override
    public  List<Matricula> filtrarPorTitulacion(List<String> titulacion){
        List<Matricula> listaFiltrada = new ArrayList<Matricula>();
        if(titulacion == null || titulacion.size() == 0){
            Query m = em.createQuery("SELECT m FROM Matricula m");
            listaFiltrada = m.getResultList();
        } else {
            List<Matricula> matriculas = new ArrayList<>();

            for (int i = 0; i< titulacion.size(); i++){
                String titulacion_ref = titulacion.get(i);
                Query q = em.createQuery("SELECT e from Expediente e where e.titulacion.Codigo = :tit_ref");
                q.setParameter("tit_ref", "titulacion_ref");
                List<Expediente> expedientes = q.getResultList();

                for (Expediente exp:expedientes){
                    q = em.createQuery("SELECT m FROM Matricula m WHERE m.expediente.IdExpediente = :exp_ref");
                    q.setParameter("exp_ref", exp.getId_Expediente());
                    matriculas.addAll(q.getResultList());
                }

            }
            listaFiltrada = matriculas;
        }
        return listaFiltrada;
    }

    @Override
    public  List<Matricula> filtrarPorCursos(List<String> curso){
        List<Matricula> listaFiltrada = new ArrayList<Matricula>();
        if(curso == null || curso.size() == 0){
            Query m = em.createQuery("SELECT m FROM Matricula m");
            listaFiltrada = m.getResultList();
        } else {
            List<Matricula> matriculas = new ArrayList<>();

            for (int i = 0; i< curso.size(); i++){
                String curso_acad = curso.get(i);
                Query q = em.createQuery("SELECT m FROM Matricula m where m.Curso_Academico = :ca_ref");
                q.setParameter("ca_ref", "curso_acad");
                List<Matricula> matriculaAux = q.getResultList();
                matriculas.addAll(matriculaAux);
            }
            listaFiltrada = matriculas;
        }
        return listaFiltrada;
    }


}
