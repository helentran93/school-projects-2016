package composite;

import java.util.ArrayList;
import java.util.List;

public class Emolevy implements Laiteosa {

	private int hinta;
	private int uusiHinta;
	List<Laiteosa> emoLista = new ArrayList<Laiteosa>();

	public Emolevy() {
		this.hinta = 10;
	}

	@Override
	public void lisaaOsa(Laiteosa laiteosa) {
		// TODO Auto-generated method stub
		emoLista.add(laiteosa);
	}

	@Override
	public int laskeHinta() {
		// TODO Auto-generated method stub
		uusiHinta = hinta;
		for(Laiteosa l : emoLista) {
			uusiHinta += l.laskeHinta();
		}
		return uusiHinta;

	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Emolevy, hinta: " + hinta);
		for(Laiteosa l : emoLista) {
			l.print();
		}
	}
}
