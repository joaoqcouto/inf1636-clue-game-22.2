package Model;

public class Armas {
	private String nome;
	public int posicao[] = new int[2];
	
	public Armas(String name) {
		this.nome = name;
	}
	
	public void moverArmaPara(int linha, int coluna) {
		this.posicao[0] = linha;
		this.posicao[1] = coluna;
	}
	
	public String NomeArma() {
		return this.nome;
	}
	
	public int[] posicaoArma() {
		return posicao;
	}
	
	public void inicializaPosicaoArma(int pos){
		if(pos == 1) {
			this.moverArmaPara(3, 3);
		}
		else if (pos == 2) {
			this.moverArmaPara(3, 11);
		}
		else if (pos == 3) {
			this.moverArmaPara(3, 20);
		}
		else if (pos == 4) {
			this.moverArmaPara(9, 3);
		}
		else if (pos == 5) {
			this.moverArmaPara(15, 3);
		}
		else if (pos == 6) {
			this.moverArmaPara(12, 20);
		}
		else if (pos == 7) {
			this.moverArmaPara(22, 3);
		}
		else if (pos == 8) {
			this.moverArmaPara(22, 11);
		}
		else if (pos == 9) {
			this.moverArmaPara(22, 20);
		}
		  
	}
}
