import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * TODO: complete the following test. Use other test cases in the other Test files for sample syntax.
 */
public class StudentTest {

    Student bill;
    Student ben;
    Student bob;

    @Before
    public void initialize() throws Exception{
        bob = new Student(18, "Bob Maher", new String []{"COSC 222","COSC 311", "MATH 200", "MATH 220"});
        bill = new Student(19, "Billy Jean", new String []{"COSC 222", "COSC 404", "ENGL 112"});
        ben = new Student(24, "Ben Mckenny", new String []{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"});
    }
    @Test
    public void testGetClasses() throws Exception {
        //TODO: test that the array of courses returned by getClasses() is
    	// correct for each object. Fix the tests below
    	
    	// finished, check the returned arrays
    	assertTrue(Arrays.equals(bob.getClasses() , new String []{"COSC 222","COSC 311", "MATH 200", "MATH 220"}));
    	assertTrue(Arrays.equals(bill.getClasses() , new String []{"COSC 222", "COSC 404", "ENGL 112"}));
    	assertTrue(Arrays.equals(ben.getClasses() , new String []{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"}));
    }

    @Test
    public void testGetAge() throws Exception {
        //TODO: test that the age returned by getAge is correct
    	// for each student
    	 
    	// finished, check every object
    	assertTrue(bob.getAge() == 18);
    	assertTrue(bill.getAge() == 19);
    	assertTrue(ben.getAge() == 24);
    }
}	