package valuuttakone;

public class Valuutta {

	String tunnus, nimi;
	float vaihtokurssi;

	public Valuutta(String tunnus, float vaihtokurssi, String nimi){
		this.tunnus = tunnus;
		this.vaihtokurssi = vaihtokurssi;
		this.nimi = nimi;
	}

	public void setTunnus(String tunnus){
		this.tunnus = tunnus;
	}

	public void setVaihtokurssi(float vaihtokurssi){
		this.vaihtokurssi = vaihtokurssi;
	}

	public void setNimi(String nimi){
		this.nimi = nimi;
	}

	public String getTunnus(){
		return this.tunnus;
	}

	public float getVaihtokurssi(){
		return this.vaihtokurssi;
	}

	public String getNimi(){
		return this.nimi;
	}
}
