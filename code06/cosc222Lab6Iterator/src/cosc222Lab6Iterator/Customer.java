package cosc222Lab6Iterator;

/** This class is complete. Do not edit it
 * 
 * @author cosc222
 *
 */

public class Customer {

	private String name;
	private int loyalty;
	
	public Customer(String name, int loyalty) {

		if (loyalty >= 0 && loyalty <= 3) {
			this.name = name;
			this.loyalty = loyalty;
		}
		else {
			System.err.println("Invalid loyalty value " + loyalty + " for customer: " + name);
			this.name = null;
			this.loyalty = -1;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getLoyalty() {
		return loyalty;
	}
	
	public String toString() {
		String output = "["+name+", ";
		if (loyalty == 0) output += "Platinum";
		if (loyalty == 1) output += "Gold";
		if (loyalty == 2) output += "Silver";
		if (loyalty == 3) output += "Bronze";
		return output + "]";
	}
}
