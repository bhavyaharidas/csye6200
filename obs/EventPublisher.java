package edu.neu.csye6200.obs;

import java.util.Observable;

public class EventPublisher extends Observable{
	
	private boolean done = false; //set true to stop the run method
	private int ctr = 0; // count how many times we loop aroun
	
	// Observable is deprecated. More sophisticated library available
	// Observable doesnt work in multi threads
	
	public EventPublisher() {
		System.out.println("Event Publisher - we are here");
	}
	
	// An event has occurred, so notify the subscribers
	public void doAction() {
		setChanged(); // Indicate that a change has happened
		notifyObservers(new String ("A message " + ctr));

	}

	public void run() {
		while(!done) {
			doAction();
			if(ctr++ > 10)
				done = true;
		}
	}
	
	public static void main(String[] args) {
		
		EventPublisher ep = new EventPublisher(); // a publisher
		EventSubscriber sub1 = new EventSubscriber();
		ep.addObserver(sub1);     // make a subscription
		ep.run();
		
	}

}
