
public class Slider {
	// A slider "ping-pongs" a value (current) between the MIN and the MAX.
	private final float MAX;
	private final float MIN;
	private float current;
	private boolean down = true;
	private float step;
	private int curFrame = 0;
	
	Slider(float min, float max, float step) {
		this.MAX = max;
		this.MIN = min;
		this.step = step;
		this.current = Math.round((min + max) / 2);
	}
	
	public float getCurrent(int frame) {
		// Returns current and updates its position between MIN and MAX.
		if (curFrame != frame) {
			current += (down ? -step : step);
			if (current < this.MIN || current > this.MAX) 
				down = !down;
			this.curFrame = frame;
		}			
		return current;
	}
}
