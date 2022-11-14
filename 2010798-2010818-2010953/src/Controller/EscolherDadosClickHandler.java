package Controller;
import Model.Jogo;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class EscolherDadosClickHandler implements MouseListener, Observed {
	// singleton structure
	static EscolherDadosClickHandler instance = null;
	static public EscolherDadosClickHandler getInstance() {
		if (instance == null) {
			instance = new EscolherDadosClickHandler();
		}
		return instance;
	}
	private EscolherDadosClickHandler() {}
	
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		Jogo jogo = Jogo.getJogo();
		
		if (jogo.getFase() == 0 ) {
			jogo.rolaDados();
			
			System.out.println("Jogou dados (PELO ESCOLHER)");
			int[] dados = jogo.getDados();
			System.out.println(dados[0]);
			System.out.println(dados[1]);	
			this.update();
		}
	}
	
	// observed structure
	private List<Observer> observerList = new ArrayList<Observer>();
	public void add(Observer o) {
		observerList.add(o);
	}
	public void remove(Observer o) {
		observerList.remove(o);
	}
	public int get() {
		// 1 indicates dados update
		return 1;
	}
	private void update() {
		ListIterator<Observer> li = observerList.listIterator();
		while(li.hasNext()) {
			li.next().notify(this);
		}
	}
}
