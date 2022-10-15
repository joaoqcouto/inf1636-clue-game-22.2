package Model;

public class Cartas {
	private String tipo; 
	private String nome;
	
	public Cartas(String type, String name) {
		this.tipo = type;
		this.nome  = name;
	}
	
	public String Tipo() {
		return this.tipo;
	}
	
	public String Nome() {
		return this.nome;
	}
}
