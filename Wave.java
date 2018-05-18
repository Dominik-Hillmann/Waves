import processing.core.*;

public class Wave  {
	private final int HEIGHT;
	private final int WIDTH;
	
	private PApplet p;
	
	private float vert; // pushes the wave forward
	private float speed;
	
	//private Slider spikedness = new Slider(10f, 100f, 0.1f);//100;
	private float spikedness = 50f;
	
	private Slider windings = new Slider(0.0f, 0.008f, 0.00001f);//0.01;
	//private float windings = 0.055f;
	
	private /*Slider*/int meanHeight;
		
	
	Wave(PApplet p, int width, int height, float speed, int meanHeight) {
		this.p = p;
		this.HEIGHT = height;
		this.WIDTH = width;
		
		this.vert = (float) (Math.random() * 100f);
		this.speed = speed;
		
		this.spikedness = (float) (Math.random() * 20 + 40); // random val between 40 and 60
		
		this.meanHeight = meanHeight;	
	} // Wave
		
	// vert random starten 
	// height1 < height 0 random
	// vert step	
	// idea: run lines from (x, sin(x)) to (x, 0)
		
	private float sin(int x, double windings, double spikedness, int horiz, float vert) {
		return (float) (spikedness * Math.sin(windings * x + vert) + horiz);
	} // sin
	
	
	public void drawWave(int frameCnt) {
		vert += speed;//0.005f;
		
		for (int x = 1; x <= WIDTH; x++) {
			
			float y = sin(
				x, 
				windings.getCurrent(frameCnt), 
				spikedness/*.getCurrent(frameCount)*/, 
				meanHeight/*height.getCurrent()*/, 
				vert
			);
			
			float yPlus = sin(
				x + 1, 
				windings.getCurrent(frameCnt), 
				spikedness/*.getCurrent(frameCount)*/, 
				meanHeight, 
				vert
			);
			
			p.line(x, y, x + 1, yPlus);
			p.line(x, y, x, 0);
		} // for
	} // drawWave
	
} // Wave
