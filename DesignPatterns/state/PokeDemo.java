package state;

public class PokeDemo {

	public static void main(String [] args){
		PokeEvolution evo = new PokeEvolution();

		//Charmander
		evo.syo();
		evo.hyokkaa();
		evo.kehity();

		//Charmeleon
		evo.syo();
		evo.hyokkaa();
		evo.kehity();

		//Charizard
		evo.syo();
		evo.hyokkaa();

		//...takaisin Charmanderiksi
		evo.kehity();

	}
}
