package es.uma.informatica.sii.ejb.practica;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.sii.ejb.practica.entidades.Ingrediente;
import es.uma.informatica.sii.ejb.practica.entidades.Lote;
import es.uma.informatica.sii.ejb.practica.entidades.*;
import es.uma.informatica.sii.ejb.practica.entidades.Producto;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Ingrediente carne = new Ingrediente ("Carne picada");
		Ingrediente pimienta = new Ingrediente ("Pimienta");
		Ingrediente especias = new Ingrediente("Especias de hamburguesa");
		Ingrediente pimenton = new Ingrediente ("Pimentón");
		Ingrediente sal = new Ingrediente ("Sal");
		Ingrediente azucar = new Ingrediente ("Azúcar");
		Ingrediente perejil = new Ingrediente ("Perejil");
		
		for (Ingrediente ingrediente: new Ingrediente [] {carne, pimienta, especias, pimenton, sal, azucar, perejil}) {
			em.persist(ingrediente);
		}
		
		Producto chorizo = new Producto ("Chorizo");
		Producto salchicha = new Producto ("Salchicha");
		Producto hamburguesa = new Producto ("Hamburguesa");
		
		chorizo.setIngredientes(Stream.of(carne, pimienta, pimenton, sal)
				.collect(Collectors.toSet()));
		
		salchicha.setIngredientes(Stream.of(carne, sal, azucar, perejil)
				.collect(Collectors.toSet()));
		
		hamburguesa.setIngredientes(Stream.of(carne, especias, sal, azucar)
				.collect(Collectors.toSet()));
		
		for (Producto producto: new Producto [] {chorizo, salchicha, hamburguesa}) {
			em.persist(producto);
		}
		
		Lote lote = new Lote ("LT1", chorizo, BigDecimal.TEN, Date.valueOf("2021-04-11"));
		lote.setLoteIngredientes(new HashMap<Ingrediente, String>());
		lote.getLoteIngredientes().put(carne, "C1");
		lote.getLoteIngredientes().put(pimienta, "Pi1");
		lote.getLoteIngredientes().put(pimenton, "PM1");
		lote.getLoteIngredientes().put(sal, "S1");
		
		em.persist(lote);
		
		lote = new Lote ("LT2", chorizo, BigDecimal.valueOf(25L), Date.valueOf("2021-04-12"));
		lote.setLoteIngredientes(new HashMap<Ingrediente, String>());
		lote.getLoteIngredientes().put(carne, "C2");
		lote.getLoteIngredientes().put(pimienta, "Pi2");
		lote.getLoteIngredientes().put(pimenton, "PM2");
		lote.getLoteIngredientes().put(sal, "S2");
		
		em.persist(lote);

		Titulacion tit = new Titulacion();
		tit.setNombre("INFORMATICA");
		tit.setCodigo("1");
		tit.setCreditos("240");
		em.persist(tit);

		Centro c = new Centro();
		c.setID("23");
		c.setTLF_Conserjeria("234234");
		c.setDireccion("BOULEVAR PASTEUR");
		em.persist(c);

		List<Centro> centros=new LinkedList<>();
		centros.add(c);
		tit.setCentros(centros);
		em.merge(tit);

		Expediente exp = new Expediente();
		exp.setExpediente("100");
		exp.setN_archivo("23ACF");
		exp.setTitulacion(tit);
		em.persist(exp);

		List<Expediente> expedientes =new LinkedList<>();
		expedientes.add(exp);
		tit.setExpedientes(expedientes);
		em.merge(tit);

		Alumno al=new Alumno();
		al.setUsername("PEPE");
		al.setPassword("1234");
		al.setEmail_personal("sd");
		al.setEmail_institucional("iferjeir");
		al.setMovil("234");
		em.persist(al);
		
		Alumno al1=new Alumno();
		al1.setUsername("MANUEL");
		al1.setPassword("1234");
		al1.setEmail_personal("sd");
		al1.setEmail_institucional("iferjeir");
		al1.setMovil("234");
		em.persist(al1);

		Secretaria sec = new Secretaria();
		sec.setDni("1234");
		sec.setUsername("RAFAEL");
		sec.setPassword("jeje");
		em.persist(sec);

		Secretaria sec1 = new Secretaria();
		sec1.setDni("12345");
		sec1.setUsername("MANOLO");
		sec1.setPassword("jeje");
		em.persist(sec1);


		exp.setAlumno(al);

		Asignatura asig =new Asignatura();
		asig.setReferencia("1234");
		asig.setNombre("CALCULO");
		asig.setOfertada("POR DESGRACIA");
		asig.setCreditos(6);
		asig.setCodigo(103);
		asig.setTitulacion(tit);

		em.persist(asig);

		Optativa asig1 =new Optativa();
		asig1.setReferencia("800");
		asig1.setNombre("DOMOTICA");
		asig1.setOfertada("OFERTADA");
		asig1.setCreditos(6);
		asig1.setCodigo(103);
		asig1.setPlazas("30");
		asig1.setMencion("ELECTRONCA");
		List<Titulacion> titulaciones=new LinkedList<>();
		titulaciones.add(tit);
		asig1.setTitulaciones(titulaciones);
		em.persist(asig1);

		List<Asignatura> asignaturas= new LinkedList<>();
		asignaturas.add(asig);asignaturas.add(asig1);
		tit.setAsignaturas(asignaturas);
		em.merge(tit);

			/*
			Matricula.MatriculaID matrId= new Matricula.MatriculaID();
			matrId.setCurso_Academico(2021L);
			matrId.setIdExpediente(exp.getExpediente());
			 */

		Matricula matricula =new Matricula();
		matricula.setIdExpediente(exp);
		matricula.setCurso_Academico(2021L);
		em.persist(matricula);

		Grupo gr=new Grupo();
		gr.setId("25");
		gr.setCurso(2021);
		gr.setLetra("A");
		gr.setTurno("MAÑANA");
		gr.setIngles("FRANCES");
		gr.setTitulo(tit);
		em.persist(gr);

		Mat_Asig mA=new Mat_Asig();
		mA.setAsignatura(asig);
		mA.setMatricula(matricula);
		mA.setGrupo(gr);
		em.persist(mA);

		GR_ASIG grA=new GR_ASIG();
		grA.setAsig(asig);
		grA.setGroup(gr);
		grA.setCurso_act(2021);
		em.persist(grA);

		List<GR_ASIG> listaAsigDeGrupos= new LinkedList<>();
		listaAsigDeGrupos.add(grA);

		Encuesta encuesta= new Encuesta();
		encuesta.setExpediente(exp);
		encuesta.setFecha_de_Envio(Date.valueOf("1997-03-10"));
		encuesta.setTexto("NO QUIERO CLASE POR LA TARDE");
		encuesta.setGrAsig(listaAsigDeGrupos);
		em.persist(encuesta);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
