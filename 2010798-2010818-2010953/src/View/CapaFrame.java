package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CapaFrame extends JFrame {
	JButton b1 = new JButton ("Novo Jogo");
	JButton b2 = new JButton ("Continuar");
	public final int LARG_DEFAULT=1023;
	public final int ALT_DEFAULT=520;
	JPanel capaPanel;
	
	public CapaFrame(String name) {
		super(name);
		
		//Dimensioning the frame in any screen
		Dimension size;
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Putting on Panel
		capaPanel = new CluePanel("./Resources/CLUE-game-box (1).jpg");
		getContentPane().add(capaPanel);
		capaPanel.add(b1);
		capaPanel.add(b2);
		
		size = b1.getPreferredSize();
		b1.setBounds(190,75,size.width,size.height);
		b1.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		
		size = b2.getPreferredSize();
		b2.setBounds(730,75,size.width,size.height);
		b2.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		
		capaPanel.setLayout(null);
		
        b1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                newGameButtonPressed();
            }
        });
	}
	
	// opening character menu
	public void newGameButtonPressed() {
		dispose();
        PersonagensFrame p = new PersonagensFrame("Clue - Personagens");
        p.setVisible(true);
	}
}
