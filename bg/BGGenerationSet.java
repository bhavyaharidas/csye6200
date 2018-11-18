package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Timer;

//Holds a group of BGGeneration instances
public class BGGenerationSet {

	ArrayList<String> plantNames;
	ArrayList<BGGeneration> plants;

	public BGGenerationSet(ArrayList<String> plantNames) {
		this.plantNames = plantNames;
	}

	// Initializes a BGGeneration for each plant name in the plantNames list
	// Creates separate thread for each plant and starts growing them.
	public void createPlants() {
		plants = new ArrayList<BGGeneration>();
		int i = 100; // iterator for starting coordinate
		for (String name : plantNames) {
			BGGeneration plant = new BGGeneration(name); // Initializing a BGGeneration
			BGStem stem = new BGStem(new int[] { i, 0 }, 5, 90); // initializing base stem of the BGGeneration
			plant.setFirstGen(stem); // setting base stem
			plant.addToStemFamily(stem);
			plants.add(plant);
			plant.start(); // Starts thread that further grows the plant
			i += 100;
		}
	}

	// Sets the boolean of each BGGeneration that drives the thread to false
	public void setDone(boolean done) {
		for (BGGeneration plant : plants) {
			plant.setDone(true);
		}
	}
}
