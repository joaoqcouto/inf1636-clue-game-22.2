package View;

import javax.swing.*;
import java.awt.*;

public class PiecesPanel extends JPanel {
	public static final int TXT_X=0;
	public static final int TXT_Y=0;
	
	// public PiecesPanel() {}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Bom dia E companhia",TXT_X,TXT_Y);
	}

}
