package mvc;

import lejos.robotics.geometry.Rectangle;

/**
 * Näkymän rajapinta, jossa esitellään View-luokan metodit parametreineen.
 *
 * @author Helen
 * @version Java 8
 *
 */
public interface View_IF {

	/**
	 * Tarkistaa, jos yhteys on true tai false. Jos on true, se käynnistää Vastaanottaja-säikeen, joka ottaa robotilta vastaan tietoa sen olinpaikasta
	 * koordinaatteina.
	 *
	 * @param yhteys Kun yhteydenmuodostus onnistuu, Model-luokasta palautetaan true. Jos ei, palautetaan arvoksi false.
	 */
	public abstract void setYhteys(boolean yhteys);
	/**
	 * Seinän luonnin jälkeen piirretään tauluun seinä ja ilmoitetaan konsolissa, että seinä on luotu.
	 * @param seinä Seinä-luokasta oliotaulukon muodossa koordinaatteja.
	 */
	public abstract void setSeinä(Seinä[] seinä);
	/**
	 * Päivittää tekstin reaaliajassa koordinaattien muodossa robotin olinpaikasta.
	 * @param msg
	 * Edustaa tekstiä koordinaattien muodossa.
	 */
	public abstract void updateTextLabel(String msg);
	/**
	 * Piirtää ja päivittää pallon sijainnin, joka edustaa robotin olinpaikkaa kartalla.
	 * @param x Robotin olinpaikan x-arvo.
	 * @param y	Robotin olinpaikan y-arvo.
	 */
	public abstract void updatePallo(float x, float y);
	/**
	 * Pisteen luonnin jälkeen piirretään piste ja ilmoitetaan konsolissa, että piste on luotu.
	 * @param getPiste Piste-luokasta oliotaulukon muodossa koordinaatteja.
	 */
	public abstract void setPiste(Piste[] getPiste);
	/**
	 * Tyhjentää seinien ja pisteiden koordinaatteja sisältävän taulukon ja alustaa suorakulmion koon.
	 * @param seinä Seinä-luokasta oliotaulukon muodossa koordinaatteja.
	 * @param piste Piste-luokasta oliotaulukon muodossa koordinaatteja.
	 * @param suorakulmio Rectangle-oliota edustava suorakulmio, joka sisältää tiedon koosta koordinaattien muodossa.
	 */
	public abstract void setTuho(Seinä[] seinä, Piste[] piste, Rectangle suorakulmio);
	/**
	 * Alueen luonnin jälkeen piirretään suorakulmion muotoinen alue, jonka koko on käyttäjän määrittämä.
	 * @param suorakulmio Rectangle-oliota edustava suorakulmio, joka sisältää tiedon koosta koordinaattien muodossa.
	 */
	public abstract void setAlue(Rectangle suorakulmio);

}
