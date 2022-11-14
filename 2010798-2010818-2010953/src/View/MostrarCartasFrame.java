package View;

import javax.swing.*;
import java.awt.*;

public class MostrarCartasFrame extends JFrame {
	public final int LARG_DEFAULT=800;
	public final int ALT_DEFAULT=700;
	CartasPanel cartasPanel1;
	CartasPanel cartasPanel2;
	
	public MostrarCartasFrame() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2 - LARG_DEFAULT/2;
		int y=sa/2 - ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		Container c=getContentPane();
		cartasPanel1 = new CartasPanel("./Resources/Cartas/Cano.jpg", 10, 10);
		c.add(cartasPanel1);
		cartasPanel2 = new CartasPanel("./Resources/Cartas/Faca.jpg", 350, 10);
		c.add(cartasPanel2);
		
		
		
	}
	public static void main(String[] args ) {
		MostrarCartasFrame f= new MostrarCartasFrame();
		f.setTitle("Minha Primeira GUI");
		f.setVisible(true);
		
	}
}

