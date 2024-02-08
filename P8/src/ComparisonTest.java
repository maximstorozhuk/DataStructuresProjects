import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ComparisonTest {
	
	static String[] testing = {"dog", "cataract", "cata", "cat", "pig", "pigs", "pigsie", "pigsies"};
	static Comparison c;
	
	@BeforeAll
	static void beforeAll() {
		c = new Comparison();
		c.setWords();
	}
	@Test
	void getWordsTest() {
		c.setTrie(c.getWords());
		assertEquals(c.getTrieCount(c.getWords()[0]), 6);
	}
	@Test
	void trieTest() {
		c.setTrie(testing);
		assertEquals(c.getTrieCount("dog"), 1);
		assertEquals(c.getTrieCount("cat"), 3);
		assertEquals(c.getTrieCount("pig"), 4);
		assertTrue(c.trieContains("pig"));
		assertEquals(c.getTrieCount("pigs"), 3);
		assertEquals(c.getTrieCount("cow"), 0);
	}
	@Test
	void clearTrieTest() {
		c.setTrie(testing);
		assertTrue(c.trieContains("pig"));
		c.t.clear();
		assertTrue(!c.trieContains("pig"));
	}
	@Test
	void deleteTrieTest() {
		c.setTrie(testing);
		c.t.delete("cat");
		assertTrue(c.trieContains("cat"));
	}
	@Test
	void containsTrieTest() {
		c.setTrie(testing);
		assertTrue(c.t.contains("cat"));
	}
	@Test
	void AVLTest() {
		c.setAVL(testing);
		assertTrue(c.containsAVL("dog"));
		assertTrue(c.containsAVL("cat"));
		assertTrue(c.containsAVL("pig"));
		assertTrue(c.containsAVL("pigs"));
		assertTrue(!c.containsAVL("cow"));
	}
	@Test 
	void deleteAVLTest() {
		c.setAVL(testing);
		c.avl.remove("pig");
		assertTrue(!c.containsAVL("pig"));
	}
	@Test
	void hashTest() {
		c.setHash(testing);
		assertTrue(c.containsHash("pig"));
		assertTrue(c.containsHash("pigsies"));
		assertTrue(c.containsHash("dog"));
	}


}
