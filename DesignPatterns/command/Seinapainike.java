package command;

public class Seinapainike {

	private Komento komento;

	public Seinapainike(Komento k) {
		this.komento = k;
	}

	public void push() {
		komento.execute();
	}

}
