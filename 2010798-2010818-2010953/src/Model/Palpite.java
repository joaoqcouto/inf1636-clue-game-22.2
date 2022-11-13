package Model;
import java.util.Queue;

class Palpite {
	private Pessoa palpiteiro;
	private Pessoa palpitado;
	private Comodo lugar_palpite;
	private Armas arma_palpite;
	
	public Palpite(Pessoa palpiteiro, Pessoa palpitado, Comodo lugar, Armas arma) {
		this.palpiteiro = palpiteiro;
		this.palpitado = palpitado;
		this.lugar_palpite = lugar;
		this.arma_palpite = arma;
	}
	
	// checa as cartas das outras pessoas
	// retorna uma carta que desprova o palpite
	// retorna null caso ninguem desprove
	Cartas isPalpiteTrue(Queue<Pessoa> filaPalpites) {
		// roda fila ate colocar palpiteiro no topo
		while (filaPalpites.peek() != palpiteiro) {
			Pessoa p = filaPalpites.remove();
			filaPalpites.add(p);
		}
		
		// tira palpiteiro da fila, vai passando pelo resto e checando as cartas
		filaPalpites.remove();
		while (!filaPalpites.isEmpty()) {
			Pessoa p = filaPalpites.remove();
			int qtdCartas = p.qtdCartas();
			Cartas cartas[] = p.cartas();
			for (int i = 0; i< qtdCartas; i++) {
				// se alguma carta desprova retorna ela
				if (
					cartas[i].Nome() == arma_palpite.NomeArma() ||
					cartas[i].Nome() == palpitado.nome() ||
					cartas[i].Nome() == lugar_palpite.nome()
				) return cartas[i];
			}
		}
		return null;
	}
}
