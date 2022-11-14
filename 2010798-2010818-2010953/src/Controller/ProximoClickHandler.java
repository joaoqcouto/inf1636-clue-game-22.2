package Controller;
import Model.Jogo;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ProximoClickHandler implements MouseListener, Observed {
	// singleton structure
	static ProximoClickHandler instance = null;
	static public ProximoClickHandler getInstance() {
		if (instance == null) {
			instance = new ProximoClickHandler();
		}
		return instance;
	}
	private ProximoClickHandler() {}
		
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		Jogo jogo = Jogo.getJogo();
		
		System.out.println("Handler de passar a vez");
		System.out.println(jogo.getFase());
		
		if (jogo.getFase() >= 2) {
			jogo.passaVez();
			System.out.println("Passou a vez");
			System.out.println(jogo.getJogadorAtualNome());
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
		// 2 indicates turn update
		return 2;
	}
	private void update() {
		ListIterator<Observer> li = observerList.listIterator();
		while(li.hasNext()) {
			li.next().notify(this);
		}
	}
}
