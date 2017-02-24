package command;

public class Testi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Valkokangas kangas = new Valkokangas();
		Komento alas = new PainikeAlas(kangas);
		Komento ylos = new PainikeYlos(kangas);
		Seinapainike p1 = new Seinapainike(alas);
		Seinapainike p2 = new Seinapainike(ylos);

		p1.push();
		p2.push();
	}

}
