package View;

import java.awt.Container;

import javax.swing.*;

public class NotasFrame extends JFrame{
	ButtonGroup personagens = new ButtonGroup();
	JRadioButton r1 = new JRadioButton();
	JRadioButton r2 = new JRadioButton();
	JRadioButton r3 = new JRadioButton();
	JRadioButton r4 = new JRadioButton();
	JRadioButton r5 = new JRadioButton();
	JRadioButton r6 = new JRadioButton();
	
	ButtonGroup comodos = new ButtonGroup();
	JRadioButton r7 = new JRadioButton();
	JRadioButton r8 = new JRadioButton();
	JRadioButton r9 = new JRadioButton();
	JRadioButton r10 = new JRadioButton();
	JRadioButton r11 = new JRadioButton();
	JRadioButton r12 = new JRadioButton();
	JRadioButton r13 = new JRadioButton();
	JRadioButton r14 = new JRadioButton();
	JRadioButton r15 = new JRadioButton();
	
	ButtonGroup armas = new ButtonGroup();
	JRadioButton r16 = new JRadioButton();
	JRadioButton r17 = new JRadioButton();
	JRadioButton r18 = new JRadioButton();
	JRadioButton r19 = new JRadioButton();
	JRadioButton r20 = new JRadioButton();
	JRadioButton r21 = new JRadioButton();
	
	public NotasFrame(String name) {
		super(name);
		Container c=getContentPane();
		personagens.add(r1);
		personagens.add(r2);
		personagens.add(r3);
		personagens.add(r4);
		personagens.add(r5);
		personagens.add(r6);
		
		c.add(r1);
	}
}
