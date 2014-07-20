package org.dcdnt.model;

import heronarts.lx.model.LXModel;

import java.util.List;

public class TreeArm extends LXModel {

	final int armNumber;
	final List<LEDBar> ledBars;
	final float theta;

	TreeArm(int armNumber, List<LEDBar> ledBars, float theta) {
		this.armNumber = armNumber;
		this.ledBars = ledBars;
		this.theta = theta;
	}

}
