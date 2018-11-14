package edu.neu.csye6200.timer;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	
	private Timer timer;
	
	//Constructor
	public TimerDemo() {
		timer = new Timer();  // a worker
		// task, delay time, periodic delay
		timer.schedule(new RemindTask(), 3000L, 1000L); // keeps calling the run method in RemindTask every 3 secs
	}
	
	//A TimerTask class
	class RemindTask extends TimerTask{
		
		private int ctr = 0;

		@Override
		public void run() {
			System.out.println("Timer alert " + ctr++);
			Toolkit.getDefaultToolkit().beep(); // Ring the bell
			if(ctr > 5) timer.cancel();
		}
	}

	public static void main(String[] args) {
		TimerDemo td = new TimerDemo();

	}

}
