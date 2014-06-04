import ddf.minim.spi.*;
import ddf.minim.signals.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.ugens.*;
import ddf.minim.effects.*;

import org.dcdnt.DecadentOasisShow;
import org.dcdnt.model.Model;
import heronarts.lx.LX;

LX lx;
DecadentOasisShow show;
Model model;

void setup() {
  size(1400, 800, OPENGL);
  frameRate(90);
  
  model = new Model();
  lx = new LX(this, model);
  show = new DecadentOasisShow(lx);
  
  
}
