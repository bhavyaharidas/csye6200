package edu.neu.csye6200.inherit;

public class AltPowerMeasure extends PowerMeasure {
	
	// This class is also a MeterI since its parent inherits MeterI
	public AltPowerMeasure() {
		System.out.println("AlterPowerMeasure constructor called");
	}
	
	@Override
	public double getResistivity() {
		return super.getResistivity() * 2;
		// or use return (voltage / current) * 2;
	}
	
}
