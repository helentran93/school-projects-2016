package mvc;

public interface View_IF {

	public abstract void setYhteys(boolean yhteys);
	public abstract void setKartta(Sein�[] sein�);
	public abstract void setSein�(Sein�[] sein�);
	public abstract void updateTextLabel(String msg);
	public abstract void updateN�ytt�(float x, float y);

}
