import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.lang.model.element.Parameterizable;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TesteRegraCadastro {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String mensagem;
	
	@Before
	public void inicializa(){
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
	
	@Parameters
    public static Collection<Object[]> getcoCollection() {
    	return Arrays.asList(new Object[][] {
    		{"", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio"},
    		{"Andrigo", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio"},
    		{"Andrigo", "Salles", "", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio"},
    		{"Andrigo", "Salles", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[] {}, "Tem certeza que voce eh vegetariano?"},
    		{"Andrigo", "Salles", "Masculino", Arrays.asList("Carne"), new String[] {"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
    	});
    }
    
	@Test
    public void DeveValidarRegras() {

	page.setNome(nome);
	page.setSobrenome(sobrenome);
	if(sexo.equals("Masculino")) {
		page.setSexoMasculino();
	}
	if(sexo.equals("Feminino")) {
		page.setSexoFeminino();
	}
	if(comidas.contains("Carne")) page.setComidaCarne();
	if(comidas.contains("Pizza")) page.setComidaPizza();
	if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
	if(comidas.contains("Frango")) page.setComidaFrango();
	page.setEsporte(esportes);
	page.cadastrar();
	System.out.println(mensagem);
	Assert.assertEquals(mensagem, dsl.alertaObterTextoEAceita());
	
	
}
	}

