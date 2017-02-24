package state;

public class Charizard extends PokeState{

	private static Charizard instance = null;
	private Charizard() {}

	public static Charizard getInstance() {
		if(instance == null) {
			instance = new Charizard();
		}
		return instance;
	}

	void syo(PokeEvolution evo) {
		System.out.println("Charizard syö kuorma-auton verran roskaruokaa.");
	}

	void hyokkaa(PokeEvolution evo) {
		System.out.println("Charizard käyttää Wing Attackia hyökkäyksessään.");
	}

	void kehity(PokeEvolution evo) {
		System.out.println("Charizard kuorsaa äänekkäästi.");
		System.out.println("Pokemonisi on muuttui takaisin Charmanderiksi.");
		muutaTila(evo, Charmander.getInstance());
	}

}
