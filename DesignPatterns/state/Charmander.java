package state;

public class Charmander extends PokeState{

	private static Charmander instance = null;
	private Charmander() {};

	public static Charmander getInstance() {
		if(instance == null) {
			instance = new Charmander();
		}
		return instance;
	}

	void kehity(PokeEvolution evo) {
		System.out.println("Charmander nukkuu sike�sti.");
		System.out.println("Charmander kehittyi Charmeleoniksi.");
		muutaTila(evo, Charmeleon.getInstance());
	}

	void syo(PokeEvolution evo) {
		System.out.println("Charmander sy� kuin lehm�.");
	}

	void hyokkaa(PokeEvolution evo) {
		System.out.println("Charmander n�ytt�� pelottavaa naamaansa.");
	}

}
