/**
 * representation of a teacher, who may teach multiple classes and has a PHD
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

