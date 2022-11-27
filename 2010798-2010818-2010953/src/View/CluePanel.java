package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
class CluePanel extends JPanel {
	private static final long serialVersionUID = -8063434957322899576L;
	private static final int TXT_X=0;
	private static final int TXT_Y=0;
	private String panelName;
	
	public CluePanel(String panelName) {
		this.panelName = panelName;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image i;
		try {
			i=ImageIO.read(new File(panelName));
			g.drawImage(i,TXT_X,TXT_Y,null);
			//g.dispose();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}	
	}
}
