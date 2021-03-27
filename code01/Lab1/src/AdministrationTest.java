import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * The JUnit test class for the administration class. For this one we included two tests
 * for each method to adequately test them for the expected return values and corner cases
 */
public class AdministrationTest {
    Administration admin = new Administration();

    UniClass COSC222;
    UniClass MATH200;

    Teacher Andrew;
    Teacher Jenn;

    Student bill;
    Student ben;
    Student bob;

    @Before
    public void initialize() throws Exception{
        //set up objects so we can test the methods of the Administration Class

        bob = new Student(18, "Bob Maher", new String []{"COSC 222","COSC 311", "MATH 200", "MATH 220"});
        bill = new Student(19, "Billy Jean", new String []{"COSC 222", "COSC 404", "ENGL 112"});
        ben = new Student(24, "Ben Mckenny", new String []{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"});

        Andrew = new Teacher(36,"Andrew Peterson",  new String []{"COSC 222", "COSC 404", "COSC 111"}, "Computer Science");
        Jenn = new Teacher(36,"Jay Low",  new String []{"MATH 200", "MATH 220"}, "Mathematics");

        COSC222 = new UniClass(new Student[]{bob,bill,ben}, Andrew, "COSC 222");
        MATH200 = new UniClass(new Student[]{bob,ben}, Jenn, "MATH 200");
    }

    /**
     * Trying to test whether intersection method does what it should.
     * This test correctly tests that the two collections are equal,
     * and this test passes. You can leave this test alone.
     */
    @Test
    public void testIntersection1() throws Exception{
        ArrayList<Student> list = new ArrayList<>(Arrays.asList(bob, ben));

        ArrayList<Student> results = admin.intersection(COSC222.getStudents(), MATH200.getStudents());
        assertTrue(list.containsAll(results) && results.containsAll(list));
    }


    /**
     * notice how this test fails. Alter the intersection method (by following the TODO)
     * to account for this in some way.
     */
    @Test
    public void testIntersection2(){
        //TODO: alter the intersection method in Administration.java to account for the test failing
        ArrayList<Student> list = new ArrayList<>(Arrays.asList(bob,ben));

        ArrayList<Student> results = admin.intersection(COSC222.getStudents(),new Student[]{});
        assertTrue(results == null);

    }

    //TODO: write 2 test cases for orderStudents1
    //consider how the previous tests where formatted
    //Build a list of students that should be the "correct" list,
    //and replace 'false' in the assertTrue with a boolean
    //expression that tests whether listStudents() produces what it should
    @Test
    public void testListStudents1() throws Exception{
    	
    	// check all students in class 'COSC222', whose last names start with 'M'
    	ArrayList<Student> list = new ArrayList<>(Arrays.asList(bill));
    	ArrayList<Student> results = new ArrayList<>(Arrays.asList(admin.listStudents(COSC222, 'J')));
    	
    	assertTrue(list.containsAll(results) && results.containsAll(list));
    }

    @Test
    public void testListStudents2() throws Exception{
    	 
    	// check all students in class 'MATH200', whose last names start with 'A' for the test failing
    	ArrayList<Student> list = new ArrayList<>(Arrays.asList(bob,ben));
    	ArrayList<Student> results = new ArrayList<>(Arrays.asList(admin.listStudents(MATH200, 'A')));
    	
    	// there should be no elements in 'results'
    	assertTrue(results.size() == 0);
    }

}