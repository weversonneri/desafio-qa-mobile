#language: pt 
#encoding: UTF-8

Funcionalidade: Excluir Tarefas
		
	@excluirTarefa	
	Cenario: Excluir uma tarefa
		Quando o usuario selecionar a tarefa
		E clicar no botao de excluir
		E confirmar a exclusao
		Entao o app exclui a tarefa
		
		
		