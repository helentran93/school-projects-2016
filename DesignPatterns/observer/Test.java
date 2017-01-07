package observer;

public class Test {
  
  	public static void main(String[] args) {
 		ClockTimer timer = new ClockTimer();
 		DigitalClock digitalClock = new DigitalClock(timer);
 		timer.addObserver(digitalClock);
  
 		//kutsutaan säie
		new Thread(timer).start();