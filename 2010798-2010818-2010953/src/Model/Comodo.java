package Model;

// cômodo = um dos 9 cômodos onde pode ter ocorrido o crime
// implementar passagem secreta
class Comodo {
	// um cômodo sabe que cômodo ele é, quantos e quem está dentro dele
	private String comodo;
	private Pessoa []pessoasDentro;
	private Casa []entradas;
	private int qtdDentro;
	private Comodo passagemSecreta;
	private int[] centro;
	
	// init
	public Comodo(String comodo, Casa entradas[], int[] centro) {
		this.comodo = comodo;
		this.entradas = entradas;
		this.pessoasDentro = new Pessoa[6];
		this.passagemSecreta = null;
		this.qtdDentro = 0;
		this.centro = centro;
	}
	
	// se uma pessoa 'p' está no cômodo
	boolean estaEmComodo(Pessoa p) {
		for (Pessoa pi: pessoasDentro) {
			if (pi == p) {
				return true;
			}
		}
		return false;
	}
	
	// coloca 'p' no cômodo
	public void entraComodo(Pessoa p) {
		if (estaEmComodo(p)) return;
		
		pessoasDentro[qtdDentro] = p;
		qtdDentro++;
	}
	
	// tira 'p' do cômodo
	public void saiComodo(Pessoa p) {
		if (!estaEmComodo(p)) return;
		
		Pessoa []novoDentro = new Pessoa[6];
		int qtd = 0;
		for (Pessoa pi: pessoasDentro) {
			if (pi != p) {
				novoDentro[qtd] = pi;
				qtd++;
			}
		}
		
		pessoasDentro = novoDentro;
		qtdDentro = qtd;
	}
	
	// operações para entrar e sair vão precisar saber as entradas de um cômodo
	public Casa[] entradas() { return entradas; }
	
	// set e get passagem secreta
	public void setPassagemSecreta(Comodo passagemSecreta) { this.passagemSecreta = passagemSecreta; }
	public Comodo passagemSecreta() { return passagemSecreta; }
	
	// pegando posicao livre pra transportar personagem
	public int[] getPosicaoLivre() {
		
		// posicoes em torno do centro
		int [] possibilidades[] = new int[9][]; 
		int poss = 0;
		for (int row = -1; row<2; row++) {
			for (int col = -1; col<2; col++) {
				possibilidades[poss] = new int[] {centro[0]+row, centro[1]+col};
				poss++;
			}
		}
		
		// checa as posicoes ate encontrar uma que ta vazia
		for (int[] posicao : possibilidades) {
			boolean ocupada = false;
			
			for (int i = 0; i < qtdDentro; i++) {
				int[] posicaoPessoa = pessoasDentro[i].posicao();
				if (posicaoPessoa[0] == posicao[0] && posicaoPessoa[1] == posicao[1]) {
					ocupada=true;
					break;
				}
				
			}
			if (!ocupada) return posicao;
		}
		
		return centro;
	}
	
	public String nome() { return comodo; }
	
}
