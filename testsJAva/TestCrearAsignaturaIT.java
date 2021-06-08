// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
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
public class TestCrearAsignaturaTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testCrearAsignatura() {
    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/loginAdmin.xhtml");
    driver.manage().window().setSize(new Dimension(1277, 820));
    driver.findElement(By.id("login:user")).click();
    driver.findElement(By.id("login:user")).sendKeys("rafa");
    driver.findElement(By.id("login:pass")).sendKeys("1");
    driver.findElement(By.id("login:pass")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector("#btnAsignaturas > .ui-button-text")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#btnAsignaturas > .ui-button-text"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector("#barraSup\\3A crearAsigBtn > .ui-button-text")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#barraSup\\3A crearAsigBtn > .ui-button-text"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("j_idt54:referencia")).click();
    driver.findElement(By.id("j_idt54:referencia")).sendKeys("4");
    driver.findElement(By.id("j_idt54:cod")).sendKeys("25");
    driver.findElement(By.id("j_idt54:creditos")).sendKeys("8");
    driver.findElement(By.id("j_idt54:ofertada")).sendKeys("si");
    driver.findElement(By.id("j_idt54:nombre")).sendKeys("javier");
    driver.findElement(By.id("j_idt54:curso")).sendKeys("2");
    driver.findElement(By.id("j_idt54:caaracter")).sendKeys("online");
    driver.findElement(By.id("j_idt54:duracion")).sendKeys("3");
    driver.findElement(By.id("j_idt54:idiomas")).sendKeys("idjfc");
    driver.findElement(By.id("j_idt54:cp")).sendKeys("0");
    driver.findElement(By.id("j_idt54:idiomas")).click();
    driver.findElement(By.id("j_idt54:saveBtn")).click();
    driver.findElement(By.id("j_idt54:idiomas")).sendKeys("chino");
  }
}
