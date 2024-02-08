import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchingTest {

	static char[] defaultArr = {'d', 'e', 'f', 'a', 'u', 'l', 't'};
	static char[] defaultPat = {'r', 'e', 's', 'i', 'l', 'i', 'e', 'n', 'c', 'e'};
	static char[] text1 = {'a', 'b', 'c', 'a', 'b', 'c', 'a', 'b', 'a', 'b', 'c'};
	static char[] pattern1 = {'a', 'b', 'c'};
	static char[] text2 = {'a', 'b', 'a', 'b', 'a', 'b', 'c'};
	static char[] pattern2 = {'a', 'b', 'a', 'b'};
	static Matching matching = new Matching();
	
	@Test
	void testFindKMP1(){
		assertEquals(matching.findKMP(text1, pattern1), 3);
		assertEquals(matching.findKMP(text2, pattern1), 1);
		assertEquals(matching.findKMP(text2, pattern2), 2);
	}

	@Test
	void testFindKMP2() {
		assertEquals(matching.findKMP(pattern1, text1), 0);
	}
	
	@Test
	void testFindKMP3() {
		assertEquals(matching.findKMP(defaultArr, defaultPat), 1);
	}
	
	@Test
	void testFindBoyerMoore1() {
		assertEquals(matching.findBoyerMoore(text1, pattern1), 3);
		assertEquals(matching.findBoyerMoore(text2, pattern1), 1);
		assertEquals(matching.findBoyerMoore(text2, pattern2), 2);
	}
	
	@Test
	void testFindBoyerMoore2() {
		assertEquals(matching.findBoyerMoore(pattern1, text1), 0);
	}
	
	@Test
	void testFindBoyerMoore3() {
		assertEquals(matching.findBoyerMoore(defaultArr, defaultPat), 1);
	}

	@Test
	void testFindBrute1() {
		assertEquals(matching.findBrute(text1, pattern1), 3);
		assertEquals(matching.findBrute(text2, pattern1), 1);
		assertEquals(matching.findBrute(text2, pattern2), 2);
	}
	
	@Test
	void testFindBrute2() {
		assertEquals(matching.findBrute(pattern1, text1), 0);
	}

	@Test
	void testFindBrute3() {
		assertEquals(matching.findBrute(defaultArr, defaultPat), 1);
	}
	
	@Test
	void testFindRabinKarp1() {
		assertEquals(matching.findRabinKarp(text1, pattern1), 3);
		assertEquals(matching.findRabinKarp(text2, pattern1), 1);
		assertEquals(matching.findRabinKarp(text2, pattern2), 2);
	}
	
	@Test
	void testFindRabinKarp2() {
		assertEquals(matching.findRabinKarp(pattern1, text1), 0);
	}
	
	@Test
	void testFindRabinKarp3() {
		assertEquals(matching.findRabinKarp(defaultArr, defaultPat), 1);
	}

}
