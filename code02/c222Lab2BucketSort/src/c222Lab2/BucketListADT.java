package c222Lab2;

import java.util.ArrayList;
import java.util.Collection;

/* Don't change this class */

public interface BucketListADT<V> {

	void add(Entry<V> item);

	void addAll(Collection<Entry<V>> c);
	
	ArrayList<Entry<V>> getBucket(int i);

	public int getNumBuckets();

	ArrayList<Entry<V>> getSortedOrder();

}
