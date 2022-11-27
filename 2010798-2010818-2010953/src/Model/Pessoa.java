package Model;

import java.util.HashMap;
import java.util.Map;

class Pessoa {
	private int numero;
	private int posicao[] = new int[2];
	private String nome;
	private Cartas cartas_jogador[] = new Cartas[6];
	private int num_cartas = 0; 
	private Map<String, Boolean> notasCartas = new HashMap<String, Boolean>();
	
	public Pessoa (String name, int numero) {
		this.nome = name;
		this.numero = numero;
		
		notasCartas.put("Corda", false);
		notasCartas.put("Cano de Chumbo", false);
		notasCartas.put("Faca", false);
		notasCartas.put("Chave Inglesa", false);
		notasCartas.put("Castical", false);
		notasCartas.put("Revolver", false);
		
		notasCartas.put("Srta. Scarlet", false);
		notasCartas.put("Coronel Mustard", false);
		notasCartas.put("Professor Plum", false);
		notasCartas.put("Reverendo Green", false);
		notasCartas.put("Sra. White", false);
		notasCartas.put("Sra. Peacock", false);
		
		notasCartas.put("Escritorio", false);
		notasCartas.put("Entrada", false);
		notasCartas.put("Sala de estar", false);
		notasCartas.put("Biblioteca", false);
		notasCartas.put("Salao de jogos", false);
		notasCartas.put("Sala de jantar", false);
		notasCartas.put("Jardim de inverno", false);
		notasCartas.put("Sala de musica", false);
		notasCartas.put("Cozinha", false);
	} 
	
	public void atribuirCarta(Cartas carta) {
		this.cartas_jogador[num_cartas] = carta; 
		num_cartas++; 
		notasCartas.replace(carta.Nome(), true);
	}
	
	public String nome() {
		return this.nome;
	}
	
	// para guardar a posicao da pessoa
	public void moverPara(int linha, int coluna) {
		this.posicao[0] = linha;
		this.posicao[1] = coluna;
	}
	public int[] posicao() {
		return posicao;
	}
	
	// pegando cartas
	public int qtdCartas() { return num_cartas; }
	public Cartas[] cartas() { return cartas_jogador; }
	
	// pegando notas
	public Map<String, Boolean> getNotas() { return notasCartas; }
	
	public void updateNotas(String campo, boolean b) {
		notasCartas.replace(campo, b);
	}
	
	public int numero() { return numero; }
}
