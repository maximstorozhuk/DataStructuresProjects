import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Write/fix the code as needed to remove warnings/errors and complete the lab 
public class Courses {
	ArrayList<Course> courses = new ArrayList<>();
	
	void loadCourses(){
		courses.add(new Course("COSC","121","Computer Programming II","Advanced programming in the application of software engineering techniques to the design and implementation of programs manipulating complex data structures.","A score of 60% or higher in one of COSC 111, COSC 123"));
		courses.add(new Course("COSC", "416", "Special Topics in Databases", "Advanced or specialized topics in database design, modelling, and implementation. This course may be taken more than once for credit. Credit will be granted for only one of COSC 416 or COSC 516 when the subject matter is of the same nature.", "COSC 304 and third-year standing"));
		courses.add(new Course("COSC","222","Data Structures","Introduction to the design, implementation and analysis of data structures. Topics will include lists, stacks, queues, trees, and graphs. Credit will only be granted for one of COSC 210 or COSC 222.","A score of 60% or higher in COSC 121"));
		courses.add(new Course("COSC","211", "Machine Architecture", "Organization and design of computer systems and their impact on the practice of software development. Instruction set architecture and assembly programming languages, design of central processing units (CPU), memory hierarchy and cache organization, input and output programming.", "COSC 121"));
		courses.add(new Course("COSC", "304", "Introduction to Databases", "Databases from a user's perspective: querying with SQL, designing with UML, and using programs to analyze data. Construction of database-driven applications and websites and experience with current database technologies. Completion of COSC 121 is recommended.", "One of COSC 111, COSC 123, COSC 210. Third-year standing."));
		courses.add(new Course("COSC", "320", "Analysis of Algorithms", "Design and analysis of algorithms, illustrated from various problem areas. Models of computation, choice of data structures, space and time efficiency, computation complexity, algorithms for searching, sorting and graph-theoretic problems, NP-complete problems.", "All of COSC 221, COSC 222 and one of MATH 221, APSC 179."));
		courses.add(new Course("COSC", "404", "Database System Implementation", "Fundamental concepts in constructing database systems including file organizations, storage management, system architectures, query processing/optimization, transaction management, recovery, and concurrency control. Additional topics may include distributed databases, mobile databases, and integration. Credit will be granted for only one of COSC 404 or COSC 504.", "COSC 304 and third-year standing"));
		courses.add(new Course("COSC","111","Computer Programming I","Introduction to the design, implementation, and understanding of computer programs. Topics include problem solving, algorithm design, and data and procedural abstraction, with emphasis on the development of working programs. This course should be followed by COSC 121.","A score of 70% or higher in one of PREC 12, MATH 12, MATH 125, MATH 126"));
	}
	
	public void listAll(){
		System.out.println(listAllAsString());
	}
	public void listAllIter() {
		System.out.println(listAllIterAsString());
	}
	public void listAllStream() {
		System.out.println(listAllStreamAsString());
	}
	public String listAllAsString(){
		Course c;
		String s = "";
		for (int i=0; i < courses.size(); i++){
			c = courses.get(i);
			s += c.accr + " " + c.number + " " + c.title + "\n";
		}
		return s;
	}
	public String listAllIterAsString() {
		//All that needs to be done here is creating an iterator, and going through it while there is a next element and printing the required values 
		ListIterator<Course> it = courses.listIterator();
		String s = "";
		while(it.hasNext()) {
			Course c = it.next();
			s += c.accr + " " + c.number + " " + c.title + "\n";
		}
		return s;
	}
	public String listAllStreamAsString() {
		// Need to ensure the output is identical to the other methods by adding a \n at the end, since unlike the other methods
		// the stream adds the \n by joining together rather than concatenating at the end
		return courses.stream()
				.map(c -> c.accr + " " + c.number + " " + c.title)
				.collect(Collectors.joining("\n")) + "\n";
	}
	public void displayCount() {
		System.out.println("There are " + count() + " courses stored");
	}
	public int count() {
		//While this returns an int equivalent to the number of courses stored for testing purposes
		return (int) courses.stream().count();
	}
	public void coursesWithDatabase() {
		coursesWithDatabaseAsList().stream().map(c -> c.accr + " " + c.number + " " + c.title).forEach(c -> System.out.println(c));
	}
	public List<Course> coursesWithDatabaseAsList() {
		//This returns a List<Course> of courses with database in the description
		return courses.stream()
		.filter(c -> c.desc.contains("database"))
		.collect(Collectors.toList());
	}
	
	public List<Course> coursesSorted() {
		return courses.stream()
				.sorted(Comparator.comparing(Course::getNumber))
				.collect(Collectors.toList());
	}
	void displayCourse(String number){
		System.out.println(displayCourseAsString(number));
	} 
	public String displayCourseAsString(String number) {
		//Traverses through every element of the list until the course with the right number is found, then prints. Breaks for loop when the 
				// correct element is found so there is no useless traversal when the element has already been found
		Course c;
		String s = "";
		for(int i = 0; i < courses.size(); i++) {
			c = courses.get(i);
			if(c.number.equals(number)) {
				s += c.accr + " " + c.number + " " + c.title + "\n";
				s += c.desc + "\n";
				s += "Prerequisite: " + c.prereq;
				break;
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
		Courses L = new Courses();
		L.loadCourses();
	}

}
