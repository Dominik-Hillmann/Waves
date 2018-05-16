import processing.core.*;

public class Wave extends PApplet {
	private float vert = 0; // pushes the wave forward	
	//private Slider spikedness = new Slider(10f, 100f, 0.1f);//100;
	private float spikedness = 50f;
	
	private Slider windings = new Slider(0.0f, 0.01f, 0.00001f);//0.01;
	//private float windings = 0.055f;
	
	
	// vert random starten
	// height1 < height 0 random
	// vert step
	
	Wave() {
		
	}
	
	private float sin(int x, double windings, double spikedness, int horiz, float vert) {
		return (float) (spikedness * Math.sin(windings * x + vert) + horiz);
	}
	
	public void drawWave() {
		vert += 0.005f;
		
		for (int x = 1; x <= WIDTH; x++) {
			
			float y = sin(
				x, 
				windings.getCurrent(frameCount), 
				spikedness/*.getCurrent(frameCount)*/, 
				HEIGHT / 2, 
				vert
			);
			
			float yPlus = sin(
				x + 1, 
				windings.getCurrent(frameCount), 
				spikedness/*.getCurrent(frameCount)*/, 
				HEIGHT / 2, 
				vert
			);
			
			line(x, y, x + 1, yPlus);
		}
	}
	
	

	
	/***** Main Functions for sketch *****/
	private final int WIDTH = 700;
	private final int HEIGHT = 1000;
	public Wave[] waves;
	
	public static void main(String[] args) {
		PApplet.main("Wave");
	}	
	
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
		
		drawWave();
	}
}
