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
		System.out.println("Charmeleon syö vähän.");
	}

	void kehity(PokeEvolution evo) {
		System.out.println("Charmeleon nukkuu sikeästi.");
		System.out.println("Pokemonisi on kehittynyt Charizardiksi.");
		muutaTila(evo, Charizard.getInstance());
	}

	void hyokkaa(PokeEvolution evo) {
		System.out.println("Charmeleon käyttää Flare Blazea hyökkäyksessään.");
	}


}
