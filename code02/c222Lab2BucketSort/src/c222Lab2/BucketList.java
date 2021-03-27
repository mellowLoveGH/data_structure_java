package c222Lab2;

import java.util.ArrayList;
import java.util.Collection;

//TODO: 5 "to do" items below

public class BucketList<V> implements BucketListADT<V> {
	
	private ArrayList<SortedBucket<V>> list;
	private int min;
	private int max;
	
	/**
	 * Constructor. Builds a list of buckets which
	 * supports Entry (key,value pairs)
	 * with expected key values from min to max 
	 * 
	 * @param min
	 * @param max
	 * @param n
	 */
	public BucketList(int min, int max, int n) {
		list = new ArrayList<SortedBucket<V>>();
		for (int i=0; i<n; i++){
			//TODO: instantiate a SortedBucket of <V> type
			SortedBucket<V> stbt = new SortedBucket<>();
			//TODO: add it to our BucketList instance variable "list"
			list.add(stbt);
		}
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Adds the given Entry into the appropriate bucket in
	 * this list of buckets.
	 * @param item
	 */
	@Override
	public void add(Entry<V> item) {
		int n = list.size();
		// DO NOT CHANGE THIS FORMULA. This ensures items will be
		// added to the correct bucket.
		int indexToInsert = n*(item.getKey()-min)/(max-min+1);

		// TODO: check if the calculated indexToInsert is
		// outside of the allowed range. If it is too large, just
		// insert into the last bucket. If it is too small (negative)
		// then insert item into bucket 0.
		
//		System.out.println(n);
//		System.out.println(indexToInsert);
		// add to the last one
		if(indexToInsert >= n) {
			(list.get(n - 1)).add(item);
		}
		// add to the first one
		else if(indexToInsert <= 0) {
			(list.get(0)).add(item);
			return;
		}
		else
			(list.get(indexToInsert)).add(item);
	}
	
	/**
	 * Adds all entries in the Collection c to this List of Buckets
	 * @param c is a Collection of Entries
	 */
	@Override
	public void addAll(Collection<Entry<V>> c) {
		// Don't touch this.
		// Implement above method .add() for this to work.
		
		for (Entry<V> e : c)
			this.add(e);
	}
	
	/**
	 * @return Returns a single ArrayList of the whole
	 * sorted order of all buckets put together
	 * 
	 */
	@Override
	public ArrayList<Entry<V>> getSortedOrder() {
		ArrayList<Entry<V>> output = new ArrayList<Entry<V>>();

		//TODO: add the contents of each bucket into the output ArrayList
		//Hint: our bucket's .getBucketContents() will get the contents
		//of that bucket in sorted order if they are stored in sorted order
		
		// take the list as a 2D-array that consists of several 1D-arrays
		// and every 1D-array is sorted
		// every time merge two 1D-arrays that both are sorted	
		
		// only one bucket
		if(list.size() == 1) {
			return list.get(0).getBucketContents();
		}
		
		// at least two buckets
		output = merge(list.get(0).getBucketContents(), list.get(1).getBucketContents());
		
		if(list.size() >= 3) {
			for (int i = 2; i < list.size(); i++) {
				output = merge(output, list.get(i).getBucketContents());
			}
		}
		
		return output;
	}
	
	public ArrayList<Entry<V>> merge(ArrayList<Entry<V>> al1, ArrayList<Entry<V>> al2){
		ArrayList<Entry<V>> al3 = new ArrayList<Entry<V>>();
		
		// index
		int i1 = 0;
		int i2 = 0;
		
		// every time get the first one (the smallest) from each list
		// compare them, add in the smaller one and increase its index
		// until any one of the two lists reaches its end
		while(i1 < al1.size() && i2 < al2.size()) {
			Entry<V> e1 = al1.get(i1);
			Entry<V> e2 = al2.get(i2);
			
			if(e1.getKey() < e2.getKey()) {
				al3.add(e1);
				i1++;
			}else {
				al3.add(e2);
				i2++;
			}
		}
		
		// if the first list is longer, add in all remaining elements in it
		while(i1 < al1.size()) {
			al3.add(al1.get(i1));
			i1++;
		}
		
		// if the second list is longer
		while(i2 < al2.size()) {
			al3.add(al2.get(i2));
			i2++;
		}
		
		return al3;
	} 
	
	
	/**
	 * Returns an ArrayList of the bucket contents of bucket i
	 * @param i
	 * @return
	 */
	@Override
	public ArrayList<Entry<V>> getBucket(int i) {
		//TODO: return the (i)th bucket as an arrayList.
		//Hint: our SortedBucket class has .getBucketContents()

		return list.get(i).getBucketContents(); // temporary line
	}
	
	/**
	 * Returns the number of buckets in this list of buckets
	 * @return int
	 */
	@Override
	public int getNumBuckets(){
		// Leave this alone.
		return list.size();
	}
	
	
	/* 
	 * Shows contents of all buckets, each bucket in [ ] brackets.
	 * Will show empty buckets as well.
	 */
	public String toString() {
		// Leave this alone
		StringBuilder output = new StringBuilder("[");
		for (SortedBucket<V> s: this.list) {
			output.append(s.toString());
		}
		output.append("]");
		return output.toString();
	}
}
