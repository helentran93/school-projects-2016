package composite;

public class Naytonohjain implements Laiteosa{

	private int hinta;

	public Naytonohjain() {
		this.hinta = 10;
	}

	@Override
	public void lisaaOsa(Laiteosa laiteosa) {
		// TODO Auto-generated method stub
		throw new RuntimeException
		("Ei voi lis�t� muita laiteosia t�h�n laiteosaan.");
	}

	@Override
	public int laskeHinta() {
		// TODO Auto-generated method stub
		return hinta;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("N�yt�nohjain, hinta: " + hinta);
	}
}
