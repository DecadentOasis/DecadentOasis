package org.dcdnt;

import heronarts.lx.LX;
import heronarts.lx.parameter.BasicParameter;
import heronarts.lx.pattern.LXPattern;
import heronarts.lx.transition.DissolveTransition;
import heronarts.lx.transition.LXTransition;

import org.dcdnt.patterns.SolidColor;

public class DecadentOasisShow {

	private LX lx;

	public DecadentOasisShow(LX lx) {
		this.lx = lx;
	}

	final BasicParameter dissolveTime = new BasicParameter("DSLV", 400, 50,
			1000);

	LXPattern[] patterns(LX lx) {
		LXPattern[] patterns = new LXPattern[] { new SolidColor(lx), };
		LXTransition t = new DissolveTransition(lx).setDuration(dissolveTime);
		for (LXPattern p : patterns) {
			p.setTransition(t);
		}
		return patterns;
	}
}