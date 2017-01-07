package observer;

import java.util.GregorianCalendar;
import java.util.Observable;

public class ClockTimer extends Observable implements Runnable{
	private int hour, minute, second;
	GregorianCalendar calendar;

	public int getHour() {
		calendar = new GregorianCalendar();
		// TODO Auto-generated method stub
		hour = calendar.get(GregorianCalendar.HOUR_OF_DAY);
		return hour;
	}

	public int getMinute() {
		calendar = new GregorianCalendar();
		// TODO Auto-generated method stub
		minute = calendar.get(GregorianCalendar.MINUTE);
		return minute;
	}

	public int getSecond() {
		calendar = new GregorianCalendar();
		// TODO Auto-generated method stub
		second = calendar.get(GregorianCalendar.SECOND);
		return second;
	}

	public void attach(DigitalClock digitalClock) {
		// TODO Auto-generated method stub
		addObserver(digitalClock);
	}

	void tick() {
		setChanged();
		notifyObservers();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			tick();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
