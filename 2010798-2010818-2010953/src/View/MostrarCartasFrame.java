package View;

import javax.swing.*;
import java.awt.*;

public class MostrarCartasFrame extends JFrame {
	final int WCARTA = 150;
	final int HCARTA = 230;
	 
	public MostrarCartasFrame(String[] cartasArray, String titulo) {
		super(titulo);
		
		int LARG_DEFAULT = WCARTA*3+60;
		int ALT_DEFAULT = HCARTA*2+70;
		if (cartasArray.length<4) ALT_DEFAULT = HCARTA+60;
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2 - LARG_DEFAULT/2;
		int y=sa/2 - ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setLayout(null);
		
		Container c=getContentPane();
		
		// adding cards
		int i = 0;
		int j = 0;
		for (String cartaNome:cartasArray) {
			CartasPanel cartasPanel = new CartasPanel(CardImages.getImage(cartaNome));
			cartasPanel.setBounds(10 + 10*i + i*WCARTA, 10 + 10*j + j*HCARTA, WCARTA, HCARTA);
			c.add(cartasPanel);
			i++;
			if (i == 3) {
				i = 0;
				j++;
			}
		}
	}
}

