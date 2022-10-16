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
				new Pessoa("Srta. Scarlet"),	
				new Pessoa("Coronel Mustard"),
				new Pessoa("Professor Plum"),
				new Pessoa("Reverendo Green"),
				new Pessoa("Sra. White"),
				new Pessoa("Sra. Peacock"),
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
		// testes simples horizontal
		assertTrue(testTabuleiro.validaMovimento(9, 8, 9, 3, 1));
		assertTrue(testTabuleiro.validaMovimento(9, 8, 9, 3, 4));
		
		// testes simples vertical
		assertTrue(testTabuleiro.validaMovimento(7, 6, 4, 6, 2));
		assertFalse(testTabuleiro.validaMovimento(7, 6, 4, 6, 1));
		
		// testes com cantos
		assertTrue(testTabuleiro.validaMovimento(16, 16, 15, 16, 4));
		assertTrue(testTabuleiro.validaMovimento( 7, 15, 7, 14, 5));
		assertFalse(testTabuleiro.validaMovimento(16, 16, 15, 16, 3));
		assertFalse(testTabuleiro.validaMovimento( 7, 15, 7, 14, 2));
	}

}
