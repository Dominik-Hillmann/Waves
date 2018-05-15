import processing.core.*;

public class Wave extends PApplet {
	private final int WIDTH = 700;
	private final int HEIGHT = 1000;
	
	private float vert = 0;
	
	private double spikedness = 100;
	private boolean down = true;
	
	private double windings = 0.01;
	private boolean wider = true;
	
	public void settings() {
		size(WIDTH, HEIGHT);
	}
	
	public void setup() {
		background(255, 255, 255);
		frameRate(30);
	}
	
	public void draw() {
		fill(0);
		background(255, 255, 255);
		
		vert += 0.05;
		
		spikedness += (down ? -1 : 1);
		if (spikedness < 10 || spikedness > 200) 
			down = !down;
		
		windings += (wider ? -0.001 : 0.001);
		if (windings < 0.01 || windings > 0.1) 
			wider = !wider;
				
		for (int x = 1; x <= WIDTH; x++) {
			float s = sin(x, windings, spikedness, HEIGHT / 2, vert);
			float sP = sin(x + 1, windings, spikedness, HEIGHT / 2, vert);
			
			line((float) x, s, (float) x + 1, sP);
		}
	}
	
	
	private float sin(int x, double windings, double spikedness, int horiz, float vert) {
		return (float) (spikedness * Math.sin(windings * x + vert) + horiz);
	}
	
	
	public static void main(String[] args) {
		PApplet.main("Wave");
	}
}
