import java.util.Scanner;

public class NStrikeIndustries {
	
	public static Empregado inicializar(Empregado Funcionario){
		
			Funcionario.nome = null;
			Funcionario.endereco = null;
			Funcionario.tipo = 0;
			Funcionario.metodo = 0;
			Funcionario.sindicato = 0;
			Funcionario.salarioFixo = 0;
			Funcionario.comissao = 0;
			Funcionario.salarioTotal = 0;
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
		Cache = inicializar(Cache);
		
		int i;
		
		for(i = 0 ; i < 100 ; i++){
			
        	Empregados[i] = new Empregado();
        	Empregados[i] = inicializar(Empregados[i]);
        }		

		int Comando = 1, undo, redo, totalDeFuncionarios = 0, id = 0;
		
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
					Empregados[i].salarioFixo = scan.nextInt();
					scan.nextLine();
					Cache.salarioFixo = Empregados[i].salarioFixo;
					
					if(Empregados[i].tipo == 3){
							System.out.println("Digite O Percentual De Comissão Sobre As Vendas Realizadas:");
							Empregados[i].comissao = scan.nextInt();
							scan.nextLine();
							Cache.comissao = Empregados[i].comissao;
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
					System.out.printf("Numero De Indentificação %02d \n\n", i);
				}
			}
			
			else if(Comando == 2){
				
				int confirmar = 2;
				while(confirmar == 2){
					
					System.out.println("Digite o ID Do Funcionário Que Deseja Remover Do Sistema:");
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
							Cache.comissao = Empregados[id].comissao;
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
				
				;
			}
			
			else{
				System.out.println("\nSincronizando Alterações Locais Com Os Servidores...");
				System.out.println("\nEncerrando Software Da Folha De Pagamento...");
				System.out.println("\n\tObrigado Pela Preferência!");
			}
			
			if(Comando > 0 && Comando <= 7){
				System.out.println("Deseja Desfazer A Última Ação?");
				System.out.println("\t1 - Sim\n\t2 - Não");
				undo = scan.nextInt();
				
				if(undo == 1){
					
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
						Empregados[id].comissao = Cache.comissao;
						Empregados[id].metodo = Cache.metodo;
						Empregados[id].sindicato = Cache.sindicato;
						Empregados[id].sindicatoID = Cache.sindicatoID;
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
							Empregados[i].comissao = Cache.comissao;
							Empregados[i].metodo = Cache.metodo;
							Empregados[i].sindicato = Cache.sindicato;
							Empregados[i].sindicatoID = Cache.sindicatoID;
							
						case 2:
							Empregados[id] = inicializar(Empregados[id]);
							totalDeFuncionarios--;
						}
						
					}
				}
			} // Undo/Redo
		}	

	}

}
