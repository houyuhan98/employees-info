//Alvin Guo and Hou Yuhan
public class Receptionist extends Employee{
	private AssistantRegionalManager supervisor;
	private int maxTaskComplexityLevel;
     
	 Receptionist(int IDNumber, String name, Task[] taskList, AssistantRegionalManager supervisor1, int maxTaskComplexityLevel1){
		 setIDNumber(IDNumber);
		 setName(name);
		 setTaskList(taskList);
		 supervisor = supervisor1;
		 maxTaskComplexityLevel = maxTaskComplexityLevel1;
	 }
	 
	public AssistantRegionalManager getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(AssistantRegionalManager supervisor) {
		this.supervisor = supervisor;
	}

	public int getMaxTaskComplexityLevel() {
		return maxTaskComplexityLevel;
	}

	public void setMaxTaskComplexityLevel(int maxTaskComplexityLevel) {
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}
	/**toString method
	 * @param super.toString(), getName(), int maxTaskComplexityLevel
	 * @return formatted string
	 */
	public String toString() {
		String str = "Receptionist\n";
		String str2 = super.toString();
		String str3 = "\n" + "Assistant Regional Manager: " + supervisor.getName();
		String str4 = "\n" + "Max Task Level: " + Integer.toString(maxTaskComplexityLevel);
		String print = str + str2 + str3 + str4;
		return print;
	
	}
	
	//equals method. Do not edit!
	public boolean equals(Receptionist r){
		boolean equal = super.equals(r);
		equal = equal && (r.getSupervisor().equals(supervisor));
		equal = equal && (r.getMaxTaskComplexityLevel() == maxTaskComplexityLevel);
		return equal;
	}
}
