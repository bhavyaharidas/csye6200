package edu.neu.csye6200.iofile;

import java.io.File;

public class FileTest {

	public void run() {
		//File baseDir = new File("test");
		File baseDir = new File("."); // Current working directory
		if(!baseDir.exists()) {
			baseDir.mkdirs(); // Make one if it doesnt exist
		}// got created at C:\Coursework\CSYE6200\projects\learning\csye6200
		listDir(baseDir);
	}
	
	public void listDir(File dirFile) {
		if(!dirFile.isDirectory()) return;
		System.out.println("Dir: " + dirFile.getAbsolutePath());
		
		//Looping to get files only and exclude directory
		for(File file : dirFile.listFiles()) {
			if(file.isDirectory()) continue; //Skip directory
			String fTxt = String.format("%1$32s %2$10d", file.getName(), file.length());
			System.out.println(fTxt);
		}
		//Looping to get folders only and exclude files
		for(File file : dirFile.listFiles()) {
			if(file.isDirectory())  //Skip files - keep directories
				listDir(file); //call the method recursively; useful to search for a particular item in the directory
		}
	}
	
	public static void main(String[] args) {
		FileTest fileTest = new FileTest();
		fileTest.run();

	}

}
