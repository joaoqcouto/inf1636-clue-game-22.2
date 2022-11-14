package Model;
import java.util.Random;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
				new Cartas("arma", "Corda"),
				new Cartas("arma", "Cano de Chumbo"),
				new Cartas("arma", "Faca"),
				new Cartas("arma", "Chave Inglesa"),
				new Cartas("arma", "Castical"),
				new Cartas("arma", "Revolver"),
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
				new Pessoa("Sra. White"),
				new Pessoa("Reverendo Green"),
				new Pessoa("Sra. Peacock"),
				new Pessoa("Professor Plum"),
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
	
	//Cartas jogador atual
	public Cartas[] getCartasJogadorAtual(){
		Pessoa atual = filaJogadores.peek();
		return atual.cartas(); 
	}
	public int getQtdCartasJogadorAtual(){
		Pessoa atual = filaJogadores.peek();
		return atual.qtdCartas(); 
	}
	
	// controle de qual 'fase' da rodada esta
	public int getFase() { return fase_rodada; }
	public void proxFase() { fase_rodada++; }
		
	// jogando dados
	public void rolaDados() { dados.rolaDados(); }
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
	}
	
	// tira jogador atual da rotacao apos acusacao errada
	public void tiraDoJogo() {
		if (fase_rodada >= 2) {
			fase_rodada = 0;
			filaJogadores.remove();
		}
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
	
	public Cartas[] getCartasEnvelope() { return envelope; }
}
