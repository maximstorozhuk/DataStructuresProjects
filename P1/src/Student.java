/**
 * representation of a student, who can be enrolled in multiple classes with an age.
 */
public class Student {
    private int age;
    private String name;
    private String[] classes;

    public Student(int age,String name, String[] classes){
        this.age = age;
        this.name = name;
        this.classes = classes;
    }

    public String[] getClasses(){
        return classes;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
    	return name;
    }
}
