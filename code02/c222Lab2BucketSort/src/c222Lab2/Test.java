package c222Lab2;

// This file will pass all tests without errors when BucketList
// and SortedBucket are fully implemented. But you need to
// add additional test cases as well.

// TODO: there are 3 "to do" items below

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

public class Test {

	/* Declaration of the test objects */
	
	BucketList<String> b;
	ArrayList<Entry<String>> everyone;
	Entry<String> jim, val, C, B, A, Aplus;
	
	/* Instantiation of the objects */
	
	@Before
	public void initialize() {
		everyone = new ArrayList<>();
		jim = new Entry<>(94 , "Jim");
		val = new Entry<>(93 , "Val");
		C = new Entry<>(68 , "C-Student");
		B = new Entry<>(72 , "B-Student");
		A = new Entry<>(84 , "A-Student");
		Aplus = new Entry<>(98 , "A-plus-Student");

		everyone.add(jim);
		everyone.add(val);
		everyone.add(C);
		everyone.add(B);
		everyone.add(A);
		everyone.add(Aplus);

	}

	/* Various tests follow */
	
	@org.junit.Test
	public void test1() {
		// BucketList constructor takes (min,max,numBuckets)
		b = new BucketList<String>(0,100,6);
		b.addAll(everyone);
		ArrayList<Entry<String>> list4 = new ArrayList<>();
		list4.add(C);
		list4.add(B);
		list4.add(A);
		ArrayList<Entry<String>> list5 = new ArrayList<>();
		list5.add(val);
		list5.add(jim);
		list5.add(Aplus);
		//System.out.println(list4);
		//System.out.println(list5);
		//System.out.println(b);
		
		// .equals in ArrayLists compares corresponding items
		assertTrue(b.getBucket(4).equals(list4)
					&& b.getBucket(5).equals(list5)
					&& b.getBucket(0).isEmpty()
					&& b.getBucket(1).isEmpty()
					&& b.getBucket(2).isEmpty()
					&& b.getBucket(3).isEmpty());
	}

	@org.junit.Test
	public void test2() {
		// BucketList constructor takes (min,max,numBuckets)
		b = new BucketList<String>(0,100,5);
		b.addAll(everyone);

		//TODO:
		
		// Figure out (on paper?) where these 6 Entry objects should
		// be in the case of 5 buckets. Then build a test
		// like in test1() to check each of the 5 buckets
		// for the correct contents (and correct order of contents)
		// (Note that list4 and list5 in test1 had their elements
		// added so that the resulting list is in sorted order so
		// that testing the corresponding bucket is easier.

		// Use whichever lists you need (see test1() )
		/*
		ArrayList<Entry<String>> list0 = new ArrayList<>();
		ArrayList<Entry<String>> list1 = new ArrayList<>();
		ArrayList<Entry<String>> list2 = new ArrayList<>();
		ArrayList<Entry<String>> list3 = new ArrayList<>();
		ArrayList<Entry<String>> list4 = new ArrayList<>();

		list4.add(Aplus); // ... add rest of Entry objects
		*/
		
		ArrayList<Entry<String>> list3 = new ArrayList<>();
		list3.add(C);
		list3.add(B);
		
		ArrayList<Entry<String>> list4 = new ArrayList<>();
		list4.add(A);
		list4.add(val);
		list4.add(jim);
		list4.add(Aplus);
		
		// .equals in ArrayLists compares corresponding items
		assertTrue(b.getBucket(3).equals(list3)
					&& b.getBucket(4).equals(list4)
					&& b.getBucket(0).isEmpty()
					&& b.getBucket(1).isEmpty()
					&& b.getBucket(2).isEmpty());
		
	}

