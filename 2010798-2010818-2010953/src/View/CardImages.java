package View;
import java.util.HashMap;
import java.util.Map;

class CardImages {
	private static Map<String, String> imagens = new HashMap<String, String>();
	
	static {
		imagens.put("Corda", "./Resources/Cartas/Corda.jpg");
		imagens.put("Cano de Chumbo", "./Resources/Cartas/Cano.jpg");
		imagens.put("Faca", "./Resources/Cartas/Faca.jpg");
		imagens.put("Chave Inglesa", "./Resources/Cartas/ChaveInglesa.jpg");
		imagens.put("Castical", "./Resources/Cartas/Castical.jpg");
		imagens.put("Revolver", "./Resources/Cartas/Revolver.jpg");
		imagens.put("Srta. Scarlet", "./Resources/Cartas/Scarlet.jpg");
		imagens.put("Coronel Mustard", "./Resources/Cartas/Mustard.jpg");
		imagens.put("Professor Plum", "./Resources/Cartas/Plum.jpg");
		imagens.put("Reverendo Green", "./Resources/Cartas/Green.jpg");
		imagens.put("Sra. White", "./Resources/Cartas/White.jpg");
		imagens.put("Sra. Peacock", "./Resources/Cartas/Peacock.jpg");
		imagens.put("Escritorio", "./Resources/Cartas/Escritorio.jpg");
		imagens.put("Entrada", "./Resources/Cartas/Entrada.jpg");
		imagens.put("Sala de estar", "./Resources/Cartas/SalaDeEstar.jpg");
		imagens.put("Biblioteca", "./Resources/Cartas/Biblioteca.jpg");
		imagens.put("Salao de jogos", "./Resources/Cartas/SalaoDeJogos.jpg");
		imagens.put("Sala de jantar", "./Resources/Cartas/SalaDeJantar.jpg");
		imagens.put("Jardim de inverno", "./Resources/Cartas/JardimInverno.jpg");
		imagens.put("Sala de musica", "./Resources/Cartas/SalaDeMusica.jpg");
		imagens.put("Cozinha", "./Resources/Cartas/Cozinha.jpg");
	}
	
	public static String getImage(String carta) {
		return imagens.get(carta);
	}
}


