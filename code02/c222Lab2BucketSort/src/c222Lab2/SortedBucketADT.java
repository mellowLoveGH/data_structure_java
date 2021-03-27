package c222Lab2;

import java.util.ArrayList;

/* Don't change this class */

public interface SortedBucketADT<V>{

	void add(Entry<V> t);

	ArrayList<Entry<V>> getBucketContents();


}
