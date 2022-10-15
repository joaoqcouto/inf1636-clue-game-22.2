package Model;

// c�modo = um dos 9 c�modos onde pode ter ocorrido o crime
// implementar passagem secreta
class Comodo {
	// um c�modo sabe que c�modo ele �, quantos e quem est� dentro dele
	public String comodo;
	private Pessoa []pessoasDentro;
	private Casa []entradas;
	private int qtdDentro;
	
	// init
	public Comodo(String comodo, Casa entradas[]) {
		this.comodo = comodo;
		this.entradas = entradas;
		this.pessoasDentro = new Pessoa[6];
		qtdDentro = 0;
	}
	
	// se uma pessoa 'p' est� no c�modo
	boolean estaEmComodo(Pessoa p) {
		for (Pessoa pi: pessoasDentro) {
			if (pi == p) {
				return true;
			}
		}
		return false;
	}
	
	// coloca 'p' no c�modo
	public void entraComodo(Pessoa p) {
		if (estaEmComodo(p)) return;
		
		pessoasDentro[qtdDentro] = p;
		qtdDentro++;
	}
	
	// tira 'p' do c�modo
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
	}
	
	// opera��es para entrar e sair v�o precisar saber as entradas de um c�modo
	public Casa[] entradas() {
		return entradas;
	}
	
}
