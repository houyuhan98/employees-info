import java.util.Arrays;
//Alvin Guo and Hou Yuhan
public class RegionalManager extends Employee {
	private int RegionNum;
	private Employee[] subordinates;
    private int minimumTask;

    RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum1, Employee[] subordinates1, int minimumTask1){
    	setIDNumber(IDNumber);
		 setName(name);
		 setTaskList(taskList);
		 RegionNum = RegionNum1;
		 subordinates = subordinates1;
		 minimumTask = minimumTask1;
    }

    RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum1, int minimumTask1){
    	setIDNumber(IDNumber);
		 setName(name);
		 setTaskList(taskList);
		 RegionNum = RegionNum1;
		 minimumTask = minimumTask1;
    }
    
    public int getRegionNum() {
		return RegionNum;
	}

	public void setRegionNum(int regionNum) {
		RegionNum = regionNum;
	}

	public Employee[] getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Employee[] subordinates) {
		this.subordinates = subordinates;
	}

	public int getMinimumTask() {
		return minimumTask;
	}

	public void setMinimumTask(int minimumTask) {
		this.minimumTask = minimumTask;
	}
	/**toString method
	 * @param super.toString(), int RegionNum, int minimumTask
	 * @return formatted string
	 */
    public String toString() { 
		String str = "Regional Manager\n" + super.toString() + "\n" + "Region Number: " + Integer.toString(RegionNum) + "\n" + "Minimum Task Level: " + Integer.toString(minimumTask) + "\nEmployees: \n";
		String str2 = "";
		for(int i = 0; i < subordinates.length; i++){
			if(i<subordinates.length-1){
				str2 += subordinates[i].toString()+ "\n";
			}
			else{
				str2 += subordinates[i].toString();
			}
		}
        String print = str + str2;
        return print;
    }
    
    //equals method. Do not edit!
	public boolean equals(RegionalManager r){
		boolean equal = super.equals(r);
		equal = equal && (r.getRegionNum() == RegionNum);
		equal = equal && (r.getMinimumTask() == minimumTask);
		for(int i = 0; i < subordinates.length; i++){
			equal = equal && (subordinates[i].equals(r.getSubordinates()[i]));
		}
		return equal;
	}
}