package Model;

// casa = um espa�o no mapa onde uma pe�a fica (que n�o � um c�modo!)
// ocupado = a pessoa que ocupa (null se nenhuma)
// vizinhos = casas acess�veis atrav�s da casa atual
class Casa {
	private boolean ocupado;
	private int posicao[];
	
	public Casa(int linha, int coluna, boolean ocupado) {
		this.posicao[0] = linha;
		this.posicao[1] = coluna;
		this.ocupado = ocupado;
	}
	
	// quando algu�m entra na casa
	public void ocupar() { this.ocupado = true; }
	
	// quando algu�m sai da casa
	public void desocupar() { this.ocupado = false; }
	
	// para retornar a posi��o
	public int[] posicao() { return posicao; }
	
	// para retornar se est� ocupado
	public boolean ocupado() { return ocupado; }
}
