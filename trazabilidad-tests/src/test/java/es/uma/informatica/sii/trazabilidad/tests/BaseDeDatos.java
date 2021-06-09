package es.uma.informatica.sii.trazabilidad.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Secretaria;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;


public class BaseDeDatos {
	
	public static void inicializar(String unidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		/* Comentar la línea de abajo si los datos se incluyen en un script de SQL */
		datos(em); 
		
		em.close();
		emf.close();
		
	}

	public static void datos(EntityManager em) {
		Secretaria secretaria = new Secretaria();
		
		secretaria.setUsername("rafa");
		secretaria.setPassword("1");
		secretaria.setNombre("Rafael ");
		secretaria.setApellido("Flores");
		secretaria.setDni("1");
		secretaria.setEmail("flores@uma.es");
		
		em.getTransaction().begin();
		em.persist(secretaria);
		em.getTransaction().commit();
		
		Secretaria secretaria1 = new Secretaria();
		
		secretaria1.setUsername("manu");
		secretaria1.setPassword("1");
		secretaria1.setNombre("Manuel ");
		secretaria1.setApellido("Garcia");
		secretaria1.setDni("1");
		secretaria1.setEmail("manu@uma.es");
		
		em.getTransaction().begin();
		em.persist(secretaria1);
		em.getTransaction().commit();
		
		Titulacion t =new Titulacion();
		t.setCodigo("1024");
		t.setCreditos("240");
		t.setNombre("Ingenieria Informatica");
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
		
		Titulacion t2 =new Titulacion();
		t2.setCodigo("1022");
		t2.setCreditos("241");
		t2.setNombre("Ingenieria Salud");
		em.getTransaction().begin();
		em.persist(t2);
		em.getTransaction().commit();
		
		Asignatura asig1 =new Asignatura();
		asig1.setNombre("Calculo");
		asig1.setCaracter("Presencial");
		asig1.setCodigo(1);
		asig1.setCred_prac(0);
		asig1.setCreditos(6);
		asig1.setCurso("Primero");
		asig1.setDuracion("5 meses");
		asig1.setIdiomas("Español,Ingles");
		asig1.setOfertada("si");
		asig1.setReferencia("1");
		asig1.setTitulacion(t);
		
		em.getTransaction().begin();
		em.persist(asig1);
		em.getTransaction().commit();
		
		Alumno al = new Alumno();
		al.setApellido1("Escobar");
		al.setApellido2("Garcia");
		al.setNombre("Manuel");
		al.setCP("29002");
		al.setDireccion("Calle larios");
		al.setDni("2589886");
		al.setEmail_institucional("escobar@uma.es");
		al.setEmail_personal("mescobar@gmail.com");
		al.setLocalidad("Malaga");
		al.setMovil("222");
		al.setTelefono("952361644");
		al.setPassword("1");
		al.setUsername("escobar");
		al.setProvincia("Malaga");
		

		em.getTransaction().begin();
		em.persist(al);
		em.getTransaction().commit();
		
		Expediente ex1 = new Expediente();
		ex1.setExpediente("1");
		ex1.setActivo("SI");
		ex1.setCreditosCF(1.0);
		ex1.setCreditosFB(1.0);
		ex1.setCreditosOB(1.0);
		ex1.setCreditosOP(1.0);
		ex1.setCreditosPE(1.0);
		ex1.setCreditosSup(1.0);
		ex1.setCreditosTF(1.0);
		ex1.setN_archivo("agua");
		ex1.setNotampr(1.0);
		
		em.getTransaction().begin();
		em.persist(ex1);
		em.getTransaction().commit();
		
		Expediente ex2 = new Expediente();
		ex2.setExpediente("2");
		ex2.setActivo("SI");
		ex2.setCreditosCF(1.0);
		ex2.setCreditosFB(1.0);
		ex2.setCreditosOB(1.0);
		ex2.setCreditosOP(1.0);
		ex2.setCreditosPE(1.0);
		ex2.setCreditosSup(1.0);
		ex2.setCreditosTF(1.0);
		ex2.setN_archivo("agua");
		ex2.setNotampr(1.0);
		
		em.getTransaction().begin();
		em.persist(ex2);
		em.getTransaction().commit();
		
		Grupo gr1 = new Grupo();
		gr1.setAsignar("si");
		gr1.setCurso(3);
		gr1.setId("23");
		gr1.setIngles("si");
		gr1.setLetra("a");
		gr1.setLetra1("a");
		gr1.setPlazas(50);
		gr1.setTurno("tarde");
		gr1.setVisible("si");
		
		em.getTransaction().begin();
		em.persist(gr1);
		em.getTransaction().commit();
		
		Matricula mat1 = new Matricula();
		mat1.setCurso_Academico(2021L);
		mat1.setEstado("SI");
		mat1.setFecha_Matricula("2021/2/2");
		mat1.setIdExpediente(ex1);
		mat1.setListado_de_Asignaturas("109");
		mat1.setNuevo_Ingreso("SI");
		mat1.setNum_Archivo("303");
		mat1.setTurno_Preferente("tarde");
		
		
		em.getTransaction().begin();
		em.persist(mat1);
		em.getTransaction().commit();
	
		
		
		

	}

}
