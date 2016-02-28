package mvc;


/**
 * Ohjaimella on vastuu p‰‰tt‰‰ ohjauslogiikasta,
 * mit‰ pit‰‰ tehd‰ miss‰kin tilanteessa.
 *
 * @author Helen
 *
 */
public class Controller implements Controller_IF{

	private View_IF n‰kym‰;
	private Model_IF malli;

	public Controller(View_IF n‰kym‰, Model_IF malli) {
		this.n‰kym‰ = n‰kym‰;
		this.malli = malli;
	}


	@Override
	public void yhteysStart() {
		n‰kym‰.setYhteys(malli.luoYhteysRoboon());
	}

	@Override
	public void kartanTuonti() {
		n‰kym‰.setKartta(malli.getSein‰());
	}

	@Override
	public void sein‰nLuonti(float x, float y, float x2, float y2) {
		malli.luoSein‰(x, y, x2, y2);
		n‰kym‰.setSein‰(malli.getSein‰());
	}

	@Override
	public void sein‰nTuho() {
		n‰kym‰.setSein‰(malli.poistaSein‰(malli.getSein‰()));
	}

	public void updateLabels(float x, float y){
		n‰kym‰.updateTextLabel(Float.toString(x)+" "+Float.toString(y));
		n‰kym‰.updateN‰yttˆ(x, y);
	}

}
