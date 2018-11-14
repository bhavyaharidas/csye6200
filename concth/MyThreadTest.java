package edu.neu.csye6200.concth;

public class MyThreadTest {
	
	private MyThread threadA = null;
	private MyThread[] threads = new MyThread[10]; // a group od threads
	
	//Constructor
	public MyThreadTest() {
		threadA = new MyThread("A");
		for(int i = 0; i< 10; i++) {
			threads[i] = new MyThread("Thread" + i);
		}
	}

	public void run() {
		threadA.start(); // Launch our thread - lift off!
		for(int i = 0; i< 10; i++) {
			threads[i].start();
		}
	}
	
	public static void main(String[] args) {
		MyThreadTest mtt = new MyThreadTest();
		mtt.run();
		System.out.println("We are done with main!!!!");

	}

}
