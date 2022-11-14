package View;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CartasPanel extends JPanel{
	public int TXT_X= 0;
	public int TXT_Y= 0;
	private String panelName;
	
	public CartasPanel(String panelName) {
		this.panelName = panelName;
	}
	public void paintComponent(Graphics g ) {
		
		Image i;
		try {
			i=ImageIO.read(new File(panelName));
			g.drawImage(i,TXT_X,TXT_Y,null);
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
}
