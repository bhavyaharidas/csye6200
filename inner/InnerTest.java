package edu.neu.csye6200.inner;

/**
 * @author bhavy
 *
 */
public class InnerTest {
	
	private int key = 20; //my secret key
	
	//An inner class
	public class InnerProc{
		public String encode(String input) {
		StringBuffer sb = new StringBuffer();
		for(char c : input.toCharArray()) {
			char c2 = (char)(c ^ key); //Xor - Exclusive OR against the key
			sb.append(c2);
		}
		return sb.toString();
		}
	}

	
	/**
	 * Constructor - this is the constructor of my class
	 * @param key - the secret 
	 */
	public InnerTest(int key) {
		this.key = key;
		
		InnerProc iProc = new InnerProc();
		
		String str0 = "My secret message 123";
		System.out.println("Str0: " + str0);
		String str1 = iProc.encode(str0);
		System.out.println("Str1: " + str1);
		String str2 = iProc.encode(str1);
		System.out.println("Str2: " + str2);
		
	}

	
	/**
	 * My main method
	 * @param args
	 */
	public static void main(String[] args) {
		InnerTest inTest = new InnerTest(30);

	}

}
