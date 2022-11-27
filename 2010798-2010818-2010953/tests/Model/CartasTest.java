package Model;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;


public class CartasTest {
	Cartas []testCartas;
	Cartas []cartas_jogo;
	int num_arma;
	int num_suspeito;
	int num_comodo;
	
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
		Random gerador = new Random();
		num_arma = gerador.nextInt(6);
		num_suspeito = 6 + gerador.nextInt(6);
		num_comodo = 12 + gerador.nextInt(9);
		testCartas = new Cartas[] 
				{
						new Cartas(cartas_jogo[num_arma].Tipo(), cartas_jogo[num_arma].Nome(), 0),
						new Cartas(cartas_jogo[num_suspeito].Tipo(), cartas_jogo[num_suspeito].Nome(), 1),
						new Cartas(cartas_jogo[num_comodo].Tipo(), cartas_jogo[num_comodo].Nome(), 2),
				};
	}
	@Test
	public void envelopeTest() {
		//Test envelope.
		assertSame("arma",testCartas[0].Tipo());
		assertSame("suspeito",testCartas[1].Tipo());
		assertSame("comodo",testCartas[2].Tipo());
		assertSame(cartas_jogo[num_arma].Nome(),testCartas[0].Nome());
		assertSame(cartas_jogo[num_suspeito].Nome(),testCartas[1].Nome());
		assertSame(cartas_jogo[num_comodo].Nome(),testCartas[2].Nome());
	}

}
