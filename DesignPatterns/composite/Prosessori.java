package composite;

public class Prosessori implements Laiteosa{

	private int hinta;

	public Prosessori() {
		this.hinta = 10;
	}

	@Override
	public void lisaaOsa(Laiteosa laiteosa) {
		// TODO Auto-generated method stub
		throw new RuntimeException
		("Ei voi lisätä muita laiteosia tähän laiteosaan.");
	}

	@Override
	public int laskeHinta() {
		// TODO Auto-generated method stub
		return hinta;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Prosessori, hinta: " + hinta);
	}
}
