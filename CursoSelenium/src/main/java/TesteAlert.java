import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TesteAlert {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
	
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///C:/Users/Samsung/Desktop/Testes%20automatizados/automass%C3%A3o/CursoSelenium/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza() {
		driver.close();
	}
	
	
    @Test
	public void deveInteragirComAlertSimples() {
	
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Alert Simples", texto);
		dsl.escrever("elementosForm:nome", texto);
 }
	
	@Test
	public void deveInteragirComAlertConfirmar() {
	
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());

	}
	
	
//	@Test
//	public void deveInteragirComAlertCancelar() {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
//		driver.get("file:///C:/Users/Samsung/Desktop/Testes%20automatizados/automass%C3%A3o/CursoSelenium/src/main/resources/componentes.html");
//		
//		driver.findElement(By.id("confirm")).click();
//		Alert alert = driver.switchTo().alert();
//		String texto = alert.getText();
//		Assert.assertEquals("Confirm Simples", alert.getText());
//		alert.dismiss();
//		Assert.assertEquals("Negado", alert.getText());
//		alert.accept();
//		
//		driver.close();
//		
//		
//	}
	
	@Test
	public void deveInteragirComAlertPrompt() {
	
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());

}

	
	@Test
	public void deveFazerCadastro() {
		page.setNome("Julia");
	    page.setSobrenome("Flores");
	    page.setSexoFeminino();
	    page.setComidaCarne();
	    page.setEscolaridade("Mestrado");
	    page.setEsporte("Natacao");
	    page.cadastrar();
		
	    page.obterResultadoCadastro().startsWith("Cadastrado!");
	    page.obterNomeCadastro().endsWith("Julia");
	    Assert.assertEquals("Sobrenome: Flores", page.ObterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Feminino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastro());
		
	}
	
}