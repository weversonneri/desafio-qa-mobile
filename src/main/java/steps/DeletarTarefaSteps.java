package steps;

import static utils.Utils.driver;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.GestaoPage;

public class DeletarTarefaSteps {

	GestaoPage gestao = new GestaoPage(driver);

	@Quando("o usuario selecionar a tarefa")
	public void oUsuarioSelecionarATarefa() throws Exception {
		gestao.selecionarTarefa();
	}

	@E("clicar no botao de excluir")
	public void clicarNoBotaoDeExcluir() {
		gestao.clicarExcluirTarefa();
	}

	@E("confirmar a exclusao")
	public void confirmarAExclusao() {
		gestao.confirmarExcluirTarefa();
	}

	@Entao("o app exclui a tarefa")
	public void oAppExcluiATarefa() {
		gestao.validarExcluirTarefa();
	}

}
