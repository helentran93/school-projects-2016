package mvc;

/**
 * Luokka, joka sis‰lt‰‰ tiedot pisteen koordinaateista.
 *
 * @author Helen
 * @version Java 8
 *
 */
public class Piste {

	/**
	 * Pisteen koordinaatti x-arvo.
	 */
	private float x;
	/**
	 * Pisteen koordinaatti y-arvo.
	 */
	private float y;

	/**
	 * Piste-luokan parametrillinen konstruktori.
	 * @param x koordinaatin x-arvo
	 * @param y koordinaatin y-arvo
	 */
	public Piste(float x, float y){
		this.x = x;
		this.y = y;
	}

	/**
	 * Setteri x-arvolle.
	 * @param x koordinaatin x-arvo
	 */
	public void setX(float x){
		this.x = x;
	}

	/**
	 * Setteri y-arvolle.
	 * @param y koordinaatin y-arvo
	 */
	public void setY(float y){
		this.y = y;
	}

	/**
	 * Getteri x-arvolle.
	 * @return Palauttaa x-arvon
	 */
	public float getX(){
		return this.x;
	}

	/**
	 * Getteri y-arvolle.
	 * @return Palauttaa y-arvon.
	 */
	public float getY(){
		return this.y;
	}
}