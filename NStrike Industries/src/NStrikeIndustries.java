import java.util.Scanner;

public class NStrikeIndustries {
	
	public static Empregado inicializar(Empregado Funcionario){
		
			Funcionario.nome = null;
			Funcionario.endereco = null;
			
			Funcionario.tipo = 0;
			Funcionario.agenda = 0;
			Funcionario.agendaNova = 0;
			Funcionario.comissaoTaxa = 0;
			Funcionario.salarioFixo = 0;
			
			Funcionario.metodo = 0;
			
			Funcionario.sindicato = 0;
			Funcionario.sindicatoFlag = 0;
			Funcionario.sindicatoID = 0;
			Funcionario.sindicatoTaxa = 0;			
			
			Funcionario.comissaoValor = 0;
			Funcionario.salarioTotal = 0;
			Funcionario.horasDia = 0;
			Funcionario.horasTotal = 0;
			Funcionario.horasExtras = 0;
		
			return Funcionario;
		}
	
	public static int[] novoDia(int[] Data){
		
		Data[0] += 1;		
		
		if(Data[0] > 30){
			Data[0] = 1;
			Data[1] += 1;
		}
		
		if(Data[1] > 12)
		{
			Data[1] = 1;
			Data[2] += 1;
		}
		
		Data[3] += 1;
	
		return Data;
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
		
		int[] Data = new int[4];
		Data[0] = 1;
		Data[1] = 1;
		Data[2] = 2017;
		Data[3] = 7;
		
		String[] Semana = new String[7];
		Semana[0] = "Domingo";
		Semana[1] = "Segunda-Feira";
		Semana[2] = "Terça-Feira";
		Semana[3] = "Quarta-Feira";
		Semana[4] = "Quinta-Feira";
		Semana[5] = "Sexta-Feira";
		Semana[6] = "Sábado";
		
		
		while(Comando > 0){
			System.out.printf("\nData: %02d/%02d/%d\n", Data[0], Data[1], Data[2]);
			System.out.printf("%s\n", Semana[Data[3]%7]);
			
			System.out.println("\nDigite No Console O Número Do Comando Que Deseja Executar:");
			System.out.println("\t0 - Encerrar Programa\n"
					+ "\t1 - Cadastrar Novo Funcionário\n"
					+ "\t2 - Remover Funcionário Existente\n"
					+ "\t3 - Editar Funcionário Existente\n"
					+ "\t4 - Registro De Cartão De Ponto\n"
					+ "\t5 - Lançar Valor Venda Efetuada\n"
					+ "\t6 - Adicionar Taxa de Serviço\n"
					+ "\t7 - Rodar A Folha De Pagamento Para Hoje\n"
					+ "\t8 - Alterar Agenda De Pagamento Do Funcionário\n"
					+ "\t9 - Criação De Novas Agendas De Pagamento\n"
					+ "\t10 - Lista De Funcionários Cadastrados\n");
			
			System.out.println("Digite Aqui Comando Que Deseja Executar:");
			Comando = scan.nextInt();
			scan.nextLine();
			Cache = inicializar(Cache);
			
			
			if(Comando == 1){
				
				if(totalDeFuncionarios == 100){
					System.out.println("\tImpossível Realizar Cadastro!\n"
							+ "\tNumero Limite De Vagas Foi Atingido");
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
					Empregados[i].agenda = Empregados[i].tipo;
					Cache.agenda = Empregados[i].agenda;
					
					System.out.print("Digite O Valor Fixo Do Salário Do Funcionário:\n"
							+ "R$ ");
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
						
						System.out.println("Digite A Taxa Sindical A Ser Retirada Do Salário Mensal Do Funcionário:\n"
								+ "R$ ");
						Empregados[i].sindicatoTaxa = scan.nextInt();
						scan.nextLine();
						Cache.sindicatoTaxa = Empregados[i].sindicatoTaxa;
						Cache.salarioTotal = Empregados[i].salarioTotal;
						Empregados[i].salarioTotal -= Empregados[i].sindicatoTaxa;
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
						System.out.printf("Não Existe Nenhum Cadastro De Funcinário Com O ID(%02d)\n",id);
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
							Cache.agenda = Empregados[id].agenda;
							Cache.agendaNova = Empregados[id].agendaNova;
							Cache.comissaoTaxa = Empregados[id].comissaoTaxa;
							Cache.salarioFixo = Empregados[id].salarioFixo;
																				
							Cache.metodo = Empregados[id].metodo;
							
							Cache.sindicato = Empregados[id].sindicato;
							Cache.sindicatoFlag = Empregados[id].sindicatoFlag;
							Cache.sindicatoID = Empregados[id].sindicatoID;
							Cache.sindicatoTaxa = Empregados[id].sindicatoTaxa;							
							
							Cache.comissaoValor = Empregados[id].comissaoValor;
							Cache.salarioTotal = Empregados[id].salarioTotal;
							
							Cache.horasDia = Empregados[id].horasDia;
							Cache.horasTotal = Empregados[id].horasTotal;
							Cache.horasExtras = Empregados[id].horasExtras;
							
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
						System.out.printf("Não Existe Nenhum Cadastro De Funcinário Com O ID(%02d)\n",id);
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
							break;							
						case 2:
							System.out.println("Atual: 2 - Assalariado");
							break;							
						case 3:
							System.out.println("Atual: 3 - Comissionado");
							break;							
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
							scan.nextLine();
							
							System.out.print("Digite O Valor Do Novo Do Salário:\n"
									+ "R$ ");
							Cache.salarioFixo = Empregados[i].salarioFixo;
							Empregados[i].salarioFixo = scan.nextFloat();
							scan.nextLine();
							
							if(Empregados[i].tipo == 3){
									System.out.println("Digite O Percentual De Comissão Sobre As Vendas Realizadas:");
									Cache.comissaoTaxa = Empregados[i].comissaoTaxa;
									Empregados[i].comissaoTaxa = scan.nextInt();
									scan.nextLine();
							}
							System.out.println("Tipo Do Funcionário Editado Com Sucesso!\n");
						}
						
						System.out.println("Deseja Editar O Método De Pagamento?");
						switch(Empregados[id].metodo){
						case 1:
							System.out.println("Atual: 1 - Cheque Via Correios");
							break;							
						case 2:
							System.out.println("Atual: 2 - Cheque Em Mãos");
							break;							
						case 3:
							System.out.println("Atual: 3 - Déposito Bancário");
							break;							
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
							break;
						case 2:
							System.out.println("Atual: 2 - Não");
							break;

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
						
						if(Empregados[id].sindicato == 1){
							
							System.out.printf("Deseja Editar Indentificação Sindical Do Funcionário?\n"
									+ "Atual %02d\n", Empregados[id].sindicatoID);
							
							System.out.printf("\t1 - Sim\n"
									+ "\t2 - Não\n");
							confirmar = scan.nextInt();
							scan.nextLine();
							
							if(confirmar == 1){
								System.out.println("Digite A Nova Indentificação Sindical Do Funcionário:");	
								Cache.sindicatoID = Empregados[id].sindicatoID;
								Empregados[id].sindicatoID = scan.nextInt();
								System.out.println("Indentificação Sindical Do Funcionário Editada Com Sucesso!\n");
							}
							
							System.out.printf("Deseja Editar A Taxa Sindical Do Funcionário?\n"
									+ "Atual %.2f\n", Empregados[id].sindicatoTaxa);
							
							System.out.println("\t1 - Sim\n"
									+ "\t2 - Não");
							confirmar = scan.nextInt();
							scan.nextLine();
							
							if(confirmar == 1){
								System.out.println("Digite A Nova Taxa Sindical Do Funcionário:\n");
								Cache.sindicatoTaxa = Empregados[id].sindicatoTaxa;
								Empregados[id].sindicatoTaxa = scan.nextFloat();
								Cache.salarioTotal = Empregados[id].salarioTotal;
								Empregados[id].salarioTotal = 0 - Empregados[id].sindicatoTaxa;
								Cache.sindicatoFlag = Empregados[id].sindicatoFlag;
								Empregados[id].sindicatoFlag = 0;
								System.out.println("Taxa Sindical Do Funcionário Editada Com Sucesso!\n");
							}
						}
						
						System.out.println("\nSalvando Edições....");
						System.out.println("\nEdição De Funcionário Finalizada Com Sucesso!");
						
						confirmar = 1;
					}	
				}
			}
			
			else if(Comando == 4){
				
				confirmar = 0;
				
				while(confirmar != 1){
					System.out.println("Insira O Numero De Identificação Do Funcionário:");
					id = scan.nextInt();
					scan.nextLine();				
					
					if(Empregados[id].nome == null){
						System.out.printf("Não Existe Nenhum Cadastro De Funcinário Com O ID(%02d)\n", id);
					}
					
					else{
						
						if(Empregados[id].tipo != 1){
							System.out.printf("Funcionário %s Não É Horista\n\n", Empregados[id].nome);
						}
						
						else{
							Cache.horasDia = Empregados[id].horasDia;
							Cache.horasExtras = Empregados[id].horasExtras;
							confirmar = Empregados[id].tipo;
							int entradaHoras;
							
							System.out.printf("\nDado Do Funcionário\n"
									+ "Nome: %s\n\n", Empregados[id].nome);
							System.out.println("Insira O Total De Horas Trabalhadas:");
							entradaHoras = scan.nextInt();
							scan.nextLine();
							
							if(Empregados[id].horasDia == 8){
								Empregados[id].horasExtras += entradaHoras;
							}
							
							else if((Empregados[id].horasDia + entradaHoras) <= 8){
								Empregados[id].horasDia += entradaHoras;
							}
							
							else{
								while(Empregados[id].horasDia < 8){
									Empregados[id].horasDia++;
									entradaHoras--;
								}
								Empregados[id].horasExtras += entradaHoras;
							}
							
							System.out.println("Ponto Registrado Com Sucesso!");
						}
					}
				}
			}
			
			else if(Comando == 5){
				
				confirmar = 0;
				
				while(confirmar != 3){
					System.out.println("Insira O Numero De Identificação Do Vendedor(Funcionário):");
					id = scan.nextInt();
					scan.nextLine();
					
					if(Empregados[id].nome == null){
						System.out.printf("Não Existe Nenhum Cadastro De Funcinário Com O ID(%02d)\n",id);
					}
					
					else{
						if(Empregados[id].tipo != 3){
							System.out.printf("Funcionário %s Não É Comissionado\n\n", Empregados[id].nome);
						}
						
						else{
							Cache.comissaoValor = Empregados[id].comissaoValor;
							confirmar = Empregados[id].tipo;
							
							System.out.printf("\nDado Do Funcionário\n"
									+ "Nome: %s\n\n", Empregados[id].nome);
							System.out.println("Insira O Valor Da Venda Efetuada:");
							System.out.print("R$ ");
							Empregados[id].comissaoValor += scan.nextInt();
							scan.nextLine();
							System.out.println("Venda Registrada Com Sucesso!");
						}
					}
				}
			}
			
			else if(Comando == 6){
				confirmar = 0;
				
				while(confirmar != 1){
					System.out.println("Insira O Numero De Identificação Do Funcionário:");
					id = scan.nextInt();
					scan.nextLine();
					
					if(Empregados[id].nome == null){
						System.out.printf("Não Existe Nenhum Cadastro De Funcinário Com O ID(%02d)\n", id);
					}
					
					else{
						if(Empregados[id].sindicato != 1){
							System.out.printf("Funcionário %s Não Pertence Ao Sindicato\n\n", Empregados[id].nome);
						}
						
						else{
							confirmar = Empregados[id].tipo;
							Cache.salarioTotal = Empregados[id].salarioTotal;
							
							System.out.printf("\nDado Do Funcionário\n"
									+ "Nome: %s\n\n", Empregados[id].nome);
							System.out.println("Insira O Valor Da Taxa De Serviço A Ser Adicionada:");
							System.out.print("R$ ");							
							Empregados[id].salarioTotal -= scan.nextInt();
							scan.nextLine();
							System.out.println("Taxa Adicionada Com Sucesso!");
						}
					}
				}
			}
			
			else if(Comando == 7){
				for(i = 0 ; i < 100 ; i++){
					Empregados[i].salarioTotalCache = Empregados[i].salarioTotal;
					switch(Empregados[i].agenda){
					case 1://Semanal
						if(Data[3] % 7 == 5){ 
							switch(Empregados[i].tipo){
							case 1://Horista
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasTotal;
								Empregados[i].horasTotalCache = Empregados[i].horasTotal;
								Empregados[i].horasTotal = 0;
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasDia;
								Empregados[i].horasDiaCache = Empregados[i].horasDia;
								Empregados[i].horasDia = 0;
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * 1.5 * Empregados[i].horasExtras;
								Empregados[i].horasExtrasCache = Empregados[i].horasExtras;
								Empregados[i].horasExtras = 0;								
									
								break;
							case 2://Assalariado
								Empregados[i].salarioTotal += (Empregados[i].salarioFixo/30) * 7;
								break;
							case 3://Comissionado
								Empregados[i].salarioTotal += (Empregados[i].salarioFixo/30) * 7;
								Empregados[i].salarioTotal += Empregados[i].comissaoValor * (Empregados[i].comissaoTaxa/100);
								Empregados[i].comissaoValorCache = Empregados[i].comissaoValor;
								Empregados[i].comissaoValor = 0;
								break;	
							}
							
							System.out.printf("\nDados Do Funcionário Pago\n"
									+ "Nome: %s\n"
									+ "Numero De Identificação: %02d\n"
									+ "Valor %.2f\n", Empregados[i].nome, i, Empregados[i].salarioTotal);
							Empregados[i].salarioTotal = 0;
							switch(Empregados[i].metodo){
							case 1:
								System.out.println("Método De Pagamento: Cheque Via Correios");
								break;							
							case 2:
								System.out.println("Método De Pagamento: Cheque Em Mãos");
								break;							
							case 3:
								System.out.println("Método De Pagamento: Déposito Bancário");
								break;
							}
						}
						break;
						
					case 2://Mensal
						if(Data[0]  == 30){
							switch(Empregados[i].tipo){
							case 1://Horista
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasTotal;
								Empregados[i].horasTotalCache = Empregados[i].horasTotal;
								Empregados[i].horasTotal = 0;
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasDia;
								Empregados[i].horasDiaCache = Empregados[i].horasDia;
								Empregados[i].horasDia = 0;
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * 1.5 * Empregados[i].horasExtras;
								Empregados[i].horasExtrasCache = Empregados[i].horasExtras;
								Empregados[i].horasExtras = 0;
								break;
							case 2://Assalariado
								Empregados[i].salarioTotal += Empregados[i].salarioFixo;
								break;
							case 3://Comissionado
								Empregados[i].salarioTotal += Empregados[i].salarioFixo;
								Empregados[i].salarioTotal += Empregados[i].comissaoValor * (Empregados[i].comissaoTaxa/100);
								Empregados[i].comissaoValorCache = Empregados[i].comissaoValor;
								Empregados[i].comissaoValor = 0;
								break;	
							}
							
							System.out.printf("\nDados Do Funcionário Pago\n"
									+ "Nome: %s\n"
									+ "Numero De Identificação: %02d\n"
									+ "Valor %.2f\n", Empregados[i].nome, i, Empregados[i].salarioTotal);
							Empregados[i].salarioTotal = 0;
							switch(Empregados[i].metodo){
							case 1:
								System.out.println("Método De Pagamento: Cheque Via Correios");
								break;							
							case 2:
								System.out.println("Método De Pagamento: Cheque Em Mãos");
								break;							
							case 3:
								System.out.println("Método De Pagamento: Déposito Bancário");
								break;
							}
						}
						
						else{
							if(Data[3] % 7 == 5){
								if(Data[0]  == 28 || Data[0]  == 29){
									switch(Empregados[i].tipo){
									case 1://Horista
										Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasTotal;
										Empregados[i].horasTotalCache = Empregados[i].horasTotal;
										Empregados[i].horasTotal = 0;
										Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasDia;
										Empregados[i].horasDiaCache = Empregados[i].horasDia;
										Empregados[i].horasDia = 0;
										Empregados[i].salarioTotal += Empregados[i].salarioFixo * 1.5 * Empregados[i].horasExtras;
										Empregados[i].horasExtrasCache = Empregados[i].horasExtras;
										Empregados[i].horasExtras = 0;

										break;
									case 2://Assalariado
										Empregados[i].salarioTotal += Empregados[i].salarioFixo;
										break;
									case 3://Comissionado
										Empregados[i].salarioTotal += Empregados[i].salarioFixo;
										Empregados[i].salarioTotal += Empregados[i].comissaoValor * (Empregados[i].comissaoTaxa/100);
										Empregados[i].comissaoValorCache = Empregados[i].comissaoValor;
										Empregados[i].comissaoValor = 0;
										break;	
									}
									
									System.out.printf("\nDados Do Funcionário Pago\n"
											+ "Nome: %s\n"
											+ "Numero De Identificação: %02d\n"
											+ "Valor %.2f\n", Empregados[i].nome, i, Empregados[i].salarioTotal);
									Empregados[i].salarioTotal = 0;
									switch(Empregados[i].metodo){
									case 1:
										System.out.println("Método De Pagamento: Cheque Via Correios");
										break;							
									case 2:
										System.out.println("Método De Pagamento: Cheque Em Mãos");
										break;							
									case 3:
										System.out.println("Método De Pagamento: Déposito Bancário");
										break;
									}
								}								
							}
						}
						break;
						
					case 3:// Bi-Semanal
						
						if(Data[3] % 7 == 5){
							if((Data[3] / 7) % 2 == 0){
								switch(Empregados[i].tipo){
								case 1://Horista
									Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasTotal;
									Empregados[i].horasTotalCache = Empregados[i].horasTotal;
									Empregados[i].horasTotal = 0;
									Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasDia;
									Empregados[i].horasDiaCache = Empregados[i].horasDia;
									Empregados[i].horasDia = 0;
									Empregados[i].salarioTotal += Empregados[i].salarioFixo * 1.5 * Empregados[i].horasExtras;
									Empregados[i].horasExtrasCache = Empregados[i].horasExtras;
									Empregados[i].horasExtras = 0;
									break;
								case 2://Assalariado
									Empregados[i].salarioTotal += (Empregados[i].salarioFixo/30) * 14;
									break;
								case 3://Comissionado
									Empregados[i].salarioTotal += (Empregados[i].salarioFixo/30) * 14;
									Empregados[i].salarioTotal += Empregados[i].comissaoValor * (Empregados[i].comissaoTaxa/100);
									Empregados[i].comissaoValorCache = Empregados[i].comissaoValor;
									Empregados[i].comissaoValor = 0;
									break;	
								}
								
								System.out.printf("\nDados Do Funcionário Pago\n"
										+ "Nome: %s\n"
										+ "Numero De Identificação: %02d\n"
										+ "Valor %.2f\n", Empregados[i].nome, i, Empregados[i].salarioTotal);
								Empregados[i].salarioTotal = 0;
								switch(Empregados[i].metodo){
								case 1:
									System.out.println("Método De Pagamento: Cheque Via Correios");
									break;							
								case 2:
									System.out.println("Método De Pagamento: Cheque Em Mãos");
									break;							
								case 3:
									System.out.println("Método De Pagamento: Déposito Bancário");
									break;
								}
							}							
						}
						break;
						
					case 4://Semanal Segunda
						if(Data[3] % 7 == 1){ 
							switch(Empregados[i].tipo){
							case 1://Horista
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasTotal;
								Empregados[i].horasTotalCache = Empregados[i].horasTotal;
								Empregados[i].horasTotal = 0;
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasDia;
								Empregados[i].horasDiaCache = Empregados[i].horasDia;
								Empregados[i].horasDia = 0;
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * 1.5 * Empregados[i].horasExtras;
								Empregados[i].horasExtrasCache = Empregados[i].horasExtras;
								Empregados[i].horasExtras = 0;
								break;
							case 2://Assalariado
								Empregados[i].salarioTotal += (Empregados[i].salarioFixo/30) * 7;
								break;
							case 3://Comissionado
								Empregados[i].salarioTotal += (Empregados[i].salarioFixo/30) * 7;
								Empregados[i].salarioTotal += Empregados[i].comissaoValor * (Empregados[i].comissaoTaxa/100);
								Empregados[i].comissaoValorCache = Empregados[i].comissaoValor;
								Empregados[i].comissaoValor = 0;
								break;	
							}
							
							System.out.printf("\nDados Do Funcionário Pago\n"
									+ "Nome: %s\n"
									+ "Numero De Identificação: %02d\n"
									+ "Valor %.2f\n", Empregados[i].nome, i, Empregados[i].salarioTotal);
							Empregados[i].salarioTotal = 0;
							switch(Empregados[i].metodo){
							case 1:
								System.out.println("Método De Pagamento: Cheque Via Correios");
								break;							
							case 2:
								System.out.println("Método De Pagamento: Cheque Em Mãos");
								break;							
							case 3:
								System.out.println("Método De Pagamento: Déposito Bancário");
								break;
							}
						}
						break;	
						
					case 5://Semanal Quarta
						if(Data[3] % 7 == 3){ 
							switch(Empregados[i].tipo){
							case 1://Horista
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasTotal;
								Empregados[i].horasTotalCache = Empregados[i].horasTotal;
								Empregados[i].horasTotal = 0;
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasDia;
								Empregados[i].horasDiaCache = Empregados[i].horasDia;
								Empregados[i].horasDia = 0;
								Empregados[i].salarioTotal += Empregados[i].salarioFixo * 1.5 * Empregados[i].horasExtras;
								Empregados[i].horasExtrasCache = Empregados[i].horasExtras;
								Empregados[i].horasExtras = 0;
								break;
							case 2://Assalariado
								Empregados[i].salarioTotal += (Empregados[i].salarioFixo/30) * 7;
								break;
							case 3://Comissionado
								Empregados[i].salarioTotal += (Empregados[i].salarioFixo/30) * 7;
								Empregados[i].salarioTotal += Empregados[i].comissaoValor * (Empregados[i].comissaoTaxa/100);
								Empregados[i].comissaoValorCache = Empregados[i].comissaoValor;
								Empregados[i].comissaoValor = 0;
								break;	
							}
							
							System.out.printf("\nDados Do Funcionário Pago\n"
									+ "Nome: %s\n"
									+ "Numero De Identificação: %02d\n"
									+ "Valor %.2f\n", Empregados[i].nome, i, Empregados[i].salarioTotal);
							Empregados[i].salarioTotal = 0;
							switch(Empregados[i].metodo){
							case 1:
								System.out.println("Método De Pagamento: Cheque Via Correios");
								break;							
							case 2:
								System.out.println("Método De Pagamento: Cheque Em Mãos");
								break;							
							case 3:
								System.out.println("Método De Pagamento: Déposito Bancário");
								break;
							}
						}
						break;
						
					
					
				case 6:// Mensal 1
					
					if(Data[0] == 1){
						switch(Empregados[i].tipo){
						case 1://Horista
							Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasTotal;
							Empregados[i].horasTotalCache = Empregados[i].horasTotal;
							Empregados[i].horasTotal = 0;
							Empregados[i].salarioTotal += Empregados[i].salarioFixo * Empregados[i].horasDia;
							Empregados[i].horasDiaCache = Empregados[i].horasDia;
							Empregados[i].horasDia = 0;
							Empregados[i].salarioTotal += Empregados[i].salarioFixo * 1.5 * Empregados[i].horasExtras;
							Empregados[i].horasExtrasCache = Empregados[i].horasExtras;
							Empregados[i].horasExtras = 0;
							break;
						case 2://Assalariado
							Empregados[i].salarioTotal += Empregados[i].salarioFixo;
							break;
						case 3://Comissionado
							Empregados[i].salarioTotal += Empregados[i].salarioFixo;
							Empregados[i].salarioTotal += Empregados[i].comissaoValor * (Empregados[i].comissaoTaxa/100);
							Empregados[i].comissaoValorCache = Empregados[i].comissaoValor;
							Empregados[i].comissaoValor = 0;
							break;	
						}
						
						System.out.printf("\nDados Do Funcionário Pago\n"
								+ "Nome: %s\n"
								+ "Numero De Identificação: %02d\n"
								+ "Valor %.2f\n", Empregados[i].nome, i, Empregados[i].salarioTotal);
						Empregados[i].salarioTotal = 0;
						switch(Empregados[i].metodo){
						case 1:
							System.out.println("Método De Pagamento: Cheque Via Correios");
							break;							
						case 2:
							System.out.println("Método De Pagamento: Cheque Em Mãos");
							break;							
						case 3:
							System.out.println("Método De Pagamento: Déposito Bancário");
							break;
						}
					}					
					
					break;					
					}
				}
			}	
					
				
					
			
			else if(Comando == 8){
				confirmar = 2;
				while(confirmar == 2){
					
					System.out.println("Digite o Numero De Identificação Do Funcionário Que Sofrerá Alteração Na Agenda De Pagamento:");
					id = scan.nextInt();
					scan.nextLine();
					
					if(Empregados[id].nome == null){
						System.out.printf("Não Existe Nenhum Cadastro De Funcinário Com O ID(%d)\n", id);
					}
					
					else{
						System.out.println("Status Da Agenda De Pagamento:");
						
						switch(Empregados[id].agenda){
						case 1:
							System.out.println("Atual: 1 - Semanal");
							break;
						case 2:
							System.out.println("Atual: 2 - Mensal");
							break;
						case 3:	
							System.out.println("Atual: 3 - Bi-Semanal");
							break;
						case 4:
							System.out.println("Atual: 4 - Semanal Segunda");
							break;
						case 5:
							System.out.println("Atual: 5 - Semanal Quarta");
							break;
						case 6:
							System.out.println("Atual: 6 - Mensal 1");
							break;
						}
						
							
						System.out.printf("Deseja Alterar A Agenda De Pagamento Do Funcionário %s?\n"
								+ "\t1 - Sim\n"
								+ "\t2 - Escolher Outro Funcionário\n", Empregados[id].nome);
						confirmar = scan.nextInt();
						scan.nextLine();
						
						if(confirmar == 1){
							System.out.println("Escolha A Nova Agenda De Pagamento Do Funcionário:\n"
									+ "\t1 - Semanal\n"
									+ "\t2 - Mensal\n"
									+ "\t3 - Bi-Semanal");
							if(Empregados[id].agendaNova == 1){
								System.out.println("\t4 - Semanal Segunda\n"
										+ "\t5 - Semanal Quarta\n"
										+ "\t6 - Mensal 1");
							}
							Empregados[id].agenda =  scan.nextInt();
							scan.nextLine();
							
							System.out.println("Agenda De Pagamento Alterada Com Sucesso!");
						}
					}			
						
				}
			}
			
			else if(Comando == 9){
				confirmar = 0;
				
				while(confirmar != 1){
					System.out.println("Digite o Numero De Identificação Do Funcionário Que Receberá Uma Nova Agenda De Pagamento:");
					id = scan.nextInt();
					scan.nextLine();
					
					if(Empregados[id].nome == null){
						System.out.printf("Não Existe Nenhum Cadastro De Funcinário Com O ID(%02d)\n", id);
					}
					
					else if(Empregados[id].agendaNova == 1){
						System.out.printf("Funcionário %s Já Posuo A Extenção Com As Novas Agendas De Pagamento\n"
								+ "\t1 - Retornar Ao Painel De Comandos\n"
								+ "\t2 - Escolher Outro Funcionário\n", Empregados[id].nome);
						confirmar = scan.nextInt();
						scan.nextLine();
					}
					
					else{						
						System.out.println("Novas Agendas De Pagamento Disponíveis:\n"
								+ "\t4 - Semanal Segunda\n"
								+ "\t5 - Semanal Quarta\n"
								+ "\t6 - Mensal 1");
						
						System.out.printf("Deseja Ativar A Extenção Com Novas Agendas De Pagamento No Funcionário %s?\n"
								+ "\t1 - Sim\n"
								+ "\t2 - Não\n", Empregados[id].nome);
						Empregados[id].agendaNova = scan.nextInt();
						scan.nextLine();
						confirmar = Empregados[id].agendaNova;
						
						if(confirmar == 1){
							System.out.println("Extenção Das Agenda De Pagamento Ativada Com Sucesso!");
						}	
					}
				}
			}
			
			else if(Comando == 10){
				for(i = 0 ; i < 100 ; i++){
					if(Empregados[i].nome != null){
						System.out.printf("Nome:%s  ID[%02d]\n", Empregados[i].nome, i);
					}
				}
			}
			
			else if(Comando > 10){
				System.out.println("\nComando Inválido\n");
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
						break;
						
					case 2:
						totalDeFuncionarios++;
						Empregados[id].nome = Cache.nome;
						Empregados[id].endereco = Cache.endereco;
						
						Empregados[id].tipo = Cache.tipo;
						Empregados[id].agenda = Cache.agenda;
						Empregados[id].agendaNova = Cache.agendaNova;
						Empregados[id].comissaoTaxa = Cache.comissaoTaxa;						
						Empregados[id].salarioFixo = Cache.salarioFixo;
						
						Empregados[id].metodo = Cache.metodo;
						
						Empregados[id].sindicato = Cache.sindicato;
						Empregados[id].sindicatoFlag = Cache.sindicatoFlag;
						Empregados[id].sindicatoID = Cache.sindicatoID;
						Empregados[id].sindicatoTaxa = Cache.sindicatoTaxa;
						
						Empregados[id].comissaoValor = Cache.comissaoValor;
						Empregados[id].salarioTotal = Cache.salarioTotal;
								
						Empregados[id].horasDia = Cache.horasDia;
						Empregados[id].horasTotal = Cache.horasTotal;
						Empregados[id].horasExtras = Cache.horasExtras;
						
						break;
						
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
						Troca.comissaoTaxa = Empregados[id].comissaoTaxa;
						Empregados[id].comissaoTaxa = Cache.comissaoTaxa;
						Cache.comissaoTaxa = Troca.comissaoTaxa;
						Troca.salarioFixo = Empregados[id].salarioFixo;
						Empregados[id].salarioFixo = Cache.salarioFixo;
						Cache.salarioFixo = Troca.salarioFixo;
						Troca.salarioTotal = Empregados[id].salarioTotal;
						Empregados[id].salarioTotal = Cache.salarioTotal;
						Cache.salarioTotal = Troca.salarioTotal;
						
						Troca.metodo = Empregados[id].metodo;
						Empregados[id].metodo = Cache.metodo;
						Cache.metodo = Troca.metodo;
						
						Troca.sindicato = Empregados[id].sindicato;
						Empregados[id].sindicato = Cache.sindicato;
						Cache.sindicato = Troca.sindicato;
						Troca.sindicatoFlag = Empregados[id].sindicatoFlag;
						Empregados[id].sindicatoFlag = Cache.sindicatoFlag;
						Cache.sindicatoFlag = Troca.sindicatoFlag;
						Troca.sindicatoID = Empregados[id].sindicatoID;
						Empregados[id].sindicatoID = Cache.sindicatoID;
						Cache.sindicatoID = Troca.sindicatoID;
						Troca.sindicatoTaxa = Empregados[id].sindicatoTaxa;
						Empregados[id].sindicatoTaxa = Cache.sindicatoTaxa;
						Cache.sindicatoTaxa = Troca.sindicatoTaxa;
						break;
						
					case 4:
						Troca.horasDia = Empregados[id].horasDia;
						Empregados[id].horasDia = Cache.horasDia;
						Cache.horasDia = Troca.horasDia;
						Troca.horasTotal = Empregados[id].horasTotal;
						Empregados[id].horasTotal = Cache.horasTotal;
						Cache.horasTotal = Troca.horasTotal;
						Troca.horasExtras = Empregados[id].horasExtras;
						Empregados[id].horasExtras = Cache.horasExtras;
						Cache.horasExtras = Troca.horasExtras;
						break;
						
					case 5:
						Troca.comissaoValor = Empregados[id].comissaoValor;
						Empregados[id].comissaoValor = Cache.comissaoValor;
						Cache.comissaoValor = Troca.comissaoValor;
						break;
						
					case 6:
						Troca.salarioTotal = Empregados[id].salarioTotal;
						Empregados[id].salarioTotal = Cache.salarioTotal;
						Cache.salarioTotal = Troca.salarioTotal;
						break;
						
					case 7:
						for(i = 0 ; i < 100 ; i++){
							Troca.salarioTotal = Empregados[i].salarioTotal;
							Empregados[i].salarioTotal = Empregados[i].salarioTotalCache;
							Empregados[i].salarioTotalCache = Troca.salarioTotal;
							switch(Empregados[i].agenda){
							
							case 1://Semanal
								if(Data[3] % 7 == 5){ 
									switch(Empregados[i].tipo){
									case 1://Horista
										Troca.horasDia = Empregados[i].horasDia;
										Empregados[i].horasDia = Empregados[i].horasDiaCache;
										Empregados[i].horasDiaCache = Troca.horasDia;
										Troca.horasTotal = Empregados[i].horasTotal;
										Empregados[i].horasTotal = Empregados[i].horasTotalCache;
										Empregados[i].horasTotalCache = Troca.horasTotal;	
										Troca.horasExtras = Empregados[i].horasExtras;
										Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
										Empregados[i].horasExtrasCache = Troca.horasExtras;
										break;
									case 2://Assalariado
										break;
									case 3://Comissionado
										Troca.comissaoValor = Empregados[i].comissaoValor;
										Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
										Empregados[i].comissaoValorCache = Troca.comissaoValor;
										break;	
									}
								}
								break;
								
							case 2://Mensal
								if(Data[0]  == 30){
									switch(Empregados[i].tipo){
									case 1://Horista
										Troca.horasDia = Empregados[i].horasDia;
										Empregados[i].horasDia = Empregados[i].horasDiaCache;
										Empregados[i].horasDiaCache = Troca.horasDia;
										Troca.horasTotal = Empregados[i].horasTotal;
										Empregados[i].horasTotal = Empregados[i].horasTotalCache;
										Empregados[i].horasTotalCache = Troca.horasTotal;							
										Troca.horasExtras = Empregados[i].horasExtras;
										Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
										Empregados[i].horasExtrasCache = Troca.horasExtras;
										break;
									case 2://Assalariado
										break;
									case 3://Comissionado
										Troca.comissaoValor = Empregados[i].comissaoValor;
										Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
										Empregados[i].comissaoValorCache = Troca.comissaoValor;
										break;	
									}
								}
								
								else{
									if(Data[3] % 7 == 5){
										if(Data[0]  == 28 || Data[0]  == 29){
											switch(Empregados[i].tipo){
											case 1://Horista
												Troca.horasDia = Empregados[i].horasDia;
												Empregados[i].horasDia = Empregados[i].horasDiaCache;
												Empregados[i].horasDiaCache = Troca.horasDia;
												Troca.horasTotal = Empregados[i].horasTotal;
												Empregados[i].horasTotal = Empregados[i].horasTotalCache;
												Empregados[i].horasTotalCache = Troca.horasTotal;							
												Troca.horasExtras = Empregados[i].horasExtras;
												Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
												Empregados[i].horasExtrasCache = Troca.horasExtras;			;
												break;
											case 2://Assalariado
												break;
											case 3://Comissionado
												Troca.comissaoValor = Empregados[i].comissaoValor;
												Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
												Empregados[i].comissaoValorCache = Troca.comissaoValor;
												break;	
											}
										}								
									}
								}
								break;
								
							case 3:// Bi-Semanal
								
								if(Data[3] % 7 == 5){
									if((Data[3] / 7) % 2 == 0){
										switch(Empregados[i].tipo){
										case 1://Horista
											Troca.horasDia = Empregados[i].horasDia;
											Empregados[i].horasDia = Empregados[i].horasDiaCache;
											Empregados[i].horasDiaCache = Troca.horasDia;
											Troca.horasTotal = Empregados[i].horasTotal;
											Empregados[i].horasTotal = Empregados[i].horasTotalCache;
											Empregados[i].horasTotalCache = Troca.horasTotal;							
											Troca.horasExtras = Empregados[i].horasExtras;
											Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
											Empregados[i].horasExtrasCache = Troca.horasExtras;
											break;
										case 2://Assalariado
											break;
										case 3://Comissionado
											Troca.comissaoValor = Empregados[i].comissaoValor;
											Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
											Empregados[i].comissaoValorCache = Troca.comissaoValor;
											break;	
										}
									}							
								}
								break;
								
							case 4://Semanal Segunda
								if(Data[3] % 7 == 1){ 
									switch(Empregados[i].tipo){
									case 1://Horista
										Troca.horasDia = Empregados[i].horasDia;
										Empregados[i].horasDia = Empregados[i].horasDiaCache;
										Empregados[i].horasDiaCache = Troca.horasDia;
										Troca.horasTotal = Empregados[i].horasTotal;
										Empregados[i].horasTotal = Empregados[i].horasTotalCache;
										Empregados[i].horasTotalCache = Troca.horasTotal;	
										Troca.horasExtras = Empregados[i].horasExtras;
										Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
										Empregados[i].horasExtrasCache = Troca.horasExtras;
										break;
									case 2://Assalariado
										break;
									case 3://Comissionado
										Troca.comissaoValor = Empregados[i].comissaoValor;
										Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
										Empregados[i].comissaoValorCache = Troca.comissaoValor;
										break;	
									}
								}
								break;
								
							case 5://Semanal Quarta
								if(Data[3] % 7 == 3){ 
									switch(Empregados[i].tipo){
									case 1://Horista
										Troca.horasDia = Empregados[i].horasDia;
										Empregados[i].horasDia = Empregados[i].horasDiaCache;
										Empregados[i].horasDiaCache = Troca.horasDia;
										Troca.horasTotal = Empregados[i].horasTotal;
										Empregados[i].horasTotal = Empregados[i].horasTotalCache;
										Empregados[i].horasTotalCache = Troca.horasTotal;	
										Troca.horasExtras = Empregados[i].horasExtras;
										Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
										Empregados[i].horasExtrasCache = Troca.horasExtras;
										break;
									case 2://Assalariado
										break;
									case 3://Comissionado
										Troca.comissaoValor = Empregados[i].comissaoValor;
										Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
										Empregados[i].comissaoValorCache = Troca.comissaoValor;
										break;	
									}
								}
								break;
								
							case 6://Mensal 1
								if(Data[0]  == 1){
									switch(Empregados[i].tipo){
									case 1://Horista
										Troca.horasDia = Empregados[i].horasDia;
										Empregados[i].horasDia = Empregados[i].horasDiaCache;
										Empregados[i].horasDiaCache = Troca.horasDia;
										Troca.horasTotal = Empregados[i].horasTotal;
										Empregados[i].horasTotal = Empregados[i].horasTotalCache;
										Empregados[i].horasTotalCache = Troca.horasTotal;							
										Troca.horasExtras = Empregados[i].horasExtras;
										Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
										Empregados[i].horasExtrasCache = Troca.horasExtras;
										break;
									case 2://Assalariado
										break;
									case 3://Comissionado
										Troca.comissaoValor = Empregados[i].comissaoValor;
										Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
										Empregados[i].comissaoValorCache = Troca.comissaoValor;
										break;	
									}
								}
								break;
								
							}
						}
						break;	
					}					
					
					System.out.println("Deseja Refazer A Última Ação?");
					System.out.println("\t1 - Sim\n\t2 - Não");
					redo = scan.nextInt();
					
					if(redo == 1){
						
						Troca = inicializar(Troca);
						
						switch(Comando){
						
						case 1:
							totalDeFuncionarios++;
							Empregados[i].nome = Cache.nome;
							Empregados[i].endereco = Cache.endereco;
							
							Empregados[i].tipo = Cache.tipo;
							Empregados[i].agenda = Cache.agenda;
							Empregados[i].comissaoTaxa = Cache.comissaoTaxa;
							Empregados[i].salarioFixo = Cache.salarioFixo;
							Empregados[i].salarioTotal = Cache.salarioTotal;
							
							Empregados[i].metodo = Cache.metodo;
								
							Empregados[i].sindicato = Cache.sindicato;
							Empregados[i].sindicatoFlag = Cache.sindicatoFlag;
							Empregados[i].sindicatoID = Cache.sindicatoID;
							Empregados[i].sindicatoTaxa = Cache.sindicatoTaxa;						
							
							break;
							
						case 2:
							Empregados[id] = inicializar(Empregados[id]);
							totalDeFuncionarios--;
							break;
							
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
							Troca.comissaoTaxa = Empregados[id].comissaoTaxa;
							Empregados[id].comissaoTaxa = Cache.comissaoTaxa;
							Cache.comissaoTaxa = Troca.comissaoTaxa;
							Troca.salarioFixo = Empregados[id].salarioFixo;
							Empregados[id].salarioFixo = Cache.salarioFixo;
							Cache.salarioFixo = Troca.salarioFixo;
							Troca.salarioTotal = Empregados[id].salarioTotal;
							Empregados[id].salarioTotal = Cache.salarioTotal;
							Cache.salarioTotal = Troca.salarioTotal;
							
							Troca.metodo = Empregados[id].metodo;
							Empregados[id].metodo = Cache.metodo;
							Cache.metodo = Troca.metodo;
							
							Troca.sindicato = Empregados[id].sindicato;
							Empregados[id].sindicato = Cache.sindicato;
							Cache.sindicato = Troca.sindicato;
							Troca.sindicatoFlag = Empregados[id].sindicatoFlag;
							Empregados[id].sindicatoFlag = Cache.sindicatoFlag;
							Cache.sindicatoFlag = Troca.sindicatoFlag;
							Troca.sindicatoID = Empregados[id].sindicatoID;
							Empregados[id].sindicatoID = Cache.sindicatoID;
							Cache.sindicatoID = Troca.sindicatoID;
							Troca.sindicatoTaxa = Empregados[id].sindicatoTaxa;
							Empregados[id].sindicatoTaxa = Cache.sindicatoTaxa;
							Cache.sindicatoTaxa = Troca.sindicatoTaxa;
							break;
							
						case 4:
							Troca.horasDia = Empregados[i].horasDia;
							Empregados[i].horasDia = Empregados[i].horasDiaCache;
							Empregados[i].horasDiaCache = Troca.horasDia;
							Troca.horasTotal = Empregados[i].horasTotal;
							Empregados[i].horasTotal = Empregados[i].horasTotalCache;
							Empregados[i].horasTotalCache = Troca.horasTotal;
							Troca.horasExtras = Empregados[id].horasExtras;
							Empregados[id].horasExtras = Cache.horasExtras;
							Cache.horasExtras = Troca.horasExtras;
							break;	
							
						case 5:
							Troca.comissaoValor = Empregados[id].comissaoValor;
							Empregados[id].comissaoValor = Cache.comissaoValor;
							Cache.comissaoValor = Troca.comissaoValor;
							break;
							
						case 6:
							Troca.salarioTotal = Empregados[id].salarioTotal;
							Empregados[id].salarioTotal = Cache.salarioTotal;
							Cache.salarioTotal = Troca.salarioTotal;
							break;
							
						case 7:
							for(i = 0 ; i < 100 ; i++){
								Troca.salarioTotal = Empregados[i].salarioTotal;
								Empregados[i].salarioTotal = Empregados[i].salarioTotalCache;
								Empregados[i].salarioTotalCache = Troca.salarioTotal;
								switch(Empregados[i].agenda){
								
								case 1://Semanal
									if(Data[3] % 7 == 5){ 
										switch(Empregados[i].tipo){
										case 1://Horista
											Troca.horasDia = Empregados[i].horasDia;
											Empregados[i].horasDia = Empregados[i].horasDiaCache;
											Empregados[i].horasDiaCache = Troca.horasDia;
											Troca.horasTotal = Empregados[i].horasTotal;
											Empregados[i].horasTotal = Empregados[i].horasTotalCache;
											Empregados[i].horasTotalCache = Troca.horasTotal;							
											Troca.horasExtras = Empregados[i].horasExtras;
											Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
											Empregados[i].horasExtrasCache = Troca.horasExtras;
											break;
										case 2://Assalariado
											break;
										case 3://Comissionado
											Troca.comissaoValor = Empregados[i].comissaoValor;
											Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
											Empregados[i].comissaoValorCache = Troca.comissaoValor;
											break;	
										}
									}
									break;
									
								case 2://Mensal
									if(Data[0]  == 30){
										switch(Empregados[i].tipo){
										case 1://Horista
											Troca.horasDia = Empregados[i].horasDia;
											Empregados[i].horasDia = Empregados[i].horasDiaCache;
											Empregados[i].horasDiaCache = Troca.horasDia;
											Troca.horasTotal = Empregados[i].horasTotal;
											Empregados[i].horasTotal = Empregados[i].horasTotalCache;
											Empregados[i].horasTotalCache = Troca.horasTotal;							
											Troca.horasExtras = Empregados[i].horasExtras;
											Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
											Empregados[i].horasExtrasCache = Troca.horasExtras;
											break;
										case 2://Assalariado
											break;
										case 3://Comissionado
											Troca.comissaoValor = Empregados[i].comissaoValor;
											Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
											Empregados[i].comissaoValorCache = Troca.comissaoValor;
											break;	
										}
									}
									
									else{
										if(Data[3] % 7 == 5){
											if(Data[0]  == 28 || Data[0]  == 29){
												switch(Empregados[i].tipo){
												case 1://Horista
													Troca.horasDia = Empregados[i].horasDia;
													Empregados[i].horasDia = Empregados[i].horasDiaCache;
													Empregados[i].horasDiaCache = Troca.horasDia;
													Troca.horasTotal = Empregados[i].horasTotal;
													Empregados[i].horasTotal = Empregados[i].horasTotalCache;
													Empregados[i].horasTotalCache = Troca.horasTotal;							
													Troca.horasExtras = Empregados[i].horasExtras;
													Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
													Empregados[i].horasExtrasCache = Troca.horasExtras;			;
													break;
												case 2://Assalariado
													break;
												case 3://Comissionado
													Troca.comissaoValor = Empregados[i].comissaoValor;
													Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
													Empregados[i].comissaoValorCache = Troca.comissaoValor;
													break;	
												}
											}								
										}
									}
									break;
									
								case 3:// Bi-Semanal
									
									if(Data[3] % 7 == 5){
										if((Data[3] / 7) % 2 == 0){
											switch(Empregados[i].tipo){
											case 1://Horista
												Troca.horasDia = Empregados[i].horasDia;
												Empregados[i].horasDia = Empregados[i].horasDiaCache;
												Empregados[i].horasDiaCache = Troca.horasDia;
												Troca.horasTotal = Empregados[i].horasTotal;
												Empregados[i].horasTotal = Empregados[i].horasTotalCache;
												Empregados[i].horasTotalCache = Troca.horasTotal;							
												Troca.horasExtras = Empregados[i].horasExtras;
												Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
												Empregados[i].horasExtrasCache = Troca.horasExtras;
												break;
											case 2://Assalariado
												break;
											case 3://Comissionado
												Troca.comissaoValor = Empregados[i].comissaoValor;
												Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
												Empregados[i].comissaoValorCache = Troca.comissaoValor;
												break;	
											}
										}							
									}
									break;
								
								case 4://Semanal Segunda
									if(Data[3] % 7 == 1){ 
										switch(Empregados[i].tipo){
										case 1://Horista
											Troca.horasDia = Empregados[i].horasDia;
											Empregados[i].horasDia = Empregados[i].horasDiaCache;
											Empregados[i].horasDiaCache = Troca.horasDia;
											Troca.horasTotal = Empregados[i].horasTotal;
											Empregados[i].horasTotal = Empregados[i].horasTotalCache;
											Empregados[i].horasTotalCache = Troca.horasTotal;	
											Troca.horasExtras = Empregados[i].horasExtras;
											Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
											Empregados[i].horasExtrasCache = Troca.horasExtras;
											break;
										case 2://Assalariado
											break;
										case 3://Comissionado
											Troca.comissaoValor = Empregados[i].comissaoValor;
											Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
											Empregados[i].comissaoValorCache = Troca.comissaoValor;
											break;	
										}
									}
									break;
									
								case 5://Semanal Quarta
									if(Data[3] % 7 == 3){ 
										switch(Empregados[i].tipo){
										case 1://Horista
											Troca.horasDia = Empregados[i].horasDia;
											Empregados[i].horasDia = Empregados[i].horasDiaCache;
											Empregados[i].horasDiaCache = Troca.horasDia;
											Troca.horasTotal = Empregados[i].horasTotal;
											Empregados[i].horasTotal = Empregados[i].horasTotalCache;
											Empregados[i].horasTotalCache = Troca.horasTotal;	
											Troca.horasExtras = Empregados[i].horasExtras;
											Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
											Empregados[i].horasExtrasCache = Troca.horasExtras;
											break;
										case 2://Assalariado
											break;
										case 3://Comissionado
											Troca.comissaoValor = Empregados[i].comissaoValor;
											Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
											Empregados[i].comissaoValorCache = Troca.comissaoValor;
											break;	
										}
									}
									break;
									
								case 6://Mensal 1
									if(Data[0]  == 1){
										switch(Empregados[i].tipo){
										case 1://Horista
											Troca.horasDia = Empregados[i].horasDia;
											Empregados[i].horasDia = Empregados[i].horasDiaCache;
											Empregados[i].horasDiaCache = Troca.horasDia;
											Troca.horasTotal = Empregados[i].horasTotal;
											Empregados[i].horasTotal = Empregados[i].horasTotalCache;
											Empregados[i].horasTotalCache = Troca.horasTotal;							
											Troca.horasExtras = Empregados[i].horasExtras;
											Empregados[i].horasExtras = Empregados[i].horasExtrasCache;
											Empregados[i].horasExtrasCache = Troca.horasExtras;
											break;
										case 2://Assalariado
											break;
										case 3://Comissionado
											Troca.comissaoValor = Empregados[i].comissaoValor;
											Empregados[i].comissaoValor = Empregados[i].comissaoValorCache;
											Empregados[i].comissaoValorCache = Troca.comissaoValor;
											break;	
										}
									}
									break;
								}
							}
							Data = novoDia(Data);
							
							for(i = 0 ; i < 100 ; i++){
								Empregados[i].horasTotal += Empregados[i].horasDia;
								Empregados[i].horasDia = 0;
							}
							
							if((Data[3]-7)%30 == 2){
								for(i = 0 ; i < 100 ; i++){
									if(Empregados[i].sindicato == 1){
										Empregados[i].salarioTotal -= Empregados[i].sindicatoTaxa;
									}
								}
								
								if(Empregados[i].sindicato == 1 && Empregados[i].sindicatoFlag != 0){
									Empregados[i].salarioTotal -= Empregados[i].sindicatoTaxa;
								}
								if(Empregados[i].sindicatoFlag == 0){
									Empregados[i].sindicatoFlag = 1;
								}
							}
							break;
						}
						
					}
				}
				if(Comando == 7 && undo != 1){
					Data = novoDia(Data);					
					
					for(i = 0 ; i < 100 ; i++){
						Empregados[i].horasTotal += Empregados[i].horasDia;
						Empregados[i].horasDia = 0;
					}
					
					if((Data[3]-7)%30 == 1){						
						for(i = 0 ; i < 100 ; i++){
							if(Empregados[i].sindicato == 1 && Empregados[i].sindicatoFlag != 0){
								Empregados[i].salarioTotal -= Empregados[i].sindicatoTaxa;
							}
							
							if(Empregados[i].sindicatoFlag == 0){
								Empregados[i].sindicatoFlag = 1;
							}
						}
					}
					
				}
			} // Undo/Redo
			
			
		}	

	}

}
