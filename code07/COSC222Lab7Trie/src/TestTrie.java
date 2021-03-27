import org.junit.*;
import static org.junit.Assert.*;

public class TestTrie {

	LowerCaseTrie trie;

	@Before
	public void initialize() {
		trie = new LowerCaseTrie();

	} 
 
	@org.junit.Test
	public void test1() {
		// test this class for correctness
		// 6 tests that test .add and .contains together
		trie.add("hello");
		assertEquals(trie.contains("hello"), true);
		trie.add("mellow");
		trie.add("Canada");
		assertEquals(trie.contains("mellow"), true);
		assertEquals(trie.contains("Canada"), true);
		trie.add("gentle");
		trie.add("peace");
		trie.add("America");
		assertEquals(trie.contains("gentle"), true);
		assertEquals(trie.contains("peace"), true);
		assertEquals(trie.contains("America"), true);
		assertEquals(trie.contains("China"), false);
		// run correctly
	}

	@org.junit.Test
	public void test2() {
		// test this class for correctness
		// 6 more tests of scenarios of using .add followed by .remove followed by
		// .contains
		trie.add("hello");
		trie.add("mellow");
		trie.add("Canada");
		trie.add("gentle");
		trie.add("peace");
		trie.add("America");

		trie.remove("hello");
		trie.remove("gentle");
		trie.remove("peace");
		assertEquals(trie.contains("hello"), false);
		assertEquals(trie.contains("gentle"), false);
		assertEquals(trie.contains("peace"), false);
		trie.remove("mellow");
		trie.remove("Canada");
		assertEquals(trie.contains("mellow"), false);
		assertEquals(trie.contains("Canada"), false);
		trie.remove("America");
		assertEquals(trie.contains("America"), false);
		// run correctly
	}

	@org.junit.Test
	public void test3() {
		// adding words which are prefixes of other words already added
		trie.add("hello");
		trie.add("hell");
		assertEquals(trie.contains("hello"), true);
		assertEquals(trie.contains("hell"), true);

		trie.add("gentleman");
		trie.add("gentle");
		assertEquals(trie.contains("gentle"), true);
		assertEquals(trie.contains("gentleman"), true);

		trie.add("international");
		trie.add("in");
		assertEquals(trie.contains("in"), true);
		assertEquals(trie.contains("international"), true);
		// run correctly
	}

	@org.junit.Test
	public void test4() {
		// testing for words which are prefixes of some added words,
		// even if those prefixes are not added
		trie.add("hello");
		assertEquals(trie.contains("hello"), true);
		assertEquals(trie.contains("hell"), false);
		assertEquals(trie.contains("he"), false);

		trie.add("gentleman");
		assertEquals(trie.contains("gentle"), false);
		assertEquals(trie.contains("gentleman"), true);
		assertEquals(trie.contains("g"), false);

		trie.add("international");
		assertEquals(trie.contains("in"), false);
		assertEquals(trie.contains("internation"), false);
		assertEquals(trie.contains("international"), true);
		// run correctly
		// this why the "endOfWord" in TrieNode class works
	}

	@org.junit.Test
	public void test5() {
		// adding words multiple times, removing the word, checking contains.
		// adding the word again, checking contains
		trie.add("hello");
		trie.add("hello");
		trie.add("hello");
		trie.remove("hello");
		assertEquals(trie.contains("hello"), false);
		trie.add("hello");
		assertEquals(trie.contains("hello"), true);

		trie.add("gentleman");
		trie.add("gentleman");
		trie.add("gentleman");
		trie.add("gentleman");
		trie.add("gentleman");
		trie.add("gentleman");
		trie.remove("gentleman");
		assertEquals(trie.contains("gentleman"), false);
		trie.add("gentleman");
		assertEquals(trie.contains("gentleman"), true);

		int N = 100;
		for (int i = 0; i < N; i++) {
			trie.add("international");
		}
		trie.remove("international");
		assertEquals(trie.contains("international"), false);
		trie.add("international");
		assertEquals(trie.contains("international"), true);
		// run correctly
	}

	@org.junit.Test
	public void test6() {
		// add word A,
		// add word B, A is the prefix of B
		// remove A, check whether B is also removed or not
		trie.add("gentle");
		trie.add("gentleman");
		trie.remove("gentle");
		assertEquals(trie.contains("gentle"), false);
		assertEquals(trie.contains("gentleman"), true);

		trie.add("in");
		trie.add("international");
		trie.remove("in");
		assertEquals(trie.contains("in"), false);
		assertEquals(trie.contains("international"), true);

		// remove the word not added
		trie.add("gentle");
		trie.add("gentleman");
		trie.remove("genteel");
		trie.add("interest");
		trie.add("inner");
		trie.remove("in");
		trie.remove("interesting");

		// add empty string
		trie.add("");
		assertEquals(trie.contains(""), false);

		// output testing
		TrieNode tn = new TrieNode(new StringBuilder(""), 'a');
		trie.output(tn);
		// run correctly
	}

	// report
	// it seems the program is not only correct but also pretty robust.
	// the coverage of "LowerCaseTrie" class is more than 90%
	// but do not find any possible errors
}
