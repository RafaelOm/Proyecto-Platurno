// Generated by Selenium IDE
package es.uma.informatica.sii.trazabilidad.tests;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class crudAsignaturaIT {
  private WebDriver driver;
  private Map<String, Object> vars;
  private static final String UNIDAD_PERSITENCIA = "AgendaPU";
  JavascriptExecutor js;
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

  @Test
  public void testVerAsignatura() {
	  
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudAsignaturas.xhtml");
	   
	    assert(driver.findElement(By.id("dt-products:0:nombre")).getText().equals("Calculo"));

    
  }
  
  @Test
  public void testCrearAsignatura() {
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	  driver.findElement(By.id("login:user")).click();
	  driver.findElement(By.id("login:user")).sendKeys("rafa");
	  driver.findElement(By.id("login:pass")).sendKeys("1");
	  driver.findElement(By.cssSelector(".ui-button-text")).click();
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudAsignaturas.xhtml");
    
      WebElement element = driver.findElement(By.id("barraSup:crearAsigBtn"));
      element.click();
      try {
		Thread.sleep(5000);
      } catch (InterruptedException e) {
      }
      driver.findElement(By.id("addAsigForm:referencia")).click();
      driver.findElement(By.id("addAsigForm:referencia")).sendKeys("4");
      driver.findElement(By.id("addAsigForm:cod")).sendKeys("25");
      driver.findElement(By.id("addAsigForm:creditos")).sendKeys("8");
      driver.findElement(By.id("addAsigForm:ofertada")).sendKeys("si");
      driver.findElement(By.id("addAsigForm:nombre")).sendKeys("Fisica");
      driver.findElement(By.id("addAsigForm:curso")).sendKeys("2");
      driver.findElement(By.id("addAsigForm:caaracter")).sendKeys("online");
      driver.findElement(By.id("addAsigForm:duracion")).sendKeys("3");
      driver.findElement(By.id("addAsigForm:idiomas")).sendKeys("idjfc");
      driver.findElement(By.id("addAsigForm:cp")).sendKeys("0");
      driver.findElement(By.id("addAsigForm:idiomas")).sendKeys("chino");
      driver.findElement(By.id("addAsigForm:saveBtn")).click();
      
      try {
  		Thread.sleep(2000);
  		} catch (InterruptedException e) {}
      
      boolean t = false;
      List<WebElement> listSpn = driver.findElement(By.id("dt-products_data")).findElements(By.tagName("span"));
      for(WebElement x:listSpn) {
    	  if(x.getText().equals("Fisica")){
    		  t=true;
    		  break;
    	  }
      }
      assert(t==true);
      
  }
  
  @Test
  public void testModificarAsignatura() {

	driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	driver.findElement(By.id("login:user")).click();
	driver.findElement(By.id("login:user")).sendKeys("rafa");
	driver.findElement(By.id("login:pass")).sendKeys("1");
	driver.findElement(By.cssSelector(".ui-button-text")).click();
	driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudAsignaturas.xhtml");

	driver.findElement(By.id("dt-products:0:modificarBtn")).click();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {

	}
    
	driver.findElement(By.id("modificarForm:cod")).clear();
    driver.findElement(By.id("modificarForm:cod")).sendKeys("123");
    driver.findElement(By.id("modificarForm:nombre")).clear();
    driver.findElement(By.id("modificarForm:nombre")).sendKeys("Calc2");
    
	
	
    driver.findElement(By.id("modificarForm:SaveBtn")).click();
    
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {

	}
    
    assert(driver.findElement(By.id("dt-products:0:codigo")).getText().equals("123"));
    assert(driver.findElement(By.id("dt-products:0:nombre")).getText().equals("Calc2"));
    
  }
  
  @Test
  public void testEliminarAsignatura() {
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudAsignaturas.xhtml");
	    
	
	    
    driver.findElement(By.id("dt-products:0:eliminarBtn")).click();
    
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {

	}
    
    List<WebElement> elements = driver.findElements(By.id("dt-products:0:nombre"));
    assert(elements.size() == 0);
    
    

  }
  
}

