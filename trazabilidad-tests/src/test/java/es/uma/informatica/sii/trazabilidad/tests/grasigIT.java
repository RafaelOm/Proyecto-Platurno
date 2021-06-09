package es.uma.informatica.sii.trazabilidad.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import es.uma.informatica.sii.anotaciones.Requisitos;

public class grasigIT {
	
	 private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  private static final String UNIDAD_PERSITENCIA = "AgendaPU";
	  @Before
	  public void setUp() {
	    driver = new FirefoxDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	    BaseDeDatos.inicializar(UNIDAD_PERSITENCIA);
	 
	    
	    
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Requisitos({"RF15","RF12","RF09"})
	  @Test
	  public void verAsignacion() {
		  
		  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/login.xhtml");
		    driver.findElement(By.id("login:user")).click();
		    driver.findElement(By.id("login:user")).sendKeys("escobar");
		    driver.findElement(By.id("login:pass")).sendKeys("1");
		    driver.findElement(By.id("login:j_idt10")).click();
		    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/vistaAlumno.xhtml");
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {

			}
		    
		    driver.findElement(By.id("dt2:0:botonForm:addBtn")).click();
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
		    assertThat(driver.findElement(By.id("dt1:0:asigtest")).getText(), is("Calculo"));
		    
		    driver.findElement(By.id("dt1:0:btnformArriba:removeBtn")).click();
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
		    
		    List<WebElement> elements = driver.findElements(By.id("dt1:0:asigtest"));
		    assert(elements.size() == 0);
		    
		    
		    
		  
	  }
	  
	  
	  
	  
	  
	  
	  

}
