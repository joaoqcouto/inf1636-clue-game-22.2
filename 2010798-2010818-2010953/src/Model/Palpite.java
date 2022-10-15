package Model;

class Palpite {
	private Pessoa palpiteiro;
	private Pessoa palpitado;
	private Comodo lugar_palpite;
	private String arma_palpite;
	
	public Palpite(Pessoa palpiteiro, Pessoa palpitado, Comodo lugar, String arma) {
		this.palpiteiro = palpiteiro;
		this.palpitado = palpitado;
		this.lugar_palpite = lugar;
		this.arma_palpite = arma;
	}
	
	boolean isPalpiteTrue(Palpite p, Pessoa outra_pessoa) {
		//se for o que esta no envelope, ninguem mais tem
		//se alguem tiver, vai ter que mostrar
		if (p.palpitado.nome() == "oficial" && p.lugar_palpite.comodo == "oficial" && p.arma_palpite == "oficial") {
			return true;
		}
		else {
			return false;
		}
	}
}
