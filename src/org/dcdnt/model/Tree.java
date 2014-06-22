package org.dcdnt.model;

import java.util.ArrayList;
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

	/**
	 * List of LEDBars on the tree
	 */
	public final List<LEDBar> ledBars;

	Tree(TreeType type, float x, float y, float z, String pusherMac, int stripNo) {
		super(new Fixture(type, x, y, z, pusherMac, stripNo));
		Fixture f = (Fixture) this.fixtures.get(0);
		this.x = x;
		this.y = y;
		this.z = z;
		this.ledBars = Collections.unmodifiableList(f.ledBars);
	}

	private static class Fixture extends LXAbstractFixture {
		final List<LEDBar> ledBars;

		Fixture(TreeType type, float x, float y, float z, String pusherMac,
				int stripNo) {
			LXTransform transform = new LXTransform();
			transform.translate(x, y, z);
			this.ledBars = new ArrayList<LEDBar>();
			int pixelNo = 0;
			float spaceBetweenLeds;
			int armLength;
			switch (type) {
			case SIX_ARM:
				armLength = 100;
				spaceBetweenLeds = armLength / 4;
				for (int armNumber = 0; armNumber < 6; armNumber++) {
					this.ledBars.add(new LEDBar(transform,
							spaceBetweenLeds * 1, 360 / armNumber, pusherMac,
							stripNo, pixelNo++));
					this.ledBars.add(new LEDBar(transform,
							spaceBetweenLeds * 3, 360 / armNumber, pusherMac,
							stripNo, pixelNo++));
					this.ledBars.add(new LEDBar(transform,
							spaceBetweenLeds * 2, 360 / armNumber, pusherMac,
							stripNo, pixelNo++));
					this.ledBars.add(new LEDBar(transform,
							spaceBetweenLeds * 0, 360 / armNumber, pusherMac,
							stripNo, pixelNo++));
				}

				break;
			case EIGHT_ARM:
				armLength = 100;
				spaceBetweenLeds = armLength / 3;
				for (int armNumber = 0; armNumber < 8; armNumber++) {
					this.ledBars.add(new LEDBar(transform,
							spaceBetweenLeds * 0, 360 / armNumber, pusherMac,
							stripNo, pixelNo++));
					this.ledBars.add(new LEDBar(transform,
							spaceBetweenLeds * 2, 360 / armNumber, pusherMac,
							stripNo, pixelNo++));
					this.ledBars.add(new LEDBar(transform,
							spaceBetweenLeds * 1, 360 / armNumber, pusherMac,
							stripNo, pixelNo++));
				}
				break;
			case TWELVE_ARM:
				armLength = 100;
				spaceBetweenLeds = armLength / 2;
				for (int armNumber = 0; armNumber < 12; armNumber++) {
					this.ledBars.add(new LEDBar(transform,
							spaceBetweenLeds * 0, 360 / armNumber, pusherMac,
							stripNo, pixelNo++));
					this.ledBars.add(new LEDBar(transform,
							spaceBetweenLeds * 1, 360 / armNumber, pusherMac,
							stripNo, pixelNo++));
				}
				break;
			default:
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
