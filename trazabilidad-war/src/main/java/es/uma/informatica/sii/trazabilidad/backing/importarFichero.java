/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.trazabilidad.backing;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

import es.uma.informatica.sii.ejb.practica.ejb.Autenticacion;
import es.uma.informatica.sii.ejb.practica.ejb.AutenticacionInterfaz;
import es.uma.informatica.sii.ejb.practica.ejb.IFCSV_Interface;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.AsignaturaInexsistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInactivaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaInexistenceException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.CuentaYaValidadaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.GrupoInexistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PasswordErroneaException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.PlaturnoException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ValidacionIncorrectaException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


@Named(value = "upload")
@RequestScoped
public class importarFichero {

	
	
    @Inject
    private AutenticacionInterfaz negocio;

    @Inject
    private InfoSesion sesion;

    private Alumno usuario;
    
    @Inject
    private IFCSV_Interface importar;
    
    private UploadedFile csvFile;

    /**
     * Creates a new instance of login
     */
    public importarFichero() {
        usuario = new Alumno();
    }
    public void handleFileUpload(FileUploadEvent event) {
        this.csvFile = null;
       
        UploadedFile file = event.getFile();
        if(file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            this.csvFile = file;
            FacesMessage msg = new FacesMessage("Successful", this.csvFile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
            	InputStream input = csvFile.getInputStream();
            	Path folder = Paths.get("/opt/jboss/wildfly/");
            	String filename = FilenameUtils.getBaseName(csvFile.getFileName()); 
            	String extension = FilenameUtils.getExtension(csvFile.getFileName());
            	Path fileupload = Files.createTempFile(folder, filename + "-", "." + extension);
            	Files.copy(input, fileupload, StandardCopyOption.REPLACE_EXISTING);
            	  msg = new FacesMessage("Successful", this.csvFile.getFileName() + " is uploaded AS A FILE IN THE SERVER.");
                 FacesContext.getCurrentInstance().addMessage(null, msg);
                 
                 
                	 importar.leerCSV(new File("/opt/jboss/wildfly/"+fileupload.getFileName()));
               
            	
            	
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }


    
    }
    
    
    public void handleFileGrAsig(FileUploadEvent event) {
        this.csvFile = null;
       
        UploadedFile file = event.getFile();
        if(file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            this.csvFile = file;
            FacesMessage msg = new FacesMessage("Successful", this.csvFile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
            	InputStream input = csvFile.getInputStream();
            	Path folder = Paths.get("/opt/jboss/wildfly/");
            	String filename = FilenameUtils.getBaseName(csvFile.getFileName()); 
            	String extension = FilenameUtils.getExtension(csvFile.getFileName());
            	Path fileupload = Files.createTempFile(folder, filename + "-", "." + extension);
            	Files.copy(input, fileupload, StandardCopyOption.REPLACE_EXISTING);
            	  msg = new FacesMessage("Successful", this.csvFile.getFileName() + " is uploaded AS A FILE IN THE SERVER.");
                 FacesContext.getCurrentInstance().addMessage(null, msg);
                 
                 
                
						importar.leerCSVGrAsig(new File("/opt/jboss/wildfly/"+fileupload.getFileName()));
					
               
            	
            	
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AsignaturaInexsistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GrupoInexistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }


    
    }
    
    
}