package mvc;


/**
 * Ohjaimella on vastuu päättää ohjauslogiikasta,
 * mitä pitää tehdä missäkin tilanteessa.
 *
 * @author Helen
 * @version Java 8
 *
 */
public class Controller implements Controller_IF{

	/**
	 * View-luokan rajapinta.
	 */
	private View_IF näkymä;
	/**
	 * Model-luokan rajapinta.
	 */
	private Model_IF malli;

	/**
	 * Controller-luokan konstruktori.
	 * @param näkymä View-luokan rajapinta
	 * @param malli Model-luokan rajapinta
	 */
	public Controller(View_IF näkymä, Model_IF malli) {
		this.näkymä = näkymä;
		this.malli = malli;
	}


	@Override
	public void yhteysStart() {
		näkymä.setYhteys(malli.luoYhteysRoboon());
	}


	@Override
	public void seinänLuonti(float x, float y, float x2, float y2) {
		malli.luoSeinä(x, y, x2, y2);
		näkymä.setSeinä(malli.getSeinä());
	}

	public void updateLabels(float x, float y){
		näkymä.updateTextLabel(Float.toString(x)+" "+Float.toString(y));
		näkymä.updatePallo(x, y);
	}

	public void tarkistuspisteLuonti(float x, float y){
		malli.luoPiste(x, y);
		näkymä.setPiste(malli.getPiste());
	}

	@Override
	public void kokoTuho() {
		näkymä.setTuho(malli.poistaSeinä(malli.getSeinä()), malli.poistaPiste(malli.getPiste()), malli.alustaAlue());
	}

	@Override
	public void alueenLuonti(float w, float h) {
		näkymä.setAlue(malli.luoAlue(w, h));
	}



}
