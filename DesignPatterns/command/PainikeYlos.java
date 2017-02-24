package command;

public class PainikeYlos implements Komento {

	private Valkokangas kangas;

	public PainikeYlos(Valkokangas k) {
		this.kangas = k;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		kangas.kangasYlos();
	}

}
