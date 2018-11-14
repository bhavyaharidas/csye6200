package edu.neu.csye6200.concth;

public class MyThread extends Thread {

	private boolean done = false;
	private int ctr = 0;
	
	public MyThread(String name) {
		super(name);
	}
	
	public void run() {
		while(!done) {
			doWork(); // Do important time consuming work
			ctr++;   // Count how many times around the loop
			System.out.println("Thread: " + this.getName() + " " + ctr);
			if(ctr > 1000)
				done = true;
		}
	}
	
	public void doWork() {
		for(int i = 0 ; i <100000; i++) {
			double val = Math.exp((double) i );
		}
	}
}
