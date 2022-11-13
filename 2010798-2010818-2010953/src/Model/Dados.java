package Model;

class Dados {
	int dados[];
	
	public Dados() {
		int dado1 = (int)((Math.random() * (7 - 1)) + 1);
		int dado2 = (int)((Math.random() * (7 - 1)) + 1);
		dados = new int[] {dado1, dado2};
	}
	
	int[] rolaDados() {
		int dado1 = (int)((Math.random() * (7 - 1)) + 1);
		int dado2 = (int)((Math.random() * (7 - 1)) + 1);
		dados = new int[] {dado1, dado2};
		return dados;
	}
	
	int[] getDados() { return dados; }
	
	int getSomaDados() {
		int s = 0;
		for (int dado:dados) s += dado;
		return s;
	}
	
	// para testes somente
	void setDados(int[] d) { dados = d; }

}
