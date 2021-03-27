package cosc222Lab6Iterator;

// TODO: there are 3 "to do" items below, and 1 bonus TODO
import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Before;

public class Test {

	/* Declaration of the test objects */
	
	Requests r;
	Iterator<Customer> i;
	/* Instantiation of the objects */
	
	@Before
	public void initialize() {
		System.out.println("Initializing");
		r = new Requests();
		
	}

	@org.junit.Test
	public void test1() {
		System.out.print("Test 1: ");
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		System.out.print("Check");
	}

	@org.junit.Test
	public void test2() {
		System.out.print("Test 2: ");
	//TODO: Test if it works if there are no customers in Platinum
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		System.out.print("Check");
	}

	@org.junit.Test
	public void test3() {
		System.out.print("Test 3: ");
	//TODO: Test if it works if there are no customers in Platinum and none in Bronze
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next(), null); // no bronze
		System.out.print("Check");
	}

	@org.junit.Test
	public void test4() {
		System.out.print("Test 4: ");
	//TODO: Test if it works if all customers in Platinum and none in Bronze
		r.add("Jim", 0);
		r.add("Jenny",0);
		r.add("Julie",0);
		r.add("Jason",0);
		r.add("Jessica",0);
		r.add("Jackie", 0);
		r.add("CowboyNeal", 0);
		r.add("Val", 0);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		assertEquals(i.next(), null); // no other levels
		System.out.print("Check");
	}

	@org.junit.Test
	public void test5() {
		System.out.print("Test 5: ");
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Joseph",5);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		System.out.print("Test 1: ");
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		System.out.print("Check");
	}

	// test if removal works
	@org.junit.Test
	public void test6() {
		System.out.print("Test 6: ");
	//TODO: Test if i.remove() works
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		System.out.print("Test 1: ");
		assertEquals(i.next().getName(),"Jim");
		i.remove(); // remove Jim
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		i.remove(); // remove Jenny
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		i.remove(); // remove Julie
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		i.remove(); // remove Val
		
		i = r.iterator(); // check after removing those 4 items above
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next(), null);
		System.out.print("Check");
	}
	
}
