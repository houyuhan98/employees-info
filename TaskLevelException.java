
import java.io.*;


//Do NOT edit this file
public class TaskLevelException extends Exception {
	private int level;
  
	public TaskLevelException(int level){
		this.level = level;
	} 
  
	public double getLevel(){
		return level;
	}
}
