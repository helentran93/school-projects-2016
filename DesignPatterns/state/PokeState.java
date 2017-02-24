package state;

abstract class PokeState {

	void syo(PokeEvolution pokeEvolution) {}

	void kehity(PokeEvolution pokeEvolution) {}

	void hyokkaa(PokeEvolution pokeEvolution) {}

	void muutaTila(PokeEvolution pokeEvolution, PokeState tila){
		pokeEvolution.muutaTila(tila);
	}
}
