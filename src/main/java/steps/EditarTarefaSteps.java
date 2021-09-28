package steps;

import static utils.Utils.driver;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.GestaoPage;

public class EditarTarefaSteps {

	GestaoPage gestao = new GestaoPage(driver);

	@Quando("o usuario selecionar a tarefa a ser alterada")
	public void oUsuarioSelecionarATarefaQueDesejaAlterar() throws Exception {
		gestao.selecionarTarefa();
	}

	@E("alterar o titulo para {string}")
	public void alterarOTituloPara(String titulo) throws Exception {
		gestao.alterarTituloDaTarefa(titulo);
	}

	@E("alterar a data de conclusao da tarefa")
	public void alterarADataDeConclusaoDaTarefa() throws Exception {
		gestao.editarDataDaTarefa();
	}

	@E("alterar a anotacao para {string}")
	public void alterarAAnotacaoPara(String nota) throws Exception {
		gestao.editarNotaDaTarefa(nota);
	}

	@Entao("o app altera a nota com o titulo {string}")
	public void oAppAlteraANotaComOTitulo(String titulo) {
		gestao.validarEdicaoDaTarefa(titulo);
	}

}
