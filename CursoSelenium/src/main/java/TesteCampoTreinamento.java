import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	private WebDriver driver;
	private DSL dsl;
		
	@Before
	public void inicializa() {
	
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///C:/Users/Samsung/Desktop/Testes%20automatizados/automass%C3%A3o/CursoSelenium/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		
	}
	
	@After
	public void finaliza() {
		driver.close();
	}
	
	
	@Test
	public void testeTextField(){
		dsl.escrever("elementosForm:nome", "Teste escrita");
		Assert.assertEquals("Teste escrita", dsl.obterValorCampo("elementosForm:nome"));
		

		
	}
	
	@Test
	public void deveInteragirComTextArea() {
		dsl.escrever("elementosForm:sugestoes", "teste\n\nLinha nova\nUltima linha\nAcabou");
		Assert.assertEquals("teste\n\nLinha nova\nUltima linha\nAcabou", dsl.obterValorCampo("elementosForm:sugestoes"));
		
		
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
		
		
		
		
   }
	
	@Test
	public void deveInteragirComChecbox() {
	
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isCheckMarcado("elementosForm:comidaFavorita:2"));
	
   }
	
	@Test
	public void deveInteragirComCombo() {
		
		dsl.selecionarCombo("elementosForm:escolaridade", "Doutorado");
		Assert.assertEquals("Doutorado", dsl.obterValorCombo("elementosForm:escolaridade"));
		
}

	
	@Test
	public void deveVerificarValoresCombo() {
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
	
		
	}
	
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		List<String> opcoesMarcadas = dsl.obterValoresCambo("elementosForm:esportes");
		Assert.assertEquals(3, opcoesMarcadas.size());
		 
		dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCambo("elementosForm:esoportes");
		Assert.assertEquals(2, opcoesMarcadas.size());
		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
		
	}
	
	
//	@Test
//	public void deveVerifazerOqueQuiser() {
	//	WebDriver driver = new ChromeDriver();
	//	driver.manage().window().setSize(new Dimension(1200, 765));
	//	driver.get("file:///C:/Users/Samsung/Desktop/Testes%20automatizados/automass%C3%A3o/CursoSelenium/src/main/resources/componentes.html");
	//	driver.findElement(By.id("elementosForm:nome")).sendKeys("Francisco");
	//	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
	//	driver.findElement(By.id("elementosForm:sexo")).click();
	//	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
	//	WebElement element = driver.findElement(By.id("elementosForm:esportes"));
	//	Select combo = new Select(element);
	//	combo.selectByValue("futebol");
	//	driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Chupa essa cambada\nTamo junto");
	//	WebElement minharola = driver.findElement(By.id("elementosForm:escolaridade"));
	//	Select teucu = new Select(minharola);
	//	teucu.selectByValue("2grauincomp");
	
//	}
	
	@Test
	public void deveInteragirComBotoes() {
		
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
		
	}	
	
	@Test
	public void deveVInteragirComLinks() {
		
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));


	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
		
		
		
	}
	
}
	
