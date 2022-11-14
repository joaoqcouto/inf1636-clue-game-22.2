package Controller;
import Model.Jogo;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PalpiteClickHandler implements Observed {
	// singleton structure
	static PalpiteClickHandler instance = null;
	static public PalpiteClickHandler getInstance() {
		if (instance == null) {
			instance = new PalpiteClickHandler();
		}
		return instance;
	}
	private PalpiteClickHandler() {}
	
	public void mouseClicked(String palpitado, String arma) {
		Jogo jogo = Jogo.getJogo();
		
		// pode dar palpite depois de andar, de dentro de um comodo
		if (jogo.getFase() == 2) {
			
			String palpiteResposta = jogo.palpita(palpitado, arma);
			
			System.out.println("PALPITE FEITO");
			if (palpiteResposta==null) {
				System.out.println("Erro no palpite");
			}
			else if (palpiteResposta=="n") {
				System.out.println("Ninguem desprovou palpite");
			}
			else {
				System.out.println("Existe carta:");
				System.out.println(palpiteResposta);
			}
			
			jogo.proxFase();
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
		// 3 indicates palpite
		return 3;
	}
	private void update() {
		ListIterator<Observer> li = observerList.listIterator();
		while(li.hasNext()) {
			li.next().notify(this);
		}
	}
}
