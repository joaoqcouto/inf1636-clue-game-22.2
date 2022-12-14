package View;
import Controller.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import Model.Jogo;

public class ClueFrame extends JFrame implements Observer{
	private static final long serialVersionUID = -2685162052017635295L;

	private Jogo jogo = Jogo.getJogo();
	
	// botao b1 de teste (printa no console estado atual)
	private JButton b1 = new JButton ("Print Game State");
	private JButton b2 = new JButton ("Passar vez");
	private JButton b3 = new JButton ("Mostrar Cartas");
	private JButton b4 = new JButton ("Bloco de Notas");
	private JButton b5 = new JButton ("Palpite");
	private JButton b6 = new JButton ("Acusar");
	private JButton b7 = new JButton ("Salvar Jogo");
	private JButton b8 = new JButton ("Jogar Dados");
	private JButton b9 = new JButton ("Escolher Dados");
	private JLabel l1 = new JLabel();
	private JLabel jogadorLabel = new JLabel();
	private Object dadosOptions[] = {1,2,3,4,5,6};
	private JComboBox c1 = new JComboBox<>(dadosOptions);
	private JComboBox c2 = new JComboBox<>(dadosOptions);

	private Map<String, Color> coresPersonagens = new HashMap<String, Color>();
	
	private CluePanel gamePanel;
	private String jogador;
		
	private final int LARG_DEFAULT=850;
	private final int ALT_DEFAULT=665;
	
	private CluePanel dadosPanel;
	private CluePanel dadosPanel2;
	private PiecesPanel piecesPanel;

	
	public static final int TXT_X=0;
	public static final int TXT_Y=0;
	
