package Model;

class Acusacao {
	private String acusador;
	private String acusado;
	private String lugar_acusacao;
	private String arma_acusacao;

	public Acusacao(String acusador, String acusado, String lugar, String arma) {
		this.acusador = acusador;
		this.acusado = acusado;
		this.lugar_acusacao = lugar;
		this.arma_acusacao = arma;
	}
	
	// checa gabarito, compara com acusacao feita
	public boolean isAcusacaoTrue(Cartas[] envelope) {
		if (
			envelope[0].Nome() == arma_acusacao &&
			envelope[1].Nome() == acusado &&
			envelope[2].Nome() == lugar_acusacao
		) return true;
			
		return false;
	}
}
