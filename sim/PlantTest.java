package edu.neu.csye6200.sim;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A source code implementing Assignment 2 (b) of CSYE 6200 Filename:
 * PlantTest.java NUID: 001470055
 * 
 * @author - Bhavya Haridas
 */

public class PlantTest {

	private static Logger log = Logger.getLogger(PlantTest.class.getName());
	java.util.logging.FileHandler handler = null;

	public PlantTest() {
		try {
			handler = new FileHandler(
					"C:\\Coursework\\CSYE6200\\projects\\learning\\csye6200\\src\\edu\\neu\\csye6200\\sim\\Logs\\server.log", true);
			handler.setFormatter(new SimpleFormatter());
			handler.setLevel(Level.ALL);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		log.getParent().removeHandler(log.getParent().getHandlers()[0]);
		log.setUseParentHandlers(false); 
		log.setLevel(Level.ALL);
		log.addHandler(handler);
		Logger.getLogger("").addHandler(handler);
	}

	private void run() throws IOException {

		// private HashMap<Integer, Plant> plantMap = new HashMap<Integer, Plant>();

		RegistryIO registry = new RegistryIO();
		String basePath = "C:\\Coursework\\CSYE6200\\projects\\learning\\csye6200\\src\\edu\\neu\\csye6200\\sim\\Registry\\";

		PlantRoster roster = PlantRoster.instance();
		roster.createPlants();

		System.out.println("MENU\n\nPress 1 - Grow and print plant\n" 
				+ "Press 2 - Save Plant\n"
				+ "Press 3 - Load previously saved plants\n" + "Press 4 - Sort and display plants\n" + "Press 5 - Exit Program");

		char input = ' ';

		// Looping to handle user input

		do {
			input = (char) System.in.read();
			switch (input) {
			case '1':
				for (Plant p : roster.getPlants()) {
					p.growPlant();
					p.calculateDimensions();
					p.printPlant();      							
				}
				break;
		
			case '2':
				try {
					log.info("Invoking method to save plant instances");
					registry.save(roster.getPlants(), basePath);
					System.out.println("Saved plant instances to directory..");
				} catch (FileNotFoundException e) { // File can't be found
					System.out.println("Exception occurred while saving plant details.");
					e.printStackTrace();
					log.severe("Exception - " + e.toString());
				} catch (IOException e) { // All other IO problems
					System.out.println("Exception occurred while saving plant details.");
					e.printStackTrace();
					log.severe("Exception - " + e.toString());
				} finally {
					input = (char) System.in.read();
				}
				break;
			case '3':
				try {
					log.info("Invoking method to load plant instances from disk");
					System.out.println("Loading plant data from directory.. \n\n");
					registry.load(basePath);
					System.out.println("Printing saved plant data.. \n\n");
					for (Plant p : registry.getSavedPlants()) {
						p.printPlant();											
					}
				} catch (FileNotFoundException e) {
					System.out.println("Exception occurred while loading saved plant details.");
					e.printStackTrace();
					log.severe("Exception - " + e.toString());
				} finally {
					input = (char) System.in.read();
				}
				break;
			case '4':
					roster.sortAndDisplayPlants();
				break;
			case '5':
			case '\r':
			case '\n':
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		} while (input != '5');
		System.out.println("Exit Program..");
		log.info("Exiting");
	}

	public static void main(String[] args) throws IOException {

		PlantTest pt = new PlantTest();
		pt.run();
	}

	protected void finalize() throws Throwable
	{
		handler.close();
	}
}
