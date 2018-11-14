package edu.neu.csye6200.sim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class PlantRoster {

	private static PlantRoster instance = null;

	private static Logger log = Logger.getLogger(PlantRoster.class.getName());

	private ArrayList<Plant> plants = new ArrayList<Plant>();

	private PlantRoster() {
		log.info("Constructing a PlantRoster instance");
	}

	public static PlantRoster instance() {
		if (instance == null)
			instance = new PlantRoster(); // Build if needed
		return instance;
	}

	public void createPlants() {
		// Plant instances created by passing name and boolean indicating if it has a
		// base stem.

		Plant p1 = new Plant("Fir", true);
		/*Plant p2 = new Plant("Redwood", true);
		FlowerPlant fp1 = new FlowerPlant("Cherry", true, "pink", 5);
		Plant p3 = new Plant("Sequoia", false);
		Plant p4 = new Plant("Cedar", true);
		FlowerPlant fp2 = new FlowerPlant("Redbud", true, "pink", 5);
		Plant p5 = new Plant("Juniper", true);*/

		/*plants.add(fp1);
		plants.add(p4);
		plants.add(p5);*/
		plants.add(p1);
		/*plants.add(p3);
		plants.add(p2);
		plants.add(fp2);*/
		/*log.info("Created plant instances - " + fp1.getTypeName() + ", " + p4.getTypeName() + ", " + p5.getTypeName()+ ", "
				+ p1.getTypeName() + ", " + p3.getTypeName() + ", " + p2.getTypeName() + ", " + fp2.getTypeName());*/
	}

	public void sortAndDisplayPlants() {
		System.out.println("Before Sorting\n");
		for (Plant plant : plants) {
			plant.printPlant();
		}
		log.info("Sorting plants based on specimen Id");
		System.out.println("\nAfter Sorting\n");
		Collections.sort(plants);
		for (Plant plant : plants) {
			plant.printPlant();
		}
	}


	public ArrayList<Plant> getPlants() {
		log.info("Retrieving Plants Map");
		return plants;
	}

}
