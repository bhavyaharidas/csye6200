package edu.neu.csye6200.bg;

import java.util.HashMap;

public class BGRule {

	private HashMap<Double, Double[]> angleLookUp; // To store angle rules

	// returns the list of rules that decides the next set of angles
	public HashMap<Double, Double[]> getAngleLookUp() {
		return angleLookUp;
	}

	public BGRule() {
		angleLookUp = new HashMap<Double, Double[]>();
		angleLookUp.put(0.0, new Double[] { 45.0 });
		angleLookUp.put(45.0, new Double[] { 0.0, 45.0, 90.0 });
		angleLookUp.put(90.0, new Double[] { 45.0, 90.0, 135.0 });
		angleLookUp.put(135.0, new Double[] { 90.0, 135.0, 180.0 });
		angleLookUp.put(180.0, new Double[] { 135.0 });
	}

	// Returns the length of stem in a subsequent generation based on current plant
	// dimension
	public int lengthLookup(double totalLength, double totalWidth) {
		int length = 0;
		if (totalLength <= 15 || totalWidth <= 30) // Length greater than 15 or width less than 30
			length = 5;
		else if ((totalLength > 15 && totalLength <= 17) || (totalWidth > 30 && totalWidth <= 40)) // Length: 15-17 or
																									// Width: 30-40
			length = 3;
		else if ((totalLength > 17 && totalLength <= 30) || (totalWidth > 40 && totalWidth <= 60)) // Length: 17-30 or
																									// Width: 40-60
			length = 1;
		else if (totalLength > 50 || totalWidth > 60) // Length greater than 50 or Width greater than 60. Stop plant
														// growth
			length = 0;
		return length;
	}
}
