package mvc;

import lejos.robotics.mapping.LineMap;

public interface Model_IF {

	public abstract boolean luoYhteysRoboon();
	public abstract void luoSein�(float x, float y, float x2, float y2);
	public abstract Sein�[] getSein�();
	public abstract Sein�[] poistaSein�(Sein�[] sein�);
	public abstract LineMap luoKarttaRobolle(Sein�[] sein�);


}
