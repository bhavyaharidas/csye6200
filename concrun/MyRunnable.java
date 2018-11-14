package edu.neu.csye6200.concrun;

public class MyRunnable implements Runnable {
	
	private boolean done = false;
	private boolean paused = false;
	private String name;
	private int ctr;
	
	public MyRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while(!done) {
			if(ctr == 100)
				paused = true;
			if(ctr == 110)
				paused = false;
			if(paused) {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ctr++;
			}
			else {
			doWork();
			ctr++;   // Count how many times around the loop
			if(ctr % 10 == 0) 
				System.out.println("Thread: " + this.name + " " + ctr);
			if(ctr > 1000)
				done = true;
			}
		}

	}
	
	public void doWork() {
		for(int i = 0 ; i <100000; i++) {
			double val = Math.exp((double) i );
		}
	}

}
