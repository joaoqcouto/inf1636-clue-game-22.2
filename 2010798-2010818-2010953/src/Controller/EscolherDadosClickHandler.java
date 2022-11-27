package Controller;
import Model.Jogo;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class EscolherDadosClickHandler implements Observed {
	// singleton structure
	public static EscolherDadosClickHandler instance = null;
	public static EscolherDadosClickHandler getInstance() {
		if (instance == null) {
			instance = new EscolherDadosClickHandler();
		}
		return instance;
	}
	private EscolherDadosClickHandler() {}
	
	public void mouseClicked(int d1, int d2) {
		Jogo jogo = Jogo.getJogo();
		int d[] = {d1, d2};
		if (jogo.getFase() <= 1 ) {
			
			jogo.setDados(d);
			if (jogo.getFase() == 0) jogo.proxFase();
			
			System.out.println("Escolheu dados");
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
		// 6 indicates escolher dados with dados update
		return 6;
	}
	private void update() {
		ListIterator<Observer> li = observerList.listIterator();
		while(li.hasNext()) {
			li.next().notify(this);
		}
	}
}
