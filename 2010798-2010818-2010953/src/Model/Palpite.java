package Model;

class Palpite {
	private Pessoa palpiteiro;
	private Pessoa palpitado;
	private String lugar_palpite;
	private String arma_palpite;
	
	// para executar os testes, nao utilizamos os valores diretamente no metodo, pois eles sao gerados aleatoriamente 
	//por isso, passamos os mesmos como parametro, segue abaixo qual sera o valor passado para eles 
	//		Jogo resultado = new Jogo();
	// resultado.envelope[1].Nome() = suspeito_gabarito
	// resultado.envelope[2].Nome() = lugar_gabarito
	//resultado.envelope[0].Nome() = arma_gabarito
	
	public Palpite(Pessoa palpiteiro, Pessoa palpitado, String lugar, String arma) {
		this.palpiteiro = palpiteiro;
		this.palpitado = palpitado;
		this.lugar_palpite = lugar;
		this.arma_palpite = arma;
	}
	
	boolean isPalpiteTrue(Palpite p, int num_jogadores, String arma_gabarito, String lugar_gabarito,  String suspeito_gabarito) {
		//traz o acusado para o mesmo comodo
		p.palpitado.posicao[0] = p.palpiteiro.posicao[0] + 1;
		//se for o que esta no envelope, ninguem mais tem
		//se alguem tiver, vai ter que mostrar
		if (p.palpitado.nome() == suspeito_gabarito && p.lugar_palpite == lugar_gabarito && p.arma_palpite == arma_gabarito) {
			return true;
			//neste caso, ninguem teve que mostrar nada porque ninguem tinha as cartas palpitadas e o jogo seguiu
		}
		else {
			System.out.printf("Mostre a carta referente ao palpite");
			return false;
		}
	}
}
