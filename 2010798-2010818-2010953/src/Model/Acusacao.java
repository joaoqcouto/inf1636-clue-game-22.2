package Model;

class Acusacao {
	private Pessoa acusador;
	private Pessoa acusado;
	private Comodo lugar_acusacao;
	private String arma_acusacao;
	
	public Acusacao(Pessoa acusador, Pessoa acusado, Comodo lugar, String arma) {
		this.acusador = acusador;
		this.acusado = acusado;
		this.lugar_acusacao = lugar;
		this.arma_acusacao = arma;
	}
	
	boolean isAcusacaoTrue(Acusacao a) {
		if (a.acusado.nome() == "oficial" && a.lugar_acusacao.comodo == "oficial" && a.arma_acusacao == "oficial") {
			System.out.printf("O vencedor do jogo é: %s", a.acusador.nome());
			return true;
		}
		else {
			return false;
		}
	}
}
