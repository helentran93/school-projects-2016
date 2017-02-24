package proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProxyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Image> kansio = new ArrayList<Image>();
		Scanner s = new Scanner(System.in);

		kansio.add(new ProxyImage("kukka.jpg"));
		kansio.add(new ProxyImage("syksy.jpg"));
		kansio.add(new ProxyImage("tulipalo.jpg"));
		kansio.add(new ProxyImage("kanala.jpg"));
		kansio.add(new ProxyImage("veitsi.jpg"));
		kansio.add(new ProxyImage("pulla.jpg"));

		System.out.println("Valokuvakansion sisältö: ");
		//tulostetaan tiedot valokuvakansion sisällöstä
		for(int j = 0; j < kansio.size(); j++) {
			System.out.println(kansio.get(j).showData());
		}

		System.out.println("Selaa valokuvakansio: ");
		//valokuvakansion selaaminen: jos kuva ei ole vielä ladattu, ladataan
		try {
			while(true) {
				System.out.println("Anna joku sivunumero väliltä 0-5, niin näytämme sinulle kuvan.");
				System.out.print(">");
				int num = s.nextInt();
				kansio.get(num).displayImage();
			}
		} catch(Exception e) {
			System.exit(1);
		}
	}

}
