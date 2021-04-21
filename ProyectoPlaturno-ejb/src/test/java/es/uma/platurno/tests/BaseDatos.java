package es.uma.platurno.tests;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
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

		Optativa opt = new Optativa();

		opt.setReferencia("300");
		opt.setCodigo(30);
		opt.setCreditos(6);
		opt.setNombre("Domotica");
		opt.setCurso("2020/2021");
		opt.setCaracter("Informativo");
		opt.setDuracion("6 meses");
		opt.setIdiomas("Español");
		opt.setCred_prac(6);

		em.persist(opt);

		Titulacion t = new Titulacion();
		t.setCodigo("100");
		t.setNombre("Ingenieria Informatica");
		t.setCreditos("250");


		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
