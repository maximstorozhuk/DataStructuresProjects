import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * recall %80 coverage or higher is necessary on a test for it to be considered "Good Enough"
 * This is the rule of thumb we will follow throughout this class
 *
 * It is good habit to test each method for correctness when testing a class, this example only
 * uses simple getters/setters but with higher complexity code comes more complicated and involved tests
 * see AdministrationTest for an example
 */

class UniClassTest {
	static UniClass COSC222, MATH200;
	static Teacher Andrew, Jennifer;
	static Student bill, ben, bob;

	@BeforeAll
	static void initialize(){
		bob = new Student(18, "Bob Maher", new String []{"COSC 222","COSC 311", "MATH 200", "MATH 220"});
		bill = new Student(19, "Bill Cosby", new String []{"COSC 222", "COSC 404", "ENGL 112"});
		ben = new Student(24, "Ben Mckenny", new String []{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"});

		Andrew = new Teacher(36,"Andrew Peterson",  new String []{"COSC 222", "COSC 404", "COSC 111"}, "Computer Science");
		Jennifer = new Teacher(36,"Jennifer Lopez",  new String []{"MATH 200", "MATH 220"}, "Mathematics");

		COSC222 = new UniClass(new Student[]{bob,bill,ben}, Andrew, "COSC 222");
		MATH200 = new UniClass(new Student[]{bob,ben}, Jennifer, "MATH 200");
	}

	@Test
	void testGetProf(){
		assertEquals(COSC222.getProf(), Andrew);
		assertEquals(MATH200.getProf(),Jennifer);
	}

	@Test
	void testGetClassCode(){
		assertEquals(COSC222.getClassCode(), "COSC 222");
		assertEquals(MATH200.getClassCode(), "MATH 200");
	}
}
