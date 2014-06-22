package org.dcdnt.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import heronarts.lx.model.LXAbstractFixture;
import heronarts.lx.model.LXModel;
import heronarts.lx.model.LXPoint;
import heronarts.lx.transform.LXTransform;

public class Tree extends LXModel {

	public enum TreeType {
		SIX_ARM, EIGHT_ARM, TWELVE_ARM
	}

	/**
	 * Global x-position of center of top of Tree
	 */
	public final float x;

	/**
	 * Global y-position of center of top of Tree
	 */
	public final float y;

	/**
	 * Global z-position of center of top of Tree
	 */
	public final float z;

	public final List<LEDBar> ledBars;

	Tree(TreeType type, float x, float y, float z) {
		super(new Fixture(type, x, y, z));
		Fixture f = (Fixture) this.fixtures.get(0);
		this.x = x;
		this.y = y;
		this.z = z;
		this.ledBars = Collections.unmodifiableList(f.ledBars);
	}

	private static class Fixture extends LXAbstractFixture {
		final List<LEDBar> ledBars;

		Fixture(TreeType type, float x, float y, float z) {
			switch (type) {
			case SIX_ARM:
				this.ledBars = Arrays.asList(new LEDBar[] {});
				break;
			case EIGHT_ARM:
				this.ledBars = Arrays.asList(new LEDBar[] {});
				break;
			case TWELVE_ARM:
				this.ledBars = Arrays.asList(new LEDBar[] {});
				break;
			default:
				this.ledBars = Arrays.asList(new LEDBar[] {});
				break;
			}

			for (LEDBar bar : this.ledBars) {
				for (LXPoint p : bar.points) {
					this.points.add(p);
				}
			}
		}
	}
}
