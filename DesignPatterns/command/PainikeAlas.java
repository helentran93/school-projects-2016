package command;

public class PainikeAlas implements Komento {

	private Valkokangas kangas;

	public PainikeAlas(Valkokangas k) {
		this.kangas = k;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		kangas.kangasAlas();
	}

}
