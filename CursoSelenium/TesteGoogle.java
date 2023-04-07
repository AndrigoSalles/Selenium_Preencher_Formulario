import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	@Test
	public void teste() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).type("escrever");
		
		
		@Test
		public void testeTextField(){
			WebDriver driver = new ChromeDriver()
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///C:/Users/Samsung/Desktop/Testes%20automatizados/automass%C3%A3o/CursoSelenium/src/main/resources/componentes.html");
			driver.findElement(By.id("elementosForm:nome")).type("escrever");
			Assert.assertEquals("teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value");
		
		
	}
}
