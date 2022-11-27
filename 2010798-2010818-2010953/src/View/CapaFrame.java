package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.GameMain;
import Model.Jogo;

import java.awt.event.*;
import java.io.File;

public class CapaFrame extends JFrame {
	private static final long serialVersionUID = 802503119670911929L;
	private JButton b1 = new JButton ("Novo Jogo");
	private JButton b2 = new JButton ("Continuar");
	private final int LARG_DEFAULT=1023;
	private final int ALT_DEFAULT=520;
	private JPanel capaPanel;
	
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
        
        b2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	continueGameButtonPressed();
            }
        });
	}
	
	// opening character menu
	private void newGameButtonPressed() {
		dispose();
        PersonagensFrame p = new PersonagensFrame("Clue - Personagens");
        p.setVisible(true);
	}
	
	// choosing game text file
	private void continueGameButtonPressed() {
		// configuring file chooser
		JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setDialogTitle("Escolha um arquivo de jogo");
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo texto", "txt");
    	fileChooser.setFileFilter(filter);
    	
    	int userSelection = fileChooser.showDialog(this,"Abrir");
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    		// file was selected
    		try {
	    		File fileToLoad = fileChooser.getSelectedFile();
	    		System.out.println("Load file: " + fileToLoad.getAbsolutePath());
	    		Jogo.loadJogo(fileToLoad);
	    		GameMain.gameLoop();
	    		dispose();
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    			String message = "Houve um erro ao tentar ler o arquivo de entrada.";
    			JOptionPane.showMessageDialog(null, message,"Erro", JOptionPane.ERROR_MESSAGE);
    		}
    	}
	}
}
