package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A source code implementing Assignment 2 (b) of CSYE 6200 Filename: Stem.java
 * NUID: 001470055
 * 
 * @author - Bhavya Haridas
 */

public class BGStem {

	private static int idCount;

	private int id;
	private int[] startLoc;
	private int length;
	private double direction;

	private ArrayList<BGStem> childStem;

	public BGStem(int[] startLoc, int length, double direction) {
		idCount++;
		this.id = idCount;
		this.startLoc = startLoc;
		this.length = length;
		this.direction = direction;
	}

	public BGStem() {

	}

	// Returns Stem Id
	public int getId() {
		return id;
	}

	// Returns start location of a stem
	public int[] getStartLoc() {
		return startLoc;
	}

	// Assigns start location of a stem
	public void setStartLoc(int[] startLoc) {
		this.startLoc = startLoc;
	}

	// Returns length of a stem
	public int getLength() {
		return length;
	}

	// Sets length of a stem
	public void setLength(int length) {
		this.length = length;
	}

	// Returns direction of a stem
	public double getDirection() {
		return direction;
	}

	// Sets direction of a stem
	public void setDirection(double direction) {
		this.direction = direction;
	}

	// Returns the list of child stems of a stem
	public List<BGStem> getChildStem() {
		return childStem;
	}

	// Adds a stem to the list of child stems of a stem
	public void addChildStem(BGStem childStem) {
		if (this.childStem == null) {
			this.childStem = new ArrayList<BGStem>();
		}
		this.childStem.add(childStem);
	}

	// Removes a stem from the list of child stems of a stem
	public void removeChild(BGStem childStem) {
		this.childStem.remove(childStem.id);
	}

	// Returns a boolean indicating if the stem is an end stem
	public Boolean hasChildren() {
		return this.childStem != null;
	}

	public String toString() {
		return String.format("%10d %2$13c %3$15s %4$13c %5$15.2f %6$13c %7$5d", id, '|', Arrays.toString(startLoc), '|',
				direction, '|', length);
	}

}
