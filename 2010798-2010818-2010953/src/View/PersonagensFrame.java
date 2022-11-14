package View;

import java.awt.*;
import javax.swing.*;

import Controller.GameMain;
import Model.Jogo;
import java.awt.event.*;

public class PersonagensFrame extends JFrame{
	
	public final int LARG_DEFAULT=934;
	public final int ALT_DEFAULT=700;
	
	JCheckBox checkboxes[];
	
	public PersonagensFrame(String name) {
        super(name);
        Dimension size;
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension screenSize=tk.getScreenSize();
        int sl=screenSize.width;
        int sa=screenSize.height;
        int x=sl/2-LARG_DEFAULT/2;
        int y=sa/2-ALT_DEFAULT/2;
        setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p = new CluePanel("./Resources/ClueNovopersonagens.png");

        getContentPane().add(p);
        
        checkboxes = new JCheckBox[] {
        	new JCheckBox("Mrs Scarlett",false),
        	new JCheckBox("Col. Mustard",false),
        	new JCheckBox("Mrs. White",false),
        	new JCheckBox("Rev. Green",false),
        	new JCheckBox("Mrs. Peacock",false),
        	new JCheckBox("Prof. Plum",false),
        };
        
        JButton j1 = new JButton("JOGAR");

        p.add(checkboxes[0]);
        p.add(checkboxes[1]);
        p.add(checkboxes[2]);
        p.add(checkboxes[3]);
        p.add(checkboxes[4]);
        p.add(checkboxes[5]);
        
        p.add(j1);

        checkboxes[0].setBounds(311,355,311,30);
        checkboxes[1].setBounds(622,310,311,30);
        checkboxes[2].setBounds(622,355,311,30);
        checkboxes[3].setBounds(0,310,311,30);
        checkboxes[4].setBounds(0,355,311,30);
        checkboxes[5].setBounds(311,310,311,30);
        
        j1.setBounds(0,0,954,30);
        j1.setFont(new java.awt.Font("Verdana", Font.BOLD, 20));
		j1.setBackground(Color.BLACK);
		j1.setForeground(Color.WHITE);
		
		checkboxes[0].setBackground(Color.RED);
		checkboxes[1].setBackground(Color.YELLOW);
		checkboxes[2].setBackground(Color.WHITE);
		checkboxes[3].setBackground(Color.GREEN);
		checkboxes[4].setBackground(Color.BLUE);
		checkboxes[5].setBackground(Color.CYAN);

        p.setLayout(null);

        //Botão Jogo
        j1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                playButtonPressed();
            }
        });
    }
	
	public void playButtonPressed() {
		// getting checkbox values
		int amount_checked = 0;
		boolean pressedCheckbox[] = new boolean[checkboxes.length];
		for (int i = 0; i < checkboxes.length; i++) {
			pressedCheckbox[i] = checkboxes[i].isSelected();
			if (checkboxes[i].isSelected()) amount_checked++;
		}
		
		// testing checkbox values
		for (int i = 0; i < checkboxes.length; i++) {
			System.out.print(checkboxes[i].getText());
			System.out.print(" - ");
			System.out.print(pressedCheckbox[i]);
			System.out.print("\n");
		}
		
		// creating game and starting game loop
		// game needs at least 3 players selected
		if (amount_checked>=3) {
			dispose();
			Jogo.createJogo(pressedCheckbox);
	        GameMain.gameLoop();
		}
		else {
			String message = "Para iniciar um jogo, selecione 3 ou mais personagens.";
			JOptionPane.showMessageDialog(null, message,"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
