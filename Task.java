//Alvin Guo and Hou Yuhan
public class Task {   
	private String name;
	private int level;

     Task(String name, int level){
    	 this.name =name;
    	 this.level = level;
     }
    //immutable class with no setters.
     
    public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	/**toString method
	 * @param getName(), getLevel()
	 * @return formatted string
	 */
     public String toString() {
    	 
    	 String str = "\t" + "Task: " + getName() + "\t" + "Level: " + getLevel();
    	 return str;
 	}
     
     
	//equals method. Do not edit!
	public boolean equals(Task t){
		return ((t.getLevel() == level) && (t.getName().equals(name)));
	}
}
