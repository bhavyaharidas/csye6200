package edu.neu.csye6200.concrun;

public class MyRunTest {
	
	// A runnable still needs thread instance to run in threads
	
	MyRunnable myRunA = null;
	Thread threadA = null;
	
	MyRunnable myRunB = null;
	Thread threadB = null;
	
	public MyRunTest() {
		myRunA = new MyRunnable("A"); //create runnable
		threadA = new Thread(myRunA); // create thread
		
		myRunB = new MyRunnable("B"); //create runnable
		threadB = new Thread(myRunB); // create thread
	}
	
	public void run() {
		threadA.start(); // start the thread
		threadB.start();
	}

	public static void main(String[] args) {
		MyRunTest mrtest = new MyRunTest();
		mrtest.run();

	}

}
