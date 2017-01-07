package valuuttakone;

public class ValuuttakoneenOhjain implements ValuuttakoneenOhjain_IF {

	Valuuttakone_IF malli;
	ValuuttakoneenGUI näkymä;

	public ValuuttakoneenOhjain(ValuuttakoneenGUI näkymä, Valuuttakone_IF malli){
		this.näkymä = näkymä;
		this.malli = malli;
	}

	@Override
	public void muunnos() {
		näkymä.setTulos(malli.muunna(näkymä.getLähtöIndeksi(), näkymä.getKohdeIndeksi(), näkymä.getMäärä()));
	}

	@Override
	public String[] getValuutat() {
		String[] taulukko = malli.getVaihtoehdot();
		return taulukko;
	}

}
