package edu.neu.csye6200.sim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.neu.csye6200.serial.CarData;

/**
 * A source code implementing Assignment 2 (b) of CSYE 6200 Filename: Plant.java
 * NUID: 001470055
 * 
 * @author - Bhavya Haridas
 */

public class Plant implements Serializable, Comparable<Plant> {

	private static int RINGS_RATE = 2;
	private static double GROWTH_RATE = 20.2;
	private static double GROWTH_CONSTANT = 32.6;

	private static int count;

	private String typeName;
	private int specimenId;
	private int annualRings;
	private double length;
	protected Stem baseStem;
	private double width;

	protected ArrayList<Stem> childStems;
	private ArrayList<Stem> stemFamily;

	public Plant(String typeName, Boolean baseStem) {
		count++;
		this.typeName = typeName;
		this.specimenId = count;
		this.annualRings = 0;
		this.stemFamily = new ArrayList<Stem>();
		if (baseStem) {
			this.baseStem = new Stem(new int[] { 0, 0 }, 0, 0);
			this.childStems = null;
		} else {
			this.childStems = new ArrayList<Stem>();
			this.baseStem = null;
		}
	}

	public Plant() {

	}

	public ArrayList<Stem> getStemFamily() {
		return stemFamily;
	}

	public void setStemFamily(ArrayList<Stem> stemFamily) {
		this.stemFamily = stemFamily;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public ArrayList<Stem> getChildStem() {
		return childStems;
	}

	public void setChildStem(ArrayList<Stem> childStem) {
		this.childStems = childStem;
	}

	public Stem getBaseStem() {
		return baseStem;
	}

	public void setBaseStem(Stem baseStem) {
		this.baseStem = baseStem;
	}

	public int getSpecimenId() {
		return this.specimenId;
	}

	public void setSpecimenId(int specimenId) {
		this.specimenId = specimenId;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void addToStemFamily(Stem stem) {
		this.stemFamily.add(stem);
	}

	public void growPlant() {
		if ((this.hasBaseStem() && this.baseStem.getLength() == 0)
				|| (!this.hasBaseStem() && this.childStems.size() == 0)) {
			this.initialGrowth();
		} else {
			if (this.hasBaseStem())
				this.growStem(baseStem);
			else {
				for (Stem child : this.childStems) {
					this.growStem(child);
				}
			}
		}
	}

	private String printHeader() {
		return String.format("%0" + 105 + "d", 0).replace("0", "*")
				+ "\n" + String.format("%10s %2$13c %3$15s %4$13c %5$15s %6$13c %7$5s", "Stem Id", '|',
						"Start Location", '|', "Direction", '|', "Length")
				+ "\n" + String.format("%0" + 105 + "d", 0).replace("0", "*");
	}

	public Boolean hasBaseStem() {
		return !(this.baseStem == null);
	}

	public int getTotalChildCount() {
		/*
		 * int count = 0; if (this.hasBaseStem()) { count +=
		 * this.baseStem.getChildCount(); } else { for (Stem child : this.childStems) {
		 * count += child.getChildCount(); } }
		 */
		return this.stemFamily.size();
	}

	public void printPlant() {
		System.out.println(this.toString());
		System.out.println(this.printHeader());
		for (Stem stem : this.stemFamily) {
			System.out.println(stem.toString());
		}
	}

	public String toString() {
		String p = "\n\nName - " + typeName + "\nSpecimen Id = " + specimenId + "\nLength - " + length + "\nWidth - "
				+ width + "\n Total Stem count - " + getTotalChildCount();

		return p;
	}

	public void calculateDimensions() {
		ArrayList<Integer> xcoords = new ArrayList<Integer>(); // to store all open x end points
		ArrayList<Integer> ycoords = new ArrayList<Integer>(); // to store all open y end points
		for (Stem stem : this.stemFamily) {
			if (!stem.hasChildren()) {
				xcoords.add(stem.getStartLoc()[0] + (int) (stem.getLength() * Math.cos(stem.getDirection())));
				ycoords.add(stem.getStartLoc()[1] + (int) (stem.getLength() * Math.sin(stem.getDirection())));
			}
		}
		this.width = Collections.max(xcoords) - Collections.min(xcoords);
		this.length = Collections.max(ycoords);
	}

	protected void initialGrowth() {
		if (this.hasBaseStem()) {
			this.baseStem.setDirection(1.57);
			this.baseStem.setLength(2);
			this.stemFamily.add(this.baseStem);
		} else {
			double dir = 0;
			int[] startLoc = new int[] { 0, 0 };
			int length = 2;
			for (int i = 0; i < 3; i++) {
				double direction = (dir + 30) % 180;
				Stem stem = new Stem(startLoc, length, direction);
				this.childStems.add(stem);
				this.stemFamily.add(stem);
				dir = direction;
			}
		}
	}

	private void growStem(Stem child) {
		if (child.hasChildren()) {
			for (Stem stem : child.getChildStem()) {
				growStem(stem);
			}
		} else {
			double dir = 0;
			int x = child.getStartLoc()[0] + (int) (child.getLength() * Math.cos(child.getDirection()));
			int y = child.getStartLoc()[1] + (int) (child.getLength() * Math.sin(child.getDirection()));
			int[] newStartLoc = new int[] { x, y };
			int newLength = child.getLength();
			for (int i = 0; i < 3; i++) {
				double newDirection = (dir + 30) % 180;
				Stem newStem = new Stem(newStartLoc, newLength, newDirection);
				child.addChildStem(newStem);
				this.stemFamily.add(newStem);
				dir = newDirection;
			}
		}

	}

	@Override
	public int compareTo(Plant plant) {
		Integer val = specimenId;
		Integer baseVal = plant.getSpecimenId();
		return val.compareTo(baseVal);
	}
}
