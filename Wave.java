import processing.core.*;

public class Wave extends PApplet {
	private final int WIDTH = 700;
	private final int HEIGHT = 1000;
	
	public void settings() {
		size(WIDTH, HEIGHT);
	}
	
	public void setup() {
		background(255, 255, 255);
	}
	
	public void draw() {
		fill(0);
		ellipse((float) (WIDTH / 2), (float) (HEIGHT / 2), 200f, 200f);
	}
	
	
	public static void main(String[] args) {
		PApplet.main("Wave");
	}
}
