public class Empregado {
		
	public String nome;
	public String endereco;
	
	public int tipo; // Horista Assalariado Comissionado
	public int agenda; // Semanal Bi-Semanal Mensal
	public int agendaNova; // Ativado ou Desativado
	public float comissaoTaxa; // Comissionado - % Sobre O Valor Da Venda
	public float salarioFixo;
	
	public int metodo; // Cheque Via Correios Cheque Em Mãos Depósito Bancário
	
	public int sindicato; // Sim ou Não
	public int sindicatoID; // Numero De Identivicação Sindical
	public float sindicatoTaxa; // Taxa Sindical
	
	//Atributos	
	public float comissaoValor; // Comissionado - Valor Total Das Comissões
	public float comissaoValorCache;
	
	public float salarioTotal; // Salario A Ser Pago No Dia De Pagamento
	
	public int horas; // Numero De Horas Trabalhadas
	public int horasCache;
	
	public int horasExtras; // Numero De Horas Extras Trabalhadas
	public int horasExtrasCache;
}