package Model;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class PalpiteTeste {
	Palpite palpiteTeste;
	Pessoa palpiteiroPessoa;
	Pessoa palpitadoPessoa;	
	Pessoa pessoaTeste1;
	Pessoa pessoaTeste2;
	Pessoa pessoaTeste3;
	Pessoa pessoaTeste4;
	Queue<Pessoa> filaPalpites1;
	Queue<Pessoa> filaPalpites2;
	Queue<Pessoa> filaPalpites3;
	Queue<Pessoa> filaPalpites4;
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
		testJogadores[3].atribuirCarta(cartas_jogo[3]);
		testJogadores[4].atribuirCarta(cartas_jogo[4]);
		testJogadores[5].atribuirCarta(cartas_jogo[5]);
		testJogadores[0].atribuirCarta(cartas_jogo[6]);
		testJogadores[1].atribuirCarta(cartas_jogo[7]);
		testJogadores[2].atribuirCarta(cartas_jogo[8]);
		testJogadores[3].atribuirCarta(cartas_jogo[9]);
		testJogadores[4].atribuirCarta(cartas_jogo[10]);
		testJogadores[5].atribuirCarta(cartas_jogo[11]);
		testJogadores[0].atribuirCarta(cartas_jogo[15]);
		testJogadores[1].atribuirCarta(cartas_jogo[16]);
		testJogadores[2].atribuirCarta(cartas_jogo[17]);
		testJogadores[3].atribuirCarta(cartas_jogo[18]);
		testJogadores[4].atribuirCarta(cartas_jogo[20]);
		testJogadores[5].atribuirCarta(cartas_jogo[19]);
		
		palpiteTeste = new Palpite("Srta. Scarlet", "Reverendo Green", "Cozinha", "Revólver");
	
		filaPalpites1 = new LinkedList<>(Arrays.asList(palpiteiroPessoa,palpitadoPessoa,pessoaTeste1));
		filaPalpites2 = new LinkedList<>(Arrays.asList(palpiteiroPessoa,palpitadoPessoa,pessoaTeste2));
		filaPalpites3 = new LinkedList<>(Arrays.asList(palpiteiroPessoa,palpitadoPessoa,pessoaTeste3));
		filaPalpites4 = new LinkedList<>(Arrays.asList(palpiteiroPessoa,palpitadoPessoa,pessoaTeste4));

	}
	
	@Test
	public void palpiteTests() {
	    assertNull(palpiteTeste.isPalpiteTrue(filaPalpites1));
	    assertSame(palpiteTeste.isPalpiteTrue(filaPalpites2),cartas_jogo[9]);
		assertSame(palpiteTeste.isPalpiteTrue(filaPalpites3),cartas_jogo[20]);
		assertSame(palpiteTeste.isPalpiteTrue(filaPalpites4),cartas_jogo[5]);
	}
}
