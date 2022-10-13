package Model;

// casa = um espaço no mapa onde uma peça fica (que não é um cômodo!)
// ocupado = a pessoa que ocupa (null se nenhuma)
// entradaPara = o cômodo para o qual a casa é entrada (null se nenhum)
// vizinhos = casas acessíveis através da casa atual
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
	
	// não pode ser feito na inicialização porque alguns vizinhos ainda não foram inicializados
	public void atualizaVizinhos(Casa []vizinhos) {
		this.vizinhos = vizinhos;
	}
	
	// quando alguém entra na casa
	public void ocupar(Pessoa p) {
		this.ocupado = p;
	}
	
	// quando alguém sai da casa
	public Pessoa desocupar() {
		Pessoa p = this.ocupado;
		this.ocupado = null;
		return p;
	}
	
}
