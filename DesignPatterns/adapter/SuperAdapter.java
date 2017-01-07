package adapter;

public class SuperAdapter implements Pelikonsoli{

	private PS3peli adaptee = new PS3peli();

	public SuperAdapter(PS3peli p) {
		this.adaptee = p;
	}

	@Override
	public void pelaa(String peli) {
		adaptee.pelaa(peli);
	}


}
