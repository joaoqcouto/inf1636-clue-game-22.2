package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class PalpiteFrame extends JFrame {
	
	public PalpiteFrame(String name) {
		super(name);
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
		
		JLabel l2=new JLabel("Cômodos:");
		ButtonGroup comodos = new ButtonGroup();
		JRadioButton r7 = new JRadioButton("Escritorio");
		JRadioButton r8 = new JRadioButton("Entrada");
		JRadioButton r9 = new JRadioButton("Sala de estar");
		JRadioButton r10 = new JRadioButton("Biblioteca");
		JRadioButton r11 = new JRadioButton("Salao de jogos");
		JRadioButton r12 = new JRadioButton("Sala de jantar");
		JRadioButton r13 = new JRadioButton("Jardim de inverno");
		JRadioButton r14 = new JRadioButton("Sala de musica");
		JRadioButton r15 = new JRadioButton("Cozinha");
		
		JLabel l3=new JLabel("Armas:");
		ButtonGroup armas = new ButtonGroup();
		JRadioButton r16 = new JRadioButton("Corda");
		JRadioButton r17 = new JRadioButton("Faca");
		JRadioButton r18 = new JRadioButton("Chave Inglesa");
		JRadioButton r19 = new JRadioButton("Castiçal");
		JRadioButton r20 = new JRadioButton("Revólver");
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
		
		l2.setBounds(200,20,150,30);
		comodos.add(r7);
		comodos.add(r8);
		comodos.add(r9);
		comodos.add(r10);
		comodos.add(r11);
		comodos.add(r12);
		comodos.add(r13);
		comodos.add(r14);
		comodos.add(r15);
		r7.setBounds(200,50,150,30);
		r8.setBounds(200,80,150,30);
		r9.setBounds(200,110,150,30);
		r10.setBounds(200,140,150,30);
		r11.setBounds(200,170,150,30);
		r12.setBounds(200,200,150,30);
		r13.setBounds(200,230,150,30);
		r14.setBounds(200,260,150,30);
		r15.setBounds(200,290,150,30);
		c.add(l2);
		c.add(r7);
		c.add(r8);
		c.add(r9);
		c.add(r10);
		c.add(r11);
		c.add(r12);
		c.add(r13);
		c.add(r14);
		c.add(r15);
		
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
		b1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	dispose();
            }
        });
		setSize(570,420);
		setVisible(true);
	}
}
