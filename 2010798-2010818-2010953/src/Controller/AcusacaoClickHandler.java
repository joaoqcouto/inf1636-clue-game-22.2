package Controller;
import Model.Jogo;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AcusacaoClickHandler implements Observed {
	// singleton structure
	static AcusacaoClickHandler instance = null;
	static public AcusacaoClickHandler getInstance() {
		if (instance == null) {
			instance = new AcusacaoClickHandler();
		}
		return instance;
	}
	private AcusacaoClickHandler() {}
	
	private int acusacao;
	
	public void mouseClicked(String acusado, String lugar, String arma) {
		Jogo jogo = Jogo.getJogo();
		
		// acusacao depois de andar
		if (jogo.getFase() >= 2) {
			
			boolean acusacaoResposta = jogo.acusa(acusado, lugar, arma);
			
			System.out.println("PALPITE FEITO");
			
			if (acusacaoResposta) {
				System.out.println("Parabens acertou");
				acusacao = 5;
			}
			
			else {
				System.out.println("Errou, saiu do jogo");
				acusacao = 4;
			}
			
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
		// 4 indicates acusacao errada
		// 5 indicates acusacao certa
		return acusacao;
	}
	private void update() {
		ListIterator<Observer> li = observerList.listIterator();
		while(li.hasNext()) {
			li.next().notify(this);
		}
	}
}
