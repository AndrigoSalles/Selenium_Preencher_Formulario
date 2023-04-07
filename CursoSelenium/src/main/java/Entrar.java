import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Entrar {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
	
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///C:/Users/Samsung/Desktop/Testes%20automatizados/automass%C3%A3o/CursoSelenium/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		
	}
	
	
	@Test
	public void testeTexFieldss(){
		dsl.escrever("elementosForm:nome", "qualquer nome");
	  	dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
	   	dsl.clicarRadio("elementosForm:sexo:1");
	   	dsl.clicarRadio("elementosForm:comidaFavorita:0");
	   	dsl.clicarRadio("elementosForm:comidaFavorita:3");
	   	dsl.clicarRadio("elementosForm:cadastrar");
	   	Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTexto());
}
	@Test
	public void testeSegundo() {
		driver.findElement(By.id("buttonPopUpHard")).click();
 	    System.out.println(driver.getWindowHandle());
      	System.out.println(driver.getWindowHandles());
      	dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "e agora?");
	
	}
			
	@Test
	public void Desafio() {
		dsl.escrever("elementosForm:nome", "Andrigo");
		Assert.assertEquals("Andrigo", dsl.obterValorCampo("elementosForm:nome"));
		driver.findElement(By.id("elementosForm:nome")).clear();
		dsl.escrever("elementosForm:nome", "Julia");
		Assert.assertEquals("Julia", dsl.obterValorCampo("elementosForm:nome"));

	}
	@Test
	public void Desafio1() {
		dsl.escrever("elementosForm:nome", "Andrigo");
		Assert.assertEquals("Andrigo", dsl.obterValorCampo("elementosForm:nome"));
		
		dsl.escrever("elementosForm:nome", "Julia");
		Assert.assertEquals("Julia", dsl.obterValorCampo("elementosForm:nome"));
		
	}
	

}
