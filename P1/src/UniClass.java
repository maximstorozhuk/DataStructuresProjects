/**
 * Representation of a class with multiple students, a teacher/professor and a classcode
 */
public class UniClass {
    private Student[] students;
    private Teacher prof;
    private String classCode;

    public UniClass(Student[] students, Teacher prof, String classCode){
        this.students = students;
        this.prof = prof;
        this.classCode = classCode;
    }
    
    public Teacher getProf(){
        return prof;
    }
    
    public String getClassCode(){
        return classCode;
    }

    public Student[] getStudents(){
        return students;
    }

}
