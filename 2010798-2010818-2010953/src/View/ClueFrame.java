package View;

import java.awt.*;
import javax.swing.*;
public class ClueFrame extends JFrame {
	public final int LARG_DEFAULT=1000;
	public final int ALT_DEFAULT=696;
	public ClueFrame(String name) {
		super(name); 
		
		//Dimensioning the frame in any screen
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Putting on Panel
		JPanel p = new CluePanel("./Resources/Tabuleiro-Clue.jpg");
		getContentPane().add(p);
	}
}