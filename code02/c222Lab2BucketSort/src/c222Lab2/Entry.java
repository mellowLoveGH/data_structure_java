package c222Lab2;

/* There is no need to modify this class. You may modify the class
   if you know what you are doing, and want to add functionality
   to it, for instance, adding mutators */

/**
 * A (key,value) pair class. Key is int type. 
 * 
 * @author cosc222
 *
 * @param <V>
 */
public class Entry <V> {
	private int key;
	private V val;
	
	public Entry(int k, V v) {
		key = k;
		val = v;
	}

	public int getKey() {
		return this.key;
	}

	public V getValue() {
		return this.val;
	}

	public String toString() {
		return this.getValue()+"="+this.getKey();
	}
}
