package es.uma.platurno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.ws.rs.core.UriBuilder;

public class Alumno implements AlumnoInterface{
	
     private String nombre;
     private String apellido1;
     private String apellido2;
     private String emailPersonal;
     private int numeroPersonal;
     private String localidad;
     private String Comunidad;
     private String calle;
     private int CodPostal;
     private EntityManager em;
        
     public Alumno()
     {
    	 // Default null
     }
     public Alumno(String n,String ap1, String ap2, String ep, int np, String l
    		 ,String co, String street, int cd) throws AlumnoException {
     
    	 if ( validateData(n, ap1, ap2, ep,np, l, co, street, cd) ) {
    		 crearAlumnoFromCsv(n, ap1, ap2, ep,np, l, co, street, cd);
    	 }else {
    		 throw new AlumnoException();
    	 }
    	 
     
     }

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}
	public void setNumeroPersonal(int numeroPersonal) {
		this.numeroPersonal = numeroPersonal;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public void setComunidad(String comunidad) {
		Comunidad = comunidad;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public void setCodPostal(int codPostal) {
		CodPostal = codPostal;
	}
	
	private void crearAlumnoFromCsv(String n, String ap1, String ap2, String ep,int np, String l, String co, String street,
			int cd) {
		Autenticacion a = new Autenticacion();
		Alumno al = em.find(Alumno.class, ep);
		
		if ( al != null ) {
			throw new AlumnoException();
		}
		
		al = new Alumno();
		al.setNombre(n);
		al.setApellido1(ap1);
		al.setApellido2(ap2);
		al.setEmailPersonal(ep);
		al.setNumeroPersonal(np);
		al.setComunidad(co);
		al.setLocalidad(l);
		al.setCalle(street);
		al.setCodPostal(cd);
		
		UriBuilder u = null;
		
		a.registrarUsuario(al, u);
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
		Alumno al = em.find(Alumno.class, dni);
		
		if ( al != null ) {
			System.out.print(al.toString());
		}
		
	}

	@Override
	public void eliminarAlumno(String dni) {
		// TODO Auto-generated method stub
		
		 Autenticacion a =new Autenticacion();
	     Alumno al =em.find(Alumno.class, dni);
	     a.compruebaLogin(al);
	     em.remove(em.merge(a));
	     
		
	}

	@Override
	public void modificarAlumno(String dni) throws IOException {
	   
		Alumno al = em.find(Alumno.class, dni);
	
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
