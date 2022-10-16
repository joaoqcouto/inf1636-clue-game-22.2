package Model;
import java.util.LinkedList;
import java.util.Queue;
// imports para busca por largura dos caminhos

class Tabuleiro {
	Object [][]tabuleiro;
	
	// matriz de ints que representa o tabuleiro
	// tabuleiro � 26 linhas : 24 colunas, coordenadas [linha][coluna]
	// 0 = espa�o v�lido; 1 - 9 = c�modos; -1 -> -6 = jogadores; 10 = espa�o inv�lido
	int tabuleiro_base[][] =
		{
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,  2,  2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
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
		// alocando espa�o para tabuleiro
		tabuleiro = new Object[tabuleiro_base.length][tabuleiro_base[0].length];
		
		// inicializando todo o tabuleiro exceto os c�modos (c�modos precisam vir depois por causa de suas entradas)
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
		
		// separando entradas dos c�modos
		Casa entradas[][] =
			{
				// entradas c�modo 1
				{ (Casa)tabuleiro[ 5][ 6] },
				
				// entradas c�modo 2
				{ (Casa)tabuleiro[ 5][ 8], (Casa)tabuleiro[ 8][11], (Casa)tabuleiro[ 8][12] },
				
				// entradas c�modo 3
				{ (Casa)tabuleiro[ 7][17] },
				
				// entradas c�modo 4
				{ (Casa)tabuleiro[ 9][ 7], (Casa)tabuleiro[12][ 3] },
				
				// entradas c�modo 5
				{ (Casa)tabuleiro[12][ 1], (Casa)tabuleiro[16][ 6] },
				
				// entradas c�modo 6
				{ (Casa)tabuleiro[ 9][17], (Casa)tabuleiro[13][15] },
				
				// entradas c�modo 7
				{ (Casa)tabuleiro[20][ 5] },
				
				// entradas c�modo 8
				{ (Casa)tabuleiro[20][ 7], (Casa)tabuleiro[17][ 9], (Casa)tabuleiro[17][14], (Casa)tabuleiro[20][16] },
				
				// entradas c�modo 9
				{ (Casa)tabuleiro[18][19] },
			};
		
		// criando c�modos
		Comodo comodos[] =
			{
				new Comodo("Escritorio", entradas[0] ),	
				new Comodo("Entrada", entradas[1] ),
				new Comodo("Sala de estar", entradas[2] ),
				new Comodo("Biblioteca", entradas[3] ),
				new Comodo("Salao de jogos", entradas[4] ),
				new Comodo("Sala de jantar", entradas[5] ),
				new Comodo("Jardim de inverno", entradas[6] ),
				new Comodo("Sala de musica", entradas[7] ),
				new Comodo("Cozinha", entradas[8] ),
			};
		
		// colocando c�modos no tabuleiro
		rowI = 0;
		for (int row[]:tabuleiro_base) {
			int colI = 0;
			for (int val:row) {
				if (val > 1 && val < 10) tabuleiro[rowI][colI] = comodos[val-1];			
				colI++;
			}
			rowI++;
		}
		
		// adicionando os vizinhos (precisa ser feito ap�s inicializa��o do tabuleiro todo)
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
	
	// reset do tabuleiro para algoritmo de dist�ncia
	void resetDist() {
		for (Object row[]:tabuleiro) for (Object casa:row) if (casa instanceof Casa) ((Casa) casa).resetDist();
	}
	
	// c�lculo da dist�ncia entre duas casas do tabuleiro
	int calculaDistancia(Casa ini, Casa fim) {
		int distancia = 0;
		this.resetDist();
		Queue<Casa> q = new LinkedList<>();
		
		ini.setDist(0);
		q.add(ini);
		while (q.size() > 0) {
			Casa c = q.remove();
			if (c == fim) return distancia;
			for (Casa n:c.vizinhos()) {
				if (!n.ocupado()) {
					n.setDist(distancia+1);
					q.add(n);
				}
			}
			distancia++;
		}
		
		return 1000; // n�o tem trajeto (dist�ncia infinita -> muito alto)
	}
	
	// valida movimento a partir de uma coordenada (x, y) para outra (x,y) no tabuleiro
	boolean validaMovimento(int xIni, int yIni, int xFim, int yFim, int dado) {
		// final fora do tabuleiro jog�vel
		if (!(tabuleiro[xFim][yFim] instanceof Casa) && !(tabuleiro[xFim][yFim] instanceof Comodo)) return false;
		
		// ambos s�o casas
		if (tabuleiro[xIni][yIni] instanceof Casa && tabuleiro[xFim][yFim] instanceof Casa) {
			// custo at� a casa precisa ser igual ao custo do trajeto
			return dado == calculaDistancia((Casa)tabuleiro[xIni][yIni], (Casa)tabuleiro[xFim][yFim]);
		}
		
		// de uma casa para um c�modo
		else if (tabuleiro[xIni][yIni] instanceof Casa && tabuleiro[xFim][yFim] instanceof Comodo) {
			//  basta chegar em uma entrada livre
			Comodo f = (Comodo)tabuleiro[xFim][yFim];
			Casa destinos[] = f.entradas();
			for (Casa dest:destinos) {
				if (!dest.ocupado() && calculaDistancia((Casa)tabuleiro[xIni][yIni], dest) <= dado) return true;
			}
		}
		
		// de um c�modo para uma casa
		else if (tabuleiro[xIni][yIni] instanceof Comodo && tabuleiro[xFim][yFim] instanceof Casa) {
			// uma das entradas do c�modo precisa ter a dist�ncia certa at� a casa
			Comodo i = (Comodo)tabuleiro[xIni][yIni];
			Casa inicios[] = i.entradas();
			for (Casa ini:inicios) {
				if (!ini.ocupado() && calculaDistancia(ini, (Casa)tabuleiro[xFim][yFim]) == dado) return true;
			}
		}
		
		// de c�modo X para c�modo Y
		else {
			// uma das entradas de X precisa estar dentro da dist�ncia para uma das entradas de Y
			Comodo i = (Comodo)tabuleiro[xIni][yIni];
			Casa inicios[] = i.entradas();
			Comodo f = (Comodo)tabuleiro[xFim][yFim];
			Casa destinos[] = f.entradas();
			for (Casa ini:inicios) {
				for (Casa dest:destinos) {
					if (!ini.ocupado() && !dest.ocupado() && calculaDistancia(ini, dest) <= dado) return true;
				}
			}
		}
		
		return false;
	}
}
