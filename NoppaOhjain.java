package application;

public class NoppaOhjain implements NoppaOhjain_IF{

	NoppaN�kym�_IF n�kym�;
	NoppaMalli_IF malli;

	public NoppaOhjain(NoppaN�kym�_IF n�kym�, NoppaMalli_IF malli){
		this.n�kym� = n�kym�;
		this.malli = malli;
	}

	@Override
	public void nopanHeitto() {
		n�kym�.setSilm�luku(malli.randomSilm�luku());
	}

}
