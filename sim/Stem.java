package edu.neu.csye6200.sim;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A source code implementing Assignment 2 (b) of CSYE 6200 Filename: Stem.java
 * NUID: 001470055
 * 
 * @author - Bhavya Haridas
 */

public class Stem {

	private static int idCount;

	private int id;
	private int[] startLoc;
	private int length;
	private double direction;

	private ArrayList<Stem> childStem; 

	public Stem(int[] startLoc, int length, double direction) {
		idCount++;
		this.id = idCount;
		this.startLoc = startLoc;
		this.length = length;
		this.direction = Math.toRadians(direction);
	}
	
	public Stem() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getStartLoc() {
		return startLoc;
	}

	public void setStartLoc(int[] startLoc) {
		this.startLoc = startLoc;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public List<Stem> getChildStem() {
		return childStem;
	}

	public void addChildStem(Stem childStem) {
		if(this.childStem == null) {
			this.childStem = new ArrayList<Stem>();
		}
		this.childStem.add(childStem);
	}

	public void removeChild(Stem childStem) {
		this.childStem.remove(childStem.id);
	}

	public int getChildCount() {
		int count = 1;
		if (!this.hasChildren()) {
			return 1;
		} else {
			for (Stem child : this.childStem) {
				count += child.getChildCount();
			}
		}
		return count;
	}

	public Boolean hasChildren() {
		return this.childStem != null;
	}

	public void printChildren() {
		if (this.hasChildren()) {
			for (Stem child : this.childStem) {
				System.out.println(child.toString());
				child.printChildren();
			}
		}
	}

	public String toString() {
		return String.format("%10d %2$13c %3$15s %4$13c %5$15.2f %6$13c %7$5d", id, '|', Arrays.toString(startLoc), '|',
				direction, '|', length);
	}

}
