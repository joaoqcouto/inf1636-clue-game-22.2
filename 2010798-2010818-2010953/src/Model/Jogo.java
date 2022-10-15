package Model;
import java.util.Scanner;
import java.util.Random;

public class Jogo {
	// mantem o tabuleiro, os jogadores, a ordem das jogadas, a resposta certa, etc.
	public Jogo() {
		
		Cartas cartas_jogo[] = 
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
		Pessoa jogadores[] =
			{
				new Pessoa("Srta. Scarlet"),	
				new Pessoa("Coronel Mustard"),
				new Pessoa("Professor Plum"),
				new Pessoa("Reverendo Green"),
				new Pessoa("Sra. White"),
				new Pessoa("Sra. Peacock"),
			};
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("Insira quantidade de Jogadores(de 3 a 6):%n");
		int qtd_jogadores = sc.nextInt();
		int total_cartas = 21; 
		
		//gabarito
		Random gerador = new Random();
		int num_arma = gerador.nextInt(6);
		int num_suspeito = 6 + gerador.nextInt(6);
		int num_comodo = 12 + gerador.nextInt(9);
		
		Cartas envolepe [] = 
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
			
		
		// criando tabuleiro e posicionando os jogadores nele
		Tabuleiro tabuleiro = new Tabuleiro(jogadores);
		
	}
}
