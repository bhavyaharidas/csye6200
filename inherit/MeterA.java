package edu.neu.csye6200.inherit;

public abstract  class MeterA {

	private double probVal = 12.3;

	public double getProbVal() {
		return probVal;
	}

	public void setProbVal(double probVal) {
		this.probVal = probVal;
	}
	
	public abstract double calcProbMeasure();
	
}
