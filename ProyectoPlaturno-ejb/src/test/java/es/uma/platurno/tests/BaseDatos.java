package es.uma.platurno.tests;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.platurno.jpa.*;
import es.uma.platurno.ejb.*;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();



		//////////////////ALUMNO////////////////////
		Alumno a = new Alumno();
		a.setUsername("mEscobar");
		a.setPassword("manolito");
		a.setDni("12345");
		a.setNombre("MANOLO");
		a.setApellido1("ESCOBAR");
		a.setApellido2("NOSE");
		a.setEmail_institucional("manolito@uma.es");
		a.setEmail_personal("manolomanolo@gmail.com");
		a.setTelefono("333333");
		a.setMovil("645353");
		a.setDireccion("Avenida malaga 24 ");
		a.setLocalidad("MADRID");
		a.setProvincia("COMUNIDAD DE MADRID");
		a.setCP("29000");

		em.persist(a);

		/////////////////////CLASE//////////////////
		Clase clase = new Clase();
		clase.setDia("2");
		clase.setHoraInicio("1");
		clase.setHoraFin("2");


		em.persist(clase);


		//////////////////ASIGNATURA/////////////////////////
		Asignatura asig =new Asignatura();
		asig.setReferencia("146");
		asig.setCodigo(25);
		asig.setCreditos(6);
		asig.setNombre("Calculo para la computacion");
		asig.setCurso("2020/2021");
		asig.setCaracter("Informativo");
		asig.setDuracion("4 meses");
		asig.setIdiomas("Español");
		asig.setCred_prac(2);

		em.persist(asig);


		//////////////////////// TITULACION ///////////////////////////
		Titulacion t= new Titulacion();
		t.setCreditos("240");
		t.setCodigo("23");
		t.setNombre("Ingenieria Informatica");
		em.persist(t);
		//////////////////////// Matricula ////////////////////////////

		Matricula m = new Matricula();
		m.setCurso_Academico(2020L);
		m.setEstado("Estudiando feliz mente");
		m.setNum_Archivo("2");
		m.setTurno_Preferente("Mañana");
		m.setFecha_Matricula(new Date(2020));
		m.setNuevo_Ingreso("ANTIGUO");
		m.setListado_de_Asignaturas("Calculo y Programar");
		m.setMat_Asigs(null);

		em.persist(m);

		Matricula m2 = new Matricula();
		m2.setCurso_Academico(2020L);
		m2.setEstado("estudiando");
		m2.setNum_Archivo("1");
		m2.setTurno_Preferente("Tarde");
		m2.setFecha_Matricula(new Date(2020));
		m2.setNuevo_Ingreso("Nuevo");
		m2.setListado_de_Asignaturas("Estadistica y Programar");

		em.persist(m2);
		////////////////////////////////GRUPO////////////////////////////////////

		Grupo grupo = new Grupo();
		grupo.setId("123");
		grupo.setCurso(2);
		grupo.setLetra("A");
		grupo.setTurno("MAÑANA");
		grupo.setIngles("NO");
		grupo.setVisible("SI");
		grupo.setAsignar("asignar");
		grupo.setPlazas(3);
		grupo.setLetra1("B");

		List<Clase> claseList = new ArrayList<>();
		claseList.add(clase);
		grupo.setClase(claseList);

		grupo.setTitulo(t);

		em.persist(grupo);

		Grupo grupo2 = new Grupo();
		grupo2.setId("222");
		grupo2.setCurso(3);
		grupo2.setLetra("B");
		grupo2.setTurno("TARDE");
		grupo2.setIngles("SI");
		grupo2.setVisible("NO");
		grupo2.setAsignar("asignar");
		grupo2.setPlazas(3);
		grupo2.setLetra1("C");

		List<Clase> claseList2 = new ArrayList<>();
		claseList2.add(clase);
		grupo2.setClase(claseList);

		List<Grupo>  grupoList2 = new ArrayList<>();
		grupoList2.add(grupo);
		grupo2.setGrupos(grupoList2);

		grupo2.setTitulo(t);

		em.persist(grupo2);

		/////////////////////CENTRO//////////////////
		Centro c = new Centro();
		c.setId("1");
		c.setNombre("ETSII");
		c.setDireccion("Boulevar");
		c.setTLF_Conserjeria("1233445");


		em.persist(c);

		////////////////////////////////MAT_ASIG////////////////////////////////////

		Mat_Asig mat_asig = new Mat_Asig();
		mat_asig.setAsignatura(asig);
		mat_asig.setMatricula(m);
		mat_asig.setGrupo(grupo);


		em.persist(mat_asig);

		/////////////////  EXPEDIENTE ////////////////
		Expediente ex = new Expediente();
		ex.setId_Expediente("11111");
		ex.setActivo("SI");
		ex.setNotaMPr(1);
		ex.setCreditosSup(1.0);
		ex.setCreditosFB(1.0);
		ex.setCreditosOP(1.0);
		ex.setCreditosOB(1.0);
		ex.setCreditosCF(1.0);
		ex.setCreditosPE(1.0);
		ex.setCreditosTF(1.0);
		ex.setN_Archivo("aaaa");
		ex.setTitulacion(t);

		em.persist(ex);

		Expediente ex2 = new Expediente();
		ex2.setId_Expediente("222222");
		ex2.setActivo("NO");
		ex2.setNotaMPr(2);
		ex2.setCreditosSup(2.0);
		ex2.setCreditosFB(2.0);
		ex2.setCreditosOP(2.0);
		ex2.setCreditosOB(2.0);
		ex2.setCreditosCF(2.0);
		ex2.setCreditosPE(2.0);
		ex2.setCreditosTF(2.0);
		ex2.setN_Archivo("bbbbb");

		em.persist(ex2);
		///////////////////////////////////ENCUESTA////////////////////////////////////////
		Encuesta encuesta = new Encuesta();
		encuesta.setId_Encuesta("asasasa");
		List<GR_ASIG> gr_asigList = null;
		encuesta.setGrupos(gr_asigList);
		encuesta.setExpediente(ex);
		encuesta.setFecha_de_Envio(new Date(2020));

		em.persist(encuesta);

		//////////////////////////////////GR_ASIG///////////////////////////////////

		GR_ASIG gr_asig = new GR_ASIG();
		gr_asig.setAsig(asig);
		gr_asig.setOferta(2);
		gr_asig.setCurso_act(2);
		List<Encuesta> encuestaList = null;
		gr_asig.setEncuesta(encuesta);
		gr_asig.setGroup(grupo);

		em.persist(gr_asig);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
