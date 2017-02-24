package state;

public class Charmeleon extends PokeState{

	private static Charmeleon instance = null;
	private Charmeleon() {}

	public static Charmeleon getInstance() {
		if(instance == null) {
			instance = new Charmeleon();
		}
		return instance;
	}

	void syo(PokeEvolution evo) {
		System.out.println("Charmeleon sy� v�h�n.");
	}

	void kehity(PokeEvolution evo) {
		System.out.println("Charmeleon nukkuu sike�sti.");
		System.out.println("Pokemonisi on kehittynyt Charizardiksi.");
		muutaTila(evo, Charizard.getInstance());
	}

	void hyokkaa(PokeEvolution evo) {
		System.out.println("Charmeleon k�ytt�� Flare Blazea hy�kk�yksess��n.");
	}


}
