package com.decadentoasis;

import processing.core.*;

public class MainProcessingSketch extends PApplet {

  public void setup() {
    size(1024,768);
    background(0);
  }

  public void draw() {
    stroke(255);
    if (mousePressed) {
      line(mouseX,mouseY,pmouseX,pmouseY);
    }
  }
}