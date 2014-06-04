package org.dcdnt.patterns;

import heronarts.lx.LX;
import heronarts.lx.parameter.BasicParameter;
import heronarts.lx.pattern.LXPattern;

public class SolidColor extends LXPattern {
	// 235 = blue, 135 = green, 0 = red
	final BasicParameter hue = new BasicParameter("HUE", 135, 0, 360);

	public SolidColor(LX lx) {
		super(lx);
		addParameter(hue);
	}

	public void run(double deltaMs) {
		setColors(LX.hsb(hue.getValuef(), 100, 100));
	}
}