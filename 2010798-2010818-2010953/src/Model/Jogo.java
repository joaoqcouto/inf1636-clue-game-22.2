package Model;

public class Jogo {
	// mantém o tabuleiro, os jogadores, a ordem das jogadas, a resposta certa, etc.
	public Jogo() {
		
		// criando jogadores (editar para definir o construtor corretamente etc.)
		Pessoa jogadores[] =
			{
				new Pessoa(),	
				new Pessoa(),
				new Pessoa(),
				new Pessoa(),
				new Pessoa(),
				new Pessoa(),
			};
		
		// criando tabuleiro e posicionando os jogadores nele
		Tabuleiro tabuleiro = new Tabuleiro(jogadores);
	}
}
