import java.net.*;
import java.util.*;


public class Comparison {
	/*
	 * Copyright (c) 2017 William Fiset

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
	 */
	
	static String[] words;
	static Trie t;
	static AVLTreeRecursive<String> avl;
	static Hashtable<String, String> hash;
	
	public void setWords() {
		try {
			URL url = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt");
			try(Scanner sc = new Scanner(url.openStream());){
				ArrayList<String> wordsArr = new ArrayList<String>();
				while(sc.hasNext()) {
					wordsArr.add(sc.next());
				}
				words = new String[wordsArr.size()];
				for(int i = 0; i < words.length; i++) {
					words[i] = wordsArr.get(i);
				}
			} 
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public String[] getWords() {
		return words;
	}
	
	public void setTrie(String[] wordsToAdd) {
		t = new Trie();
		for(int i = 0; i < wordsToAdd.length; i++) {
			t.insert(wordsToAdd[i]);
		}
	}
	public boolean trieContains(String s) {
		return t.contains(s);
	}
	public int getTrieCount(String s) {
		return t.count(s);
	}
	
	public void setAVL(String[] wordsToAdd) {
		avl = new AVLTreeRecursive<String>();
		for(int i = 0; i < wordsToAdd.length; i++) {
			avl.insert(wordsToAdd[i]);
		}
	}
	
	public boolean containsAVL(String s) {
		return avl.contains(s);
	}
	
	public void setHash(String[] wordsToAdd) {
		hash = new Hashtable<String, String>();
		for(int i = 0; i < wordsToAdd.length; i++) {
			hash.put(wordsToAdd[i], wordsToAdd[i]);
		}
	}
	
	public boolean containsHash(String s) {
		return hash.containsKey(s);
	}
	
	
	
	
}
