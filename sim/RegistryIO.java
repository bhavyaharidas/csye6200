package edu.neu.csye6200.sim;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class RegistryIO {

	private static Logger log = Logger.getLogger(RegistryIO.class.getName());

	private ArrayList<Plant> savedPlants = new ArrayList<Plant>();
	
	public RegistryIO() {
		log.info("Constructing a RegistryIO instance");
	}


	public ArrayList<Plant> getSavedPlants() {
		return savedPlants;
	}

	public void setSavedPlants(ArrayList<Plant> savedPlants) {
		this.savedPlants = savedPlants;
	}

	public void load(String fileName) throws IOException {
		log.info("Loading all class instances saved as txt files in - " + fileName);
		File directory = new File(fileName);
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (files != null) {
				for (File file : files) {
					log.info("Loading " + file.getName());
					XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
					Plant p = (Plant) decoder.readObject();
					log.info("Loaded " + p.getTypeName());
					savedPlants.add(p);
				}
			}
		} else
			throw new FileNotFoundException();
	}

	public void save(ArrayList<Plant> plants, String fileName) throws IOException {

		log.info("Saving plant instances to " + fileName + " in separate txt files.");
		for (Plant plant : plants) {
			XMLEncoder encoder = new XMLEncoder(
					new BufferedOutputStream(new FileOutputStream(fileName + plant.getTypeName() + ".txt")));
			encoder.writeObject(plant);
			encoder.close();
			log.info("Saved object " + plant.getTypeName() + " as " + plant.getTypeName() + ".txt");
		}
	}

}
