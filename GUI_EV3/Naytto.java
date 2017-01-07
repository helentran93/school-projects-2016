package mvc;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Canvas-luokan aliluokka Näyttö, joka sisältää metodeja erilaisten kuvioiden piirtämiseen.
 *
 * @author Helen
 * @version Java 8
 *
 */
public class Näyttö extends Canvas{

	/**
	 * Tarjoaa komponentteja kuvioiden piirtämiseen.
	 */
	private GraphicsContext gc;

	/**
	 * Näyttö-luokan konstruktori, joka muodostaa valmiiksi View-luokan käyttöliittymään taulun kooksi 200x200.
	 * @param w Käyttöliittymän taulun leveys
	 * @param h Käyttöliittymän taulun korkeus
	 */
	public Näyttö(float w, float h) {
		super(w, h);
		gc = this.getGraphicsContext2D();
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		gc.strokeRect(0, 0, 200, 200);

	}

	/**
	 * Piirtää seinän tauluun käyttäjän antamien arvojen perusteella.
	 * @param x Seinän x-arvo
	 * @param y Seinän y-arvo
	 * @param x2 Seinän x2-arvo
	 * @param y2 Seinän y2-arvo
	 */
	public void piirräSeinä(float x, float y, float x2, float y2){
		gc.setStroke(Color.RED);
		gc.setLineWidth(5);
		gc.strokeLine(x, y, x2, y2);
	}

	/**
	 * Pyyhkii taulun kuvioista kokonaan.
	 */
	public void pyyhiTaulu(){
		gc.clearRect(2, 2, 197, 197);
	}

	/**
	 * Piirtää robotin olinpaikan taululle robotilta saatujen x- ja y-arvojen perusteella.
	 * @param x Robotin olinpaikan x-arvo
	 * @param y Robotin olinpaikan y-arvo
	 */
	public void piirräPaikannus(float x, float y) {
		gc.setFill(Color.RED);
		gc.fillOval(x, y, 5, 5);
	}

	/**
	 * Piirtää tarkistuspisteen taululle käyttäjän antamien x- ja y-arvojen perusteella.
	 * @param x Pisteen koordinaatin x-arvo
	 * @param y Pisteen koordinaatin y-arvo
	 */
	public void piirräPiste(float x, float y) {
		gc.setFill(Color.DARKBLUE);
		gc.fillRoundRect(x, y, 10, 10, 10, 10);
	}

	/**
	 * Merkitsee tauluun valmiiksi robotin lähtökohdan.
	 */
	public void lähtöKohta(){
		gc.setFill(Color.ORANGERED);
		gc.fillRect(0, 0, 10, 10);
	}

	/**
	 * Piirtää suorakulmion muotoisen alueen taululle käyttäjän antamien w- ja h-arvojen perusteella.
	 * @param w Alueen leveys
	 * @param h Alueen korkeus
	 */
	public void piirräAlue(float w, float h){
		gc.setStroke(Color.DARKMAGENTA);
		gc.strokeRect(0, 0, w, h);
	}
}
