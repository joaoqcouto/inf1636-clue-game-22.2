package Model;

class Pessoa {
	int posicao[] = new int[2];
	
	// para guardar a posi��o da pessoa
	public void moverPara(int linha, int coluna) {
		this.posicao[0] = linha;
		this.posicao[1] = coluna;
	}
	public int[] posicao() {
		return posicao;
	}
}
