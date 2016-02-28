package valuuttakone;

import java.util.ArrayList;
import java.util.Arrays;

public class Valuuttakone implements Valuuttakone_IF {
	ValuuttaAccessObject vao;

	ArrayList<Valuutta> valuutat = new ArrayList<Valuutta>();
	private String[] nimet;

	Valuutta euro, ruotsi, norja, usa;{

	euro = new Valuutta("EUR", 1.0f, "Euroopan euro");
	ruotsi = new Valuutta("SEK", 9.5f, "Ruotsin kruunu");
	norja = new Valuutta("NOK", 8.25f, "Norjan kruunu");
	usa = new Valuutta("USD", 1.35f, "Yhdysvaltain dollari");

	valuutat.add(euro);
	valuutat.add(ruotsi);
	valuutat.add(norja);
	valuutat.add(usa);
	};


	public Valuuttakone(){
		nimet = new String[4];
		for(int i = 0; i < valuutat.size(); i++){
			Valuutta v = valuutat.get(i);
			nimet[i] = v.getNimi();
		}
	}

// 	Testataan, tulostuuko taulukko oikein
	@Override
	public String[] getVaihtoehdot() {
		System.out.println(Arrays.toString(nimet));	//nimet
		return this.nimet;
	}

	@Override
	public double muunna(int mistä, int mihin, double määrä) {

		double valinta1 = valuutat.get(mistä).getVaihtokurssi();
		double valinta2 = valuutat.get(mihin).getVaihtokurssi();

		double jakolasku = määrä /valinta1;
		double kertolasku = valinta2 * jakolasku;

		return kertolasku;
	}

}
