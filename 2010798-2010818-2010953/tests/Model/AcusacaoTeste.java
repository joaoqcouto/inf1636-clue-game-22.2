package Model;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

// precisa refazer os testes
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
						new Cartas("arma", "Corda"),
						new Cartas("suspeito", "Srta. Scarlet"),
						new Cartas("comodo", "Entrada"),
				};
		testCartas = new Cartas[] 
				{
						new Cartas("arma", "Corda"),
						new Cartas("suspeito", "Srta. Scarlet"),
						new Cartas("comodo", "Entrada"),
				};
		test2Cartas = new Cartas[] 
				{
						new Cartas("arma", "Faca"),
						new Cartas("suspeito", "Professor Plum"),
						new Cartas("comodo", "Sala de jantar"),
				};
	}
	
	@Test
	public void acusacaoTests() {
		assertTrue(novaAcusacao.isAcusacaoTrue(testCartas));
		assertFalse(novaAcusacao.isAcusacaoTrue(test2Cartas));
		
	}
}
