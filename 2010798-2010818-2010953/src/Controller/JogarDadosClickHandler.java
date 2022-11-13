package Controller;
import Model.Jogo;
import java.awt.event.*;

public class JogarDadosClickHandler implements MouseListener {
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		Jogo jogo = Jogo.getJogo();
		
		if (jogo.getFase() == 0 ) {
			jogo.rolaDados();
			jogo.proxFase();
			
			System.out.println("Jogou dados");
			int[] dados = jogo.getDados();
			System.out.println(dados[0]);
			System.out.println(dados[1]);	
		}
	}
}
