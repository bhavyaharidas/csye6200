package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextArea;

import edu.neu.csye6200.ui.BGApp;

//Holds starting point of the application
public class PlantGrowthApp extends BGApp {

	private BGGenerationSet plants;

	// Overridden BGApp method to execute events on "start" button click
	@Override
	public void startAction() {
		plants = new BGGenerationSet(new ArrayList<String>(Arrays.asList(textfield.getText().split(","))));
		plants.createPlants();
	}

	// Overridden BGApp method to execute events on "stop" button click
	@Override
	public void stopAction() {
		plants.setDone(true);
	}

	public static void main(String[] args) {
		PlantGrowthApp app = new PlantGrowthApp();
	}
}
