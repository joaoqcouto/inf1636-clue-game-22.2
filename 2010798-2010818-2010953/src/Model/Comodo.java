package Model;

// cômodo = um dos 9 cômodos onde pode ter ocorrido o crime
// implementar passagem secreta
class Comodo {
	// um cômodo sabe que cômodo ele é, quantos e quem está dentro dele
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
	}
	
	// operações para entrar e sair vão precisar saber as entradas de um cômodo
	public Casa[] entradas() {
		return entradas;
	}
	
}
