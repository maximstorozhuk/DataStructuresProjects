import java.util.ArrayList;

/**
 * an administrative body that has functions involving classes, students, profs ect...
 */
public class Administration {

    /**
     * returns an arraylist of students who's last name begins with the given character
     * students can be assumed to have only 1 first and last name, separated by a space
     * @param class1 class who's students we are inspecting
     * @param start character we are concerned with
     */
    public ArrayList<Student> orderStudents(UniClass class1, char start){
        ArrayList<Student> list = new ArrayList<>();
        start = Character.toLowerCase(start);
        Student[] arr = class1.getStudents();
        for(int i = 0; i < arr.length; i++)
        {
        	String name = arr[i].getName();
        	char c = '&';
        	for(int j = 0; j < name.length(); j++)
        	{
        		if(name.charAt(j) == ' ') {
        			c = name.charAt(j+1);
        			break;
        		}
        	}
        	c = Character.toLowerCase(c);
        	if(c == start) {
        		list.add(arr[i]);
        	}
        }
        

        return list;
    }

    /**
     * compares two lists of students and returns the common students (or set intersection)
     * @param class1 list of students
     * @param class2 second list of students
     */
    public ArrayList<Student> intersection(Student[] class1, Student[] class2){
        ArrayList<Student> list = new ArrayList<>();
        //TODO: alter method to account for empty lists in some way
        if(class1.length == 0 || class2.length == 0){
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
