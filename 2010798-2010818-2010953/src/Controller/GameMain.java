package Controller;
import View.CapaFrame;
import View.ClueFrame;

public class GameMain {
	// abre tela inicial
	public static void main(String[] args) {
		CapaFrame capa = new CapaFrame("Clue - Inicio");
		capa.setVisible(true);
	}
	
	// vai ser chamado com o jogo ja inicializado
	public static void gameLoop() {			
		ClueFrame gameFrame = new ClueFrame("Clue - Jogo");
		System.out.println(" --- INICIO DO JOGO --- ");
		gameFrame.setVisible(true);
	}
}