	@org.junit.Test
	public void test3() {
		// BucketList constructor takes (min,max,numBuckets)
		b = new BucketList<String>(0,100,4);
		b.addAll(everyone);
		
		//TODO:
		// Write this test similar to test2(). But this time these
		// six Entry Objects are added into a BucketList with 4 buckets
		
		ArrayList<Entry<String>> list2 = new ArrayList<>();
		list2.add(C);
		list2.add(B);
		
		ArrayList<Entry<String>> list3 = new ArrayList<>();
		list3.add(A);
		list3.add(val);
		list3.add(jim);
		list3.add(Aplus);
		
		// .equals in ArrayLists compares corresponding items
		assertTrue(b.getBucket(2).equals(list2)
					&& b.getBucket(3).equals(list3)
					&& b.getBucket(0).isEmpty()
					&& b.getBucket(1).isEmpty());
		
//		assertTrue(true); // change this assert
	}
	
	@org.junit.Test
	public void emptyTest() {
		// BucketList constructor takes (min,max,numBuckets)
		// Testing if we can construct in the negative range, and if
		// it will still perform "sort" without crashing if all buckets
		// are empty
		b = new BucketList<String>(-50,50,6);
		assertTrue(b.getNumBuckets()==6 && b.getSortedOrder().size()==0); 
	}

	@org.junit.Test
	public void perfectStudentTest() {
		// test where an Entry named "perfect" with a score of 100 will
		// be placed in a BucketList which stores grades from 0 to 100 and
		// having 10 buckets.
		
		b = new BucketList<String>(0,100,10);
		b.add(new Entry<>(100,"perfect"));
		assertTrue(b.getBucket(9).size()==1); 
	}

	@org.junit.Test
	public void outOfBoundsTest1() {
		// tests if we can add an Entry with key value larger than max
		
		b = new BucketList<String>(0,100,10);
		b.add(new Entry<>(110,"superPerfect"));
		assertTrue(b.getBucket(9).size()==1); 
	}

	@org.junit.Test
	public void outOfBoundsTest2() {
		// tests if we can add an Entry with key value less than min
		
		b = new BucketList<String>(0,100,10);
		b.add(new Entry<>(-110,"notSoPerfect"));
		assertTrue(b.getBucket(0).size()==1); 
	}

	@org.junit.Test
	public void additionalTest() {
		//TODO: Write an additional test that
		//is different from the above
		
		// when there are 10 buckets
		b = new BucketList<String>(0,100,10);
		b.addAll(everyone);
		
		ArrayList<Entry<String>> list6 = new ArrayList<>();
		list6.add(C);
		ArrayList<Entry<String>> list7 = new ArrayList<>();
		list7.add(B);
		ArrayList<Entry<String>> list8 = new ArrayList<>();
		list8.add(A);
		ArrayList<Entry<String>> list9 = new ArrayList<>();
		list9.add(val);
		list9.add(jim);
		list9.add(Aplus);
		
		for(int i = 0; i < 6; i++) {
			assertTrue(b.getBucket(i).isEmpty());
		}
		assertTrue(b.getBucket(6).equals(list6)
				&& b.getBucket(7).equals(list7)
				&& b.getBucket(8).equals(list8)
				&& b.getBucket(9).equals(list9));
		
		
		// test Entry class
		Entry<String> e1 = b.getBucket(9).get(0);
		assertTrue(e1.getKey() == val.getKey());
		assertTrue(e1.getValue().equals(val.getValue()));
		
		Entry<String> e2 = b.getBucket(8).get(0);
		assertTrue(e2.getKey() == A.getKey());
		assertTrue(e2.getValue().equals(A.getValue()));
		
		Entry<String> e3 = b.getBucket(7).get(0);
		assertTrue(e3.getKey() == B.getKey());
		assertTrue(e3.getValue().equals(B.getValue()));
		
		Entry<String> e4 = b.getBucket(6).get(0);
		assertTrue(e4.getKey() == C.getKey());
		assertTrue(e4.getValue().equals(C.getValue()));
		
		
		// test bucket list again
		// if there is only 1 bucket
		b = new BucketList<String>(0,100,1);
		b.addAll(everyone);
		
		ArrayList<Entry<String>> list0 = new ArrayList<>();
		list0.add(C);
		list0.add(B);
		list0.add(A);
		list0.add(val);
		list0.add(jim);
		list0.add(Aplus);

		assertTrue(b.getBucket(0).equals(list0));
		
		
		
		
	}

}
