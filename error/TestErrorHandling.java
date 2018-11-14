/**
 * 
 */
package edu.neu.csye6200.error;

import java.io.IOException;

/**
 * @author bhavy
 *
 */
public class TestErrorHandling {

	public void run() {
		testCatch();
	}

	// Let's call this error-prone method
	public void testCatch() {
		try {
			testError(1);
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getLocalizedMessage());
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// Could produce an exception
	public void testError(int val) throws Exception {
		if (val > 5) {
			throw new IOException("This is an IO error");
		}
		if (val < 2) {
			throw new IllegalArgumentException("This is an IA error");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestErrorHandling teh = new TestErrorHandling();
		teh.run();
	}

}
