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

import es.uma.informatica.sii.anotaciones.Requisitos;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
public class ImportarCsvIT {
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
  @Requisitos({"RF01"})
  @Test
  public void testImportarCsv() {
	  PrintWriter out;
	  try {
		  out = new PrintWriter("/home/alumno/Escritorio/samplealumnos.csv");
		  out.println("Curso Académico:;2020/2021;;;;;;;;;;;;;;;;;;;;;;;");
		  out.println("Tipo Estudio:;Grado;;;;;;;;;;;;;;;;;;;;;;;");
		  out.println("Estado Matrícula:;Activa;;;;;;;;;;;;;;;;;;;;;;;");
		  out.println("DOCUMENTO;NOMBRE;1º APELLIDO;2º APELLIDO;Nº EXPEDIENTE;Nº ARCHIVO;EMAIL_INSTITUCIONAL;EMAIL_PERSONAL;TELEFONO;MOVIL;DIRECCION_NOTIFICACION;LOCALIDAD_NOTIFICACION;PROVINCIA_NOTIFICACION;CP_NOTIFICACION;FECHA_MATRICULA;TURNO_PREFERENTE;GRUPOS_ASIGNADOS;NOTA_MEDIA;CREDITOS_SUPERADOS;CREDITOS_FB;CREDITOS_OB;CREDITOS_OP;CREDITOS_CF;CREDITOS_PE;CREDITOS_TF");
		  out.println("7;Carmelita;Enríquez;Navarro;7;1;06104200001@uma.es;CarmelitaEnriquezNavarro@gustr.com;795 115 697;795 115 697;Ventanilla de Beas 72;Ourol;MÁLAGA;27865;22/09/2020 15:06;Mañana;207-,208-,306-,402-,403-,404-,405-,803-;6.32;150;60;78;12;0;0;0"); 
		  out.println("8;Gregorina;Gómez;Pabon;8;3060002002;06104100002@uma.es;GregorinaGomezPabon@fleckens.hu;783 582 041;783 582 041;La Fontanilla 73;Pedroche;MÁLAGA;14412;20/09/2020 15:07;Mañana;101-,103-,105-,109-,110-,202-,204-,205-,206-,208-,209-;6.28;24;24;0;0;0;0;0");
		  out.println("9;Amarilia;Espino;Melgar;9;30600330003;06105600003@uma.es;AmariliaEspinoMelgar@jourrapide.com;602 758 528;602 758 528;C/ Libertad 44;Mijares;MÁLAGA;5461;18/09/2020 12:27;Mañana;332-,414-,415-,416-,830-,831-,832-,833-,930-,931-,932-;6.47;183;60;72;51;0;0;0");
		  out.println("10;Loreta;Anaya;Rojas;10;3443;06104200004@uma.es;LoretaAnayaRojas@jourrapide.com;769 575 980;769 575 980;C/ Cuevas de Ambrosio 20;Bailén;MÁLAGA;23710;02/09/2020 14:45;Mañana;101-,102-,103-,104-,105-,106-,107-,108-,109-,110-;5.8;12;12;0;0;0;0;0");
		  out.println("11;Otelo;Menéndez;Mendoza;11;435;06104100005@uma.es;OteloMenendezMendoza@jourrapide.com;637 106 003;637 106 003;Urzáiz 90;Ocaña;MÁLAGA;45300;20/09/2020 16:13;Mañana;101-,102-,105-,202-,205-,206-,207-,208-,209-,210-;6.07;42;36;6;0;0;0;0");
		  out.close();
	} catch (FileNotFoundException e) {

	}


      // Close the file.

	  driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
	    driver.findElement(By.id("login:user")).click();
	    driver.findElement(By.id("login:user")).sendKeys("rafa");
	    driver.findElement(By.id("login:pass")).sendKeys("1");
	    driver.findElement(By.cssSelector(".ui-button-text")).click();
	    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/vistaSecretaria.xhtml");
	    
	    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      WebElement element = driver.findElement(By.id("uplFrm1:uplInput_input"));
      element.sendKeys("/home/alumno/Escritorio/samplealumnos.csv");
      
      try {
		Thread.sleep(3000);
      } catch (InterruptedException e) {
      }
      
      List<WebElement> listBtn = driver.findElements(By.tagName("button"));
      for(WebElement w:listBtn) {
    	  String s = w.getAttribute("disabled");
    	  if(s == null) {
        	  if(w.getText().equals("Upload")){
        		  w.click();
        		  break;
        	  }
    	  }
      }
      try {
		Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      
      driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudAlumnos.xhtml");
      
      try {
  			Thread.sleep(3000);
  		} catch (InterruptedException e) {
  		}
      boolean b = false;
      List<WebElement> listSpn = driver.findElement(By.id("dt-products_data")).findElements(By.tagName("span"));
      for(WebElement x:listSpn) {
    	  if(x.getText().equals("LoretaAnayaRojas@jourrapide.com")){
    		  b=true;
    	  }
      }
      assert(b==true);
      
  }
}

