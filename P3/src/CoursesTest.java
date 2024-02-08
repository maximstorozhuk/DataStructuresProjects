import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CoursesTest {

	static Courses courses;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		courses = new Courses();
		courses.loadCourses();
	}

	@Test
	void displayTest() {
		Course c = courses.courses.get(0);
		String s = c.accr + " " + c.number + " " + c.title + "\n" + c.desc + "\n" + "Prerequisite: " + c.prereq;
		assertTrue(s.equals(courses.displayCourseAsString(c.number)));
	}
	
	@Test
	void listAllTest() {
		String list = courses.listAllAsString();
		String listIter = courses.listAllIterAsString();
		String listStream = courses.listAllStreamAsString();
		assertTrue(list.equals(listIter) && listIter.equals(listStream));
	}
	
	@Test
	void countTest() {
		int count = courses.count();
		assertEquals(count, 8);
	}
	
	@Test
	void databaseTest() {
		Course[] arr = {courses.courses.get(1), courses.courses.get(4), courses.courses.get(6)};
		assertArrayEquals(arr, courses.coursesWithDatabaseAsList().toArray());
	}
	
	@Test 
	void sortTest() {
		Course[] arr = {courses.courses.get(7), courses.courses.get(0), courses.courses.get(3), courses.courses.get(2),
				courses.courses.get(4), courses.courses.get(5), courses.courses.get(6), courses.courses.get(1)};
		assertArrayEquals(arr, courses.coursesSorted().toArray());
	}
	
}
