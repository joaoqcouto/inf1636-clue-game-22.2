package Model;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PalpiteTeste {
	Palpite palpiteTeste;
	Pessoa palpiteiroPessoa;
	Pessoa palpitadoPessoa;	
	
	@Before
	public void setUp() {
		palpiteTeste = new Palpite (palpiteiroPessoa = new Pessoa ("Sra. White"), palpitadoPessoa = new Pessoa ("Srta. Scarlet"), "Sala de musica", "Corda");
	}
	
	@Test
	public void palpiteTests() {
		// gabarito igual a acusacao
		assertTrue(palpiteTeste.isPalpiteTrue(palpiteTeste, 3, "Corda", "Sala de musica", "Srta. Scarlet"));
		//erro no lugar
		assertFalse(palpiteTeste.isPalpiteTrue(palpiteTeste, 3, "Corda", "Sala de jantar", "Srta. Scarlet"));
		//erro na arma
		assertFalse(palpiteTeste.isPalpiteTrue(palpiteTeste, 3, "Faca", "Sala de musica", "Srta. Scarlet"));
		//erro no suspeito
		assertFalse(palpiteTeste.isPalpiteTrue(palpiteTeste, 3, "Corda", "Sala de musica", "Sra. Peacock"));
		
		
	}
}
