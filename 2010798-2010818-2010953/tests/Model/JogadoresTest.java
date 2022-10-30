package Model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JogadoresTest {
	Pessoa testJogadores[];
	Cartas cartas_jogo[];
	
	
	@Before
	public void setUp() {
		cartas_jogo = new Cartas[] 
				{
					new Cartas("arma", "Corda"),
					new Cartas("arma", "Cano de Chumbo"),
					new Cartas("arma", "Faca"),
					new Cartas("arma", "Chave Inglesa"),
					new Cartas("arma", "Castiçal"),
					new Cartas("arma", "Revólver"),
					new Cartas("suspeito", "Srta. Scarlet"),
					new Cartas("suspeito", "Coronel Mustard"),
					new Cartas("suspeito", "Professor Plum"),
					new Cartas("suspeito", "Reverendo Green"),
					new Cartas("suspeito", "Sra. White"),
					new Cartas("suspeito", "Sra. Peacock"),
					new Cartas("comodo", "Escritorio"),
					new Cartas("comodo", "Entrada"),
					new Cartas("comodo", "Sala de estar"),
					new Cartas("comodo", "Biblioteca"),
					new Cartas("comodo", "Salao de jogos"),
					new Cartas("comodo", "Sala de jantar"),
					new Cartas("comodo", "Jardim de inverno"),
					new Cartas("comodo", "Sala de musica"),
					new Cartas("comodo", "Cozinha"),
			};
		
		testJogadores = new Pessoa[]
			{
				new Pessoa("Srta. Scarlet"),	
				new Pessoa("Coronel Mustard"),
				new Pessoa("Professor Plum"),
				new Pessoa("Reverendo Green"),
				new Pessoa("Sra. White"),
				new Pessoa("Sra. Peacock"),
			};
		
		testJogadores[0].atribuirCarta(cartas_jogo[0]);
		testJogadores[1].atribuirCarta(cartas_jogo[1]);
		testJogadores[2].atribuirCarta(cartas_jogo[2]);
		testJogadores[0].atribuirCarta(cartas_jogo[3]);
		testJogadores[1].atribuirCarta(cartas_jogo[4]);
		testJogadores[2].atribuirCarta(cartas_jogo[5]);
	}
	
	@Test
	public void cartasjogadorestest() {
		assertSame("Srta. Scarlet", testJogadores[0].nome());
		assertSame(cartas_jogo[0].Tipo(), testJogadores[0].cartas_jogador[0].Tipo());
		assertSame(cartas_jogo[0].Nome(), testJogadores[0].cartas_jogador[0].Nome());
		assertSame(cartas_jogo[3].Tipo(), testJogadores[0].cartas_jogador[1].Tipo());
		assertSame(cartas_jogo[3].Nome(), testJogadores[0].cartas_jogador[1].Nome());
		assertSame("Coronel Mustard", testJogadores[1].nome());
		assertSame(cartas_jogo[1].Tipo(), testJogadores[1].cartas_jogador[0].Tipo());
		assertSame(cartas_jogo[1].Nome(), testJogadores[1].cartas_jogador[0].Nome());
		assertSame(cartas_jogo[4].Tipo(), testJogadores[1].cartas_jogador[1].Tipo());
		assertSame(cartas_jogo[4].Nome(), testJogadores[1].cartas_jogador[1].Nome());
		assertSame("Professor Plum", testJogadores[2].nome());
		assertSame(cartas_jogo[2].Tipo(), testJogadores[2].cartas_jogador[0].Tipo());
		assertSame(cartas_jogo[2].Nome(), testJogadores[2].cartas_jogador[0].Nome());
		assertSame(cartas_jogo[5].Tipo(), testJogadores[2].cartas_jogador[1].Tipo());
		assertSame(cartas_jogo[5].Nome(), testJogadores[2].cartas_jogador[1].Nome());
		
	}

}
