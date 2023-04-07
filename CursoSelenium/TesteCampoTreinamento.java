import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;

public class TesteCampoTreinamento {

	@Test
    public void testeTextField(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///C:/Users/Samsung/Desktop/Testes%20automatizados/automass%C3%A3o/CursoSelenium/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).click();
        driver.findElement(By.id("elementosForm:nome")).sendKeys("teste de escrita33");
        Assert.assertEquals("teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        
		
				
			
	}
}
