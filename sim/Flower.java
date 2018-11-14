package edu.neu.csye6200.sim;
import java.util.Arrays;

public class Flower {

	private static int idCount;
	
	private int id;
	private String color;
	private int petalCount;
	private int[] location;
	
	public Flower(String color, int petalCount, int[] location) {
		idCount++;
		this.id = idCount;
		this.color = color;
		this.petalCount = petalCount;
		this.location = location;
	}
	
	public Flower() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPetalCount() {
		return petalCount;
	}


	public void setPetalCount(int petalCount) {
		this.petalCount = petalCount;
	}

	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}

	public String toString() {
		return String.format("%10d %2$13c %3$15s %4$13c %5$15s%6$13c %7$5d", getId(), '|', Arrays.toString(getLocation()), '|',
				getColor(), '|', getPetalCount());
	}
	
}
