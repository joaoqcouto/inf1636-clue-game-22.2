package Model;

// casa = um espa�o no mapa onde uma pe�a fica (que n�o � um c�modo!)
// ocupado = a pessoa que ocupa (null se nenhuma)
// entradaPara = o c�modo para o qual a casa � entrada (null se nenhum)
// vizinhos = casas acess�veis atrav�s da casa atual
class Casa {
	Pessoa ocupado;
	Comodo entradaPara;
	Casa[] vizinhos;
	int posicaoX;
	int posicaoY;
	
	public Casa(int posicaoX, int posicaoY, Pessoa ocupado, Comodo entradaPara) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.ocupado = ocupado;
		this.entradaPara = entradaPara;
	}
	
	// n�o pode ser feito na inicializa��o porque alguns vizinhos ainda n�o foram inicializados
	public void atualizaVizinhos(Casa []vizinhos) {
		this.vizinhos = vizinhos;
	}
	
	// quando algu�m entra na casa
	public void ocupar(Pessoa p) {
		this.ocupado = p;
	}
	
	// quando algu�m sai da casa
	public Pessoa desocupar() {
		Pessoa p = this.ocupado;
		this.ocupado = null;
		return p;
	}
	
}
