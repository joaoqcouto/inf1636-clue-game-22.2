package View;

import java.awt.Container;
import javax.swing.border.*;

import Model.Cartas;
import Model.Jogo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.*;

public class NotasFrame extends JFrame{
	public final int LARG_DEFAULT=520;
	public final int ALT_DEFAULT=400;
	
	Jogo jogo = Jogo.getJogo();
	Map<String, Boolean> notas = jogo.getNotas();
			
	JCheckBox cb1 = new JCheckBox("Reverendo Green"		, notas.get("Reverendo Green"));
	JCheckBox cb2 = new JCheckBox("Coronel Mustard"		, notas.get("Coronel Mustard"));
	JCheckBox cb3 = new JCheckBox("Sra. White"			, notas.get("Sra. White"));
	JCheckBox cb4 = new JCheckBox("Professor Plum"		, notas.get("Professor Plum"));
	JCheckBox cb5 = new JCheckBox("Srta. Scarlet"		, notas.get("Srta. Scarlet"));
	JCheckBox cb6 = new JCheckBox("Sra. Peacock"		, notas.get("Sra. Peacock"));
	
	JCheckBox cb7 = new JCheckBox("Escritorio"			, notas.get("Escritorio"));
	JCheckBox cb8 = new JCheckBox("Entrada"				, notas.get("Entrada"));
	JCheckBox cb9 = new JCheckBox("Sala de estar"		, notas.get("Sala de estar"));
	JCheckBox cb10 = new JCheckBox("Biblioteca"			, notas.get("Biblioteca"));
	JCheckBox cb11 = new JCheckBox("Salao de jogos"		, notas.get("Salao de jogos"));
	JCheckBox cb12 = new JCheckBox("Sala de jantar"		, notas.get("Sala de jantar"));
	JCheckBox cb13 = new JCheckBox("Jardim de inverno"	, notas.get("Jardim de inverno"));
	JCheckBox cb14 = new JCheckBox("Sala de musica"		, notas.get("Sala de musica"));
	JCheckBox cb15 = new JCheckBox("Cozinha"			, notas.get("Cozinha"));
	
	JCheckBox cb16 = new JCheckBox("Corda"				, notas.get("Corda"));
	JCheckBox cb17 = new JCheckBox("Cano de Chumbo"		, notas.get("Cano de Chumbo"));
	JCheckBox cb18 = new JCheckBox("Faca"				, notas.get("Faca"));
	JCheckBox cb19 = new JCheckBox("Chave Inglesa"		, notas.get("Chave Inglesa"));
	JCheckBox cb20 = new JCheckBox("Castical"			, notas.get("Castical"));
	JCheckBox cb21 = new JCheckBox("Revolver"			, notas.get("Revolver"));
	
	
	
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
		
		cb1.setEnabled(false);
		cb2.setEnabled(false);
		cb3.setEnabled(false);
		cb4.setEnabled(false);
		cb5.setEnabled(false);
		cb6.setEnabled(false);
		
		cb7.setEnabled(false);
		cb8.setEnabled(false);
		cb9.setEnabled(false);
		cb10.setEnabled(false);
		cb11.setEnabled(false);
		cb12.setEnabled(false);
		cb13.setEnabled(false);
		cb14.setEnabled(false);
		cb15.setEnabled(false);
		
		cb16.setEnabled(false);
		cb17.setEnabled(false);
		cb18.setEnabled(false);
		cb19.setEnabled(false);
		cb20.setEnabled(false);
		cb21.setEnabled(false);
		
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
