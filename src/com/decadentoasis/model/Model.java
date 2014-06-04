package com.decadentoasis.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import heronarts.lx.model.LXAbstractFixture;
import heronarts.lx.model.LXModel;

public class Model extends LXModel {

	public final List<Tree> trees;
	public final TreeHouse treeHouse;
	public final Waterfall waterfall;
	public final PalmTreeArtCar palmTreeArtCar;
	public final ChineseJunkArtCar chineseJunkArtCar;

	Model() {
		super(new Fixture());
		Fixture f = (Fixture) this.fixtures.get(0);
		this.trees = Collections.unmodifiableList(f.trees);
		this.waterfall = new Waterfall();
		this.palmTreeArtCar = new PalmTreeArtCar();
		this.chineseJunkArtCar = new ChineseJunkArtCar();
		this.treeHouse = new TreeHouse();
	}

	private static class Fixture extends LXAbstractFixture {

		final List<Tree> trees = new ArrayList<Tree>();

		private Fixture() {

		}
	}

}
