package View;

import java.awt.*;
import javax.swing.*;

import Controller.GameMain;
import Model.Jogo;
import java.awt.event.*;

public class PersonagensFrame extends JFrame{
	private static final long serialVersionUID = 8548773917709225304L;
	private final int LARG_DEFAULT=934;
	private final int ALT_DEFAULT=700;
	
	private JCheckBox checkboxes[];
	
	public PersonagensFrame(String name) {
        super(name);
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
        	new JCheckBox("Srta. Scarlet",false),
        	new JCheckBox("Coronel Mustard",false),
        	new JCheckBox("Sra. White",false),
        	new JCheckBox("Reverendo Green",false),
        	new JCheckBox("Sra. Peacock",false),
        	new JCheckBox("Professor Plum",false),
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
		
		checkboxes[0].setBackground(new Color(255, 160, 160));
		checkboxes[1].setBackground(new Color(255, 255, 160));
		checkboxes[2].setBackground(new Color(255, 255, 255));
		checkboxes[3].setBackground(new Color(160, 255, 225));
		checkboxes[4].setBackground(new Color(150, 150, 255));
		checkboxes[5].setBackground(new Color(220, 160, 255));
		
        p.setLayout(null);

        //Botão Jogo
        j1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                playButtonPressed();
            }
        });
    }
	
	private void playButtonPressed() {
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
