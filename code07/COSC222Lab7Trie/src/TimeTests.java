import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListSet;

public class TimeTests { 

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> arraylist = new ArrayList<>();

		LowerCaseTrie trie = new LowerCaseTrie();
		LinkedList<String> linkedlist = new LinkedList<>();
		HashSet<String> hashset = new HashSet<>();
		ConcurrentSkipListSet<String> skiplist = new ConcurrentSkipListSet<>();
		
		FileReader f = new FileReader("englishWords.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			arraylist.add(s);
		}
		sc.close();
		
		int numTrials = 2000000;
		
		// test the time it takes to do this
		// read the time before and after this for-loop
		long start, end;
		start = System.currentTimeMillis();
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			// add this randomWord to a data structure you are testing
//			trie.add(randomWord);
			linkedlist.add(randomWord);
//			hashset.add(randomWord);
//			skiplist.add(randomWord);
		}
		end = System.currentTimeMillis();
		System.out.println("add() time: " + (end - start));
		
		start = end;
		// repeat this to test 200000 calls of .contains() of random words
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			// add this randomWord to a data structure you are testing
//			trie.contains(randomWord);
//			linkedlist.contains(randomWord);
//			hashset.contains(randomWord);
//			skiplist.contains(randomWord);
		}
		end = System.currentTimeMillis();
		System.out.println("contains() time: " + (end - start));
		
		start = end;
		// repeat this to test 200000 calls of .remove() of random words
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			// add this randomWord to a data structure you are testing
//			trie.remove(randomWord);
			linkedlist.remove(randomWord);
//			hashset.remove(randomWord);
//			skiplist.remove(randomWord);
		}
		end = System.currentTimeMillis();
		System.out.println("remove() time: " + (end - start));
		
		// report your findings for time required for add/contains/remove
		// for each of the data structures linkedlist/hashset/skiplist/trie
		//				200000 .add()	200000 .contains()	200000 .remove() 	unit
		// Trie				2890			1864				1889			millisecond
		// LinkedList		309			O(n^2) too long		O(n^2) too long
		// HashSet			849				837					551
		// SkipList			4653			4799				2698
		
		// analysis
		// for the time taken by using LinkedList data structure, it is too long.
		// even running several minutes, it does not finish and will run out of the memory.
		// the add() of LinkedList is O(1)
		// while the contains() and remove() will be O(n)
		// within the loop, it is O(n^2), namely, 200000 * 200000, that is too long
		// 
		// Trie, it is like 26-ary tree, so generally and averagely
		// the time complexity of add(), contains() and remove()
		// is: O(logn)
		//
		// HashSet, 
		// the time complexity of add(), contains() and remove()
		// is: O(1)
		
		// SkipList, 
		// the time complexity of add(), contains() and remove()
		// O(log n)
		
	}
}
