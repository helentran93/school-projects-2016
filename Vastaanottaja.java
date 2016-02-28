
package mvc;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Platform;

public class Vastaanottaja extends Thread{

	private ServerSocket serv;
	private Socket s;
	private DataInputStream in;
	private volatile boolean stop = false;
	private String teksti;
	private Controller_IF ohjain;
	float x;
	float y;

	public Vastaanottaja(Controller_IF c){
		this.setPriority(1);
		ohjain=c;
		try {
			serv = new ServerSocket(1114);
			System.out.println(serv.getInetAddress());
			s = serv.accept();
			in = new DataInputStream(s.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(){ //Runnissa luetaan ja v‰litet‰‰n ohjaimelle koordinaatit
		while(!stop){
			if(s.isClosed()){
				System.out.println("EIIII");
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			try {
				x=in.readFloat(); //Luetaan l‰hetetyt koordinaatit. Math round vi rikkoa
				y=in.readFloat();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Platform.runLater(new Runnable(){
				public void run(){

					ohjain.updateLabels(x , y); //Kontrollerille tieto koordinaateista

				}
			});
		}

	}

	public void kill(){
		stop = true;
	}

}
