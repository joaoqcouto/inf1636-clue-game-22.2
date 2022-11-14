package View;

import java.awt.Container;
import javax.swing.border.*;

import Model.Cartas;
import Model.Jogo;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class NotasFrame extends JFrame{
	public final int LARG_DEFAULT=520;
	public final int ALT_DEFAULT=400;
	
	Jogo jogo = Jogo.getJogo();
	Cartas carta_jogador_vez [] = jogo.getCartasJogadorAtual();
	int num_cartas = jogo.getQtdCartasJogadorAtual();
			
	JCheckBox cb1 = new JCheckBox("Reverendo Green", false);
	JCheckBox cb2 = new JCheckBox("Coronel Mustard", false);
	JCheckBox cb3 = new JCheckBox("Sra. White", false);
	JCheckBox cb4 = new JCheckBox("Professor Plum", false);
	JCheckBox cb5 = new JCheckBox("Srta. Scarlet", false);
	JCheckBox cb6 = new JCheckBox("Sra. Peacock", false);
	
	JCheckBox cb7 = new JCheckBox("Escritorio", false);
	JCheckBox cb8 = new JCheckBox("Entrada", false);
	JCheckBox cb9 = new JCheckBox("Sala de estar", false);
	JCheckBox cb10 = new JCheckBox("Biblioteca", false);
	JCheckBox cb11 = new JCheckBox("Salao de jogos", false);
	JCheckBox cb12 = new JCheckBox("Sala de jantar", false);
	JCheckBox cb13 = new JCheckBox("Jardim de inverno", false);
	JCheckBox cb14 = new JCheckBox("Sala de musica", false);
	JCheckBox cb15 = new JCheckBox("Cozinha", false);
	
	JCheckBox cb16 = new JCheckBox("Corda", false);
	JCheckBox cb17 = new JCheckBox("Cano de Chumbo", false);
	JCheckBox cb18 = new JCheckBox("Faca", false);
	JCheckBox cb19 = new JCheckBox("Chave Inglesa", false);
	JCheckBox cb20 = new JCheckBox("Castiçal", false);
	JCheckBox cb21 = new JCheckBox("Revólver", false);
	
	
	
	public NotasFrame(String nome) {
		super(nome);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2 - LARG_DEFAULT/2;
		int y=sa/2 - ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		
		setLayout(null);
		Container c=getContentPane();
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS)); 
		p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
		p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
		
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		p1.add(cb4);
		p1.add(cb5);
		p1.add(cb6);
		p1.setBounds(10,10,150,170);
		
		p2.add(cb7);
		p2.add(cb8);
		p2.add(cb9);
		p2.add(cb10);
		p2.add(cb11);
		p2.add(cb12);
		p2.add(cb13);
		p2.add(cb14);
		p2.add(cb15);
		p2.setBounds(180,10,150,240);
	
		p3.add(cb16);
		p3.add(cb17);
		p3.add(cb18);
		p3.add(cb19);
		p3.add(cb20);
		p3.add(cb21);
		p3.setBounds(340,10,150,170);
		
		Border b=BorderFactory.createLoweredBevelBorder();
		p1.setBorder(BorderFactory.createTitledBorder(b,"Suspeitos"));
		Border b2=BorderFactory.createLoweredBevelBorder();
		p2.setBorder(BorderFactory.createTitledBorder(b2,"Comodos"));
		Border b3=BorderFactory.createLoweredBevelBorder();
		p3.setBorder(BorderFactory.createTitledBorder(b3,"Armas"));
		
		c.add(p1);
		c.add(p2);
		c.add(p3);
		
	}
	
}
