package mvc;

public class Seinä {

	float x, y, x2, y2;

	public Seinä(float x, float y, float x2, float y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void setX(float x){
		this.x = x;
	}

	public void setY(float y){
		this.y = y;
	}

	public void setX2(float x2){
		this.x2 = x2;
	}

	public void setY2(float y2){
		this.y2 = y2;
	}

	public float getX(){
		return this.x;
	}

	public float getY(){
		return this.y;
	}

	public float getX2(){
		return this.x2;
	}

	public float getY2(){
		return this.y2;
	}


}
