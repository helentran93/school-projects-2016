package mvc;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Näyttö extends Canvas{

	private GraphicsContext gc;

	public Näyttö(float w, float h) {
		super(w, h);
		gc = this.getGraphicsContext2D();
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		gc.strokeRect(0, 0, 400, 320);

	}

	public void piirräSeinä(float x, float y, float x2, float y2){
		gc.setStroke(Color.RED);
		gc.setLineWidth(5);
		gc.strokeLine(x, y, x2, y2);
	}

	public void pyyhiTaulu(){
		gc.clearRect(2, 2, 397, 317);
	}

	public void piirräPaikannus(float x, float y) {
		gc.setFill(Color.RED);
		gc.fillOval(10, 10, 10, 10);
	}

}
