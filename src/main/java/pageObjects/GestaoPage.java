package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Utils.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GestaoPage {

	public GestaoPage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.microsoft.todos:id/email_phone_edit_text")
	private MobileElement campoEmail;

	@AndroidFindBy(id = "com.microsoft.todos:id/sign_in_button")
	private MobileElement botaoEntrarEmail;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement campoSenha;

	@AndroidFindBy(accessibility = "Entrar")
	private MobileElement botaoEntrarSenha;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Tarefas']")
	private MobileElement abaTarefas;

	@AndroidFindBy(id = "com.microsoft.todos:id/new_todo_fab")
	private MobileElement novaTarefa;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Adicionar uma tarefa']")
	private MobileElement textoNovaTarefa;

	@AndroidFindBy(id = "com.microsoft.todos:id/create_task_image_button")
	private MobileElement criarNovaTarefa;

	@AndroidFindBy(id = "com.microsoft.todos:id/task_content")
	private MobileElement tarefaSelecionada;

	@AndroidFindBy(id = "com.microsoft.todos:id/note_card")
	private MobileElement clicarCampoAnotacao;

	@AndroidFindBy(id = "com.microsoft.todos:id/note")
	private MobileElement textoCampoAnotacao;

	@AndroidFindBy(id = "android:id/home")
	private MobileElement retornarEdicao;

	@AndroidFindBy(id = "com.microsoft.todos:id/back")
	private MobileElement retornarHome;

	@AndroidFindBy(id = "com.microsoft.todos:id/duedate_textview")
	private MobileElement editarData;

	@AndroidFindBy(xpath = "//android.widget.TextView[1]")
	private MobileElement selecionarData;

	@AndroidFindBy(id = "com.microsoft.todos:id/delete")
	private MobileElement botaoExcluir;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement botaoConfirmarExcluir;
	
	@AndroidFindBy(id = "com.microsoft.todos:id/empty_state_text")
	private MobileElement listaDeTarefasVazia;

	public void preencheCampoEmail(String email) throws Exception {

		campoEmail.sendKeys(email);

		botaoEntrarEmail.click();
	}

	public void preencheCampoSenha(String senha) throws Exception {

		System.out.println("campo senha selecionado");
		campoSenha.sendKeys(senha);

		botaoEntrarSenha.click();

	}

	public void realizarLogin() throws Exception {
		preencheCampoEmail("mosekan988@hotmail.com");
		preencheCampoSenha("testestefanini2021");

	}

	public void selecionaAbaTarefas() throws Exception {
		abaTarefas.click();
	}

	public void adicionarTarefa() throws Exception {
		novaTarefa.click();
	}

	public void nomaDaTarefa(String tarefa) throws Exception {
		textoNovaTarefa.sendKeys(tarefa);
	}

	public void cadastrarTarefa() throws Exception {
		criarNovaTarefa.click();
	}

	public void validarCadastroTarefa(String tarefa) {
		System.out.println("VALIDAÇÃO: adicionar tarefa - " + tarefa);

		MobileElement validacao = (MobileElement) driver.findElement(MobileBy.xpath("//*[@text='" + tarefa + "']"));

		assertEquals(tarefa, validacao.getText());
	}

	///// Editar tarefa

	public void selecionarTarefa() throws Exception {
		realizarLogin();
		selecionaAbaTarefas();

		tarefaSelecionada.click();

	}

	public void alterarTituloDaTarefa(String titulo) throws Exception {
		MobileElement selecionaTitulo = (MobileElement) driver
				.findElement(MobileBy.xpath("//android.widget.TextView[2]"));
		selecionaTitulo.click();

		MobileElement alteraTitulo = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.EditText"));
		alteraTitulo.sendKeys(titulo);

	}

	public void editarDataDaTarefa() throws Exception {
		editarData.click();
		selecionarData.click();
	}

	public void editarNotaDaTarefa(String nota) throws Exception {
		clicarCampoAnotacao.click();
		textoCampoAnotacao.sendKeys(nota);
		retornarEdicao.click();
	}

	public void validarEdicaoDaTarefa(String titulo) {
		MobileElement tituloAlterado = (MobileElement) driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + titulo + "']"));
		System.out.println("VALIDAÇÃO: editar tarefa - " + tituloAlterado.getText());

		assertEquals(titulo, tituloAlterado.getText());

		retornarHome.click();
	}

	// excluir tarefa

	public void clicarExcluirTarefa() {
		botaoExcluir.click();

	}

	public void confirmarExcluirTarefa() {
		botaoConfirmarExcluir.click();

	}

	public void validarExcluirTarefa() {
		assertTrue(listaDeTarefasVazia.isDisplayed());
		System.out.println("VALIDAÇÃO: TAREFA EXCLUIDA - " + listaDeTarefasVazia.isDisplayed());

	}

}
