package Model;

// casa = um espaço no mapa onde uma peça fica (que não é um cômodo!)
// ocupado = a pessoa que ocupa (null se nenhuma)
// vizinhos = casas acessíveis através da casa atual
class Casa {
	private boolean ocupado;
	private int posicao[];
	
	public Casa(int linha, int coluna, boolean ocupado) {
		this.posicao[0] = linha;
		this.posicao[1] = coluna;
		this.ocupado = ocupado;
	}
	
	// quando alguém entra na casa
	public void ocupar() { this.ocupado = true; }
	
	// quando alguém sai da casa
	public void desocupar() { this.ocupado = false; }
	
	// para retornar a posição
	public int[] posicao() { return posicao; }
	
	// para retornar se está ocupado
	public boolean ocupado() { return ocupado; }
}
