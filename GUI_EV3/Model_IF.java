package mvc;

import lejos.robotics.geometry.Rectangle;

/**
 * Model-luokan rajapinta, jossa esitellään metodeja parametreineen.
 * @author Helen
 * @version Java 8
 */
public interface Model_IF {

	/**
	 * Getteri tarkistuspisteelle.
	 * @return Palauttaa Piste-luokan oliotaulukon.
	 */
	public abstract Piste[] getPiste();
	/**
	 * Luo yhteyden robottiin ja samalla lähettää kartan robotille avaamalla tietovirran.
	 * @return Palauttaa boolean arvon joko true tai false.
	 */
	public abstract boolean luoYhteysRoboon();
	/**
	 * Luo uuden Seinä-luokan olion ja lisää sen ArrayList-listaan.
	 * @param x Seinän x-arvo
	 * @param y Seinän y-arvo
	 * @param x2 Seinän x2-arvo
	 * @param y2 Seinän y2-arvo
	 */
	public abstract void luoSeinä(float x, float y, float x2, float y2);
	/**
	 * Getteri seinälle.
	 * @return Palauttaa Seinä-luokan oliotaulukon.
	 */
	public abstract Seinä[] getSeinä();
	/**
	 * Tyhjentää seinien koordinaatteista sisältävän oliotaulukon.
	 * @param seinä	Olio, joka sisältää tiedon koordinaateista
	 * @return Palauttaa taulukon.
	 */
	public abstract Seinä[] poistaSeinä(Seinä[] seinä);
	/**
	 * Luo uuden Piste-luokan olion ja lisää sen ArrayList-listaan.
	 * @param x Pisteen x-arvo
	 * @param y Pisteen y-arvo
	 */
	public abstract void luoPiste(float x, float y);
	/**
	 * Tyhjentää pisteiden koordinaatteista sisältävän oliotaulukon.
	 * @param piste Olio, joka sisältää tiedon koordinaateista.
	 * @return Palauttaa taulukon.
	 */
	public abstract Piste[] poistaPiste(Piste[] piste);
	/**
	 * Luo uuden Rectangle-luokan olion ja määritellään alueen kokoa w- ja h-arvoilla.
	 * @param w Alueen leveys
	 * @param h Alueen korkeus
	 * @return Palauttaa olion.
	 */
	public abstract Rectangle luoAlue(float w, float h);
	/**
	 * Muuttaa alueen koon takaisin vakioksi (0, 0, 200, 200).
	 * @return Palauttaa olion.
	 */
	public abstract Rectangle alustaAlue();

}
