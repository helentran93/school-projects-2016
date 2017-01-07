package mvc;


/**
 * Ohjaimen rajapinta, jossa esitellään Controller-luokan metodit parametreineen.
 * @author Helen
 * @version Java 8
 *
 */
public interface Controller_IF {

	/**
	 * Vie käskyn luoda yhteyden Model-luokkaan ja odottaa vastausta yhteyden muodostamisen onnistumisesta. Vie sen takaisin View-luokkaan setYhteys()-metodille.
	 */
	public abstract void yhteysStart();
	/**
	 * Vie koordinaatit Model-luokkaan luodakseen seinät ja tuo sieltä seinien koordinaatteja sisältävän taulukon View-luokkaan.
	 * @param x Seinän koordinaatin x-arvo
	 * @param y Seinän koordinaatin y-arvo
	 * @param x2 Seinän koordinaatin x2-arvo
	 * @param y2 Seinän koordinaatin y2-arvo
	 */
	public abstract void seinänLuonti(float x, float y, float x2, float y2);
	/**
	 * Vie käskyn näkymään päivittämään tekstin ikkunassa joka kerta, kun robotti liikkuu.
	 * @param x Robotin olinpaikan x-arvo
	 * @param y Robotin olinpaikan y-arvo
	 */
	public abstract void updateLabels(float x, float y);
	/**
	 * Vie käskyn luoda uuden tarkistuspisteen Model-luokkaan ja tuo sieltä pisteiden koordinaatteja sisältävän taulukon View-luokkaan.
	 * @param x Pisteen koordinaatin x-arvo
	 * @param y Pisteen koordinaatin y-arvo
	 */
	public abstract void tarkistuspisteLuonti(float x, float y);
	/**
	 * Vie käskyn tyhjentää kaikki taulukot koordinaateista Model-luokkaan ja tuo sieltä tyhjät taulukot View-luokkaan.
	 */
	public abstract void kokoTuho();
	/**
	 * Vie käskyn määrittää alueen koko Model-luokkaan ja tuo sieltä alueen koon koordinaattien muodossa (0, 0, w, h) View-luokkaan.
	 * @param w Alueen leveys
	 * @param h Alueen korkeus
	 */
	public abstract void alueenLuonti(float w, float h);

}
