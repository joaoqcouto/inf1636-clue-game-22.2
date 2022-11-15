package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.*;

import Controller.PalpiteClickHandler;

public class PalpiteFrame extends JFrame {
	int LARG_DEFAULT = 570;
	int ALT_DEFAULT = 420;
	
	public PalpiteFrame(String name) {
		super(name);
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2 - LARG_DEFAULT/2;
		int y=sa/2 - ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		
		setLayout(null);
		Container c=getContentPane();
		
		JLabel l1=new JLabel("Suspeitos:");
		ButtonGroup personagens = new ButtonGroup();
		JRadioButton r1 = new JRadioButton("Srta. Scarlet");
		JRadioButton r2 = new JRadioButton("Coronel Mustard");
		JRadioButton r3 = new JRadioButton("Sra. White");
		JRadioButton r4 = new JRadioButton("Reverendo Green");
		JRadioButton r5 = new JRadioButton("Sra. Peacock");
		JRadioButton r6 = new JRadioButton("Professor Plum");
		
		JLabel l3=new JLabel("Armas:");
		ButtonGroup armas = new ButtonGroup();
		JRadioButton r16 = new JRadioButton("Corda");
		JRadioButton r17 = new JRadioButton("Faca");
		JRadioButton r18 = new JRadioButton("Chave Inglesa");
		JRadioButton r19 = new JRadioButton("Castical");
		JRadioButton r20 = new JRadioButton("Revolver");
		JRadioButton r21 = new JRadioButton("Cano de chumbo");
		
		JButton b1 = new JButton ("Dar palpite");
		b1.setBounds(0,350 , 555, 30);
		b1.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		
		l1.setBounds(50,20,150,30);
		personagens.add(r1);
		personagens.add(r2);
		personagens.add(r3);
		personagens.add(r4);
		personagens.add(r5);
		personagens.add(r6);
		r1.setBounds(50,50,150,30);
		r2.setBounds(50,80,150,30);
		r3.setBounds(50,110,150,30);
		r4.setBounds(50,140,150,30);
		r5.setBounds(50,170,150,30);
		r6.setBounds(50,200,150,30);
		c.add(l1);
		c.add(r1);
		c.add(r2);
		c.add(r3);
		c.add(r4);
		c.add(r5);
		c.add(r6);
		
		l3.setBounds(350,20,150,30);
		armas.add(r16);
		armas.add(r17);
		armas.add(r18);
		armas.add(r19);
		armas.add(r20);
		armas.add(r21);
		r16.setBounds(350,50,150,30);
		r17.setBounds(350,80,150,30);
		r18.setBounds(350,110,150,30);
		r19.setBounds(350,140,150,30);
		r20.setBounds(350,170,150,30);
		r21.setBounds(350,200,150,30);
		c.add(l3);
		c.add(r16);
		c.add(r17);
		c.add(r18);
		c.add(r19);
		c.add(r20);
		c.add(r21);
		
		c.add(b1);
		
		PalpiteClickHandler handler = PalpiteClickHandler.getInstance();
		b1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	String palpitado = getSelectedButtonText(personagens);
            	String arma = getSelectedButtonText(armas);
            	
            	if (palpitado != null && arma != null) {
            		handler.mouseClicked(palpitado, arma);
                	dispose();
            	}
            }
        });
		
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setVisible(true);
	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
