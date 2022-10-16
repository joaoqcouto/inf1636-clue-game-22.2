package Model;

// casa = um espa�o no mapa onde uma pe�a fica (que n�o � um c�modo!)
// ocupado = a pessoa que ocupa (null se nenhuma)
// vizinhos = casas acess�veis atrav�s da casa atual
class Casa {
	private boolean ocupado;
	private int posicao[];
	private Casa vizinhos[]={};
	private int dist;
	
	public Casa(int linha, int coluna, boolean ocupado) {
		this.posicao[0] = linha;
		this.posicao[1] = coluna;
		this.ocupado = ocupado;
		this.dist=-1;
	}
	
	// quando algu�m entra na casa
	public void ocupar() { this.ocupado = true; }
	
	// quando algu�m sai da casa
	public void desocupar() { this.ocupado = false; }
	
	// para retornar a posi��o
	public int[] posicao() { return posicao; }
	
	// para retornar se est� ocupado
	public boolean ocupado() { return ocupado; }
	
	// para adicionar um vizinho
	public void addVizinho(Casa vizinho) {
		Casa[] newVizinhos = new Casa[vizinhos.length+1];
		System.arraycopy(vizinho, 0, newVizinhos, 0, vizinhos.length);
		newVizinhos[vizinhos.length] = vizinho;
		this.vizinhos = newVizinhos;
	}
	
	public Casa[] vizinhos() { return vizinhos; }
	
	// para busca por largura
	public void setDist(int d) { this.dist = d; }
	public int getDist() { return this.dist; }
	public void resetDist() { this.dist = -1; }
}
