package mvc;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lejos.robotics.mapping.LineMap;
import lejos.utility.Delay;

public class Robo{

	public static void main(String[] args) {
		LineMap kartta = new LineMap();
		ServerSocket ss;
		DataInputStream in = null;

		try{
			ss = new ServerSocket(1111);
			System.out.println("Odotetaan yhteyttä...");
			Socket s = ss.accept();
			in = new DataInputStream(s.getInputStream());
			kartta.loadObject(in);
			System.out.println("Onnistui");
			Delay.msDelay(5000);
			in.close();
			ss.close();
		}catch(IOException e){
			e.printStackTrace();
			}}
	}
