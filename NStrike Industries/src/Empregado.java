public class Empregado {
		
	public String nome;
	public String endereco;		
	public int tipo; // Horista Assalariado Comissionado
	public int metodo; // Cheque Via Correios Cheque Em Mãos Depósito Bancário
	public int sindicato; // Sim ou Não
	public int sindicatoID; // Para Localização da Taxa Sindical
	
	//Atributos
	public float salarioFixo; // Mensal Horario
	public float comissao; // Comissionado
	public float salarioTotal; // Salario Fixo + Comissao
}