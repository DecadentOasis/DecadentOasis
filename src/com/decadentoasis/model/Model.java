package com.decadentoasis.model;

import java.util.ArrayList;
import java.util.List;

import heronarts.lx.model.LXAbstractFixture;
import heronarts.lx.model.LXModel;

public class Model extends LXModel {

	Model() {
		super(new Fixture());
		Fixture f = (Fixture) this.fixtures.get(0);
	}

	private static class Fixture extends LXAbstractFixture {

		private Fixture() {

		}
	}

}
