package View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CartaFrame extends JFrame {
	private static final long serialVersionUID = -4288466601153569156L;
	private final int LARG_DEFAULT=320;
	private final int ALT_DEFAULT=580;
	private CluePanel cartaPanel;
	 
	public CartaFrame(String carta) {
		super(carta); 
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2 - LARG_DEFAULT/2;
		int y=sa/2 - ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setLayout(null);
		
		Container c = getContentPane();
		cartaPanel = new CluePanel(CardImages.getImage(carta));
		cartaPanel.setBounds(10, 30, 300, 500);
		
		JButton sair = new JButton ("OK");
		sair.setBounds(10, 485, 285, 50);
		sair.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
		sair.setBackground(Color.WHITE);
		sair.setForeground(Color.BLACK);
		
		JLabel mensagemLabel = new JLabel("Um jogador possui a seguinte carta");
		c.add(mensagemLabel);
		mensagemLabel.setBounds(10, 0,300,30);
		mensagemLabel.setFont(new java.awt.Font("Verdana", Font.BOLD, 12));
		
		sair.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) { dispose(); }
        });
		
		c.add(sair);
		c.add(cartaPanel);
	}
}

