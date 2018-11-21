/**
 * 
 */
package edu.neu.csye6200.command;

/**
 * Command Design Pattern
 * @author bhavy
 *
 */
public abstract class Command {
	
	protected StringBuffer doc = null; //Mimicking a document. Since strings are immutable
	
	//Constructor
	public Command(StringBuffer doc) {
		this.doc = doc;
	}

	abstract public void execute();
	abstract public void undo(); //to undo whatever was done in execute()
}
