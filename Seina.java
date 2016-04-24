package mvc;

/**
 * Luokka, joka sisältää tiedot seinän koordinaateista.
 *
 * @author Helen
 * @version Java 8
 *
 */
public class Seinä {

	/**
	 * Seinän koordinaatin x-arvo.
	 */
	private float x;
	/**
	 * Seinän koordinaatin y-arvo.
	 */
	private float y;
	/**
	 * Seinän koordinaatin x2-arvo/leveyden arvo.
	 */
	private float x2;
	/**
	 * Seinän koordinaatin y2-arvo/korkeuden arvo.
	 */
	private float y2;

	/**
	 * Seinä-luokan parametrillinen konstruktori.
	 * @param x koordinaatin x-arvo
	 * @param y koordinaatin y-arvo
	 * @param x2 koordinaatin x2-arvo
	 * @param y2 koordinaatin y2-arvo
	 */
	public Seinä(float x, float y, float x2, float y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
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
	 * Setteri x2-arvolle.
	 * @param x2 koordinaatin x2-arvo
	 */
	public void setX2(float x2){
		this.x2 = x2;
	}

	/**
	 * Setteri y2-arvolle.
	 * @param y2 koordinaatin y2-arvo
	 */
	public void setY2(float y2){
		this.y2 = y2;
	}

	/**
	 * Getteri x-arvolle.
	 * @return Palauttaa x-arvon.
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

	/**
	 * Getteri x2-arvolle.
	 * @return Palauttaa x2-arvon.
	 */
	public float getX2(){
		return this.x2;
	}

	/**
	 * Getteri y2-arvolle.
	 * @return Palauttaa y2-arvon.
	 */
	public float getY2(){
		return this.y2;
	}


}
