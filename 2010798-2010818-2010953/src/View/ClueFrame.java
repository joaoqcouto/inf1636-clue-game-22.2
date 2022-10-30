package View;

import java.awt.*;
import javax.swing.*;

public class ClueFrame extends JFrame {
	JButton b1 = new JButton ("Passagem Secreta");
	JButton b2 = new JButton ("Próximo");
	JButton b3 = new JButton ("Mostrar Cartas");
	JButton b4 = new JButton ("Bloco de Notas");
	JButton b5 = new JButton ("Palpite");
	JButton b6 = new JButton ("Acusar");
	JButton b7 = new JButton ("Salvar Jogo");
	JButton b8 = new JButton ("Jogar Dados");
	JButton b9 = new JButton ("Escolher Dados");
	
	
	public final int LARG_DEFAULT=900;
	public final int ALT_DEFAULT=696;
	public ClueFrame(String name) {
		
		super(name); 
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Putting on Panel
		CluePanel p = new CluePanel("./Resources/Tabuleiro-Clue.jpg");
		getContentPane().add(p);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		b1.setBounds(710,20,160,30);
		b2.setBounds(710,60,160,30);
		b3.setBounds(710,100,160,30);
		b4.setBounds(710,140,160,30);
		b5.setBounds(710,180,160,30);
		b6.setBounds(710,220,160,30);
		b7.setBounds(710,260,160,30);
		b8.setBounds(710,500,160,30);
		b9.setBounds(710,540,160,30);

		p.setLayout(null);
	}
}