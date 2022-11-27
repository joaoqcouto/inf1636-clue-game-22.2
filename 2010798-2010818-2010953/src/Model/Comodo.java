package Model;

// cômodo = um dos 9 cômodos onde pode ter ocorrido o crime
// implementar passagem secreta
class Comodo {
	// um cômodo sabe que cômodo ele é, quantos e quem está dentro dele
	private String comodo;
	private Pessoa [] pessoasDentro = {};
	private Casa []entradas;
	private Comodo passagemSecreta;
	private int[] centro;
	
	// init
	public Comodo(String comodo, Casa entradas[], int[] centro) {
		this.comodo = comodo;
		this.entradas = entradas;
		this.passagemSecreta = null;
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
		Pessoa []novoDentro = new Pessoa[pessoasDentro.length+1];
		System.arraycopy(pessoasDentro, 0, novoDentro, 0, pessoasDentro.length);
		novoDentro[pessoasDentro.length] = p;
		pessoasDentro = novoDentro;
	}
	
	// tira 'p' do cômodo
	public void saiComodo(Pessoa p) {
		if (!estaEmComodo(p)) return;
		
		Pessoa []novoDentro = new Pessoa[pessoasDentro.length-1];
		int qtd = 0;
		for (Pessoa pi: pessoasDentro) {
			if (pi != p) {
				novoDentro[qtd] = pi;
				qtd++;
			}
		}
		
		pessoasDentro = novoDentro;
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
			if (pessoasDentro.length == 0) return posicao;
			boolean ocupada = false;
			System.out.println("Quantidade dentro do comodo: "+pessoasDentro.length);
			for (int i = 0; i < pessoasDentro.length; i++) {
				System.out.println("Indice: "+i);
				int[] posicaoPessoa = pessoasDentro[i].posicao();
				if (posicaoPessoa[0] == posicao[0] && posicaoPessoa[1] == posicao[1]) {
					ocupada=true;
				}
			}
			if (!ocupada) return posicao;
		}
		
		return centro;
	}
	
	// se comodo ta sem saida disponivel
	public boolean estaFechado() {
		// se nao tem passagem secreta e nenhuma entrada ta livre
		if (passagemSecreta != null) return false;
		for (Casa c:entradas) {
			if (!c.ocupado()) return false;
		}
		return true;
	}
	
	public String nome() { return comodo; }
	
}
