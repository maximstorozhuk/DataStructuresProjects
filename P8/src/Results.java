
public class Results {

	/*
	 * Will comment out the rest of the code in this class because it skews the coverage testing.
	 * You can uncomment if you want to recreate the findings
	 * Here are the results for finding every word in the file
	 * Trie: ~0.120-0.160 seconds
	 * AVL (Balanced Binary Search Tree): ~0.120-0.160 seconds
	 * HashTable: ~0.055-0.075 seconds
	 */
	
	/*
	
	public static void main(String[] args) {
		Comparison c = new Comparison();
		System.out.println("Trie: " + timeForAllWordsTrie(c) + "s");
		System.out.println("AVL: " + timeForAllWordsAVL(c) + "s");
		System.out.println("Hash: " + timeForAllWordsHash(c) + "s");

	}
	
	static double timeForAllWordsTrie(Comparison c) {
		c.setWords();
		c.setTrie(c.getWords());
		boolean[] arr = new boolean[c.getWords().length];
		long l1 = System.currentTimeMillis();
		for(int i = 0; i < c.words.length; i++) {
			arr[i] = c.trieContains(c.words[i]);
		}
		long l2 = System.currentTimeMillis();
		return (l2 - l1) / 1000.0;
	}
	
	static double timeForAllWordsAVL(Comparison c) {
		c.setAVL(c.getWords());
		boolean[] arr = new boolean[c.getWords().length];
		long l1 = System.currentTimeMillis();
		for(int i = 0; i < c.words.length; i++) {
			arr[i] = c.containsAVL(c.words[i]);
		}
		long l2 = System.currentTimeMillis();
		return (l2 - l1) / 1000.0;
	}
	
	static double timeForAllWordsHash(Comparison c) {
		c.setHash(c.getWords());
		boolean[] arr = new boolean[c.getWords().length];
		long l1 = System.currentTimeMillis();
		for(int i = 0; i < c.words.length; i++) {
			arr[i] = c.containsHash(c.words[i]);
		}
		long l2 = System.currentTimeMillis();
		return (l2 - l1) / 1000.0;
	}
	*/

}
