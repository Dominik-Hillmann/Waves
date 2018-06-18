const NUM_WAVES = 3;
const PERC_WIDTH = 0.38;
// const SPEED_WINDOW = { upper: .01, lower: .01, step: .0001 };
// const WIND_WINDOW = { upper: .00001, lower: .01, step: .0001 };
// const SPEED_WINDOW = { upper: .01, lower: .01, step: .0001 };

class Color {
   constructor(r, g, b) {
      this.r = r;
      this.g = g;
      this.b = b;
   }
}

class Slider {
   // A slider ping-pongs a value between its min and its max.
   constructor(min, max, step) {
      this.min = min;
      this.max = max;
      this.mean = Math.round((min + max) / 2);

      this.step = step;
      this.current = this.randBetween(min, max); // RANDOM STARTER EINBAUEN

      this.down = true;
      this.curFrame = 0;
   }

   curr(frame) {
      // returns current value and updates its position between min and max
      if (this.curFrame != frame) {
         this.current += this.down ? -this.step : this.step;
         this.down = (this.current < this.min || this.current > this.max) ? !this.down : this.down;
         this.curFrame = frame;
      }
      return this.current;
   }

   randBetween(min, max) {
      return Math.random() * (max - min) + min;
   }
} // Slider


class Wave {
   constructor(speed, meanHeight, wind, spike) {
      // later replacement of magic numbers
      this.speed = new Slider(speed - 0.01, speed + 0.01, 0.0001);
      this.vert = 0;

      this.meanHeight = meanHeight;

      this.wind = new Slider(wind - 0.01, wind, 0.00001);
      this.spike = new Slider(spike - 20, spike + 20, 0.1);
   }

   drawWave(frameCnt, thickness) {
      this.vert += this.speed.curr(frameCnt);

      for (let x = 1; x <= width; x++) {
         let y = this.spike.curr(frameCnt) * Math.sin(this.wind.curr(frameCnt) * x + this.vert) + this.meanHeight;
         ellipse(x, y, thickness);
      }
   }
} // Wave


let cnv;
let waves = [];
let colors = [
   new Color(163, 201, 168),
   new Color(105, 162, 151),
   new Color(80, 128, 142)
]; // same # of colors as  NUM_WAVES

function setup() {
   frameRate(30);
   cnv = createCanvas(Math.round(PERC_WIDTH * displayWidth), displayHeight);
   cnv.parent("sketch");

   for (let i = 0; i < NUM_WAVES; i++) {
      waves.push(new Wave(.01, height / 2, .01, 40));
   }
}

function draw() {
   background(255, 255, 255, 10);

   for (let i = 0; i < NUM_WAVES; i++) {
      let col = colors[i];
      // fill(col.r, col.g, col.b);
      stroke(col.r, col.g, col.b);
      waves[i].drawWave(frameCount, 2);
   }
}

function resize() {
   resizeCanvas(Math.round(PERC_WIDTH * windowWidth), windowHeight);
   /**** WICHTIG: Sketch soll stoppen, sobald Fenster zu klein wird / neu starten, wenn wieder richtige
    Größe erreicht ist****/
}
