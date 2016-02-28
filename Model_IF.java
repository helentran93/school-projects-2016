package mvc;

import lejos.robotics.mapping.LineMap;

public interface Model_IF {

	public abstract boolean luoYhteysRoboon();
	public abstract void luoSeinä(float x, float y, float x2, float y2);
	public abstract Seinä[] getSeinä();
	public abstract Seinä[] poistaSeinä(Seinä[] seinä);
	public abstract LineMap luoKarttaRobolle(Seinä[] seinä);


}
