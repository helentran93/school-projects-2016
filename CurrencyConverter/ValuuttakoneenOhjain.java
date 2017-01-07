package valuuttakone;

public class ValuuttakoneenOhjain implements ValuuttakoneenOhjain_IF {

	Valuuttakone_IF malli;
	ValuuttakoneenGUI n�kym�;

	public ValuuttakoneenOhjain(ValuuttakoneenGUI n�kym�, Valuuttakone_IF malli){
		this.n�kym� = n�kym�;
		this.malli = malli;
	}

	@Override
	public void muunnos() {
		n�kym�.setTulos(malli.muunna(n�kym�.getL�ht�Indeksi(), n�kym�.getKohdeIndeksi(), n�kym�.getM��r�()));
	}

	@Override
	public String[] getValuutat() {
		String[] taulukko = malli.getVaihtoehdot();
		return taulukko;
	}

}
