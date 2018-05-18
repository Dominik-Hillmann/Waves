import processing.core.*;


public class main extends PApplet {
	private final int WIDTH = 700;
	private final int HEIGHT = 1000;
	Wave wave = new Wave(this, WIDTH, HEIGHT, 0.005f, HEIGHT / 2);
	
	Wave[] waves;

	public static void main(String[] args) {
		PApplet.main("main");
	}	
	
	public void settings() {
		size(WIDTH, HEIGHT);
	}
	
	public void setup() {
		background(255, 255, 255);
		frameRate(30);
		
		waves = new Wave[2];
		waves[0] = new Wave(this, WIDTH, HEIGHT, 0.005f, HEIGHT / 2);
		waves[1] = new Wave(this, WIDTH, HEIGHT, 0.005f, HEIGHT / 2);
	}
	
	public void draw() {
		fill(0);
		background(255, 255, 255);
				
		for (Wave wave : waves) {
			wave.drawWave(frameCount);
		}
	}

}
