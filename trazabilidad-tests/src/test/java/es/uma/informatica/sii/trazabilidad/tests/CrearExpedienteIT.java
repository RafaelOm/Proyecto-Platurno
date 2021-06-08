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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CrearExpedienteIT {
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
  
  
  @Test
  public void VerExpediente() {
	  
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudExpedientes.xhtml");
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    
	    assertThat(driver.findElement(By.id("dt-products:0:expedienteOutPut")).getText(), is("1"));
	    assertThat(driver.findElement(By.id("dt-products:0:activoOutPut")).getText(), is("SI"));
	    assertThat(driver.findElement(By.id("dt-products:0:notamprOutPut")).getText(), is("1.0"));
	    assertThat(driver.findElement(By.id("dt-products:0:creditosSupOutPut")).getText(), is("1.0"));
	    assertThat(driver.findElement(By.id("dt-products:0:creditosFBOutPut")).getText(), is("1.0"));
	    assertThat(driver.findElement(By.id("dt-products:0:creditosOPOutPut")).getText(), is("1.0"));
	    assertThat(driver.findElement(By.id("dt-products:0:creditosOBOutPut")).getText(), is("1.0"));
	    assertThat(driver.findElement(By.id("dt-products:0:creditosCFOutPut")).getText(), is("1.0"));
	    assertThat(driver.findElement(By.id("dt-products:0:creditosPEOutPut")).getText(), is("1.0"));
	    assertThat(driver.findElement(By.id("dt-products:0:creditostfOutPut")).getText(), is("1.0"));
	    assertThat(driver.findElement(By.id("dt-products:0:n_archivoOutPut")).getText(), is("agua"));
    
    
  }
  
  @Test
  public void crearExpedienteIT() {
    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
    driver.manage().window().setSize(new Dimension(1367, 717));
    driver.findElement(By.id("login:pass")).sendKeys("1");
    driver.findElement(By.id("login:pass")).click();
    driver.findElement(By.id("login:user")).click();
    driver.findElement(By.id("login:user")).sendKeys("rafa");
    driver.findElement(By.cssSelector(".ui-button-text")).click();
    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudExpedientes.xhtml");
    
    
    
    
    
    driver.findElement(By.id("barraSup:crearBtn")).click();
    
    try {
		Thread.sleep(7000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    driver.findElement(By.id("rellenarDatos:expediente")).click();
    driver.findElement(By.id("rellenarDatos:expediente")).sendKeys("1");
    driver.findElement(By.id("rellenarDatos:activo")).click();
    driver.findElement(By.id("rellenarDatos:activo")).sendKeys("si");
    driver.findElement(By.id("rellenarDatos:notampr")).click();
    driver.findElement(By.id("rellenarDatos:notampr")).sendKeys("1");
    driver.findElement(By.id("rellenarDatos:creditosSup")).click();
    driver.findElement(By.id("rellenarDatos:creditosSup")).sendKeys("1");
    driver.findElement(By.id("rellenarDatos:creditosfb")).click();
    driver.findElement(By.id("rellenarDatos:creditosfb")).sendKeys("1");
    driver.findElement(By.id("rellenarDatos:creditosop")).click();
    driver.findElement(By.id("rellenarDatos:creditosop")).sendKeys("1");
    driver.findElement(By.id("rellenarDatos:creditosob")).click();
    driver.findElement(By.id("rellenarDatos:creditosob")).sendKeys("1");
    driver.findElement(By.id("rellenarDatos:creditoscf")).click();
    driver.findElement(By.id("rellenarDatos:creditoscf")).sendKeys("1");
    driver.findElement(By.id("rellenarDatos:creditospe")).click();
    driver.findElement(By.id("rellenarDatos:creditospe")).sendKeys("1");
    driver.findElement(By.id("rellenarDatos:creditostf")).click();
    driver.findElement(By.id("rellenarDatos:creditostf")).sendKeys("1");
    driver.findElement(By.id("rellenarDatos:n_archivo")).click();
    driver.findElement(By.id("rellenarDatos:n_archivo")).sendKeys("1");
    driver.findElement(By.name("rellenarDatos:guardar")).click();
  }
  
  
  @Test
  public void modificarAlumno() throws InterruptedException {
	  
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudExpedientes.xhtml");

	driver.findElement(By.id("dt-products:0:modificarBtn")).click();

	Thread.sleep(3000);
	
    driver.findElement(By.id("modificarForm:activo")).click();
	driver.findElement(By.id("modificarForm:activo")).clear();
    driver.findElement(By.id("modificarForm:activo")).sendKeys("No");

    driver.findElement(By.id("modificarForm:modificar")).click();
    
    Thread.sleep(3000);
    
    assertThat(driver.findElement(By.id("dt-products:0:activoOutPut")).getText(), is("No"));
    
   
  }
  
  
  @Test
  public void eliminarAlumno() throws InterruptedException {
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudExpedientes.xhtml");
	    
	
	    
	    
    driver.findElement(By.id("dt-products:0:eliminarBtn")).click();
    
    Thread.sleep(3000);
    
    List<WebElement> elements = driver.findElements(By.id("dt-products:0:activoOutPut"));
    assert(elements.size() == 0);
    
    

  }
}
