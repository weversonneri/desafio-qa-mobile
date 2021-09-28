#language: pt 
#encoding: UTF-8

Funcionalidade: Editar Tarefas

	@editarTarefa	
	Cenario: Alterar uma tarefa
		Quando o usuario selecionar a tarefa a ser alterada
		E alterar o titulo para "Deixar o carro no lava-jato 🚗"
		E alterar a data de conclusao da tarefa
		E alterar a anotacao para "Remover itens pessoais antes"
		Entao o app altera a nota com o titulo "Deixar o carro no lava-jato 🚗"

		
		