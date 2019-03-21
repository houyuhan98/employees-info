import java.util.Arrays;
//Alvin Guo and Hou Yuhan
public abstract class Employee {	
	private int IDNumber;
	private String name;
    private Task[] taskList; 
	
    Employee(){}
    
    Employee(int IDNumber, String name, Task[] taskList){
		 this.IDNumber = IDNumber;
		 this.name = name;
		 this.taskList = taskList;
	 }
    
    public int getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(int iDNumber) {
		IDNumber = iDNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Task[] getTaskList() {
		return taskList;
	}

	public void setTaskList(Task[] taskList) {
		this.taskList = taskList;
	}
	/**toString method
	 * @param getName(), getIDNumber(), Task.toString()
	 * @return formatted string
	 */
	public String toString() {
		String str = "Name: " + getName() + "\n";
		String str2 = "ID: " + getIDNumber() + "\n";
		String str3 = "Task List: " + "\n";
		String str4 = "";
		for(int i = 0; i < taskList.length; i++){
		str4 += taskList[i].toString() + "\n";
		}
		String print = (str + str2 + str3 + str4).trim();
		return print;
	 }
	 
    //equals method. Do not edit!
	public boolean equals(Employee e){
		boolean equal = true;
		equal = equal && (e.getIDNumber() == IDNumber);
		equal = equal && (e.getName().equals(name));
		for(int i = 0; i < taskList.length; i++){
			equal = equal && (taskList[i].equals(e.getTaskList()[i]));
		}
		return equal;
	}
}
