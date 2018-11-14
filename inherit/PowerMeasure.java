package edu.neu.csye6200.inherit;

public class PowerMeasure extends MeterA implements MeterI {

	protected double current = 1.0; // 1 Ampere
	protected double voltage = 12.0; // 12 Volts

	// Constructor
	public PowerMeasure() {
		System.out.println("Power measure constructor called");
	}

	// V = IR
	public double getResistivity() {
		return voltage / current;
	}

	@Override // From the interface MeterI
	public double measure() {
		return voltage * current;
	}

	@Override //From the abstract class MeterA
	public double calcProbMeasure() {
		return 0;
	}

}
