package composite;

import java.util.ArrayList;
import java.util.List;

public class Kotelo implements Laiteosa {

	private int hinta;
	private int uusiHinta;
	List<Laiteosa> koteloLista = new ArrayList<Laiteosa>();

	public Kotelo() {
		this.hinta = 10;
	}

	@Override
	public void lisaaOsa(Laiteosa laiteosa) {
		// TODO Auto-generated method stub
		koteloLista.add(laiteosa);
	}

	@Override
	public int laskeHinta() {
		uusiHinta = hinta;
		// TODO Auto-generated method stub
		for(Laiteosa l : koteloLista) {
			uusiHinta += l.laskeHinta();
		}
		return uusiHinta;
	}

	@Override
	public void print() {
		System.out.println("Kotelo, hinta: " + hinta);
		for(Laiteosa l : koteloLista) {
			l.print();
		}
		System.out.println("Kokonaishinnaksi tuli " + uusiHinta + " euroa.");
	}
}
