package Model;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TabuleiroTest {
	Tabuleiro testTabuleiro;
	
	@Before
	public void setUp() {
		Pessoa jogadores[] =
			{
				new Pessoa("Srta. Scarlet", 0),	
				new Pessoa("Coronel Mustard", 1),
				new Pessoa("Professor Plum", 2),
				new Pessoa("Reverendo Green", 3),
				new Pessoa("Sra. White", 4),
				new Pessoa("Sra. Peacock", 5),
			};
		testTabuleiro = new Tabuleiro(jogadores);
	}
	
	@Test
	public void movementTests() {
	// TESTES DE CASA -> CASA
		// testes simples horizontal
		assertTrue(testTabuleiro.validaMovimento(5, 1, 5, 2, 1));
		assertFalse(testTabuleiro.validaMovimento(5, 1, 5, 3, 1));
		
		// testes simples vertical
		assertTrue(testTabuleiro.validaMovimento(5, 7, 4, 7, 1));
		assertFalse(testTabuleiro.validaMovimento(5, 7, 3, 7, 1));
		
		// testes com cantos
		assertTrue(testTabuleiro.validaMovimento(5, 16, 7, 18, 4));
		assertTrue(testTabuleiro.validaMovimento(15, 15, 16, 18, 4));
		assertFalse(testTabuleiro.validaMovimento(15, 15, 16, 18, 3));
		
		// testes com caminho não convencional
		assertTrue(testTabuleiro.validaMovimento(11, 6, 7, 6, 6));
		assertFalse(testTabuleiro.validaMovimento(11, 6, 7, 6, 4));
		assertTrue(testTabuleiro.validaMovimento(9, 8, 9, 14, 8));
		assertFalse(testTabuleiro.validaMovimento(9, 8, 9, 14, 6));
		
	// TESTES DE CASA -> COMODO
		assertTrue(testTabuleiro.validaMovimento(9, 8, 9, 3, 1));
		assertTrue(testTabuleiro.validaMovimento(9, 8, 9, 3, 4));
		
		
	// TESTES DE COMODO -> CASA
		// comodo com uma entrada
		assertTrue(testTabuleiro.validaMovimento(4, 6, 6, 6, 1));
		assertTrue(testTabuleiro.validaMovimento(3, 2, 6, 6, 1));
		assertFalse(testTabuleiro.validaMovimento(3, 2, 5, 6, 1));
		
		// comodo com mais entradas
		assertTrue(testTabuleiro.validaMovimento(20, 11, 16, 13, 2));
		assertTrue(testTabuleiro.validaMovimento(20, 11, 16, 13, 5));
		assertFalse(testTabuleiro.validaMovimento(20, 11, 16, 13, 3));
		
	// TESTES DE COMODO -> COMODO
		// passagens normais
		assertTrue(testTabuleiro.validaMovimento(3, 3, 4, 11, 2));
		assertTrue(testTabuleiro.validaMovimento(3, 3, 4, 11, 5));
		assertTrue(testTabuleiro.validaMovimento(4, 20, 12, 20, 2));
		assertFalse(testTabuleiro.validaMovimento(4, 20, 12, 20, 1));
		
		// mesmo cômodo
		assertFalse(testTabuleiro.validaMovimento(3, 3, 1, 3, 1));
		assertFalse(testTabuleiro.validaMovimento(13, 16, 13, 20, 4));
		
		// passagem secreta (dado não importaria para passar)
		assertTrue(testTabuleiro.validaMovimento(3, 3, 22, 22, 0));
		assertTrue(testTabuleiro.validaMovimento(22, 2, 3, 20, 5));
		assertTrue(testTabuleiro.validaMovimento(22, 22, 3, 3, 6));
		assertTrue(testTabuleiro.validaMovimento(3, 20, 22, 2, 3));
	}

}
