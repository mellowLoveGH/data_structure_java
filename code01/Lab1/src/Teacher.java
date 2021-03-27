/**
 * A Teacher class.
 */
public class Teacher {
    private int age;
    private String name;
    private String[] classes;
    private String PhD;

    public Teacher(int age, String name, String[] classes, String PhD){
        this.age = age;
        this.name = name;
        this.classes = classes;
        this.PhD = PhD;
        
    }
    
    public String getName(){
    	return name;
    }
    
    public int getAge(){
        return age;
    }

    public String[] getClasses(){
        return classes;
    }

    public String getPhD(){
        return PhD;
    }
}

