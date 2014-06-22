package org.dcdnt.model;

import heronarts.lx.model.LXModel;
import heronarts.lx.model.LXPoint;
import heronarts.lx.transform.LXTransform;
import java.lang.Math;
import java.util.Arrays;

import processing.core.PVector;

public class LEDBar extends LXModel {

	/**
	 * Global x-position of center of LED Bar
	 */
	public final float x;

	/**
	 * Global y-position of center of LED Bar
	 */
	public final float y;

	/**
	 * Global z-position of center of LED Bar
	 */
	public final float z;

	/**
	 * x-position of LED bar, relative to center of tree top
	 */
	public final float tx;

	/**
	 * y-position of LED Bar, relative to center of tree top
	 */
	public final float ty = 0;

	/**
	 * z-position of LED Bar, relative to center of tree top
	 */
	public final float tz;

	/**
	 * Radial distance from LED Bar center to center of tree in x-z plane
	 */
	public final float r;

	/**
	 * Angle in degrees from LED Bar center to center of tree in x-z plane
	 */
	public final float theta;

	/**
	 * Create an LED Bar
	 * 
	 * @param transform
	 *            An LXTransform object representing the top of the tree
	 * @param r
	 *            The distance from LED bar center to center of tree in x-z
	 *            plane
	 * @param theta
	 *            The angle in degrees from LED Bar center to center of tree in
	 *            x-z plane
	 * @param pusherMac
	 *            The MAC address of the PixelPusher this LED bar is attached to
	 * @param stripNo
	 *            The number of the port on the PixelPusher the LED Bar is
	 *            attached to
	 * @param pixelNo
	 *            The index in the string of pixels this LED bar represents
	 * 
	 */

	LEDBar(LXTransform transform, float r, float theta, String pusherMac,
			int stripNo, int pixelNo) {

		super(Arrays.asList(new LXPoint[] { new LXPoint(transform.x()
				+ (r * (float) Math.cos(theta)), transform.y(), transform.z()
				+ (r * (float) Math.sin(theta))) }));

		this.x = this.points.get(0).x;
		this.y = this.points.get(0).y;
		this.z = this.points.get(0).z;
		this.tx = this.x - transform.x();
		// this.ty = this.y - transform.y();
		this.tz = this.z - transform.z();
		this.r = r;
		this.theta = theta;

	}
}
