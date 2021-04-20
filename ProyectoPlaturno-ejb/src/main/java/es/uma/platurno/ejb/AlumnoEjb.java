package es.uma.platurno.ejb;

import es.uma.platurno.AlumnoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AlumnoEjb implements AlumnoInterface {
	@PersistenceContext(unitName = "Alumno")
	private EntityManager em;

     public AlumnoEjb()
     {
    	 // Default null
     }

     public AlumnoEjb(String n, String ap1, String ap2, String ep, int np, String l
    		 , String co, String street, int cd,String EmailI,String Telefono) throws AlumnoException {
     
    	 if ( validateData(n, ap1, ap2, ep,np, l, co, street, cd,Telefono,EmailI) ) {
    		 crearAlumnoFromCsv(n, ap1, ap2, ep,np, l, co, street, cd,Telefono,EmailI);
    	 }else {
    		 throw new AlumnoException();
    	 }
    	 
     
     }


	
	private void crearAlumnoFromCsv(String n, String ap1, String ap2, String ep,int np, String l, String co, String street,
			int cd,String email,String Telefono) {
		Autenticacion a = new Autenticacion();
		AlumnoEjb al = em.find(AlumnoEjb.class, ep);
		
		if ( al != null ) {
			throw new AlumnoException();
		}
		
		al = new AlumnoEjb();
		al.setNombre(n);
		al.setApellido1(ap1);
		al.setApellido2(ap2);
		al.setEmailPersonal(ep);
		al.setNumeroPersonal(np);
		al.setComunidad(co);
		al.setLocalidad(l);
		al.setCalle(street);
		al.setCodPostal(cd);
		

		
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
	public void leerAlumno(String dni) {
		// TODO Auto-generated method stub
		AlumnoEjb al = em.find(AlumnoEjb.class, dni);
		
		if ( al != null ) {
			System.out.print(al.toString());
		}
		
	}

	@Override
	public void eliminarAlumno(String dni) {
		// TODO Auto-generated method stub
		
		 Autenticacion a =new Autenticacion();
	     AlumnoEjb al =em.find(AlumnoEjb.class, dni);
	     em.remove(em.merge(a));
	     
		
	}

	@Override
	public void modificarAlumno(String dni) throws IOException {
	   
		AlumnoEjb al = em.find(AlumnoEjb.class, dni);
	
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
			          al.setEmailPersonal(n);
				      break;
			case "B": 
		          n = br.readLine().toString();
			      al.setNumeroPersonal(Integer.parseInt(n));
			      break;
			case "C": 
		          n = br.readLine().toString();
			      al.setLocalidad(n);
			      break;
			case "D": 
		          n = br.readLine().toString();
			      al.setComunidad(n);
			      break;
			case "E": 
		          n = br.readLine().toString();
			      al .setCalle(n);
			      break;
			case "F": 
		          n = br.readLine().toString();
			      al.setCodPostal(Integer.parseInt(n));
			      break;
			}
			
		} else {
			throw new AlumnoException("Error, Alumno no encontrado.");
		}
		
	}
	
	   public String getNombre() {
			return nombre;
		}
		public String getApellido1() {
			return apellido1;
		}
		public String getApellido2() {
			return apellido2;
		}
		public String getEmailPersonal() {
			return emailPersonal;
		}
		public int getNumeroPersonal() {
			return numeroPersonal;
		}
		public String getLocalidad() {
			return localidad;
		}
		public String getComunidad() {
			return Comunidad;
		}
		public String getCalle() {
			return calle;
		}
		public int getCodPostal() {
			return CodPostal;
		}
		public EntityManager getEm() {
			return em;
		}
		
}
