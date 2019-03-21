import java.util.Arrays;
//Alvin Guo and Hou Yuhan
public class SalesAssociate extends Employee{
	private int numClients;
	private String[] products;
    private RegionalManager supervisor;
    
    SalesAssociate(int IDNumber, String name, Task[] taskList, int numClients1, String[] products1, RegionalManager supervisor1){
    	setIDNumber(IDNumber);
		 setName(name);
		 setTaskList(taskList);
		 numClients = numClients1;
		 products = products1;
		 supervisor = supervisor1;
    }
	
	
	public int getNumClients() {
		return numClients;
	}

	public void setNumClients(int numClients) {
		this.numClients = numClients;
	}

	public String[] getProducts() {
		return products;
	}

	public void setProducts(String[] products) {
		this.products = products;
	}

	public RegionalManager getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(RegionalManager supervisor) {
		this.supervisor = supervisor;
	}
	/**toString method
	 * @param super.toString(), getName(), int numClients, String[]products
	 * @return formatted string
	 */
	public String toString() {
	    String str = "Sales Associate\n";
	    String str2 = super.toString();
	    String str3 = "\nRegional Manager: " + supervisor.getName();
	    String str4 = "\n" + "Number of clients: " + Integer.toString(numClients);
	    String str5 = "\n" + "Products to sell: \n";
	    String str6 ="";
	    for (int i = 0; i < products.length; i++){
	    	str6 += "\t" + products[i] + "\n";
	    }
        String print = (str + str2 + str3 + str4 + str5 + str6).trim();
        return print;
	}

	//equals method. Do not edit!
	public boolean equals(SalesAssociate s){
		boolean equal = super.equals(s);
		equal = equal && (s.getNumClients() == numClients);
		equal = equal && (s.getSupervisor().equals(supervisor));
		
		for(int i = 0; i < products.length; i++){
			equal = equal && (products[i].equals(s.getProducts()[i]));
		}
		return equal;
	}
	
}