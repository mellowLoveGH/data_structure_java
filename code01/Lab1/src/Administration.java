import java.util.ArrayList;
import java.util.Arrays;

/**
 * An administrative body that has functions involving classes, students, profs etc...
 */
public class Administration {
	
	public static void main(String[] args) {
		
		Administration admin = new Administration();

	    UniClass COSC222;
	    UniClass MATH200;

	    Teacher Andrew;
	    Teacher Jenn;

	    Student bill;
	    Student ben;
	    Student bob;
	    bob = new Student(18, "Bob Maher", new String []{"COSC 222","COSC 311", "MATH 200", "MATH 220"});
        bill = new Student(19, "Billy Jean", new String []{"COSC 222", "COSC 404", "ENGL 112"});
        ben = new Student(24, "Ben Mckenny", new String []{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"});

        Andrew = new Teacher(36,"Andrew Peterson",  new String []{"COSC 222", "COSC 404", "COSC 111"}, "Computer Science");
        Jenn = new Teacher(36,"Jay Low",  new String []{"MATH 200", "MATH 220"}, "Mathematics");

        COSC222 = new UniClass(new Student[]{bob,bill,ben}, Andrew, "COSC 222");
        MATH200 = new UniClass(new Student[]{bob,ben}, Jenn, "MATH 200");
        
//        ArrayList<Student> results = new ArrayList<>(Arrays.asList();
		System.out.println(admin.listStudents(MATH200, 'A') == null);
	}
	
    /**
     * returns an array of students whose last name begins with the given character
     * @param class1 class whose students we are inspecting
     * @param start character we are concerned with
     */
    public Student[] listStudents(UniClass class1, char start){
        ArrayList<Student> list = new ArrayList<>();
        //TODO: Write the method described above
         
        Student[] stu = class1.getStudents();
        // if there is no student in the class, return null
        if(stu == null || stu.length == 0) {
        	return null;
        }
        
        // iterate through the student array
        for (int i = 0; i < stu.length; i++) {
			
        	Student s = stu[i];
        	// get the last name, split the name, get the second one
        	String ln = s.getName().split(" ")[1];
        	// get the first character of the last name
        	char ch = ln.charAt(0);
        	
        	// they are equal
        	if(ch == start) {
        		list.add(s);
        	}
		}
        
        // here down-cast is necessary
        Student[] result = new Student[list.size()];
        for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
        
        return result;
    }

    /**
     * compares two lists of students and returns the common students (or set intersection)
     * @param class1 list of students
     * @param class2 second list of students
     */
    public ArrayList<Student> intersection(Student[] class1,Student[] class2){
        ArrayList<Student> list = new ArrayList<>();
        //TODO: alter this method to conform to the expected test result in AdministrationTest in the case of an empty list
        
        if(class1 == null || class2 == null) {
        	return null;
        }
        if(class1.length == 0 || class2.length == 0) {
        	return null;
        }
        
        for (Student stud1: class1){
            for (Student stud2: class2){

                if(stud1.equals(stud2) && !list.contains(stud1)){
                    list.add(stud1);
                }

            }
        }

        return list;
    }
}
