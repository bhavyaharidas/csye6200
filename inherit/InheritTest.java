/**
 * 
 */
package edu.neu.csye6200.inherit;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


import edu.neu.csye6200.sim.PlantRoster;

/**
 * @author bhavy
 *
 */
public class InheritTest {

	//Constructor
	public InheritTest() {
		java.util.logging.Handler handler = null;
		try {
			handler = new FileHandler("server.log");
		}catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		Logger.getLogger("").addHandler(handler);
	}
	
	public void run() {
		PowerMeasure pm0 = new PowerMeasure();
		System.out.println("Power measure resistivity: " + pm0.getResistivity());
		
		AltPowerMeasure apm0 = new AltPowerMeasure();
		System.out.println("Alt Power measure resistivity: " + apm0.getResistivity());
		
		displayMeasure(apm0); //apm0 is an interface MeterI (is-A)
		
		//static call to create instance of MeterManager (the singleton class)
		MeterManager meterMgr = MeterManager.instance();
		meterMgr.add(pm0);
		meterMgr.add(apm0);
		
		meterMgr.displayMeters();
		
		MeterManager meterMgr2 = MeterManager.instance(); //Same exact object as meterMgr
		
		meterMgr2.displayMeters();
	}
	
	public void displayMeasure(MeterI meter) {
		System.out.println("Measure is " + meter.measure());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InheritTest iTest = new InheritTest();
		iTest.run();

	}

}
