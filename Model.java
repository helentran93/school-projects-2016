package mvc;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import lejos.robotics.geometry.Line;
import lejos.robotics.geometry.Rectangle;
import lejos.robotics.mapping.LineMap;


/**
 * Luokassa toteutetaan karttojen ja janojen koordinaattien käsittelyn sekä yhteyden luomisen robottiin.
 *
 * @author Helen
 * @version Java 8
 *
 */
public class Model implements Model_IF{

	/**
	 * Lista, joka sisältää pisteiden koordinaattien x- ja y-arvot.
	 */
	ArrayList<Piste> pisteet = new ArrayList<Piste>();
	/**
	 * Lista, joka sisältää seinien koordinaattien x-, y-, x2- ja y2-arvot.
	 */
	ArrayList<Seinä> seinät = new ArrayList<Seinä>();
	/**
	 * Perustietotyypeille tarkoitettu tietovirta, johon lähetetään tiedot kartasta seinien ja alueen koon kanssa.
	 */
	private DataOutputStream dat = null;
	/**
	 * Olioille tarkoitettu tietovirta, johon lähetetään tiedot tarkistuspisteistä.
	 */
	private ObjectOutputStream out = null;
	/**
	 * Käyttöliittymän ja robotin välinen käytettävä kommunikoinnin päätepiste, joka avataan tiedonsiirron ajaksi ja suljetaan sen päätteeksi.
	 */
	private Socket s;
	/**
	 * Rectangle-oliota edustava suorakulmio, joka sisältää tiedon koosta koordinaattien muodossa.
	 */
	private Rectangle suorakulmio;
	/**
	 * Muuttuja, joka muuttaa arvoaan true tai false joka kerta, kun alueen kokoa määritetään uudestaan.
	 */
	boolean lippu = false;


	@Override
	public boolean luoYhteysRoboon() {

		Line[] janat = new Line[seinät.size()];
		for(int i = 0; i < janat.length; i++){
			janat[i] = new Line(seinät.get(i).getX(), seinät.get(i).getY(), seinät.get(i).getX2(), seinät.get(i).getY2());
		}

		LineMap kartta = new LineMap();
		if(lippu != true){
			suorakulmio = new Rectangle(0, 0, 200, 200);
		} else{
			suorakulmio = new Rectangle(suorakulmio.x, suorakulmio.y, suorakulmio.width, suorakulmio.height);
		}
		kartta = new LineMap(janat, suorakulmio);

		try {
			s = new Socket("10.0.1.1", 1111);
			s.setReuseAddress(true);
			out = new ObjectOutputStream(s.getOutputStream());
			for(int i = 0; i < pisteet.size(); i++){
				int[] piste = {(int)pisteet.get(i).getX(), (int)pisteet.get(i).getY()};
				out.writeObject(piste);
			}
			int[] lopetus = {-1, -1};
			out.writeObject(lopetus);
			out.flush();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Pisteiden lähettäminen epäonnistui!");
			e1.printStackTrace();
		}

		try {
			dat = new DataOutputStream(s.getOutputStream());
			kartta.dumpObject(dat);
			dat.flush();
			dat.close();
			s.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Kartan lähettäminen ei onnistunut!");
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void luoSeinä(float x, float y, float x2, float y2) {
		if(x <= 200 && y <= 200 && x2 <= 200 && y2 <= 200 && 0 <= x && 0 <= y && 0 <= x2 && 0 <= y2){
			Seinä seinä = new Seinä(x, y, x2, y2);
			seinät.add(seinä);
			System.out.println("Seinän luonti onnistunut.");
		} else{
			JOptionPane.showMessageDialog(null, "Seinää ei voi sijoittaa taulun ulkopuolelle!");
		}
	}

	@Override
	public Seinä[] getSeinä(){
		Seinä[] palautaSeinä = new Seinä[seinät.size()];
		for(Seinä s: seinät){
			System.out.println("Seinä luotu: "+s.getX()+", "+s.getY()+", "+s.getX2()+", "+s.getY2());
		}
		return (Seinä[])seinät.toArray(palautaSeinä);
	}

	@Override
	public Seinä[] poistaSeinä(Seinä[] seinä) {
		Seinä[] palautaSeinä = new Seinä[seinät.size()];
		for(int i = 0; i < palautaSeinä.length; i++){
			seinät.clear();
		}
		System.out.println("Seinien koordinaattien taulukko tyhjennetty.");
		return (Seinä[])seinät.toArray(palautaSeinä);
	}


	@Override
	public void luoPiste(float x, float y) {
		if(x <= 200 && y <= 200 && 0 <= x && 0 <= y){
			Piste piste = new Piste(x, y);
			pisteet.add(piste);
			System.out.println("Tarkistuspiste on asetettu.");
		} else{
			JOptionPane.showMessageDialog(null, "Pistettä ei voi sijoittaa taulun ulkopuolelle!");
		}
	}


	@Override
	public Piste[] getPiste() {
		Piste[] palautaPisteet = new Piste[pisteet.size()];
		for(Piste p: pisteet){
			System.out.println("Tarkistuspiste kohdassa: "+p.getX()+", "+p.getY());
		}
		return (Piste[])pisteet.toArray(palautaPisteet);
	}


	@Override
	public Piste[] poistaPiste(Piste[] piste) {
		Piste[] palautaPiste = new Piste[pisteet.size()];
		for(int i = 0; i < palautaPiste.length; i++){
			pisteet.clear();
		}
		System.out.println("Pisteiden koordinaattien taulukko tyhjennetty.");
		return (Piste[])pisteet.toArray(palautaPiste);
	}


	@Override
	public Rectangle luoAlue(float w, float h) {
		try{
			if(w <= 200 & h <= 200 && 0 <= w && 0 <= h){
				suorakulmio = new Rectangle(0, 0, w, h);
				System.out.println("Alue on luotu: "+suorakulmio.x+", "+suorakulmio.y+", "+suorakulmio.width+", "+suorakulmio.height);
				lippu = true;
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Alueen luonti ei onnistunut.");
		}
		return suorakulmio;
	}

	@Override
	public Rectangle alustaAlue(){
		suorakulmio = new Rectangle(0, 0, 200, 200);
		System.out.println("Alue alustettu.");
		lippu = false;
		return suorakulmio;
	}
	}
