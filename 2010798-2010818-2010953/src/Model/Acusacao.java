package Model;

class Acusacao {
	private Pessoa acusador;
	private Pessoa acusado;
	private String lugar_acusacao;
	private String arma_acusacao;
	// para executar os testes, nao utilizamos os valores diretamente no metodo, pois eles sao gerados aleatoriamente 
	//por isso, passamos os mesmos como parametro, segue abaixo qual sera o valor passado para eles 
	//		Jogo resultado = new Jogo();
	// resultado.envelope[1].Nome() = suspeito_gabarito
	// resultado.envelope[2].Nome() = lugar_gabarito
	//resultado.envelope[0].Nome() = arma_gabarito
	
	public Acusacao(Pessoa acusador, Pessoa acusado, String lugar, String arma) {
		this.acusador = acusador;
		this.acusado = acusado;
		this.lugar_acusacao = lugar;
		this.arma_acusacao = arma;
	}
	
	boolean isAcusacaoTrue(Acusacao a, String arma_gabarito, String lugar_gabarito,  String suspeito_gabarito) {
		//traz o acusado para o mesmo comodo
		a.acusado.posicao[0] = a.acusador.posicao[0] + 1;
		if (a.acusado.nome() == suspeito_gabarito && a.lugar_acusacao == lugar_gabarito && a.arma_acusacao == arma_gabarito) {
			//caso a acusacao seja igual ao gabarito, o jogo termina
			System.out.printf("O jogo terminou. O vencedor é: %s", a.acusador.nome());
			return true;
		}
		else {
			//caso contrario, o jogador nao pode mais fazer jogadas, apenas sera movimentado quando acusado/palpitado, alem de mostrar as cartas
			//a variavel de instancia "tem_vez" serve para mostrar que ele nao fara mais jogadas
			a.acusador.tem_vez = false;
			return false;
		}
	}
}
