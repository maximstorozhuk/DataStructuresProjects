import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * the Junit test class for the administration class, for this one we included two tests
 * for each method to adequately test them for the expected and corner case
 */
public class AdministrationTest {
    Administration admin = new Administration();

    static UniClass COSC222, MATH200;
    static Teacher andrew, jennifer;
    static Student bill, ben, bob;

    @BeforeAll
    static void setUpBeforeClass(){
        //set up objects so we can test the methods of the Administration Class
    	bob = new Student(18, "Bob Maher", new String []{"COSC 222","COSC 311", "MATH 200", "MATH 220"});
        bill = new Student(19, "Bill Simmons", new String []{"COSC 222", "COSC 404", "ENGL 112"});
        ben = new Student(24, "Ben Mckenny", new String []{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"});

        andrew = new Teacher(36,"Andrew Peterson",  new String []{"COSC 222", "COSC 404", "COSC 111"}, "Computer Science");
        jennifer = new Teacher(36,"Jennifer Lopez",  new String []{"MATH 200", "MATH 220"}, "Mathematics");

        COSC222 = new UniClass(new Student[]{bob,bill,ben}, andrew, "COSC 222");
        MATH200 = new UniClass(new Student[]{bob,ben}, jennifer, "MATH 200");
        
    }

    /**
     * trying to test whether intersection method does what it should
     */
    @Test
    void testIntersection1(){
        ArrayList<Student> list = new ArrayList<>(Arrays.asList(bob, ben));

        ArrayList<Student> results = admin.intersection(COSC222.getStudents(), MATH200.getStudents());
        assertTrue(list.containsAll(results) && results.containsAll(list));
    }
    
    /**
     * notice how this test fails, I may want to alter the intersection method to account for
     * this in some way. (Hint: your going to do that)
     */
    @Test
    void testIntersection2(){
        //TODO: alter the intersection method to account for the test failing
        ArrayList<Student> results = admin.intersection(COSC222.getStudents(),new Student[]{});
        assertTrue(results == null);

    }

    //TODO: write 2 test cases for orderStudents1 consider how the previous tests where formatted
    //for this you may want to think of how a change in the parameters may alter the returned value
    //(i.e. think about corner cases)
    @Test
    void testListStudents1(){
    	ArrayList<Student> results = admin.orderStudents(COSC222, 'm');
    	ArrayList<Student> expected = new ArrayList<>(Arrays.asList(bob, ben));
    	assertTrue(expected.containsAll(results) && results.containsAll(expected));
    	
    	
    } 

    @Test
    void testListStudents2(){
    	ArrayList<Student> results = admin.orderStudents(MATH200, 'p');
    	assertTrue(results.isEmpty());
    	
    }

}