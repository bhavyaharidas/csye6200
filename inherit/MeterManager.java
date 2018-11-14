package edu.neu.csye6200.inherit;

import java.util.ArrayList;
import java.util.logging.Logger;

// Example of a Singleton class
public class MeterManager {
	
	private static Logger log = Logger.getLogger(MeterManager.class.getName());
	
	private static MeterManager instance = null; // The single copy

	private ArrayList<MeterI> meterList = new ArrayList<MeterI>();
	
	private MeterManager() { // Can't be built external to class
		log.info("Constructing a MeterManager instance");
	}
	
	public static MeterManager instance() {
		if(instance == null) instance = new MeterManager(); // Build if needed
		return instance; // Return the single copy
	}
	
	public void add(MeterI meter) {
		meterList.add(meter);
		log.warning("Added a meter");
	}
	
	public void displayMeters(){
		for(MeterI meter : meterList) {
			String fTxt = String.format("Measure: %1$8f Resistivity: %2$8f", meter.measure(),meter.getResistivity());
			System.out.println(fTxt);
		}
	}
	
}
