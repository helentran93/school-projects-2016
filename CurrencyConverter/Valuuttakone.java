package tehtävät;

public class Valuuttakone implements Valuuttakone_IF {

	private ValuuttaAccessObject dao = new ValuuttaAccessObject();
	private Valuutta valuutat[];

	public Valuuttakone(){
		valuutat = dao.readValuutat();
	}

// 	Testataan, tulostuuko taulukko oikein
	@Override
	public String[] getVaihtoehdot() {
		String nimet[] = new String[valuutat.length];
		for(int i = 0; i < nimet.length; i++){
			nimet[i] = valuutat[i].getNimi();
		}
		return nimet;
	}

	@Override
	public double muunna(int mistä, int mihin, double määrä) {

		double valinta1 = valuutat[mistä].getVaihtokurssi();
		double valinta2 = valuutat[mihin].getVaihtokurssi();

		double jakolasku = määrä /valinta1;
		double kertolasku = jakolasku * valinta2;

		return kertolasku;
	}

}
