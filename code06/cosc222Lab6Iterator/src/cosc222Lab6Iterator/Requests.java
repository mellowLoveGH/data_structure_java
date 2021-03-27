package cosc222Lab6Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/** This class maintains customer requests of customer loyalty types: Platinum, Gold, Silver, and Bronze. 
 * These will be implemented as loyalty 0, 1, 2, 3, respectively.
 * It implements the Iterable interface, meaning
 * a user can create an iterator to iterate through the items it contains.
 * 
 * The order in which customers should be iterated is through their loyalty rank first, (platinum first, bronze last)
 * and then in order in which these customers were placed in the collection.
 * 
 * @author cosc222
 *
 */

public class Requests implements Iterable<Customer> {

	private int size;
	private ArrayList<LinkedList<Customer>> reqs;
	
	public Requests() {
		size = 0;

		// This is going to be an arrayList of 4 LinkedLists
		reqs = new ArrayList<LinkedList<Customer>>();
		
		reqs.add(new LinkedList<>()); // index 0 is platinum

		//TODO: add a linkedlist for gold, silver, bronze
		reqs.add(new LinkedList<>()); // index 1 is glod
		reqs.add(new LinkedList<>()); // index 2 is silver
		reqs.add(new LinkedList<>()); // index 3 is bronze
	}

	/**
	 * Adds a customer by name,loyalty (0=platinum, 1=gold, 2=silver, 3=bronze)
	 * @param name
	 * @param loy
	 */
	public void add(String name, int loy) {
		//Leave this method as is. Complete the next method.
		add(new Customer(name,loy));
	}
	
	public void add(Customer c) {
		// Leave this line as is. If a customer is invalid, its loyalty program is set to -1
		if (c.getLoyalty() == -1) return;
	

		//TODO: add customer to the appropriate list. Don't forget to increase the size variable.
		int id = c.getLoyalty();
		reqs.get(id).add(c);
		size++;
	}

	@Override
	public Iterator<Customer> iterator() {
		// Do not move this class. It is an inner-class to the Requests class
		// See https://stackoverflow.com/questions/5849154/can-we-write-our-own-iterator-in-java
		// For an example of creating your own iterator.
		
		Iterator<Customer> itr = new Iterator<Customer>() {

			private int index = 0;
			@Override

			public boolean hasNext() {
				//TODO: this should return true if index has not yet reached the last item
				return index < size;
			}

			@Override
			public Customer next() {
				//TODO: This method must return the next item in this collection, keeping in mind that
				//the cusomters in Platinum go first (if any), the customers in Gold go next (if any), etc.
				//This is your main task of this assignment.
				int pi = reqs.get(0).size();
				if(index < pi) {
					Customer c = reqs.get(0).get(index);
					index++;
					return c;
				}
				
				int gi = reqs.get(1).size();
				if(index < pi + gi) {
					Customer c = reqs.get(1).get(index - pi);
					index++;
					return c;
				}
				
				int si = reqs.get(2).size();
				if(index < pi + gi + si) {
					Customer c = reqs.get(2).get(index - pi - gi);
					index++;
					return c;
				}
				
				int bi = reqs.get(3).size();
				if(index < pi + gi + si + bi) {
					Customer c = reqs.get(3).get(index - pi - gi - si);
					index++;
					return c;
				}
				
				return null;
			}
		
			@Override
			public void remove() {
				//TODO: Solutions without this method completed will earn up to 8/10. 
				// .remove is in the Iterable interface, but Java leaves it as an
				// optional method that can be omitted.
				// This method must remove the last item that was returned by this iterator
				
				// get the last item that was returned by iterator
				int id = index - 1;
				if(id < reqs.get(0).size()) { 
					// in platinum
					reqs.get(0).remove(id);
				}else if(id < reqs.get(0).size() + reqs.get(1).size()) {
					// in gold
					reqs.get(1).remove(id - reqs.get(0).size());
				}else if(id < reqs.get(0).size() + reqs.get(1).size() + reqs.get(2).size()) {
					// in silver
					reqs.get(2).remove(id - reqs.get(0).size() - reqs.get(1).size());
				}else {
					// in bronze
					reqs.get(3).remove(id - reqs.get(0).size() - reqs.get(1).size() - reqs.get(2).size());
				}
				index--;
				size--;
			}
			
		};
		return itr;
	}
	
	
	
	
}
