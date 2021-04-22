package es.uma.platurno.ejb;

import es.uma.platurno.ejb.exceptions.*;
import es.uma.platurno.jpa.Alumno;
import es.uma.platurno.jpa.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class AlumnoEjb implements AlumnoInterface {
	@PersistenceContext(unitName = "ProyectoPlaturno.GrupoF")
	private EntityManager em;

     public AlumnoEjb()
     {
    	 // Default null
     }

     public AlumnoEjb(String n, String ap1, String ap2, String ep, int np, String l
    		 , String co, String street, int cd,String EmailI,String Telefono) throws AlumnoException {
     
    	 if ( validateData( n,  ap1,  ap2,  ep,  np,  l,  co,  street,  cd) ) {
    		 crearAlumnoFromCsv( n,  ap1,  ap2,  ep, np,  l,  co,  street,
			  cd, EmailI, Integer.valueOf(Telefono));
    	 }else {
    		 throw new AlumnoException();
    	 }
    	 
     
     }


	
	private void crearAlumnoFromCsv(String n, String ap1, String ap2, String ep,int np, String l, String pro, String street,
			int cd,String email,int Telefono) {
		Autenticacion a = new Autenticacion();
		Alumno al = em.find(Alumno.class, ep);
		
		if ( al != null ) {
			throw new AlumnoException();
		}
		
		al = new Alumno();
		al.setNombre(n);
		al.setApellido1(ap1);
		al.setApellido2(ap2);
		al.setEmail_personal(ep);
		al.setMovil(String.valueOf(Telefono));
		al.setProvincia(pro);
		al.setLocalidad(l);
		al.setDireccion(street);
		al.setCP(String.valueOf(cd));
		

		
		em.persist(al);
	}

	private boolean validateData(String n, String ap1, String ap2, String ep, int np, String l, String co, String street, int cd) {

		boolean ok = false;
		
        if (n != null) {
        	if ( ap1!= null) {
        		if (ap2 != null) {
        			if ( ep != null ) {
        				if ( String.valueOf(np) != null) {
        					if ( l != null ) {
        						if ( street != null ) {
        							if ( co != null ) {
        								if ( String.valueOf(cd) != null ) {
        									ok = true;
        								} else {
        									throw new AlumnoException();
        								}
        							}else {
    									throw new AlumnoException();
    								}
        						}else {
									throw new AlumnoException();
								}
        					}else {
								throw new AlumnoException();
							}
        				}else {
							throw new AlumnoException();
						}
        			}else {
						throw new AlumnoException();
					}
        		}else {
					throw new AlumnoException();
				}
        	}else {
				throw new AlumnoException();
			}
        }else {
			throw new AlumnoException();
		}
		return ok;
	}

	
	@Override
	public void leerAlumno(Usuario a) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
		// TODO Auto-generated method stub
		Autenticacion au = new Autenticacion();
		au.compruebaLogin(a);
		Alumno al = em.find(Alumno.class, a.getIdentificador());
		
		if ( al != null ) {
			System.out.print(al.toString());
		}
		
	}

	@Override
	public void eliminarAlumno(Usuario u) throws PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
		// TODO Auto-generated method stub
		
		 Autenticacion a =new Autenticacion();
		 a.compruebaLogin(u);
		 a.compruebaLogin(u);
	     Alumno al =em.find(Alumno.class,u.getIdentificador() );
	     em.remove(em.merge(al));
	     
		
	}

	@Override
	public void modificarAlumno(Usuario a) throws IOException, PlaturnoException, CuentaInactivaException, CuentaInexistenceException, PasswordErroneaException {
	   /*
	    * Beta v1. No definitivo.
	    */
		
		
		Autenticacion au = new Autenticacion();
		au.compruebaLogin(a);
		Alumno al = em.find(Alumno.class,a.getIdentificador());
	
		System.out.printf( " Ingrese la opcion que desea usar: ");
		System.out.print(" Opcion A) Modificar Email Personal \n"
				        +" Opcion B) Modificar Numero Personal \n"
				        +" Opcion C) Modificar Localidad \n"
				        +" Opcion D) Modificar Comunidad \n"
				        +" Opcion E) Modificar Direccion Fisica \n"
				        +" Opcion F) Modificar Codigo Postal \n"
				        );
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String option = br.readLine().toString();
		String n;
		if ( al != null ) {
			
			switch(option) {
			      
			case "A": 
			          n = br.readLine().toString();
			          al.setEmail_personal(n);
				      break;
			case "B": 
		          n = br.readLine().toString();
			      al.setMovil(String.valueOf(n));
			      break;
			case "C": 
		          n = br.readLine().toString();
			      al.setLocalidad(n);
			      break;
			case "D": 
		          n = br.readLine().toString();
			      al.setProvincia(n);
			      break;
			case "E": 
		          n = br.readLine().toString();
			      al .setDireccion(n);
			      break;
			case "F": 
		          n = br.readLine().toString();
			      al.setCP(String.valueOf(n));
			      break;
			}
			
		} else {
			throw new AlumnoException("Error, Alumno no encontrado.");
		}
		
	}

}
