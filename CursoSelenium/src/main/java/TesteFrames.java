import static org.junit.Assert.assertEquals;

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


public class TesteFrames {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa(){
		driver = new ChromeDriver();
    	driver.manage().window().setSize(new Dimension(1200, 765));
    	driver.get("file:///C:/Users/Samsung/Desktop/Testes%20automatizados/automass%C3%A3o/CursoSelenium/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	
	}
	
//	@After
//	public void finaliza() {
//		driver.close();
//		
//	}
	@Test
    public void DeveInteragirComFrames() {
   
		dsl.entrarFrame("frame1");
        dsl.clicarBotao("frameButton");
	    String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
        dsl.sairFrame();
        dsl.escrever("elementosForm:nome", msg);
        dsl.fecharJanela();
}

	
	
	@Test
    public void DeveInteragirComJanelas() {
   
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.fecharJanela();
		dsl.trocarJanela("");
		dsl.escrever(By.tagName("textarea"), "e agora?");
		dsl.fecharJanela();
	
    
	}
	
	@Test
    public void DeveInteragirComJanelasSemTitulo() {
   
		
		dsl.clicarBotao("buttonPopUpHard");
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "e agora?");
		dsl.fecharJanela();

	 }
	
	@Test
    public void DeveInteragirDesafioNomeObrigatorio() {
    
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
		dsl.fecharJanela();
	}
	
	@Test
    public void DeveInteragirDesafioSobrenomeObrigatorio() {
    
		page.setNome("Nome qualquer");
	    page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
		dsl.fecharJanela();
    	
	}
    	
	@Test
    public void DeveInteragirDesafioSexoObrigatorio() {
 
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
	    page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
		dsl.fecharJanela();
	}
	
	@Test
    public void DeveInteragirDesafioComidaObrigatorio() {
    
		page.setNome("Nome Qualquer");
		page.setSobrenome("Sobrenome");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.cadastrar();
	   	Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	   	dsl.fecharJanela();
	   	
	}
	
	
	@Test
    public void DeveInteragirDesafioEsportesObrigatorio() {
   
		page.setNome("Nome Qualquer");
		page.setSobrenome("Sobrenome");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setEsporte("Karate", "O que eh esporte?");
		page.cadastrar();
		
    	Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
    	dsl.fecharJanela();
    	
	}
	
	public void EntrarnoSite() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Samsung/Desktop/Testes%20automatizados/automass%C3%A3o/CursoSelenium/src/main/resources/componentes.html");
		
		dsl.escrever("elementosForm:nome", "nome");
		dsl.fecharJanela();
	}
}