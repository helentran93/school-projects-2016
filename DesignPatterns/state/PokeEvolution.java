package state;

public class PokeEvolution {

	private PokeState tila;

	public PokeEvolution() {
		tila = Charmander.getInstance();
	}

	public void syo() {
		tila.syo(this);
	}

	public void kehity() {
		tila.kehity(this);
	}

	public void hyokkaa() {
		tila.hyokkaa(this);
	}

	protected void muutaTila(PokeState t) {
		tila = t;
	}
}
