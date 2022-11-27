package Model;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Jogo {
	// jogo � singleton
	static Jogo jogo = null;
	
	// mantem o tabuleiro, os jogadores, a ordem das jogadas, a resposta certa, etc.
	Cartas cartas_jogo[];
	Pessoa jogadores[];
	Queue<Pessoa> filaJogadores;
	Queue<Pessoa> filaPalpites;
	Cartas envelope [];
	Tabuleiro tabuleiro;
	Dados dados;
	Armas armas[];
	
	// mantem em que 'fase' de uma rodada o jogo esta
	// vai ser util para limitar as acoes possiveis do jogador
	// 0 => rola dados ; 1 => escolhe pra onde vai ; 2 => palpita/acusa/passa a vez ; 3 => acusa/passa a vez
	int fase_rodada = 0;
	
	// operadores de singleton
	public static void createJogo(boolean a_jogar[]) {
		jogo = new Jogo(a_jogar);
	}
	
	public static Jogo getJogo() {
		return jogo;
	}
	
	private Jogo(boolean a_jogar[]) {
		Random gerador = new Random();
		dados = new Dados();
		
		armas = new Armas[] 
		{
				new Armas("Corda"),
				new Armas("Cano de Chumbo"),
				new Armas("Faca"),
				new Armas("Chave Inglesa"),
				new Armas( "Castical"),
				new Armas("Revolver"),
		};
		
		int pos_arma[] = new int[6];
		 
		for (int i = 0; i < pos_arma.length; i++) {
			pos_arma[i] = -1; 
		}
		
		for(int i = 0; i < pos_arma.length; i++) {
			int position = 1 + gerador.nextInt(9);
			pos_arma[i] = position; 
		}
		
		for(int i = 0; i<6;i++) {
			armas[i].inicializaPosicaoArma(pos_arma[i]); 
		}
		
		
		cartas_jogo = new Cartas[] 
			{
				new Cartas("arma", "Corda", 0),
				new Cartas("arma", "Cano de Chumbo", 1),
				new Cartas("arma", "Faca", 2),
				new Cartas("arma", "Chave Inglesa", 3),
				new Cartas("arma", "Castical", 4),
				new Cartas("arma", "Revolver", 5),
				new Cartas("suspeito", "Srta. Scarlet", 6),
				new Cartas("suspeito", "Coronel Mustard", 7),
				new Cartas("suspeito", "Professor Plum", 8),
				new Cartas("suspeito", "Reverendo Green", 9),
				new Cartas("suspeito", "Sra. White", 10),
				new Cartas("suspeito", "Sra. Peacock", 11),
				new Cartas("comodo", "Escritorio", 12),
				new Cartas("comodo", "Entrada", 13),
				new Cartas("comodo", "Sala de estar", 14),
				new Cartas("comodo", "Biblioteca", 15),
				new Cartas("comodo", "Salao de jogos", 16),
				new Cartas("comodo", "Sala de jantar", 17),
				new Cartas("comodo", "Jardim de inverno", 18),
				new Cartas("comodo", "Sala de musica", 19),
				new Cartas("comodo", "Cozinha", 20),
		};
		
		// criando jogadores (Da pra dar mais liberdade na escolha)
		jogadores = new Pessoa[]
			{
				new Pessoa("Srta. Scarlet", 0),	
				new Pessoa("Coronel Mustard", 1),
				new Pessoa("Sra. White", 2),
				new Pessoa("Reverendo Green", 3),
				new Pessoa("Sra. Peacock", 4),
				new Pessoa("Professor Plum", 5),
			};
		
		int total_cartas = 21; 
		
		//gabarito
		
		int num_arma = gerador.nextInt(6);
		int num_suspeito = 6 + gerador.nextInt(6);
		int num_comodo = 12 + gerador.nextInt(9);
		
		envelope = new Cartas[] 
		{
				cartas_jogo[num_arma],
				cartas_jogo[num_suspeito],
				cartas_jogo[num_comodo],
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
		
		// distribuindo cartas
		int j= 0; 
		for(int i = 0; i < total_cartas; i++) {
			if(aux[i] != num_arma && aux[i] != num_suspeito && aux[i] != num_comodo) {
				// proximo que vai jogar
				while (!a_jogar[j]) j = (j+1) % jogadores.length;
				jogadores[j].atribuirCarta(cartas_jogo[aux[i]]);
				j = (j+1) % jogadores.length; 
			}
			
		}
		
		// coloca na fila quem for jogar
		filaJogadores = new LinkedList<>();
		filaPalpites = new LinkedList<>();
		for (int i = 0; i < jogadores.length; i++) {
			if (a_jogar[i]) {
				filaPalpites.add(jogadores[i]);
				filaJogadores.add(jogadores[i]);
			}
		}
		
		// criando tabuleiro e posicionando os jogadores nele
		tabuleiro = new Tabuleiro(jogadores);
		
	}
	
	// salvando jogo para inicializar certo
	/*
		para salvar o jogo precisa salvar:
		
		TABULEIRO
		- onde estao os jogadores
		
		TURNO
		- fila do jogo
		- fila de desprovar palpite (tem eliminados)
		- fase da rodada
		- dados
		
		PALPITES
		- quem tem quais cartas
		- anotacoes
		- envelope
		
		
	*/
	public boolean salvaJogo() {
		PrintWriter out = null;
		Locale l;
		try {
			out = new PrintWriter(new FileWriter("gamesave.txt"));
			l = new Locale.Builder().setLanguage("pt").setScript("Latn").setRegion("BR").build();
			
			// saving player positions
			out.format(l, "POSICOES\n");
			for (Pessoa p:jogadores) {
				int[] pos = p.posicao();
				out.format(l, "%d %d\n", pos[0], pos[1]);
			}
			
			// saving play queue
			Queue<Pessoa> copiaFilaJogadores = new LinkedList<>(filaJogadores);
			out.format(l, "\nFILA VEZ\n");
			out.format(l, "%d\n", copiaFilaJogadores.size());
			while (!copiaFilaJogadores.isEmpty()) {
				Pessoa p = copiaFilaJogadores.poll();
				out.format(l, "%d ", p.numero());
			}
			out.format(l, "\n");
			
			// saving guess queue
			Queue<Pessoa> copiaFilaPalpites = new LinkedList<>(filaPalpites);
			out.format(l, "\nFILA PALPITES\n");
			out.format(l, "%d\n", copiaFilaPalpites.size());
			while (!copiaFilaPalpites.isEmpty()) {
				Pessoa p = copiaFilaPalpites.poll();
				out.format(l, "%d ", p.numero());
			}
			out.format(l, "\n");
			
			// saving turn phase
			out.format(l, "\nFASE RODADA\n");
			out.format(l, "%d\n", fase_rodada);
			
			// saving dice
			int d[] = dados.getDados();
			out.format(l, "\nDADOS\n");
			out.format(l, "%d %d\n", d[0], d[1]);
			
			// saving cards for each person
			// one line is (number of cards for person) - (their cards)
			out.format(l, "\nCARTAS\n");
			for (Pessoa p:jogadores) {
				
				int num = p.qtdCartas();
				Cartas c[] = p.cartas();
				
				out.format(l, "%d - ", num);
				for (int i = 0; i < num; i++) {
					out.format(l, "%d ", c[i].numero());
				}
				out.format(l, "\n");
			}
			
			// saving envelope
			out.format(l, "\nENVELOPE\n");
			for (Cartas c:envelope) {
				out.format(l, "%d ", c.numero());
			}
			out.format(l, "\n");
			
			// saving notes for each person
			// one line is (number of notes for person) - (cards they have notes on)
			out.format(l, "\nNOTAS\n");
			for (Pessoa p:jogadores) {
				
				Map<String, Boolean> notas = p.getNotas();
				
				int qtdNotas = 0;
				for (Map.Entry<String,Boolean> nota : notas.entrySet()) {
					if (nota.getValue()) qtdNotas++;
				}
				
				out.format(l, "%d - ", qtdNotas);
				for (Map.Entry<String,Boolean> nota : notas.entrySet()) {
					if (nota.getValue()) out.format(l, "(%s) ", nota.getKey());
				}
				out.format(l, "\n");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return false; // erro ao salvar
		}
		finally { out.close(); }
		return true; // salvou com sucesso
	}
	
	//Cartas jogador atual
	public String[] getCartasJogadorAtual(){
		Pessoa atual = filaJogadores.peek();
		Cartas cartas[] = atual.cartas(); 
		int qtd = atual.qtdCartas();
		
		String cartasNomes[] = new String[qtd];
		for (int i = 0; i<qtd; i++) cartasNomes[i] = cartas[i].Nome();
		
		return cartasNomes;
	}

	// controle de qual 'fase' da rodada esta
	public int getFase() { return fase_rodada; }
	public void proxFase() { fase_rodada++; }
		
	// jogando dados
	public void rolaDados() { dados.rolaDados(); }
	public void setDados(int[] d) { dados.setDados(d); }
	public int[] getDados() { return dados.getDados(); }
	
	// checa se tem jogadores
	public boolean semJogadores() {
		return filaJogadores.isEmpty();
	}
	
	// pega jogador atual
	public String getJogadorAtualNome() {
		Pessoa atual = filaJogadores.peek();
		return atual.nome();
	}
	
	// pos do jogador atual
	public int[] getJogadorAtualPosicao() {
		Pessoa atual = filaJogadores.peek();
		return atual.posicao();
	}
	
	// passa jogador atual pro fim
	public void passaVez() {
		if (fase_rodada >= 2) {
			fase_rodada = 0;
			Pessoa atual = filaJogadores.remove();
			filaJogadores.add(atual);
		}
		
		// passa para palpite caso esteja preso
		if (tabuleiro.estaPresoEmComodo(filaJogadores.peek())) fase_rodada = 2;
	}
	
	// tira jogador atual da rotacao apos acusacao errada
	public void tiraDoJogo() {
		if (fase_rodada >= 2) {
			fase_rodada = 0;
			filaJogadores.remove();
		}
		
		// passa para palpite caso esteja preso
		if (tabuleiro.estaPresoEmComodo(filaJogadores.peek())) fase_rodada = 2;
	}
	
	public boolean moveJogador(int[] posFinal) {
		if (fase_rodada == 1) {
			Pessoa atual = filaJogadores.peek();
			boolean moveu = tabuleiro.movePessoa(atual, posFinal, dados.getSomaDados());
			if (moveu) {
				fase_rodada++;
				System.out.println("Movimento feito");
			};
			return moveu;
		}
		return false;
	}
	
	// pega posicoes dos jogadores
	// ordem sempre igual do vetor original
	public int[][] getPosicoesJogadores() {
		int[][] pos = new int[jogadores.length][];
		
		// preenche posicoes
		for (int i=0; i<jogadores.length; i++) {
			pos[i] = jogadores[i].posicao();
		}
		
		return pos;
	}
	
	// notas
	public Map<String, Boolean> getNotas() {
		Pessoa atual = filaJogadores.peek();
		return atual.getNotas();
	}
	public void updateNotas(String s, Boolean b) {
		Pessoa atual = filaJogadores.peek();
		atual.updateNotas(s, b);
	}
	
	// palpite e acusacao
	public boolean estaEmComodo() {
		Pessoa atual = filaJogadores.peek();
		return tabuleiro.estaEmComodo(atual);
	}
	
	// retorna nome da carta que nega palpite (ou null)
	public String palpita(String palpitado, String arma) {
		Pessoa atual = filaJogadores.peek();
		
		// tenta transportar jogador e pegar nome do comodo
		String comodo = tabuleiro.transportaPessoa(atual, palpitado);
		if (comodo == null) return null;
		
		// monta e valida o palpite
		Palpite palpite_corrente = new Palpite(atual.nome(), palpitado, comodo, arma);
		Cartas cartaPalpite = palpite_corrente.isPalpiteTrue(new LinkedList<>(filaPalpites));
		
		// retorna o nome da carta (ou nada)
		if (cartaPalpite==null) return "n";
		return cartaPalpite.Nome();
	}
	
	public boolean acusa(String acusado, String lugar, String arma) {
		Pessoa atual = filaJogadores.peek();
		Acusacao acusacao_corrente = new Acusacao(atual.nome(), acusado, lugar, arma);
		
		Boolean acertou = acusacao_corrente.isAcusacaoTrue(envelope);
		// se errou perdeu a vez pra sempre
		if (!acertou) {
			tiraDoJogo();
		}
		
		return acertou;
	}
	
	public String[] getCartasEnvelope() {
		String cartasNomes[] = new String[3];
		for (int i = 0; i<3; i++) cartasNomes[i] = envelope[i].Nome();
		
		return cartasNomes;
	}
}
