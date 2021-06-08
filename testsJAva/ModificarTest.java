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
public class ModificarTest {
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
  public void modificar() {
    driver.get("http://0.0.0.0:8080/trazabilidad-war/faces/crudAlumnos.xhtml");
    driver.manage().window().setSize(new Dimension(1277, 626));
    driver.findElement(By.cssSelector(".pi-pencil")).click();
    driver.findElement(By.id("modificarForm:direccion")).click();
    driver.findElement(By.id("modificarForm:direccion")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("modificarForm:direccion")).sendKeys(Keys.UP);
    driver.findElement(By.id("modificarForm:direccion")).click();
    driver.findElement(By.id("modificarForm:direccion")).sendKeys("calle carranza");
    driver.findElement(By.cssSelector("#modificarForm\\3AmodificarDialogBtn > .ui-button-text")).click();
    driver.findElement(By.cssSelector("td:nth-child(7)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("calle carranza"));
  }
}
