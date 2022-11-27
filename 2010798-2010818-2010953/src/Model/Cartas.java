package Model;

class Cartas {
	private int numero;
	private String tipo; 
	private String nome;
	
	public Cartas(String type, String name, int numero) {
		this.tipo = type;
		this.nome  = name;
		this.numero = numero;
	}
	
	public String Tipo() {
		return this.tipo;
	}
	
	public String Nome() {
		return this.nome;
	}
	
	public int numero() { return numero; }
}
