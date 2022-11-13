package View;
import Controller.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;
import Model.Jogo;

public class ClueFrame extends JFrame {
	
	Jogo jogo = Jogo.getJogo();
	
	// botao b1 de teste (printa no console estado atual)
	JButton b1 = new JButton ("Print Game State");
	JButton b2 = new JButton ("Próximo");
	JButton b3 = new JButton ("Mostrar Cartas");
	JButton b4 = new JButton ("Bloco de Notas");
	JButton b5 = new JButton ("Palpite");
	JButton b6 = new JButton ("Acusar");
	JButton b7 = new JButton ("Salvar Jogo");
	JButton b8 = new JButton ("Jogar Dados");
	JButton b9 = new JButton ("Escolher Dados");
	Color coresPersonagens[] = { Color.RED, Color.YELLOW, Color.PINK, Color.GREEN, Color.WHITE, Color.BLUE };
	CluePanel gamePanel;
	
	public final int LARG_DEFAULT=810;
	public final int ALT_DEFAULT=665;
	
	public int currentColor = 0;
	
	public static final int TXT_X=0;
	public static final int TXT_Y=0;
	
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
		gamePanel = new CluePanel("./Resources/Tabuleiro-Clue.jpg");
		getContentPane().add(gamePanel);
		gamePanel.add(b1);
		gamePanel.add(b2);
		gamePanel.add(b3);
		gamePanel.add(b4);
		gamePanel.add(b5);
		gamePanel.add(b6);
		gamePanel.add(b7);
		gamePanel.add(b8);
		gamePanel.add(b9);
		
		b1.setBounds(620,20,160,30);
		b1.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		
		b2.setBounds(620,60,160,30);
		b2.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		
		b3.setBounds(620,100,160,30);
		b3.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		b3.setBackground(Color.WHITE);
		b3.setForeground(Color.BLACK);
		
		b4.setBounds(620,140,160,30);
		b4.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		b4.setBackground(Color.WHITE);
		b4.setForeground(Color.BLACK);
		
		b5.setBounds(620,180,160,30);
		b5.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		b5.setBackground(Color.WHITE);
		b5.setForeground(Color.BLACK);
		
		b6.setBounds(620,220,160,30);
		b6.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		b6.setBackground(Color.WHITE);
		b6.setForeground(Color.BLACK);
		
		b7.setBounds(620,260,160,30);
		b7.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		b7.setBackground(Color.WHITE);
		b7.setForeground(Color.BLACK);
		
		b8.setBounds(620,500,160,30);
		b8.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		b8.setBackground(Color.WHITE);
		b8.setForeground(Color.BLACK);
		
		b9.setBounds(620,540,160,30);
		b9.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		b9.setBackground(Color.WHITE);
		b9.setForeground(Color.BLACK);
		
		JLabel l = new JLabel(jogo.getJogadorAtualNome());
		gamePanel.add(l);
		l.setBounds(620, 300,160,30);
		l.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		
		// listener do tabuleiro
		gamePanel.addMouseListener(new TabuleiroClickHandler());
		
		// listeners dos botoes
		
		b4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	NotasFrame n = new NotasFrame("Clue - Personagens");
                n.setVisible(true);
            }
        });
		
		b2.addMouseListener(new ProximoClickHandler());
		b8.addMouseListener(new JogarDadosClickHandler());
		//gamePanel.add();
		
		// log do estado
		b1.addMouseListener(new PrintGameStateHandler());
		
		//dadosPanel = new CluePanel("./Resources/dado1.jpg");
		//getContentPane().add(dadosPanel);
		
		gamePanel.setLayout(null);
		
	}
	
}