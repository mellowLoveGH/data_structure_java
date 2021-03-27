/**
 * An implementation of a trie which supports .add(s) .contains(s)
 * .remove(s) (remove does not remove nodes, but just removes the
 * information that a word exists at a particular node where the
 * word would be found in the trie)
 * 
 * It also keeps track of the number of distinct words it contains
 * and the number of nodes it is using to hold all those words
 *
 * You should not have to modify this file at all.
 */

public class LowerCaseTrie {

	private TrieNode head = new TrieNode(new StringBuilder(""),'>');
	public int numNodes = 1;
	public int numWords = 0;
	
	public void add(String s) {
		s = s.toLowerCase();
		if (contains(s) == true) return;
		else {
			add(s,head);
			numWords++;
		}
	}
	
	public boolean contains(String s) {
		s = s.toLowerCase();
		if (s.length() == 0) return false;
		return contains(s,head);
	}
	
	private boolean contains(String s, TrieNode t) {
		if (s.length() == 0) 
			return t.endOfWord;
		char c = s.charAt(0);
		if (t.next[c-'a'] == null) 
			return false;
		else
			return contains(s.substring(1), t.next[c-'a']);
		
	}

	public void remove(String s) {
		s = s.toLowerCase();
		if (contains(s) == false)
			return;
		else {
			remove(s,head);
			numWords--;
		}
	}
	
	private void remove(String s, TrieNode t) {
		if (s.length() == 0) {
			t.endOfWord = false;
			return;
		}
		char c = s.charAt(0);
		if (t.next[c-'a'] == null) 
			return;
		else
			remove(s.substring(1), t.next[c-'a']);
		
	}

	public void output(TrieNode t) {
		
		for (int i=0; i<26; i++) {
			if (t.next[i] != null) {
				if (t.next[i].endOfWord)
					System.out.println(t.next[i].wordSoFar);
				output(t.next[i]);
			}
		}
	}
	
	private void add(String s, TrieNode t) {
		if (s.length() == 0) 
			t.endOfWord = true;
		else {
			char c = s.charAt(0);
			if (t.next[c-'a'] == null) {
				t.next[c-'a'] = new TrieNode(t.wordSoFar, c);
				numNodes++;
			}
			add(s.substring(1), t.next[c-'a']);
		}
	}
	

	
}

class TrieNode {

	boolean endOfWord = false;
	StringBuilder wordSoFar;
	TrieNode[] next = new TrieNode[26];
	
	public TrieNode(StringBuilder s, char c){
		wordSoFar = new StringBuilder(s);
		wordSoFar.append(c);
	}
	
}
