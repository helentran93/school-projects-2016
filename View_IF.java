package mvc;

public interface View_IF {

	public abstract void setYhteys(boolean yhteys);
	public abstract void setKartta(Seinä[] seinä);
	public abstract void setSeinä(Seinä[] seinä);
	public abstract void updateTextLabel(String msg);
	public abstract void updateNäyttö(float x, float y);

}
