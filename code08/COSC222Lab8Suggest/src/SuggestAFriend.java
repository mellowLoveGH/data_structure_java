import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class SuggestAFriend {

	/**
	 * Given social network g and name s, returns an ArrayList of all
	 * the names that this social network would suggest s may know
	 * @param g
	 * @param s
	 */
	public static ArrayList<String> suggest(Graph g, String s) {
		// First, let's make sure name s exists in this graph g
		if (g.containsName(s) == false) {
			System.err.println(s + " does not exist in this graph");
			return null;
		}
		
		// here use BFS (breadth first search)
		// use a Queue to help achieve
		
		// TODO: Find and store the friends of s
		ArrayList<String> sFriends = g.getNbrs(s);
		
		// use to help find the indirect friends for s
		Queue<String> queue = new LinkedList<String>();
		// add in the directly connected persons
		for (int i = 0; i < sFriends.size(); i++) {
			queue.offer(sFriends.get(i));
		}

		// TODO: Find the list of friends of the friends of s
		// Don't forget to exclude s from this list
		
		// store in the possibly suggested ones
		// String is for the indirect friends
		// Integer is for how many common friends they have, default value is 1
		HashMap<String, Integer> sgt = new HashMap<>();
		int max = 0; // used to record the most common friends
		
		// by dequeue the items from queue
		// add in the second-level friends
		while(! queue.isEmpty()) {
			String tmp = queue.poll();
			// get the friends of tmp
			ArrayList<String> fds = g.getNbrs(tmp); 
			
			// check every friends of tmp whether it is the indirect to s
			for (int i = 0; i < fds.size(); i++) {
				// the potential friend of s
				String potential = fds.get(i); 
				if(sFriends.contains(potential) || potential.equals(s)) {
					// it is still the direct friend of s 
					// or is s
					continue;
				}else {
					// find the how many common friends they share
					int num = findCommon(g, s, potential);
					sgt.put(potential, num);
					
					// record the maximum
					// used to suggest in the final step
					if(max < num) {
						max = num;
					}
				}
			}
		}
		
		// TODO: Of all the friends of friends of s, find the ones with
		// the largest number of common friends with s
		ArrayList<String> result = new ArrayList<>();
		
		// iterate through the hash map
		Iterator<Entry<String, Integer>> iter = sgt.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			int v = entry.getValue();
			if(v == max) {
				result.add(entry.getKey());
				// print out for checking
//				System.out.println(s + "\t" + entry.getKey() + "\t" + v);
			}
		}
		
		// TODO: return an ArrayList of all the names with most common friends
		return result;
	}

	// given two persons that are not direct connected
	// find how many common friends they share
	public static int findCommon(Graph g, String s1, String s2) {
		int common = 0;
		
		ArrayList<String> fds1 = g.getNbrs(s1);
		ArrayList<String> fds2 = g.getNbrs(s2);
		
		// if they are direct friends
//		fds1.remove(s2);
//		fds2.remove(s1);
		
		// embedded loop
		for (int i = 0; i < fds1.size(); i++) {
			String tmp = fds1.get(i);
			if(fds2.contains(tmp)) {
				common++;
			}
		}
		
		return common;
	}
	

}
