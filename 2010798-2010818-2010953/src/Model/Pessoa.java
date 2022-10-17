package Model;

class Pessoa {
	public int posicao[] = new int[2];
	private String nome;
	public Cartas cartas_jogador[] = new Cartas[6];
	private int num_cartas = 0; 
	public boolean tem_vez;
	
	public Pessoa (String name) {
		this.nome = name;
	} 
	
	public void atribuirCarta(Cartas carta) {
		this.cartas_jogador[num_cartas] = carta; 
		num_cartas++; 
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
}
