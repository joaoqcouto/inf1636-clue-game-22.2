package Model;
import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;

public class Jogo {
	// mantem o tabuleiro, os jogadores, a ordem das jogadas, a resposta certa, etc.
	Cartas cartas_jogo[];
	Pessoa jogadores[];
	Queue<Pessoa> filaJogadores;
	Cartas envelope [];
	Tabuleiro tabuleiro;
	Dados dados;
	Armas armas[];
	
	public Jogo(int qtd_jogadores) {
		Random gerador = new Random();
		dados = new Dados();
		
		armas = new Armas[] 
		{
				new Armas("Corda"),
				new Armas("Cano de Chumbo"),
				new Armas("Faca"),
				new Armas("Chave Inglesa"),
				new Armas( "Castiçal"),
				new Armas("Revólver"),
		};
		
		int pos_arma[] = new int[6];
		 
		for (int i = 0; i < pos_arma.length; i++) {
			pos_arma[i] = -1; 
		}
		
		for(int i = 0; i < pos_arma.length; i++) {
			int position = 1 + gerador.nextInt(9);
			while(pos_arma[position]!=-1) {
				position = (position + 1) % 6; 
			}
			pos_arma[position] = i; 
		}
		
		for(int i = 0; i<6;i++) {
			armas[i].inicializaPosicaoArma(pos_arma[i]); 
		}
		
		
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
		
		// criando jogadores (Da pra dar mais liberdade na escolha)
		jogadores = new Pessoa[]
			{
				new Pessoa("Srta. Scarlet"),	
				new Pessoa("Coronel Mustard"),
				new Pessoa("Professor Plum"),
				new Pessoa("Reverendo Green"),
				new Pessoa("Sra. White"),
				new Pessoa("Sra. Peacock"),
			};
		
		int total_cartas = 21; 
		
		//gabarito
		
		int num_arma = gerador.nextInt(6);
		int num_suspeito = 6 + gerador.nextInt(6);
		int num_comodo = 12 + gerador.nextInt(9);
		
		envelope = new Cartas[] 
		{
				new Cartas(cartas_jogo[num_arma].Tipo(), cartas_jogo[num_arma].Nome()),
				new Cartas(cartas_jogo[num_suspeito].Tipo(), cartas_jogo[num_suspeito].Nome()),
				new Cartas(cartas_jogo[num_comodo].Tipo(), cartas_jogo[num_comodo].Nome()),
		};
		
		int aux[] = new int[21]; 
		for (int i = 0; i < aux.length; i++) {
			aux[i] = -1; 
		}
		
		for(int i = 0; i < aux.length; i++) {
			int pos =  gerador.nextInt(21);
			while(aux[pos]!=-1) {
				pos = (pos + 1) % 21; 
			}
			aux[pos] = i; 
		}
		
		int j= 0; 
		for(int i = 0; i < total_cartas; i++) {
			if(aux[i] != num_arma && aux[i] != num_suspeito && aux[i] != num_comodo) {
				jogadores[j].atribuirCarta(cartas_jogo[aux[i]]);
				j = (j+1) % qtd_jogadores; 
			}
			
		}
		
		// coloca jogadores na fila de pr�ximo de acordo com a quantidade
		filaJogadores = new LinkedList<>();
		for (int i = 0; i < qtd_jogadores; i++) {
			filaJogadores.add(jogadores[i]);
		}
		
		// criando tabuleiro e posicionando os jogadores nele
		tabuleiro = new Tabuleiro(jogadores);
		
	}
	
	public Pessoa getJogadorAtual() {
		Pessoa atual = filaJogadores.peek();
		return atual;
	}
	
	public void passaVez() {
		Pessoa atual = filaJogadores.remove();
		filaJogadores.add(atual);
	}
	
	public void tiraDoJogo(String nome) {
		for (Pessoa p:jogadores) {
			if (p.nome() == nome) {
				filaJogadores.remove(p);
				break;
			}
		}
	}
}
