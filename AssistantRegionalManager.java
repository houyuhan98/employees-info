//Alvin Guo and Hou Yuhan
/**
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
public class AssistantRegionalManager extends Employee{
	private RegionalManager manager;
	private int minimumTask;
	
	 AssistantRegionalManager(int IDNumber, String name, Task[] taskList, RegionalManager manager1, int minimumTask1){
		 setIDNumber(IDNumber);
		 setName(name);
		 setTaskList(taskList);
		 manager = manager1;
		 minimumTask = minimumTask1;
	 }
	
	
	public RegionalManager getManager() {
		return manager;
	}

    public void setManager(RegionalManager manager) {
		this.manager = manager;
	}

    public int getMinimumTask() {
		return minimumTask;
	}

    public void setMinimumTask(int minimumTask) {
		this.minimumTask = minimumTask;
	}

    /**toString method
     * @param super.toString(), getName(), int minimumTask
     * @return formatted string
     */
    public String toString() {
		String str = "Assistant Regional Manager\n";
		String str2= super.toString()+"\n";
		String str3 = "Regional Manager: "+manager.getName()+"\n";
		String str4 = "Minimum Task Level: "+Integer.toString(minimumTask);
		String print = str + str2 + str3 + str4;
		return print;
	}
	
	
	
	//equals method. Do not edit!
	public boolean equals(AssistantRegionalManager r){
		boolean equal = super.equals(r);
		equal = equal && (r.getMinimumTask() == minimumTask);
		equal = equal && (r.getManager().equals(manager));
		return equal;
	}
}
