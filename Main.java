package observer;

public class Main {

	public static void main(String[] args) {
		ClockTimer timer = new ClockTimer();
		DigitalClock digitalClock = new DigitalClock(timer);
		timer.addObserver(digitalClock);

		//kutsutaan s�ie
		new Thread(timer).start();
	}

}
