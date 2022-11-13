package Controller;
import Model.Jogo;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.awt.event.*;

// listeners are singletons and are being observed for UI updates
public class TabuleiroClickHandler implements MouseListener, Observed {
	// singleton structure
	static TabuleiroClickHandler instance = null;
	static public TabuleiroClickHandler getInstance() {
		if (instance == null) {
			instance = new TabuleiroClickHandler();
		}
		return instance;
	}
	private TabuleiroClickHandler() {}
	
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		int x=e.getX();
	    int y=e.getY();
	    if (x <= 603 && y <= 626) {
	    	int tabuleiroCol = x/25;
	    	int tabuleiroLinha = y/25;
	    	
	    	System.out.println("Clicou no tabuleiro");
	    	System.out.println("Linha "+tabuleiroLinha+", Coluna "+tabuleiroCol);
	    	
	    	Jogo jogo = Jogo.getJogo();
	    	int[] pos = {tabuleiroLinha, tabuleiroCol};
	    	boolean updated = jogo.moveJogador(pos);
	    	if (updated) this.update();
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
	public int get(int updateInfo) {
		// 0 indicates update from tabuleiro
		return 0;
	}
	private void update() {
		ListIterator<Observer> li = observerList.listIterator();
		while(li.hasNext()) {
			li.next().notify(this);
		}
	}
}
