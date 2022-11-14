package Controller;
import Model.Jogo;
import java.awt.event.*;

public class PrintGameStateHandler implements MouseListener {
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		Jogo jogo = Jogo.getJogo();
		
		System.out.println("\n\nJOGADOR ATUAL");
		System.out.println(jogo.getJogadorAtualNome());
		
		System.out.println("POSICAO ATUAL");
		int[] pos = jogo.getJogadorAtualPosicao();
		System.out.printf("LINHA %d , COLUNA %d \n",pos[0], pos[1]);
		
		System.out.println("O QUE FAZER");
		int fase = jogo.getFase();
		System.out.println(fase);
		
		if (fase == 0) {
			System.out.println("-> JOGAR DADOS");
		}
		
		if (fase == 1) {
			System.out.println("-> SE MOVER");
		}
		
		if (fase == 2) {
			System.out.println("-> PALPITE/ACUSAR");
			System.out.println("-> PASSAR A VEZ");
		}
		
		if (fase == 3) {
			System.out.println("-> ACUSAR");
			System.out.println("-> PASSAR A VEZ");
		}
	}
}
