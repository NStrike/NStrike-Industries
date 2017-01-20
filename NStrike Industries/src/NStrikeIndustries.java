import java.util.Scanner;

public class NStrikeIndustries {
	
	public static Empregado inicializar(Empregado Funcionario){
		
			Funcionario.nome = null;
			Funcionario.endereco = null;
			Funcionario.tipo = 0;
			Funcionario.metodo = 0;
			Funcionario.sindicato = 0;
			Funcionario.salarioFixo = 0;
			Funcionario.comissaoTaxa = 0;
			Funcionario.sindicatoID = 0;
		
			return Funcionario;
		}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\t     Olá!\nBem-Vindo As Industrias NStrike!");
		System.out.println("\nInicializando Software Da Folha De Pagamento...");	
		System.out.println("\nSoftware Inicializado Com Sucesso!");
		
		Empregado[] Empregados = new Empregado[100];
		Empregado Cache = new Empregado();
		Empregado Troca = new Empregado();		
		
		int i;
		
		for(i = 0 ; i < 100 ; i++){
			
        	Empregados[i] = new Empregado();
        	Empregados[i] = inicializar(Empregados[i]);
        }		

		int Comando = 1, undo, redo, totalDeFuncionarios = 0, id = 0, confirmar;
		
		while(Comando > 0){
			System.out.println("\nComandos Dísponiveis No Programa:");
			System.out.println("\t1 - Cadastrar Novo Funcionário\n"
					+ "\t2 - Remover Funcionário Existente\n"
					+ "\t3 - Editar Funcionário Existente\n"
					+ "\t4 - Registro De Cartão De Ponto\n"
					+ "\t5 - Lançar Valor Venda Efetuada\n"
					+ "\t6 - Adicionar Taxa de Serviço\n"
					+ "\t7 - Rodar A Folha De Pagamento Para Hoje\n"
					+ "\t8 - Agenda De Pagamento\n"
					+ "\t9 - Criação De Novas Agendas De Pagamento\n");
			
			System.out.println("Digite Aqui Comando Que Deseja Executar:");
			Comando = scan.nextInt();
			scan.nextLine();
			Cache = inicializar(Cache);
			
			
			if(Comando == 1){
				
				if(totalDeFuncionarios == 100){
					System.out.println("Impossível Realizar Cadastro!\n"
							+ "Numero Limite De Vagas Foi Atingido");
				}
				
				else{
					
					totalDeFuncionarios++;
					i = 0;					
					while(Empregados[i].nome != null){
						i++;
					}
					
					System.out.println("Iniciando Cadastro...");
					System.out.println("\nInsira Os Dados Do Novo Funcionário:");
					System.out.println("Obs.: Não Insira Acentos e Não Haverá Distição Entre Letras Maius. e Minus.\n"
							+ "\nNome:");
					Empregados[i].nome = scan.nextLine();
					Cache.nome = Empregados[i].nome;
					
					System.out.println("Endereço:");
					Empregados[i].endereco = scan.nextLine();
					Cache.endereco = Empregados[i].endereco;
					
					System.out.println("Tipo De Funcionário:\n"
							+ "\t1 - Horista\n"
							+ "\t2 - Assalariado\n"
							+ "\t3 - Comissionado");
					Empregados[i].tipo = scan.nextInt();
					scan.nextLine();
					Cache.tipo = Empregados[i].tipo;
					
					System.out.println("Digite O Valor Fixo Do Salário Do Funcionário:");
					Empregados[i].salarioFixo = scan.nextFloat();
					scan.nextLine();
					Cache.salarioFixo = Empregados[i].salarioFixo;
					
					if(Empregados[i].tipo == 3){
							System.out.println("Digite O Percentual De Comissão Sobre As Vendas Realizadas:");
							Empregados[i].comissaoTaxa = scan.nextInt();
							scan.nextLine();
							Cache.comissaoTaxa = Empregados[i].comissaoTaxa;
					}
					
					System.out.println("Método De Pagamento:\n"
							+ "\t1 - Cheque Via Correios\n"
							+ "\t2 - Cheque Em Mãos\n"
							+ "\t3 - Déposito Bancário");
					Empregados[i].metodo = scan.nextInt();
					scan.nextLine();
					Cache.metodo = Empregados[i].metodo;
					
					System.out.println("Funcionário Pertence Ao Sindicato?\n"
							+ "\t1 - Sim\n"
							+ "\t2 - Não");
					Empregados[i].sindicato = scan.nextInt();
					scan.nextLine();
					Cache.sindicato = Empregados[i].sindicato;
					
					if(Empregados[i].sindicato == 1){

						System.out.println("Digite o ID Do Funcionário No Sindicato:");
						Empregados[i].sindicatoID = scan.nextInt();
						scan.nextLine();
						Cache.sindicatoID = Empregados[i].sindicatoID;					
					}
					
					System.out.printf("Funcionário %s Cadastrado Com Sucesso!\n", Empregados[i].nome);
					System.out.printf("Numero De Indentificação %02d\n", i);
				}
			}
			
			else if(Comando == 2){
				
				confirmar = 2;
				while(confirmar == 2){
					
					System.out.println("Digite o Numero De Identificação Do Funcionário Que Deseja Remover Do Sistema:");
					id = scan.nextInt();
					scan.nextLine();
					
					if(Empregados[id].nome == null){
						System.out.printf("Não Existe Nenhum Cadastro De Funcinário Com O ID(%d)\n");
					}
					
					else{
						
						System.out.printf("Deseja Remover O Funcionário %s?\n"
								+ "\t1 - Sim\n"
								+ "\t2 - Escolher Outro Funcionário\n", Empregados[id].nome);
						confirmar = scan.nextInt();
						scan.nextLine();
						
						if(confirmar == 1){
							totalDeFuncionarios--;
							Cache.nome = Empregados[id].nome;
							Cache.endereco = Empregados[id].endereco;
							Cache.tipo = Empregados[id].tipo;
							Cache.salarioFixo = Empregados[id].salarioFixo;
							Cache.comissaoTaxa = Empregados[id].comissaoTaxa;
							Cache.metodo = Empregados[id].metodo;
							Cache.sindicato = Empregados[id].sindicato;
							Cache.sindicatoID = Empregados[id].sindicatoID;
							Empregados[id] = inicializar(Empregados[id]);
							System.out.printf("Funcionário %s Removido Com Sucesso!\n", Cache.nome);
						}
					}	
				}				
			}
			
			else if(Comando == 3){				
				
				confirmar = 2;
				while(confirmar == 2){
					
					System.out.println("Insira O Numero De Identificação Do Funcionário Que Deseja Editar:");
					id = scan.nextInt();
					scan.nextLine();
					
					if(Empregados[id].nome == null){
						System.out.printf("Não Existe Nenhum Cadastro De Funcinário Com O ID(%d)\n");
					}
					
					else{
						
						System.out.printf("Deseja Editar O Nome Do Funcionário?\n"
								+ "Atual: %s\n"
								+ "\t1 - Sim\n"
								+ "\t2 - Não\n", Empregados[id].nome);
						confirmar = scan.nextInt();
						scan.nextLine();
						
						if(confirmar == 1){
							System.out.println("Digite Novo Nome Do Funcionário:");
							Cache.nome = Empregados[id].nome;
							Empregados[id].nome = scan.nextLine();
							System.out.println("Nome Do Funcionário Editado Com Sucesso!\n");
						}
						
						System.out.printf("Deseja Editar O Endereço Do Funcionário?\n"
								+ "Atual: %s\n"
								+ "\t1 - Sim\n"
								+ "\t2 - Não\n", Empregados[id].endereco);
						confirmar = scan.nextInt();
						scan.nextLine();
						
						if(confirmar == 1){
							System.out.println("Digite Novo Endereço Do Funcionário:");
							Cache.endereco = Empregados[id].endereco;
							Empregados[id].endereco = scan.nextLine();
							System.out.println("Endereço Do Funcionário Editado Com Sucesso!\n");
						}
						
						System.out.println("Deseja Editar O Tipo Do Funcionário?");
						switch(Empregados[id].tipo){
						case 1:
							System.out.println("Atual: 1 - Horista");
						case 2:
							System.out.println("Atual: 2 - Assalariado");
						case 3:
							System.out.println("Atual: 3 - Comissionado");
						}
						System.out.printf("\t1 - Sim\n"
								+ "\t2 - Não\n");
						confirmar = scan.nextInt();
						scan.nextLine();
						
						if(confirmar == 1){
							System.out.println("Escolha O Novo Tipo Do Funcionário:\n"
									+ "\t1 - Horista\n"
									+ "\t2 - Assalariado\n"
									+ "\t3 - Comissionado");
							Cache.tipo = Empregados[id].tipo;
							Empregados[id].tipo = scan.nextInt();
							System.out.println("Tipo Do Funcionário Editado Com Sucesso!\n");
						}
						
						System.out.println("Deseja Editar O Método De Pagamento?");
						switch(Empregados[id].metodo){
						case 1:
							System.out.println("Atual: 1 - Cheque Via Correios");
						case 2:
							System.out.println("Atual: 2 - Cheque Em Mãos");
						case 3:
							System.out.println("Atual: 3 - Déposito Bancário");
						}
						System.out.printf("\t1 - Sim\n"
								+ "\t2 - Não\n");
						confirmar = scan.nextInt();
						scan.nextLine();
						
						if(confirmar == 1){
							System.out.println("Escolha O Novo Método De Pagamento:\n"
									+ "\t1 - Cheque Via Correios\n"
									+ "\t2 - Cheque Em Mãos\n"
									+ "\t3 - Déposito Bancário");
							Cache.metodo = Empregados[id].metodo;
							Empregados[id].metodo = scan.nextInt();
							System.out.println("Método De Pagamento Editado Com Sucesso!\n");
						}
						
						System.out.println("Deseja Editar A Condição Sindical Do Funcionário?");
						switch(Empregados[id].sindicato){
						case 1:
							System.out.println("Atual: 1 - Sim");
						case 2:
							System.out.println("Atual: 2 - Não");

						}
						System.out.printf("\t1 - Sim\n"
								+ "\t2 - Não\n");
						confirmar = scan.nextInt();
						scan.nextLine();
						
						if(confirmar == 1){
							System.out.println("Escolha A Nova Condição Sindical Do Funcionário:\n"
									+ "\t1 - Sim\n"
									+ "\t2 - Não\n");
	
							Cache.sindicato = Empregados[id].sindicato;
							Empregados[id].sindicato = scan.nextInt();
							System.out.println("Condição Sindical Do Funcionário Editada Com Sucesso!\n");
						}
						
						System.out.printf("Deseja Editar Indentificação Sindical Do Funcionário?\n"
								+ "Atual %02d\n", Empregados[id].sindicatoID);
						
						System.out.printf("\t1 - Sim\n"
								+ "\t2 - Não\n");
						confirmar = scan.nextInt();
						scan.nextLine();
						
						if(confirmar == 1){
							System.out.println("Digite A Nova Indentificação Sindical Do Funcionário:\n"
									+ "\t1 - Sim\n"
									+ "\t2 - Não\n");
	
							Cache.sindicatoID = Empregados[id].sindicatoID;
							Empregados[id].sindicatoID = scan.nextInt();
							System.out.println("Indentificação Sindical Do Funcionário Editada Com Sucesso!\n");
						}
						
						System.out.println("\nSalvando Edições....");
						System.out.println("\nEdição De Funcionário Finalizada Com Sucesso!");
						
						confirmar = 1;
					}	
				}
			}
			
			else if(Comando == 4){
				
				;
			}
			
			else if(Comando == 5){
				
				confirmar = 1;
				
				while(confirmar != 3){
					System.out.println("Insira O Numero De Identificação Do Vendedor(Funcionário):");
					id = scan.nextInt();
					scan.nextLine();
					Cache.comissaoValor = Empregados[id].comissaoValor;
					
					if(Empregados[id].tipo != 3){
						System.out.printf("Funcionário %s Não É Comissionado\n\n", Empregados[id].nome);
					}
					
					else{
						
						System.out.printf("\nDado Do Funcionário\n"
								+ "Nome: %s\n\n", Empregados[id].nome);
						System.out.println("Insira O Valor Da Venda Efetuada:");
						System.out.print("R$ ");
						Empregados[id].comissaoValor += scan.nextInt();
						scan.nextLine();
						System.out.println("Venda Registrada Com Sucesso!");
						confirmar = 3;
					}
				}
			}
			
			else{
				System.out.println("\nSincronizando Alterações Locais Com Os Servidores...");
				System.out.println("\nEncerrando Software Da Folha De Pagamento...");
				System.out.println("\n\tObrigado Pela Preferência!");
			}
			
			if(Comando > 0 && Comando <= 7){
				System.out.println("\nDeseja Desfazer A Última Ação?");
				System.out.println("\t1 - Sim\n\t2 - Não");
				undo = scan.nextInt();
				
				if(undo == 1){
					
					Troca = inicializar(Troca);
					
					switch(Comando){
						
					case 1:
						Empregados[i] = inicializar(Empregados[i]);
						totalDeFuncionarios--;
						
					case 2:
						totalDeFuncionarios++;
						Empregados[id].nome = Cache.nome;
						Empregados[id].endereco = Cache.endereco;
						Empregados[id].tipo = Cache.tipo;
						Empregados[id].salarioFixo = Cache.salarioFixo;
						Empregados[id].comissaoTaxa = Cache.comissaoTaxa;
						Empregados[id].metodo = Cache.metodo;
						Empregados[id].sindicato = Cache.sindicato;
						Empregados[id].sindicatoID = Cache.sindicatoID;
						
					case 3:
						Troca.nome = Empregados[id].nome;
						Empregados[id].nome = Cache.nome;
						Cache.nome = Troca.nome;
						Troca.endereco = Empregados[id].endereco;
						Empregados[id].endereco = Cache.endereco;
						Cache.endereco = Troca.endereco;
						Troca.tipo = Empregados[id].tipo;
						Empregados[id].tipo = Cache.tipo;
						Cache.tipo = Troca.tipo;
						Troca.metodo = Empregados[id].metodo;
						Empregados[id].metodo = Cache.metodo;
						Cache.metodo = Troca.metodo;
						Troca.sindicato = Empregados[id].sindicato;
						Empregados[id].sindicato = Cache.sindicato;
						Cache.sindicato = Troca.sindicato;
						Troca.sindicatoID = Empregados[id].sindicatoID;
						Empregados[id].sindicatoID = Cache.sindicatoID;
						Cache.sindicatoID = Troca.sindicatoID;
						
					case 5:
						Troca.comissaoValor = Empregados[id].comissaoValor;
						Empregados[id].comissaoValor = Cache.comissaoValor;
						Cache.comissaoValor = Troca.comissaoValor;
					}					
					
					System.out.println("Deseja Refazer A Última Ação?");
					System.out.println("\t1 - Sim\n\t2 - Não");
					redo = scan.nextInt();
					
					if(redo == 1){
						
						switch(Comando){
						
						case 1:
							totalDeFuncionarios++;
							Empregados[i].nome = Cache.nome;
							Empregados[i].endereco = Cache.endereco;
							Empregados[i].tipo = Cache.tipo;
							Empregados[i].salarioFixo = Cache.salarioFixo;
							Empregados[i].comissaoTaxa = Cache.comissaoTaxa;
							Empregados[i].metodo = Cache.metodo;
							Empregados[i].sindicato = Cache.sindicato;
							Empregados[i].sindicatoID = Cache.sindicatoID;
							
						case 2:
							Empregados[id] = inicializar(Empregados[id]);
							totalDeFuncionarios--;
							
						case 3:
							Troca.nome = Empregados[id].nome;
							Empregados[id].nome = Cache.nome;
							Cache.nome = Troca.nome;
							Troca.endereco = Empregados[id].endereco;
							Empregados[id].endereco = Cache.endereco;
							Cache.endereco = Troca.endereco;
							Troca.tipo = Empregados[id].tipo;
							Empregados[id].tipo = Cache.tipo;
							Cache.tipo = Troca.tipo;
							Troca.metodo = Empregados[id].metodo;
							Empregados[id].metodo = Cache.metodo;
							Cache.metodo = Troca.metodo;
							Troca.sindicato = Empregados[id].sindicato;
							Empregados[id].sindicato = Cache.sindicato;
							Cache.sindicato = Troca.sindicato;
							Troca.sindicatoID = Empregados[id].sindicatoID;
							Empregados[id].sindicatoID = Cache.sindicatoID;
							Cache.sindicatoID = Troca.sindicatoID;
							
						case 5:
							Troca.comissaoValor = Empregados[id].comissaoValor;
							Empregados[id].comissaoValor = Cache.comissaoValor;
							Cache.comissaoValor = Troca.comissaoValor;
						}
						
					}
				}
			} // Undo/Redo
		}	

	}

}
