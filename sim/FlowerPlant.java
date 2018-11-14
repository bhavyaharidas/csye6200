package edu.neu.csye6200.sim;
import java.util.ArrayList;

public class FlowerPlant extends Plant {

	private String flowerColor;
	private int petalCount;
	private ArrayList<Flower> flowers;

	public FlowerPlant(String typeName, Boolean baseStem, String flowerColor, int petalCount) {
		super(typeName, baseStem);
		this.flowerColor = flowerColor;
		this.petalCount = petalCount;
		flowers = new ArrayList<Flower>();
	}

	public FlowerPlant() {
		
	}
	public ArrayList<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(ArrayList<Flower> flowers) {
		this.flowers = flowers;
	}

	public void growPlant() {
		super.growPlant();
		for(Stem stem: this.getStemFamily()) {
			if(stem.getStartLoc()[1] % 2 == 0) {
				Flower flower = new Flower(this.flowerColor, this.petalCount, stem.getStartLoc());
				this.flowers.add(flower);
			}
		}
	}

	public void printPlant() {
		super.printPlant();
		System.out.println("Flower count - " + flowers.size());
		System.out.println("\nFLOWERS\n");
		System.out.println(printFlowerHeader());
		for (Flower flower : this.flowers) {
			System.out.println(flower.toString());
		}
	}
	private String printFlowerHeader() {
		return String.format("%0" + 105 + "d", 0).replace("0", "*")
				+ "\n" + String.format("%10s %2$13c %3$15s %4$13c %5$15s %6$13c %7$5s", "Flower Id", '|',
						"Location", '|', "Color", '|', "Number of petals")
				+ "\n" + String.format("%0" + 105 + "d", 0).replace("0", "*");
	}


}