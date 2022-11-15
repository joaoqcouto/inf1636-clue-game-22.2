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
				palpiteiroPessoa = new Pessoa("Srta. Scarlet"),	
			    palpitadoPessoa = new Pessoa("Coronel Mustard"),
				pessoaTeste1 = new Pessoa("Professor Plum"),
				pessoaTeste2 = new Pessoa("Reverendo Green"),
				pessoaTeste3 = new Pessoa("Sra. White"),
				pessoaTeste4 = new Pessoa("Sra. Peacock"),
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
