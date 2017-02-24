package composite;

public class Main {

	public static void main(String[] args) {

		//koosteet
		Laiteosa kotelo = new Kotelo();
		Laiteosa emolevy = new Emolevy();

		//lehdet
		Laiteosa muistipiiri = new Muistipiiri();
		Laiteosa naytonohjain = new Naytonohjain();
		Laiteosa prosessori = new Prosessori();
		Laiteosa verkkokortti = new Verkkokortti();

		//lis‰t‰‰n koosteeseen
		emolevy.lisaaOsa(verkkokortti);
		emolevy.lisaaOsa(prosessori);
		emolevy.lisaaOsa(naytonohjain);
		emolevy.lisaaOsa(muistipiiri);

		//kooste koosteeseen
		kotelo.lisaaOsa(emolevy);

		kotelo.laskeHinta();
		kotelo.print();
	}

}