	public ClueFrame(String name) {
		super(name); 
		
		// keeping background colors
		coresPersonagens.put("Srta. Scarlet", new Color(255, 160, 160));
		coresPersonagens.put("Coronel Mustard", new Color(255, 255, 160));
		coresPersonagens.put("Professor Plum", new Color(220, 160, 255));
		coresPersonagens.put("Reverendo Green", new Color(160, 255, 225));
		coresPersonagens.put("Sra. White", new Color(255, 255, 255));
		coresPersonagens.put("Sra. Peacock", new Color(150, 150, 255));
		
		ProximoClickHandler.getInstance().add(this);
		EscolherDadosClickHandler.getInstance().add(this);
		JogarDadosClickHandler.getInstance().add(this);
		PalpiteClickHandler.getInstance().add(this);
		TabuleiroClickHandler.getInstance().add(this);
		AcusacaoClickHandler.getInstance().add(this);
		
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
		
		piecesPanel = new PiecesPanel();
		getContentPane().add(gamePanel);
		gamePanel.add(piecesPanel);
		piecesPanel.setBounds(0, 0, 603, 626);
		piecesPanel.setOpaque(false);
		
		gamePanel.add(b1);
		gamePanel.add(b2);
		gamePanel.add(b3);
		gamePanel.add(b4);
		gamePanel.add(b5);
		gamePanel.add(b6);
		gamePanel.add(b7);
		gamePanel.add(b8);
		gamePanel.add(b9);
		gamePanel.add(c1);
		gamePanel.add(c2);

		c1.setBounds(620, 580, 80, 30);
		c1.setBackground(Color.WHITE);
		c1.setForeground(Color.BLACK);
		
		c2.setBounds(700, 580, 80, 30);
		c2.setBackground(Color.WHITE);
		c2.setForeground(Color.BLACK);
		
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
		
		jogador = jogo.getJogadorAtualNome();
		jogadorLabel = new JLabel(jogador);
		gamePanel.add(jogadorLabel);
		jogadorLabel.setBounds(620, 300,160,30);
		jogadorLabel.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		
		gamePanel.add(l1);
		l1.setBounds(620, 320,200,30);
		l1.setFont(new java.awt.Font("Verdana", Font.BOLD, 10));
		
		// listener do tabuleiro
		gamePanel.addMouseListener(TabuleiroClickHandler.getInstance());
		
		
		// listeners dos botoes
		
		b4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	String titulo = new StringBuilder().append(jogo.getJogadorAtualNome()).append("'s notes").toString();
            	NotasFrame n = new NotasFrame(titulo);
                n.setVisible(true);
            }
        });
		
		b2.addMouseListener(ProximoClickHandler.getInstance());
		b8.addMouseListener(JogarDadosClickHandler.getInstance());
		
		EscolherDadosClickHandler escolhaHandler = EscolherDadosClickHandler.getInstance();
		b9.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
    			int d1=(int) c1.getSelectedItem();
    			int d2=(int) c2.getSelectedItem();
            	escolhaHandler.mouseClicked(d1, d2);
            }
        });
		
		b5.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	Jogo jogo = Jogo.getJogo();
            	if (jogo.getFase()==2 && jogo.estaEmComodo()) {
            		PalpiteFrame p = new PalpiteFrame("Palpite");
                    p.setVisible(true);
            	}
            }
        });
		
		b6.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Jogo jogo = Jogo.getJogo();
            	if (jogo.getFase()>=2) {
            		AcusacaoFrame a = new AcusacaoFrame("Acusacao");
                    a.setVisible(true);
            	}
            }
        });
		
		b3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	Jogo jogo = Jogo.getJogo();
            	String cartas[] = jogo.getCartasJogadorAtual();
            	String titulo = new StringBuilder().append(jogo.getJogadorAtualNome()).append("'s cards").toString();
        		MostrarCartasFrame c = new MostrarCartasFrame(cartas, titulo);
        		c.setVisible(true);
            }
        });
		
		// log do estado
		b1.addMouseListener(new PrintGameStateHandler());
		
		b7.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	// configuring file chooser
            	JFileChooser fileChooser = new JFileChooser();
            	fileChooser.setDialogTitle("Escolha um local para salvar o jogo");
            	FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo texto", "txt");
            	fileChooser.setFileFilter(filter);
            	
            	int userSelection = fileChooser.showSaveDialog(null);
            	if (userSelection == JFileChooser.APPROVE_OPTION) {
            		// file was selected
            		
            		File fileToSave = fileChooser.getSelectedFile();
            		System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            		
            		Jogo jogo = Jogo.getJogo();
                	boolean salvou = jogo.salvaJogo(fileToSave.getAbsolutePath());
                	if (salvou) {
                		String message = "Estado do jogo salvo";
        				JOptionPane.showMessageDialog(null, message,"Jogo salvo", JOptionPane.INFORMATION_MESSAGE);
                	} else {
                		String message = "Erro ao salvar o jogo.";
        				JOptionPane.showMessageDialog(null, message,"Erro", JOptionPane.ERROR_MESSAGE);
                	}
            	}
            }
        });
		
		printaDados();
		l1.setText("Role os dados");
		gamePanel.remove(dadosPanel);
		gamePanel.remove(dadosPanel2);
		
		// in case of game that has started, upate accordingly
		if (jogo.getFase() > 0) {
			if (jogo.getFase() == 1) {
				printaDados();
				int vet[] = jogo.getDados();
				int total = vet[0]+vet[1];
				StringBuilder c = new StringBuilder()
						.append("Voce deve andar ")
					    .append(String.valueOf(total))
					    .append(" posicoes");

				l1.setText(c.toString());
			}
			else if (jogo.getFase() == 2 && jogo.estaEmComodo()) {
				l1.setText("Palpite, acuse ou passe a vez");
			}
			else {
				l1.setText("Acuse ou passe a vez");
			}
		}
		
		jogador = jogo.getJogadorAtualNome();
		gamePanel.setBackground(coresPersonagens.get(jogador));
		
		
		
		gamePanel.setLayout(null);
		piecesPanel.setLayout(null);	
	}
	
	private void printaDados () {		
		Jogo jogo = Jogo.getJogo();
		int vet[] = jogo.getDados();
		
		int total = vet[0]+vet[1];
		StringBuilder c = new StringBuilder()
				.append("Voce deve andar ")
			    .append(String.valueOf(total))
			    .append(" posicoes");

		l1.setText(c.toString());
		int num = vet[0];
		StringBuilder a = new StringBuilder()
				.append("./Resources/dado")
			    .append(String.valueOf(num))
			    .append(".jpg");
		
		dadosPanel = new CluePanel(a.toString());
		gamePanel.add(dadosPanel);
		dadosPanel.setBounds(620, 350, 95, 106);
		
		int num2 = vet[1];
		StringBuilder b = new StringBuilder()
				.append("./Resources/dado")
			    .append(String.valueOf(num2))
			    .append(".jpg");
		
		dadosPanel2 = new CluePanel(b.toString());
		gamePanel.add(dadosPanel2);
		dadosPanel2.setBounds(730, 350, 95, 106);
	}

	public void notify(Observed o) {
		int n = o.get();
		// clicou no tabuleiro (personagem andou)
		if (n == 0) {
			Jogo jogo = Jogo.getJogo();
			boolean podePalpitar = jogo.estaEmComodo();
			gamePanel.remove(dadosPanel);
			gamePanel.remove(dadosPanel2);
			if (podePalpitar) l1.setText("Palpite, acuse ou passe a vez");
			else l1.setText("Acuse ou passe a vez");
		}
		// rolou dados
		if (n == 1) {
			gamePanel.remove(dadosPanel);
			gamePanel.remove(dadosPanel2);
			printaDados();
		}
		// passou vez
		if (n == 2) {
			gamePanel.remove(dadosPanel);
			gamePanel.remove(dadosPanel2);
			
			Jogo jogo = Jogo.getJogo();
			jogador = jogo.getJogadorAtualNome();
			jogadorLabel.setText(jogador);
			if (jogo.getFase()==0) l1.setText("Role os dados");
			else l1.setText("Palpite, acuse ou passe a vez");
			gamePanel.setBackground(coresPersonagens.get(jogador));
			
		}
		// palpite
		if (n == 3) {
			PalpiteClickHandler pp = (PalpiteClickHandler)o;
			String resposta = pp.getResposta();
			
			// ninguem desprovou
			if (resposta == "n") {
				String message = "Nenhum jogador mostrou cartas que desprovam o seu palpite.";
				JOptionPane.showMessageDialog(null, message,"Resultado do palpite", JOptionPane.INFORMATION_MESSAGE);
			}
			
			// alguma carta desprovou
			else if (resposta!=null) {
				CartaFrame cartaFrame = new CartaFrame(resposta);
				cartaFrame.setVisible(true);
			}
			
			l1.setText("Acuse ou passe a vez");
		}
		// acusacao errada
		// existe a chance de ter sido o ultimo jogador (acabou o jogo)
		if (n == 4) {
			gamePanel.remove(dadosPanel);
			gamePanel.remove(dadosPanel2);
			
			Jogo jogo = Jogo.getJogo();
			
			MostrarCartasFrame c = new MostrarCartasFrame(jogo.getCartasEnvelope(), "Cartas do envelope");
    		c.setVisible(true);
			
			// abrir uma tela de parabens que mata o jogo qd fecha
			String errou = "Voce fez uma acusacao errada. Seu personagem foi removido do jogo";
			JOptionPane.showMessageDialog(null, errou,"Acusacao errada", JOptionPane.ERROR_MESSAGE);
						
			if (jogo.semJogadores()) {
				String fim = "Todos os jogadores erraram. Fim de jogo.";
				JOptionPane.showMessageDialog(null, fim,"Sem mais jogadores", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			
			jogador = jogo.getJogadorAtualNome();
			gamePanel.setBackground(coresPersonagens.get(jogador));
			jogadorLabel.setText(jogador);
			l1.setText("Role os dados");
		}
		// acusacao certa (acabou o jogo)
		if (n == 5) {
			// abrir uma tela de parabens que mata o jogo qd fecha
			
			gamePanel.remove(dadosPanel);
			gamePanel.remove(dadosPanel2);
			
			Jogo jogo = Jogo.getJogo();
			MostrarCartasFrame c = new MostrarCartasFrame(jogo.getCartasEnvelope(), "Cartas do envelope");
    		c.setVisible(true);
    		
			String message = "Parabens! Acusacao correta. Voce ganhou!";
			JOptionPane.showMessageDialog(null, message,"Vencedor", JOptionPane.INFORMATION_MESSAGE);

			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    	System.exit(0);
		}
		// escolheu dados
		if(n==6) {
			gamePanel.remove(dadosPanel);
			gamePanel.remove(dadosPanel2);
			printaDados();
		}
		gamePanel.revalidate();
		gamePanel.repaint();
	}
	
}