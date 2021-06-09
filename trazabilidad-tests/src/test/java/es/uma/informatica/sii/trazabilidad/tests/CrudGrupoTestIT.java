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

import es.uma.informatica.sii.anotaciones.Requisitos;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
public class CrudGrupoTestIT {
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
  @Requisitos({"RF12"})
  @Test
  public void crearGrupo() throws InterruptedException {
    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
    driver.manage().window().setSize(new Dimension(1371, 721));
    driver.findElement(By.id("login:user")).click();
    driver.findElement(By.id("login:user")).sendKeys("rafa");
    driver.findElement(By.id("login:pass")).sendKeys("1");
    driver.findElement(By.cssSelector(".ui-button-text")).click();
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudGrupos.xhtml");
    
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    
    driver.findElement(By.id("f:btnCrear")).click();
    
    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("addGForm:id")));

   
    driver.findElement(By.id("addGForm:id")).click();
    driver.findElement(By.id("addGForm:id")).sendKeys("1");
    driver.findElement(By.id("addGForm:curso")).click();
    driver.findElement(By.id("addGForm:curso")).sendKeys("2");
    driver.findElement(By.id("addGForm:letra")).sendKeys("a");
    driver.findElement(By.id("addGForm:ingles")).sendKeys("si");
    driver.findElement(By.id("addGForm:visible")).sendKeys("no");
    driver.findElement(By.id("addGForm:turno")).sendKeys("tarde");
    driver.findElement(By.id("addGForm:asignar")).sendKeys("si");
    driver.findElement(By.id("addGForm:plazas")).sendKeys("5");
    driver.findElement(By.id("addGForm:letra1")).sendKeys("b");
    driver.findElement(By.id("addGForm:savebtn")).click();
  }
  @Requisitos({"RF12"})
  @Test
  public void VerGrupo() throws InterruptedException {
	  
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudGrupos.xhtml");
	    
	   
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
	    
	    assertThat(driver.findElement(By.id("dt-products:0:idd")).getText(), is("23"));
	    assertThat(driver.findElement(By.id("dt-products:0:curso")).getText(), is("3"));
	    assertThat(driver.findElement(By.id("dt-products:0:letra")).getText(), is("a"));
	    assertThat(driver.findElement(By.id("dt-products:0:turno")).getText(), is("tarde"));
	    assertThat(driver.findElement(By.id("dt-products:0:ingles")).getText(), is("si"));
	    assertThat(driver.findElement(By.id("dt-products:0:visible")).getText(), is("si"));
	    assertThat(driver.findElement(By.id("dt-products:0:asignar")).getText(), is("si"));
	    assertThat(driver.findElement(By.id("dt-products:0:plazas")).getText(), is("50"));
	    assertThat(driver.findElement(By.id("dt-products:0:letra1")).getText(), is("a"));
	    
    
    
  }
  @Requisitos({"RF12"})
  @Test
  public void modificarGrupo() throws InterruptedException {
	  
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudGrupos.xhtml");
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    
	    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}

	driver.findElement(By.id("dt-products:0:modificarBtn")).click();
	
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
    
    driver.findElement(By.id("modificarForm:curso")).click();
	driver.findElement(By.id("modificarForm:curso")).clear();
    driver.findElement(By.id("modificarForm:curso")).sendKeys("99");
    driver.findElement(By.id("modificarForm:savebtn")).click();
    
    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
    
    assertThat(driver.findElement(By.id("dt-products:0:curso")).getText(), is("99"));
    
   
  }
  
  @Requisitos({"RF12"})
  @Test
  public void eliminarGrupo() throws InterruptedException {
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudGrupos.xhtml");
	    
	
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

	    
    driver.findElement(By.id("dt-products:0:deleteBtn")).click();
    
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

    
    List<WebElement> elements = driver.findElements(By.id("dt-products:1:curso"));
    assert(elements.size() == 0);
    
    

  }
  
}
