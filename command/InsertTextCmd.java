package edu.neu.csye6200.command;

public class InsertTextCmd extends Command {

	private String inputTxt = "";
	private int insertIndex = 0;
	
	//Constructor
	public InsertTextCmd(StringBuffer doc, String inputTxt, int insertIndex) {
		super(doc);
		this.inputTxt = inputTxt;  //hang on to the input command params
		this.insertIndex = insertIndex;
	}

	@Override
	public void execute() {
		doc.insert(insertIndex, inputTxt); // Insert the input at an index. Insert() method inbuilt in StringBuffer
	}

	@Override
	public void undo() {
		int endIndex = insertIndex + inputTxt.length();
		doc.delete(insertIndex, endIndex);
	}

}
