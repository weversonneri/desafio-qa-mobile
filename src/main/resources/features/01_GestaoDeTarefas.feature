#language: pt 
#encoding: UTF-8

Funcionalidade: Gestor de Tarefas

			Eu enquanto usuário
			Necessito organizar minhas tarefas
			Para que eu consiga planejar a execução da mesma durante o dia			

	@criarTarefa	
	Cenario: Criar nova tarefa
		Quando o usuario selecionar aba Tarefas
		E clicar no botao de adicionar uma tarefa
		E informar no campo Adicionar uma tarefa o texto "Comprar ração pro 🐶"
		E clicar no botao para Adicionar uma tarefa
		Entao o app adiciona a nova tarefa "Comprar ração pro 🐶"
		
		