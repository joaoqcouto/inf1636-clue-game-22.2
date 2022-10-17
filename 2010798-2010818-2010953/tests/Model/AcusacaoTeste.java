package Model;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AcusacaoTeste {
	Acusacao acusacaoTeste;
	Pessoa acusadorPessoa;
	Pessoa acusadoPessoa;
	Acusacao novaAcusacao;
	
	
	@Before
	public void setUp() {
		acusacaoTeste = new Acusacao (acusadorPessoa = new Pessoa ("Sra. White"), acusadoPessoa = new Pessoa ("Srta. Scarlet"), "Sala de musica", "Corda");
	}
	
	@Test
	public void acusacaoTests() {
		// gabarito igual a acusacao
		assertTrue(acusacaoTeste.isAcusacaoTrue(acusacaoTeste, "Corda", "Sala de musica", "Srta. Scarlet"));
		//errou apenas a arma
		assertFalse(acusacaoTeste.isAcusacaoTrue(acusacaoTeste, "Faca", "Sala de musica", "Srta. Scarlet"));
		//errou apenas o comodo
		assertFalse(acusacaoTeste.isAcusacaoTrue(acusacaoTeste, "Corda", "Sala de jantar", "Srta. Scarlet"));
		//errou apenas o suspeito
		assertFalse(acusacaoTeste.isAcusacaoTrue(acusacaoTeste, "Corda", "Sala de musica", "Coronel Mustard"));
	}
}
