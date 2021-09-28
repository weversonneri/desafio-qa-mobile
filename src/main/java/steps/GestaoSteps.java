package steps;

import static utils.Utils.driver;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.GestaoPage;

public class GestaoSteps {

	GestaoPage gestao = new GestaoPage(driver);

	/*
	 * @Dado("que o usuario acessou o aplicativo") public void
	 * queOUsuarioAcessouOAplicativo() throws Exception { // mainclass.acessarApp();
	 * }
	 */

	@Quando("o usuario selecionar aba Tarefas")
	public void selecionaAbaTarefas() throws Exception {
		gestao.realizarLogin();
		gestao.selecionaAbaTarefas();
	}

	@E("clicar no botao de adicionar uma tarefa")
	public void clicaNoBotaoDeAdicionarUmaTarefa() throws Exception {
		gestao.adicionarTarefa();
	}

	@E("informar no campo Adicionar uma tarefa o texto {string}")
	public void informaNoCampoAdicionarUmaTarefaOTexto(String tarefa) throws Exception {
		gestao.nomaDaTarefa(tarefa);
	}

	@E("clicar no botao para Adicionar uma tarefa")
	public void clicaNoBotaoParaAdicionarUmaTarefa() throws Exception {
		gestao.cadastrarTarefa();
	}

	@Entao("o app adiciona a nova tarefa {string}")
	public void oAppAdicionaANovaTarefa(String tarefa) {
		gestao.validarCadastroTarefa(tarefa);
	}

}
