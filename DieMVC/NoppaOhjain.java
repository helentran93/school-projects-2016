package application;

public class NoppaOhjain implements NoppaOhjain_IF{

	NoppaNäkymä_IF näkymä;
	NoppaMalli_IF malli;

	public NoppaOhjain(NoppaNäkymä_IF näkymä, NoppaMalli_IF malli){
		this.näkymä = näkymä;
		this.malli = malli;
	}

	@Override
	public void nopanHeitto() {
		näkymä.setSilmäluku(malli.randomSilmäluku());
	}

}
