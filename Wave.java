import processing.core.*;

public class Wave extends PApplet {
	private final int WIDTH = 700;
	private final int HEIGHT = 1000;
	
	private double spikedness = 500;
	
	public void settings() {
		size(WIDTH, HEIGHT);
	}
	
	public void setup() {
		background(255, 255, 255);
	}
	
	public void draw() {
		fill(0);
		
		// if (spikedness <= 500) hin und her
				
		for (int x = 1; x <= WIDTH; x++) {
			line(				
				(float) x,
				sin(x, 0.05, 500, 300),
				(float) x + 1,
				sin(x + 1, 0.05, 500, 300)				
			);
		}
	}
	
	
	private float sin(int x, double wideness, double spikedness, int addPx) {
		return (float) (spikedness * Math.sin(wideness * x) + addPx);
	}
	
	
	public static void main(String[] args) {
		PApplet.main("Wave");
	}
}
