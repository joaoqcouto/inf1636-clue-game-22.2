package Model;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AcusacaoTeste {
	Acusacao acusacaoTeste;
	Pessoa acusadorPessoa;
	Pessoa acusadoPessoa;
	Acusacao novaAcusacao;
	Cartas []testCartas;
	Cartas []test2Cartas;
	Cartas []envelope;
	
	@Before
	public void setUp() {
		novaAcusacao = new Acusacao("Professor Plum", "Srta. Scarlet", "Entrada", "Corda");
		
		envelope = new Cartas[] 
				{
						new Cartas("arma", "Corda", 0),
						new Cartas("suspeito", "Srta. Scarlet", 1),
						new Cartas("comodo", "Entrada", 2),
				};
		testCartas = new Cartas[] 
				{
						new Cartas("arma", "Corda", 0),
						new Cartas("suspeito", "Srta. Scarlet", 1),
						new Cartas("comodo", "Entrada", 2),
				};
		test2Cartas = new Cartas[] 
				{
						new Cartas("arma", "Faca", 3),
						new Cartas("suspeito", "Professor Plum", 4),
						new Cartas("comodo", "Sala de jantar", 5),
				};
	}
	
	@Test
	public void acusacaoTests() {
		assertTrue(novaAcusacao.isAcusacaoTrue(testCartas));
		assertFalse(novaAcusacao.isAcusacaoTrue(test2Cartas));
		
	}
}
