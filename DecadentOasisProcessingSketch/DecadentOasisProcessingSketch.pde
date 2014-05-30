import heronarts.lx.LX;

void setup() {
  size(1400, 800, OPENGL);
  frameRate(90);
  lx = new LX(this, model);
}
