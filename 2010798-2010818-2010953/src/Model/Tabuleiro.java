package Model;
import java.util.LinkedList;
import java.util.Queue;
// imports para busca por largura dos caminhos

class Tabuleiro {
	Object [][]tabuleiro;
	
	// matriz de ints que representa o tabuleiro
	// 0 = espaï¿½o vï¿½lido; 1 - 9 = cï¿½modos; -1 -> -6 = jogadores; 10 = espaï¿½o invï¿½lido
	int tabuleiro_base[][] =
		{
			{ 1,  1,  1,  1,  1,  1, 10,  0, 10,  2,  2,  2,  2,  2,  2, 10, -1, 10,  3,  3,  3,  3,  3,  3},
			{ 1,  1,  1,  1,  1,  1,  1,  0,  0,  2,  2,  2,  2,  2,  2,  0,  0,  3,  3,  3,  3,  3,  3,  3},
			{ 1,  1,  1,  1,  1,  1,  1,  0,  0,  2,  2,  2,  2,  2,  2,  0,  0,  3,  3,  3,  3,  3,  3,  3},
			{ 1,  1,  1,  1,  1,  1,  1,  0,  0,  2,  2,  2,  2,  2,  2,  0,  0,  3,  3,  3,  3,  3,  3,  3},
			{10,  0,  0,  0,  0,  0,  0,  0,  0,  2,  2,  2,  2,  2,  2,  0,  0,  3,  3,  3,  3,  3,  3,  3},
			{-6,  0,  0,  0,  0,  0,  0,  0,  0,  2,  2,  2,  2,  2,  2,  0,  0,  3,  3,  3,  3,  3,  3,  3},
			{10,  4,  4,  4,  4,  4,  0,  0,  0,  2,  2,  2,  2,  2,  2,  0,  0,  0,  0,  0,  0,  0,  0, 10},
			{ 4,  4,  4,  4,  4,  4,  4,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -2},
			{ 4,  4,  4,  4,  4,  4,  4,  0,  0, 10, 10, 10, 10, 10,  0,  0,  0,  0,  0,  0,  0,  0,  0, 10},
			{ 4,  4,  4,  4,  4,  4,  4,  0,  0, 10, 10, 10, 10, 10,  0,  0,  6,  6,  6,  6,  6,  6,  6,  6},
			{10,  4,  4,  4,  4,  4,  0,  0,  0, 10, 10, 10, 10, 10,  0,  0,  6,  6,  6,  6,  6,  6,  6,  6},
			{ 0,  0,  0,  0,  0,  0,  0,  0,  0, 10, 10, 10, 10, 10,  0,  0,  6,  6,  6,  6,  6,  6,  6,  6},
			{ 5,  5,  5,  5,  5,  5,  0,  0,  0, 10, 10, 10, 10, 10,  0,  0,  6,  6,  6,  6,  6,  6,  6,  6},
			{ 5,  5,  5,  5,  5,  5,  0,  0,  0, 10, 10, 10, 10, 10,  0,  0,  6,  6,  6,  6,  6,  6,  6,  6},
			{ 5,  5,  5,  5,  5,  5,  0,  0,  0, 10, 10, 10, 10, 10,  0,  0,  6,  6,  6,  6,  6,  6,  6,  6},
			{ 5,  5,  5,  5,  5,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  6,  6,  6,  6,  6},
			{ 5,  5,  5,  5,  5,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 10},
			{10,  0,  0,  0,  0,  0,  0,  0,  8,  8,  8,  8,  8,  8,  8,  8,  0,  0,  0,  0,  0,  0,  0,  0},
			{-5,  0,  0,  0,  0,  0,  0,  0,  8,  8,  8,  8,  8,  8,  8,  8,  0,  0,  9,  9,  9,  9,  9, 10},
			{10,  7,  7,  7,  7,  0,  0,  0,  8,  8,  8,  8,  8,  8,  8,  8,  0,  0,  9,  9,  9,  9,  9,  9},
			{ 7,  7,  7,  7,  7,  7,  0,  0,  8,  8,  8,  8,  8,  8,  8,  8,  0,  0,  9,  9,  9,  9,  9,  9},
			{ 7,  7,  7,  7,  7,  7,  0,  0,  8,  8,  8,  8,  8,  8,  8,  8,  0,  0,  9,  9,  9,  9,  9,  9},
			{ 7,  7,  7,  7,  7,  7,  0,  0,  8,  8,  8,  8,  8,  8,  8,  8,  0,  0,  9,  9,  9,  9,  9,  9},
			{ 7,  7,  7,  7,  7,  7, 10,  0,  0,  0,  8,  8,  8,  8,  0,  0,  0, 10,  9,  9,  9,  9,  9,  9},
			{10, 10, 10, 10, 10, 10, 10, 10, 10, -4, 10,  8,  8, 10, -3, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		};
	
	public Tabuleiro(Pessoa jogadores[]) {
		// alocando espaï¿½o para tabuleiro
		tabuleiro = new Object[tabuleiro_base.length][tabuleiro_base[0].length];
		
		// inicializando todo o tabuleiro exceto os cï¿½modos (cï¿½modos precisam vir depois por causa de suas entradas)
		int rowI = 0;
		for (int row[]:tabuleiro_base) {
			int colI = 0;
			for (int val:row) {
				if (val == 10) tabuleiro[rowI][colI] = null;			
				if (val == 0) tabuleiro[rowI][colI] = new Casa(rowI, colI, false);
				if (val < 0) {
					tabuleiro[rowI][colI] = new Casa(rowI, colI, true);
					jogadores[(val*-1)-1].moverPara(rowI, colI);
				}

				colI++;
			}
			rowI++;
		}
		
		// separando entradas dos cï¿½modos
		Casa entradas[][] =
			{
				// entradas cï¿½modo 1
				{ (Casa)tabuleiro[ 4][ 6] },
				
				// entradas cï¿½modo 2
				{ (Casa)tabuleiro[ 4][ 8], (Casa)tabuleiro[ 7][11], (Casa)tabuleiro[ 7][12] },
				
				// entradas cï¿½modo 3
				{ (Casa)tabuleiro[ 6][17] },
				
				// entradas cï¿½modo 4
				{ (Casa)tabuleiro[ 8][ 7], (Casa)tabuleiro[11][ 3] },
				
				// entradas cï¿½modo 5
				{ (Casa)tabuleiro[11][ 1], (Casa)tabuleiro[15][ 6] },
				
				// entradas cï¿½modo 6
				{ (Casa)tabuleiro[ 8][17], (Casa)tabuleiro[12][15] },
				
				// entradas cï¿½modo 7
				{ (Casa)tabuleiro[19][ 5] },
				
				// entradas cï¿½modo 8
				{ (Casa)tabuleiro[19][ 7], (Casa)tabuleiro[16][ 9], (Casa)tabuleiro[16][14], (Casa)tabuleiro[19][16] },
				
				// entradas cï¿½modo 9
				{ (Casa)tabuleiro[17][19] },
			};
		
		// posicoes em cada comodo de forma que todas as posicoes em volta sejam no comodo
		int centros[][] =
			{
				{ 2 , 3  },
				{ 3 , 11 },
				{ 3 , 20 },
				{ 8 , 3  },
				{ 14, 3  },
				{ 12, 20 },
				{ 22, 3  },
				{ 20, 11 },
				{ 20, 20 },
			};
		
		// criando cï¿½modos
		Comodo comodos[] =
			{
				new Comodo("Escritorio", 		entradas[0], centros[0] ),	
				new Comodo("Entrada", 			entradas[1], centros[1] ),
				new Comodo("Sala de estar", 	entradas[2], centros[2] ),
				new Comodo("Biblioteca", 		entradas[3], centros[3] ),
				new Comodo("Salao de jogos", 	entradas[4], centros[4] ),
				new Comodo("Sala de jantar", 	entradas[5], centros[5] ),
				new Comodo("Jardim de inverno", entradas[6], centros[6] ),
				new Comodo("Sala de musica", 	entradas[7], centros[7] ),
				new Comodo("Cozinha", 			entradas[8], centros[8] ),
			};
		
		// colocando cï¿½modos no tabuleiro
		rowI = 0;
		for (int row[]:tabuleiro_base) {
			int colI = 0;
			for (int val:row) {
				if (val > 0 && val < 10) tabuleiro[rowI][colI] = comodos[val-1];			
				colI++;
			}
			rowI++;
		}
		
		// adicionando passagens secretas
		comodos[0].setPassagemSecreta(comodos[8]);
		comodos[8].setPassagemSecreta(comodos[0]);
		comodos[2].setPassagemSecreta(comodos[6]);
		comodos[6].setPassagemSecreta(comodos[2]);
		
		// adicionando os vizinhos (precisa ser feito após inicialização do tabuleiro todo)
		rowI = 0;
		for (Object row[]:tabuleiro) {
			int colI = 0;
			for (Object casa:row) {
				// casas para adicionar vizinhos
				if (casa instanceof Casa) {
					// vizinho de baixo
					if (rowI < tabuleiro.length-1 && tabuleiro[rowI+1][colI] instanceof Casa) ((Casa) casa).addVizinho((Casa)tabuleiro[rowI+1][colI]);
					// vizinho de cima
					if (rowI > 0 && tabuleiro[rowI-1][colI] instanceof Casa) ((Casa) casa).addVizinho((Casa)tabuleiro[rowI-1][colI]);
					// vizinho da direita
					if (colI < tabuleiro[0].length-1 && tabuleiro[rowI][colI+1] instanceof Casa) ((Casa) casa).addVizinho((Casa)tabuleiro[rowI][colI+1]);
					// vizinho da esquerda
					if (colI > 0 && tabuleiro[rowI][colI-1] instanceof Casa) ((Casa) casa).addVizinho((Casa)tabuleiro[rowI][colI-1]);
				}
				colI++;
			}
			rowI++;
		}
	}
	
	// reset do tabuleiro para algoritmo de distância
	void resetDist() {
		for (Object row[]:tabuleiro) for (Object casa:row) if (casa instanceof Casa) ((Casa) casa).resetDist();
	}
	
	// cï¿½lculo da distï¿½ncia entre duas casas do tabuleiro
	int calculaDistancia(Casa ini, Casa fim) {
		this.resetDist();
		Queue<Casa> q = new LinkedList<>();
		
		ini.setDist(0);
		q.add(ini);
		while (q.size() > 0) {
			Casa c = q.remove();
			if (c == fim) return c.getDist();
			for (Casa n:c.vizinhos()) {
				if (!n.ocupado()) {
					if (n.getDist() > c.getDist()+1 || n.getDist() == -1) {
						n.setDist(c.getDist()+1);
						q.add(n);
					}
				}
			}
		}
		
		return 1000; // não tem trajeto (distância infinita -> muito alto)
	}
	
	// valida movimento a partir de uma coordenada (x, y) para outra (x,y) no tabuleiro
	boolean validaMovimento(int rowIni, int colIni, int rowFim, int colFim, int dado) {		
		// mesmo lugar
		if (rowIni==rowFim && colIni==colFim) return false;
		
		// final fora do tabuleiro jogï¿½vel
		if (!(tabuleiro[rowFim][colFim] instanceof Casa) && !(tabuleiro[rowFim][colFim] instanceof Comodo)) return false;

		// ambos sï¿½o casas
		if (tabuleiro[rowIni][colIni] instanceof Casa && tabuleiro[rowFim][colFim] instanceof Casa) {
			// custo atï¿½ a casa precisa ser igual ao custo do trajeto
			return dado == calculaDistancia((Casa)tabuleiro[rowIni][colIni], (Casa)tabuleiro[rowFim][colFim]);
		}
		
		// de uma casa para um cï¿½modo
		else if (tabuleiro[rowIni][colIni] instanceof Casa && tabuleiro[rowFim][colFim] instanceof Comodo) {
			//  basta chegar em uma entrada livre
			Comodo f = (Comodo)tabuleiro[rowFim][colFim];
			Casa destinos[] = f.entradas();
			for (Casa dest:destinos) {
				if (!dest.ocupado() && calculaDistancia((Casa)tabuleiro[rowIni][colIni], dest) <= dado) return true;				
			}
		}
		
		// de um cï¿½modo para uma casa
		else if (tabuleiro[rowIni][colIni] instanceof Comodo && tabuleiro[rowFim][colFim] instanceof Casa) {
			// uma das entradas do cï¿½modo precisa ter a distï¿½ncia certa atï¿½ a casa
			Comodo i = (Comodo)tabuleiro[rowIni][colIni];
			Casa inicios[] = i.entradas();
			for (Casa ini:inicios) {
				if (!ini.ocupado() && calculaDistancia(ini, (Casa)tabuleiro[rowFim][colFim]) == dado) return true;
			}
		}
		
		// de cï¿½modo X para cï¿½modo Y
		else if (tabuleiro[rowIni][colIni] instanceof Comodo && tabuleiro[rowFim][colFim] instanceof Comodo) {			
			// uma das entradas de X precisa estar dentro da distï¿½ncia para uma das entradas de Y
			Comodo i = (Comodo)tabuleiro[rowIni][colIni];
			Casa inicios[] = i.entradas();
			Comodo f = (Comodo)tabuleiro[rowFim][colFim];
			Casa destinos[] = f.entradas();
			
			// mesmo cômodo
			if (i == f) return false;
			
			// caso especial: passagem secreta
			if (i.passagemSecreta() == f) return true;
			
			for (Casa ini:inicios) {
				for (Casa dest:destinos) {
					if (!ini.ocupado() && !dest.ocupado() && calculaDistancia(ini, dest) <= dado) return true;
				}
			}
		}
		// else
		return false;
	}
	
	// movimento comum
	boolean movePessoa(Pessoa p, int[] posicaoFim, int dados) {
		int[] posicaoIni = p.posicao();
		
		// se movimento pode ser feito
		boolean podeMover = validaMovimento(posicaoIni[0], posicaoIni[1], posicaoFim[0], posicaoFim[1], dados);
		System.out.println("Movimento checado");
		if ( podeMover ) {
			
			if (tabuleiro[posicaoIni[0]][posicaoIni[1]] instanceof Casa) {
				Casa casaIni = (Casa)tabuleiro[posicaoIni[0]][posicaoIni[1]];
				casaIni.desocupar();
			}
			
			if (tabuleiro[posicaoFim[0]][posicaoFim[1]] instanceof Casa) {
				Casa casaFim = (Casa)tabuleiro[posicaoFim[0]][posicaoFim[1]];
				casaFim.ocupar();
			}
			
			if (tabuleiro[posicaoIni[0]][posicaoIni[1]] instanceof Comodo) {
				Comodo comodoIni = (Comodo)tabuleiro[posicaoIni[0]][posicaoIni[1]];
				comodoIni.saiComodo(p);
			}
			
			if (tabuleiro[posicaoFim[0]][posicaoFim[1]] instanceof Comodo) {
				Comodo comodoFim = (Comodo)tabuleiro[posicaoFim[0]][posicaoFim[1]];
				comodoFim.entraComodo(p);
			}
			
			p.moverPara(posicaoFim[0], posicaoFim[1]);
			
			// movimento feito
			return true;
		}
		return false;
	}
		
	// levando para comodo (palpite)
	void transportaPessoa(Pessoa p, Comodo comodoFim) {
		int[] posicaoIni = p.posicao();

		System.out.println("Movimento checado");
			
		if (tabuleiro[posicaoIni[0]][posicaoIni[1]] instanceof Casa) {
			Casa casaIni = (Casa)tabuleiro[posicaoIni[0]][posicaoIni[1]];
			casaIni.desocupar();
		}
		
		if (tabuleiro[posicaoIni[0]][posicaoIni[1]] instanceof Comodo) {
			Comodo comodoIni = (Comodo)tabuleiro[posicaoIni[0]][posicaoIni[1]];
			comodoIni.saiComodo(p);
		}
		
		int[] livre = comodoFim.getPosicaoLivre();
		comodoFim.entraComodo(p);
		
		p.moverPara(livre[0], livre[1]);
	}
}
