public class Empregado {
		
	public String nome;
	public String endereco;		
	public int tipo; // Horista Assalariado Comissionado
	public int metodo; // Cheque Via Correios Cheque Em M�os Dep�sito Banc�rio
	public int sindicato; // Sim ou N�o
	public int sindicatoID; // Para Localiza��o da Taxa Sindical	
	
	//Atributos
	public float salarioFixo; // Mensal Horario
	public float comissaoTaxa; // Comissionado - % Sobre O Valor Da Venda
	public float comissaoValor; // Comissionado - Valor Total Das Comiss�es
}