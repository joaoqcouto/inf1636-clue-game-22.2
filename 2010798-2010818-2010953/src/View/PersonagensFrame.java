package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PersonagensFrame extends JFrame{
	
	public final int LARG_DEFAULT=934;
	public final int ALT_DEFAULT=700;
	
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
        JCheckBox cb1=new JCheckBox("Mrs Scarlett",false);
        JCheckBox cb2=new JCheckBox("Col. Mustard",false);
        JCheckBox cb3=new JCheckBox("Mrs. White",false);
        JCheckBox cb4=new JCheckBox("Rev. Green",false);
        JCheckBox cb5=new JCheckBox("Mrs. Peacock",false);
        JCheckBox cb6=new JCheckBox("Prof. Plum",false);
        JButton j1 = new JButton("JOGAR");

        p.add(cb1);
        p.add(cb2);
        p.add(cb3);
        p.add(cb4);
        p.add(cb5);
        p.add(cb6);
        p.add(j1);

        cb1.setBounds(311,355,311,30);
        cb2.setBounds(622,310,311,30);
        cb3.setBounds(622,355,311,30);
        cb4.setBounds(0,310,311,30);
        cb5.setBounds(0,355,311,30);
        cb6.setBounds(311,310,311,30);
        
        j1.setBounds(0,0,954,30);
        j1.setFont(new java.awt.Font("Verdana", Font.BOLD, 20));
		j1.setBackground(Color.BLACK);
		j1.setForeground(Color.WHITE);
		
        cb1.setBackground(Color.RED);
        cb2.setBackground(Color.YELLOW);
        cb3.setBackground(Color.WHITE);
        cb4.setBackground(Color.GREEN);
        cb5.setBackground(Color.BLUE);
        cb6.setBackground(Color.CYAN);

        p.setLayout(null);

        //Botão Jogo
        j1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                dispose(); 
                ClueFrame f=new ClueFrame("Clue - Jogo");
                f.setVisible(true);
            }
        });
    }
}
