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
						new Armas("Castiçal"),
						new Armas("Revólver"),
				};
		
		int pos_arma[] = new int[6];
		 
		pos_arma[0] = 5;
		pos_arma[1] = 1;
		pos_arma[2] = 3;
		pos_arma[3] = 9;
		pos_arma[4] = 7;
		pos_arma[5] = 4;
		
		
		testArmas[0].inicializaPosicaoArma(pos_arma[0]); 
		testArmas[1].inicializaPosicaoArma(pos_arma[1]);
		testArmas[2].inicializaPosicaoArma(pos_arma[2]);
		testArmas[3].inicializaPosicaoArma(pos_arma[3]);
		testArmas[4].inicializaPosicaoArma(pos_arma[4]);
		testArmas[5].inicializaPosicaoArma(pos_arma[5]);
		
	}
	
	@Test
	public void posicaoarmastest() {
		assertSame("Corda", testArmas[0].NomeArma());
		assertSame(15, testArmas[0].posicao[0]);
		assertSame(3, testArmas[0].posicao[1]);
		assertSame("Cano de Chumbo", testArmas[1].NomeArma());
		assertSame(3, testArmas[1].posicao[0]);
		assertSame(3, testArmas[1].posicao[1]);
		assertSame("Faca", testArmas[2].NomeArma());
		assertSame(3, testArmas[2].posicao[0]);
		assertSame(20, testArmas[2].posicao[1]);
		assertSame("Chave Inglesa", testArmas[3].NomeArma());
		assertSame(22, testArmas[3].posicao[0]);
		assertSame(20, testArmas[3].posicao[1]);
		assertSame("Castiçal", testArmas[4].NomeArma());
		assertSame(22, testArmas[4].posicao[0]);
		assertSame(3, testArmas[4].posicao[1]);
		assertSame("Revólver", testArmas[5].NomeArma());
		assertSame(9, testArmas[5].posicao[0]);
		assertSame(3, testArmas[5].posicao[1]);
		
	}

}
