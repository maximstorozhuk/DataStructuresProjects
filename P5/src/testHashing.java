import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class testHashing {

	static Hashing hash;
	
	@BeforeAll
	static void setup() throws Exception {
		hash = new Hashing();
	}
		
	@Test
	void testHashPolynomial() {
		String s = "red";
		int a = 3;
		int hashed = (int) hash.hashPolynomial(s, a);
		int expectedHashed = 'r' * 9 + 'e' * 3 + 'd';
		assertEquals(hashed, expectedHashed);
	}
	
	@Test
	void testIO() throws IOException {
		Object[] nums = hash.io(3);
		long l = (long) nums[2];
		assertEquals(hash.table.get(l), nums[1]);
	}
	
	@Test
	void testIO2() throws IOException{
		hash.setNP();
		Object[] nums = hash.io2(100, 200);
		long l = (long) nums[2];
		assertEquals(hash.table.get(l), nums[1]);
	}

	@Test 
	void setNPTest(){
		hash.setNP();
		int n1 = hash.p;
		assertTrue(hash.p == 560017);
	}
	
	@Test
	void testCompressionMAD() {
		hash.setNP();
		String s = "red";
		int a = 3;
		int alpha = 10;
		int beta = 20;
		int hashed = (int) hash.compressionMAD(hash.hashPolynomial(s,a), alpha, beta);
		int expectedHashed = ((('r' * 9 + 'e' * 3 + 'd') * alpha + beta) % hash.p) % hash.n;
	}

}
