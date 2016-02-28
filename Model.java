package mvc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import lejos.robotics.geometry.Line;
import lejos.robotics.geometry.Rectangle;
import lejos.robotics.mapping.LineMap;

/**
 * Luokassa toteutetaan karttojen
 * ja janojen koordinaattien k�sittelyn sek� yhteyden luomisen robottiin.
 *
 * @author Helen
 *
 */
public class Model implements Model_IF{

	ArrayList<Sein�> sein�t = new ArrayList<Sein�>();
	private float[] koordinaatit;
	private float x, y, x2, y2;
	private DataOutputStream dat = null;
	private ObjectOutputStream out = null;
	private Socket s;


	Line [] jana = new Line[5];{
		jana [0] = new Line(200, -18, 30, -18);
		jana [1] = new Line(18, -30, 200, -250);
		jana [2] = new Line(92, 100, 92, -200);
		jana [3] = new Line(200, -90, -200, -90);
		jana [4] = new Line(0, 0, 0, -200);

	}

	ArrayList<int []> taulukotp = new ArrayList<int []>();

	int[] pp1 = {90, 0};
	int[] pp2 = {50, -35};
	int[] pp3 = {15, -75};
	int[] pp4 = {10, -5};
	int[] pp5 = {-1, -1};


	@Override
		public boolean luoYhteysRoboon() {

			LineMap kartta = new LineMap();
			Rectangle suorakulmio = new Rectangle(0, 0, 202, -200);
			kartta = new LineMap(jana, suorakulmio);

			taulukotp.add(pp1);
			taulukotp.add(pp2);
			taulukotp.add(pp3);
			taulukotp.add(pp4);
			taulukotp.add(pp5);

			try {
				s = new Socket("10.0.1.1", 1111);
				s.setReuseAddress(true);
				out = new ObjectOutputStream(s.getOutputStream());
				for(int [] a : taulukotp){
					out.writeObject(a);
				}
				out.flush();
				//out.close();
				//s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				//s = new Socket("10.0.1.1", 1111);
				//s.setReuseAddress(true);
				dat = new DataOutputStream(s.getOutputStream());
				kartta.dumpObject(dat);
				dat.flush();
				dat.close();
				s.close();

			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}


	public void luoSein�(float x, float y, float x2, float y2) {
		Sein� sein� = new Sein�(x, y, x2, y2);
		sein�t.add(sein�);
		System.out.println("Sein�n luonti onnistunut.");
	}

	public Sein�[] getSein�(){
		Sein�[] palautaSein� = new Sein�[sein�t.size()];
		for(Sein� s: sein�t){
			System.out.println(s.x+", "+s.y+", "+s.x2+", "+s.y2);
		}
		return (Sein�[])sein�t.toArray(palautaSein�);
	}

	@Override
	public Sein�[] poistaSein�(Sein�[] sein�) {
		Sein�[]palautaSein� = new Sein�[sein�t.size()];
		for(Sein� s: sein�t){
			sein�t.clear();
			System.out.println("Koordinaattien taulukko tyhjennetty.");
		}

		return (Sein�[])sein�t.toArray(palautaSein�);
	}


	@Override
	public LineMap luoKarttaRobolle(Sein�[] sein�) {
		Line[] janat = new Line[sein�t.size()];
		for(int i = 0; i < janat.length; i++){
			{
			janat[i] = new Line(sein�t.get(i).getX(), sein�t.get(i).getY(), sein�t.get(i).getX2(), sein�t.get(i).getY2());
			}
		}
		LineMap kartta = new LineMap();
		Rectangle suorakulmio = new Rectangle(0, 0, 400, 320);
		kartta = new LineMap(janat, suorakulmio);
		return kartta;
	}

	}
