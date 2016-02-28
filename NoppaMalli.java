package application;

import java.util.Random;

public class NoppaMalli implements NoppaMalli_IF{

	Random r = new Random();

	public int randomSilmäluku(){
		return r.nextInt((6 - 1) + 1) + 1;
	}
}
