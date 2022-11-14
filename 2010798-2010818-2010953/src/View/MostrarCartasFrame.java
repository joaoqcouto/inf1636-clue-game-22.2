package View;

import javax.swing.*;
import java.awt.*;

public class MostrarCartasFrame extends JFrame {
	public final int LARG_DEFAULT=800;
	public final int ALT_DEFAULT=700;
	CluePanel cartasPanel1;
	CluePanel cartasPanel2;
	 
	public MostrarCartasFrame(String name) {
		super(name); 
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2 - LARG_DEFAULT/2;
		int y=sa/2 - ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		
		setLayout(null);
		Container c=getContentPane();
		
		cartasPanel1 = new CluePanel("./Resources/Cartas/Cano.jpg");
		cartasPanel1.setBounds(10, 10, 300, 500);
		
		cartasPanel2 = new CluePanel("./Resources/Cartas/Faca.jpg");
		cartasPanel2.setBounds(330, 10, 300, 500);
		
		c.add(cartasPanel1);
		c.add(cartasPanel2);
		
	}
}

