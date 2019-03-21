//Alvin Guo and Hou Yuhan
public class Sorter{
	/**sort method
	 * @param Employee[]
	 * @return an old object with names in ascending alphabetical order
	 */
	public static Employee[] sort(Employee [] a){
		
		Employee temp;
		
		for(int i = 0; i < a.length; i++){
			temp = a[i];
           for(int j = i+1 ; j < a.length; j++){
			  if ((a[i].getName()).compareTo(a[j].getName())>0){
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
}