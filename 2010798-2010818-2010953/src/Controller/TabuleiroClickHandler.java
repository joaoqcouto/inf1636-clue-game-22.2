package Controller;
import Model.Jogo;
import java.awt.event.*;

public class TabuleiroClickHandler implements MouseListener {
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		int x=e.getX();
	    int y=e.getY();
	    if (x <= 603 && y <= 626) {
	    	int tabuleiroCol = x/25;
	    	int tabuleiroLinha = y/25;
	    	
	    	System.out.println("Clicou no tabuleiro");
	    	System.out.println("Linha "+tabuleiroLinha+", Coluna "+tabuleiroCol);
	    	
	    	Jogo jogo = Jogo.getJogo();
	    	int[] pos = {tabuleiroLinha, tabuleiroCol};
	    	jogo.moveJogador(pos);
	    }
	}
}
