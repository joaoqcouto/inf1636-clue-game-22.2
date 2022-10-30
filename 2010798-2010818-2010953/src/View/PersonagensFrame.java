package View;

import java.awt.*;
import javax.swing.*;
public class PersonagensFrame extends JFrame{
	
	public final int LARG_DEFAULT=575;
	public final int ALT_DEFAULT=460;
	
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
		JPanel p = new CluePanel("./Resources/Clue-Start.jpg");
		
		getContentPane().add(p);
		JCheckBox cb1=new JCheckBox("Mrs Scarlett",false);
		JCheckBox cb2=new JCheckBox("Col. Mustard",false);
		JCheckBox cb3=new JCheckBox("Mrs. White",false);
		JCheckBox cb4=new JCheckBox("Rev. Green",false);
		JCheckBox cb5=new JCheckBox("Mrs. Peacock",false);
		JCheckBox cb6=new JCheckBox("Prof. Plum",false);

		cb1.setBounds(50,50,100,30);
		cb2.setBounds(50,80,100,30);
		cb3.setBounds(50,110,100,30);
		cb4.setBounds(50,140,100,30);
		cb5.setBounds(50,140,100,30);
		cb6.setBounds(50,140,100,30);

		p.add(cb1);
		p.add(cb2);
		p.add(cb3);
		p.add(cb4);
	}
}
