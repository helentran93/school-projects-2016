package mvc;


public interface Controller_IF {

	public abstract void yhteysStart();
	public abstract void kartanTuonti();
	public abstract void seinänLuonti(float x, float y, float x2, float y2);
	public abstract void seinänTuho();
	public abstract void updateLabels(float x, float y);

}
