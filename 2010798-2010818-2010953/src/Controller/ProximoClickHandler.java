package Controller;
import Model.Jogo;
import java.awt.event.*;

public class ProximoClickHandler implements MouseListener {
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		Jogo jogo = Jogo.getJogo();
		
		if (jogo.getFase() == 2) {
			jogo.passaVez();
			System.out.println("Passou a vez");
			System.out.println(jogo.getJogadorAtualNome());
		}
	}
}
