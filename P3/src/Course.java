//extend/modify as needed to complete the lab
public class Course {
	String accr, number, title, desc, prereq;
	public Course(String accr, String number, String title, String desc, String prereq) {
		// (COSC, 121, Computer Programming II, description of course, prequisites)
		this.accr = new String(accr);
		this.number = new String(number);
		this.title = new String(title);
		this.desc = new String(desc);
		this.prereq = new String(prereq);
	}
	public int getNumber() {
		//Helper method for sorting, question 8
		return Integer.parseInt(number);
	}
}