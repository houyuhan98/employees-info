
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
//Alvin Guo and Hou Yuhan
public class TheOffice { 
	
	private Employee[] workers;
	
	public Employee[] getWorkers() {
		return workers;
	}

	public void setWorkers(Employee[] workers) {
		this.workers = workers;
	}
	
	//Constructor
	TheOffice(){}
	
	TheOffice(String fileLoc) throws TaskLevelException{
		
		//This is used to read a file, do NOT edit!!!
		Scanner fs = null;
		File f = null;
		
		//Try Catch on file
		try{ 
			f = new File(fileLoc); 
			fs = new Scanner(f); 
		}
		catch(FileNotFoundException e){ 
			System.out.println("FileNotFoundException: The file \""+ fileLoc + "\" could not be found.");
		}
		
		
		//First Line is number of employees
		int size = Integer.parseInt(fs.nextLine());
		
		workers = new Employee[size];
				
		//This might be useful, feel free to delete, or not use these		
		RegionalManager manager = null;
		int supremum = 0;
		AssistantRegionalManager assistantManager = null;
		int ATRM = 0; 
		
		//Loops through file
		for(int i = 0; i < size; i++){
			//Sets temp variables for all possible member variables
			int IDNumber = -1;
			String name = null;
			Task[] taskList = null; 
			int RegionNum = -1; 
			int minimumTask = -1;
			int numClients = -1;
			String[] products = null;
			int maxTaskComplexityLevel = -1;
			
			//Check which type of employee
			String type = fs.nextLine().trim();
			
			//Get Standard information (id, name)
			IDNumber = Integer.parseInt(fs.nextLine().trim());
			name =  fs.nextLine();
			
			//Gets number of tasks and makes a task array based on the size
			int tasks = Integer.parseInt(fs.nextLine().trim());
			taskList = new Task[tasks];
				
			//Fills up Task List
			for(int j = 0; j < tasks; j++){
				//Gets information for task
				String work = fs.nextLine();
				int num = Integer.parseInt(fs.nextLine().trim());
				
				//Sets task at array spot
				taskList[j] = new Task(work, num); 
			}
			
			//Scanner read for Regional Manager. Use this as an example to do the other 3 types
			if(type.equals("RegionalManager")){
				//Gets Region Number and Minimum Task Level
				RegionNum = Integer.parseInt(fs.nextLine().trim());
				minimumTask = Integer.parseInt(fs.nextLine().trim());
				
				//Loop through the Task list
				for(int j = 0; j < taskList.length; j++ ){
					//If a task is below the minimum task level, throw exception
					if(taskList[j].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}			
				
				//set manager to new regional manager
				manager = new RegionalManager(IDNumber, name, taskList, RegionNum, minimumTask);
				
				//set workers[i] to regional manager
				workers[i] = manager;
				
				//Set supremum (Might be useful)
				supremum = minimumTask;
			}
			else if(type.equals("AssistantRegionalManager")){
				
				minimumTask = Integer.parseInt(fs.nextLine().trim());
				for(int j = 0; j < taskList.length; j++ ){
					//If a task is below the minimum task level, throw exception
					if(taskList[j].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}			
				assistantManager = new AssistantRegionalManager(IDNumber, name, taskList, manager, minimumTask);
				workers[i] = assistantManager;
				
			}
			else if(type.equals("SalesAssociate")){
				numClients = Integer.parseInt(fs.nextLine().trim());
				int numProduct = Integer.parseInt(fs.nextLine().trim());
				products = new String[numProduct];
				
				for(int j = 0; j < numProduct; j++ ){
					products[j] = fs.nextLine().trim();
				}	
				SalesAssociate aobject = new SalesAssociate(IDNumber, name, taskList, numClients, products, manager);
				workers[i] = aobject;
				
			}
			else if(type.equals("Receptionist")){
				
				maxTaskComplexityLevel = Integer.parseInt(fs.nextLine().trim());
				
				Receptionist aobject1 = new Receptionist(IDNumber, name, taskList, assistantManager, maxTaskComplexityLevel);
				workers[i] = aobject1;
		
			}
		}
		
		//Set up Employee Arrays for regional manager
		Employee[] a = new Employee[size -1];
		for(int i = 0, j = 0; i < workers.length; i++){
			if(!(workers[i] instanceof RegionalManager)){
				a[j++] = workers[i];
			}
		}
		
		//If there is a manager, set the subordinate array
		if(manager != null){
			manager.setSubordinates(a);
		}
	}
	
	
	/**toString method
	 * @param call RegionalManager.toString() only
	 * @return formatted string
	 */
	public String toString() {
		String str = "";
		for(int i = 0, j = 0; i < workers.length; i++){
			if(workers[i] instanceof RegionalManager){
		
		str += ((RegionalManager)workers[i]).toString() + "\n";
			}
		}
		String print = str.trim();
		return print;
	}
	
	/**levelDisplay method
	 * @param Employee's names and minimumTaskLevels
	 * @return formatted string
	 */
	public String levelDisplay(){
		String str = "";
		int mintaskLevel = 0;
		int temp = -1;
		
		for(int i = 0; i < workers.length; i++){
			if(workers[i] instanceof RegionalManager){
			mintaskLevel = ((RegionalManager) workers[i]).getMinimumTask();
			}
			if(workers[i] instanceof AssistantRegionalManager){
				mintaskLevel = ((AssistantRegionalManager) workers[i]).getMinimumTask();
			}
			if(workers[i] instanceof SalesAssociate || workers[i] instanceof Receptionist){
				mintaskLevel = 1;
			}
		    str += "Name: " + workers[i].getName() + "\t" + "Level: " + Integer.toString(mintaskLevel) + "\n";
		
		}
		String print = str.trim();
	    return print;
	}
	
	
	public static void main(String[] args) throws TaskLevelException{
		//Gets location for file
		TheOffice o = new TheOffice((args[0]+".txt"));
		
		//Prints office, then the current level display
		System.out.println(o + "\n\n\n" + o.levelDisplay());
		
		//Sorts(by name) the employee array
		Sorter.sort(o.getWorkers());
		
		//Prints the sorted(by name) level display
		System.out.println("\n\n\n" + o.levelDisplay());
	}
	
}