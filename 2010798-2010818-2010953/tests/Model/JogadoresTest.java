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
					new Cartas("arma", "Corda", 0),
					new Cartas("arma", "Cano de Chumbo", 1),
					new Cartas("arma", "Faca", 2),
					new Cartas("arma", "Chave Inglesa", 3),
					new Cartas("arma", "Castical", 4),
					new Cartas("arma", "Revolver", 5),
					new Cartas("suspeito", "Srta. Scarlet", 6),
					new Cartas("suspeito", "Coronel Mustard", 7),
					new Cartas("suspeito", "Professor Plum", 8),
					new Cartas("suspeito", "Reverendo Green", 9),
					new Cartas("suspeito", "Sra. White", 10),
					new Cartas("suspeito", "Sra. Peacock", 11),
					new Cartas("comodo", "Escritorio", 12),
					new Cartas("comodo", "Entrada", 13),
					new Cartas("comodo", "Sala de estar", 14),
					new Cartas("comodo", "Biblioteca", 15),
					new Cartas("comodo", "Salao de jogos", 16),
					new Cartas("comodo", "Sala de jantar", 17),
					new Cartas("comodo", "Jardim de inverno", 18),
					new Cartas("comodo", "Sala de musica", 19),
					new Cartas("comodo", "Cozinha", 20),
			};
		
		testJogadores = new Pessoa[]
			{
				new Pessoa("Srta. Scarlet", 0),	
				new Pessoa("Coronel Mustard", 1),
				new Pessoa("Professor Plum", 2),
				new Pessoa("Reverendo Green", 3),
				new Pessoa("Sra. White", 4),
				new Pessoa("Sra. Peacock", 5),
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
		assertSame(cartas_jogo[0].Tipo(), testJogadores[0].cartas()[0].Tipo());
		assertSame(cartas_jogo[0].Nome(), testJogadores[0].cartas()[0].Nome());
		assertSame(cartas_jogo[3].Tipo(), testJogadores[0].cartas()[1].Tipo());
		assertSame(cartas_jogo[3].Nome(), testJogadores[0].cartas()[1].Nome());
		assertSame("Coronel Mustard", testJogadores[1].nome());
		assertSame(cartas_jogo[1].Tipo(), testJogadores[1].cartas()[0].Tipo());
		assertSame(cartas_jogo[1].Nome(), testJogadores[1].cartas()[0].Nome());
		assertSame(cartas_jogo[4].Tipo(), testJogadores[1].cartas()[1].Tipo());
		assertSame(cartas_jogo[4].Nome(), testJogadores[1].cartas()[1].Nome());
		assertSame("Professor Plum", testJogadores[2].nome());
		assertSame(cartas_jogo[2].Tipo(), testJogadores[2].cartas()[0].Tipo());
		assertSame(cartas_jogo[2].Nome(), testJogadores[2].cartas()[0].Nome());
		assertSame(cartas_jogo[5].Tipo(), testJogadores[2].cartas()[1].Tipo());
		assertSame(cartas_jogo[5].Nome(), testJogadores[2].cartas()[1].Nome());
		
	}

}
