package Model;

class Acusacao {
	private Pessoa acusador;
	private Pessoa acusado;
	private Comodo lugar_acusacao;
	private Armas arma_acusacao;

	public Acusacao(Pessoa acusador, Pessoa acusado, Comodo lugar, Armas arma) {
		this.acusador = acusador;
		this.acusado = acusado;
		this.lugar_acusacao = lugar;
		this.arma_acusacao = arma;
	}
	
	// checa gabarito, compara com acusacao feita
	boolean isAcusacaoTrue() {
		Cartas envelope[] = Jogo.getJogo().getCartasEnvelope();
		if (
			envelope[0].Nome() == arma_acusacao.NomeArma() &&
			envelope[1].Nome() == acusado.nome() &&
			envelope[2].Nome() == lugar_acusacao.nome()
		) return true;
			
		return false;
	}
}
