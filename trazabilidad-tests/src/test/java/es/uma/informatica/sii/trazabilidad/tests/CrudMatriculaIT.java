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
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
public class CrudMatriculaIT {
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
  public void crearMatricula() {
    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
    driver.manage().window().setSize(new Dimension(1367, 717));
    driver.findElement(By.id("login:user")).click();
    driver.findElement(By.id("login:user")).sendKeys("rafa");
    driver.findElement(By.id("login:pass")).sendKeys("1");
    driver.findElement(By.cssSelector(".ui-button-text")).click();
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudMatricula.xhtml");
    
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    
    driver.findElement(By.id("barraSup:crearBtn")).click();
    
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    
    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("crearForm:idExpediente")));
    
    driver.findElement(By.id("crearForm:idExpediente")).click();
    driver.findElement(By.id("crearForm:idExpediente")).sendKeys("1");
    driver.findElement(By.id("crearForm:curso_Academico")).sendKeys("2021");
    driver.findElement(By.id("crearForm:estado")).sendKeys("si");
    driver.findElement(By.id("crearForm:turno_Preferente")).sendKeys("tarde");
    driver.findElement(By.id("crearForm:fecha_Matricula")).sendKeys("2021/10/7");
    driver.findElement(By.id("crearForm:num_Archivo")).sendKeys("23");
    driver.findElement(By.id("crearForm:nuevo_Ingreso")).sendKeys("si");
    driver.findElement(By.id("crearForm:listado_de_Asignaturas")).click();
    driver.findElement(By.id("crearForm:listado_de_Asignaturas")).sendKeys("213");
    driver.findElement(By.id("crearForm:saveBtn")).click();
  }
  
  
  @Test
  public void VerMatricula() {
	  
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudMatricula.xhtml");
	    
	    
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
	    
	    
	    assertThat(driver.findElement(By.id("dt-products:0:idExpedienteOutput")).getText(), is("1"));
	    assertThat(driver.findElement(By.id("dt-products:0:curso_AcademicoOutput")).getText(), is("2021"));
	    assertThat(driver.findElement(By.id("dt-products:0:estadoOutput")).getText(), is("SI"));
	    assertThat(driver.findElement(By.id("dt-products:0:num_ArchivoOutput")).getText(), is("303"));
	    assertThat(driver.findElement(By.id("dt-products:0:turno_PreferenteOutput")).getText(), is("tarde"));
	    assertThat(driver.findElement(By.id("dt-products:0:fecha_MatriculaOutput")).getText(), is("2021/2/2"));
	    assertThat(driver.findElement(By.id("dt-products:0:nuevo_IngresoOutput")).getText(), is("SI"));
	    assertThat(driver.findElement(By.id("dt-products:0:listado_de_AsignaturasOutput")).getText(), is("109"));
	    
    
    
  }
  
  
  @Test
  public void modificarMatricula() throws InterruptedException {
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudMatricula.xhtml");
	    
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    
	    

		driver.findElement(By.id("dt-products:0:modificarBtn")).click();
		
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

	    try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}
	    
	    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("modificarForm:estado")));
		driver.findElement(By.id("modificarForm:estado")).click();
		driver.findElement(By.id("modificarForm:estado")).clear();
	    driver.findElement(By.id("modificarForm:estado")).sendKeys("NO");
	    driver.findElement(By.id("modificarForm:modificarBtn")).click();
	    
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		assertThat(driver.findElement(By.id("dt-products:0:estadoOutput")).getText(), is("NO"));
    
    

  }
  
  @Test
  public void eliminarMatricula() throws InterruptedException {
	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudMatricula.xhtml");
	    
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
	    
	    
    driver.findElement(By.id("dt-products:0:eliminarBtn")).click();
    
    driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS) ;
    
    Thread.sleep(5000);
    
    List<WebElement> elements = driver.findElements(By.id("dt-products:0:idExpedienteOutput"));
    assert(elements.size() == 0);
    
    

  }
}
