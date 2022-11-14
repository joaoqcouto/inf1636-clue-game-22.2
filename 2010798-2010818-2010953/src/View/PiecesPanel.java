package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import Model.Jogo;

public class PiecesPanel extends JPanel {
	public static final int TXT_X=0;
	public static final int TXT_Y=0;
	public Color colors[] =
		{ 
			new Color(200, 80, 80),
			new Color(200, 200, 80),
			new Color(255, 255, 255),
			new Color(80, 200, 160),
			new Color(80, 80, 200),
			new Color(150, 80, 200)
		};
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		int[][] posicoes = Jogo.getJogo().getPosicoesJogadores();
		for (int i=0; i<posicoes.length; i++) {
			int Y = posicoes[i][0]*25+12;
			int X = posicoes[i][1]*25+12;
			
			Ellipse2D circulo = new Ellipse2D.Double();
			circulo.setFrameFromCenter(X, Y, X+10, Y+10);
			g2d.setPaint(colors[i]);
			g2d.fill(circulo);
			
			g2d.setPaint(Color.BLACK);
			g2d.draw(circulo);
		}
	}

}
