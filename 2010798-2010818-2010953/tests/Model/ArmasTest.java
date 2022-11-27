package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArmasTest {
	Armas testArmas[];
	
	
	
	@Before
	public void setUp() {
		testArmas = new Armas[] 
			{
				new Armas("Corda"),
				new Armas("Cano de Chumbo"),
				new Armas("Faca"),
				new Armas("Chave Inglesa"),
				new Armas("Castical"),
				new Armas("Revolver"),
			};
	}
	
	@Test
	public void posicaoarmastest() {
		assertSame("Corda", testArmas[0].NomeArma());
		assertSame("Cano de Chumbo", testArmas[1].NomeArma());
		assertSame("Faca", testArmas[2].NomeArma());
		assertSame("Chave Inglesa", testArmas[3].NomeArma());
		assertSame("Castical", testArmas[4].NomeArma());
		assertSame("Revolver", testArmas[5].NomeArma());
	}

}
