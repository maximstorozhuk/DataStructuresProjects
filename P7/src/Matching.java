import java.util.*;
import java.net.*;
import java.io.*;

/*Copyright (c) 2017 William Fiset

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/strings/KMP.java
*/

public class Matching {

	static String[] arr;
	static String[] arrAfter;
	static char[] defaultArr = {'d','e','f','a','u','l','t'};
	static final int MAX_ALPHABET_SIZE = 256;
	
	
	
	
	
	public static int findKMP(char[] text, char[] pattern){
		//Didn't copy and paste, but took heavy inspiration from licensed code at top of java file
		if(isItDefault(text)) {
			text = defaultText();
		}
		int numComparisons = 0;
		int numMatches = 0;
		if(text == null || pattern == null || pattern.length > text.length) {
			return 0;
		}
		int m = pattern.length;
		int n = text.length;
		int i = 0;
		int j = 0;
		int[] array = kmpHelper(pattern, m);
		while(i < n) {
			if(pattern[j] == text[i]) {
				i++;
				j++;
			}
			numComparisons++;
			if(j == m) {
				numMatches++;
				j = array[j-1];
				numComparisons++;
			} else if(i < n && pattern[j] != text[i]){
				numComparisons++;
				if(j != 0) {
					j = array[j-1];
					numComparisons++;
				} else {
					i = i+1;
					numComparisons++;
				}
			}
		}
		System.out.println("There were " + numComparisons + " comparisons in this KMP algorithm running.");
		return numMatches;
	}
	
	public static int[] kmpHelper(char[] pattern, int m) {
		int[] array = new int[m];
		for(int i = 1, len = 0; i < m;) {
			if(pattern[i] == pattern[len]) {
				array[i++] = ++len;
			} else {
				if(len > 0) {
					len = array[len - 1];
				} else {
					i++;
				}
			}
		}
		return array;
	}
	
	public static int findBoyerMoore(char[] text, char[] pattern){	
		//Didn't copy and paste, but took heavy inspiration from licensed code at top of java file
		if(isItDefault(text)) {
			text = defaultText();
		}
		int numComparisons = 0;
		int numMatches = 0;
		if(text == null || pattern == null || pattern.length > text.length) {
			return 0;
		}
		int[] skipTable = generateSkipTable(pattern);
		int n = pattern.length;
		for(int textIndex = n - 1, patternIndex = n - 1; textIndex < text.length;) {
			if(patternIndex >= 0 && pattern[patternIndex] == text[textIndex]) {
				numComparisons++;
				if(patternIndex == 0) {
					numComparisons++;
					numMatches++;
				} else {
					numComparisons++;
					textIndex--;
				}
				patternIndex--;
			} else {
				numComparisons++;
				textIndex += n - Math.min(Math.max(patternIndex, 0), skipTable[text[textIndex]] + 1);
				patternIndex = n-1;
			}
		}
		System.out.println("There were " + numComparisons + " comparisons in this Boyer-Moore algorithm running.");
		return numMatches;
	}
	
	public static int[] generateSkipTable(char[] pattern) {
		int[] skipTable = new int[MAX_ALPHABET_SIZE];
		for(int i = 0; i < pattern.length; i++) {
			skipTable[pattern[i]] = i;
		}
		return skipTable;
	}
	
	public static int findBrute(char[] text, char[] pattern){
		//Did this one myself
		if(isItDefault(text)) {
			text = defaultText();
		}
		int numComparisons = 0;
		int numMatches = 0;
		if(text == null || pattern == null || pattern.length > text.length) {
			return 0;
		}
		int n = pattern.length;
		for(int i = 0; i < text.length - n + 1; i++) {
			int[] comparison = new int[n];
			boolean done = true;
			for(int j = 0; j < n; j++) {
				comparison[j] = text[i + j];
			}
			for(int j = 0; j < n; j++) {
				if(comparison[j] != pattern[j]) {
					numComparisons++;
					done = false;
					break;
				}
				numComparisons++;
			}
			if(done) {numMatches++;}
		}
		System.out.println("There were " + numComparisons + " comparisons in this Brute Force algorithm running.");
		return numMatches;
	}
	
	
	
	public static int findRabinKarp(char[] text, char[] pattern){	
		//Did this one myself
		if(isItDefault(text)) {
			text = defaultText();
		}
		int numComparisons = 0;
		int numMatches = 0;
		if(text == null || pattern == null || pattern.length > text.length) {
			return 0;
		}
		String strPat = "";
		String strText = "";
		for(int i = 0; i < pattern.length; i++) {
			strPat += pattern[i];
			strText += text[i];
		}
		long patPoly = strPat.hashCode();
		long txtPoly = strText.hashCode();
		for(int i = 0; i < text.length - pattern.length + 1; i++) {
			if(patPoly == txtPoly) {
				numComparisons++;
				numMatches++;
			}else {
				numComparisons++;
			}
			if(i == text.length - pattern.length) {
				break;
			}
			strText = strText.substring(1, pattern.length) + text[i + pattern.length];
			txtPoly = strText.hashCode();
		}
		System.out.println("There were " + numComparisons + " comparisons in this Rabin Karp algorithm running.");
		return numMatches;
	}
	
	public static void importWords(){
		arr = new String[100];
		try {
			URL url = new URL("https://learn.microsoft.com/en-us/dotnet/core/testing/unit-testing-best-practices");
			try(Scanner sc = new Scanner(url.openStream());){
				for(int i = 0; i < 100; i++) {
					arr[i] = sc.next();
				}
			} catch(Exception e) {
				System.out.println(e.toString());
			}
		} catch(MalformedURLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static boolean isItDefault(char[] text) {
		if(text.length != 7) {
			return false;
		}
		String s = "";
		for(int i = 0; i < 7; i++) {
			s += text[i];
		}
		if(s.equals("default")) {
			return true;
		} else
		return false;
	}
	
	public static char[] defaultText(){
		importWords();
		ArrayList<Character> array = new ArrayList<Character>();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length(); j++) {
				array.add(arr[i].charAt(j));
			}
		}
		char[] returnable = new char[array.size()];
		for(int i = 0; i < returnable.length; i++) {
			returnable[i] = array.get(i);
		}
		return returnable;
	}
	
	public static void main(String[] args){
		//Uncomment the below lines of code if you want to recreate the findings from the submitted pdf
		/*
		importWords();
		char[] defaultPat = {'a', 'n'};
		System.out.println("There were " + findKMP(defaultArr, defaultPat) + " matches found \n");
		System.out.println("There were " + findBoyerMoore(defaultArr, defaultPat) + " matches found \n");
		System.out.println("There were " + findBrute(defaultArr, defaultPat) + " matches found \n");
		System.out.println("There were " + findRabinKarp(defaultArr, defaultPat) + " matches found \n");
		char[] dna = importDNA();
		char[] dnaPat1 = {'A', 'A'};
		System.out.println("There were " + findKMP(dna, dnaPat1) + " matches found \n");
		System.out.println("There were " + findBoyerMoore(dna, dnaPat1) + " matches found \n");
		System.out.println("There were " + findBrute(dna, dnaPat1) + " matches found \n");
		System.out.println("There were " + findRabinKarp(dna, dnaPat1) + " matches found \n");
		char[] dnaPat2 = {'A', 'A', 'G', 'G', 'A', 'G'};
		System.out.println("There were " + findKMP(dna, dnaPat2) + " matches found \n");
		System.out.println("There were " + findBoyerMoore(dna, dnaPat2) + " matches found \n");
		System.out.println("There were " + findBrute(dna, dnaPat2) + " matches found \n");
		System.out.println("There were " + findRabinKarp(dna, dnaPat2) + " matches found \n");
		char[] dnaPat3 = {'A','T','T','G','C','A','T','T','G','C','C','A','T'};
		System.out.println("There were " + findKMP(dna, dnaPat3) + " matches found \n");
		System.out.println("There were " + findBoyerMoore(dna, dnaPat3) + " matches found \n");
		System.out.println("There were " + findBrute(dna, dnaPat3) + " matches found \n");
		System.out.println("There were " + findRabinKarp(dna, dnaPat3) + " matches found \n \n \n \n");
		char[] shakespeare = importShakespeare();
		char[] sPat1 = {'e', 'd'};
		System.out.println("There were " + findKMP(shakespeare, sPat1) + " matches found \n");
		System.out.println("There were " + findBoyerMoore(shakespeare, sPat1) + " matches found \n");
		System.out.println("There were " + findBrute(shakespeare, sPat1) + " matches found \n");
		System.out.println("There were " + findRabinKarp(shakespeare, sPat1) + " matches found \n");
		char[] sPat2 = {'a', 'n', 'd'};
		System.out.println("There were " + findKMP(shakespeare, sPat2) + " matches found \n");
		System.out.println("There were " + findBoyerMoore(shakespeare, sPat2) + " matches found \n");
		System.out.println("There were " + findBrute(shakespeare, sPat2) + " matches found \n");
		System.out.println("There were " + findRabinKarp(shakespeare, sPat2) + " matches found \n");
		char[] sPat3 = {'t', 'h', 'y', 's', 'e', 'l', 'f', 't', 'h', 'y'};
		System.out.println("There were " + findKMP(shakespeare, sPat3) + " matches found \n");
		System.out.println("There were " + findBoyerMoore(shakespeare, sPat3) + " matches found \n");
		System.out.println("There were " + findBrute(shakespeare, sPat3) + " matches found \n");
		System.out.println("There were " + findRabinKarp(shakespeare, sPat3) + " matches found \n");
		*/
		
		

	}

	/*
	 * All of the rest of the code is used for finding additional results, but is commented out because of coverage testing requirements
	 * Uncomment the code if you want to see it function
	 */
	
	/*
	
	public static char[] importDNA() {
		ArrayList<Character> dnarray = new ArrayList<Character>(10000);
		try {
			File f = new File("C:/Eclipse/COSC222Assignments/lab7-maximstorozhuk/Lab7/src/dna.txt");
			try(Scanner sc = new Scanner(f);) {
				String s = sc.next();
				for(int i = 0; i < s.length(); i++) {
					dnarray.add(s.charAt(i));
				}
			} catch(Exception e) {
				System.out.println(e.toString());
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		char[] dnaray = new char[dnarray.size()];
		for(int i = 0; i < dnaray.length; i++) {
			dnaray[i] = dnarray.get(i);
		}
		return dnaray;
	}
	
	public static char[] importShakespeare() {
		ArrayList<Character> sharray = new ArrayList<Character>(100000);
		try {
			File f = new File("C:/Eclipse/COSC222Assignments/lab7-maximstorozhuk/Lab7/src/shakespeare.txt");
			try(Scanner sc = new Scanner(f);){
				while(sc.hasNext()) {
					String s = sc.next();
					for(int i = 0; i < s.length(); i++) {
						sharray.add(s.charAt(i));
					}
				}
			} catch(Exception e) {
				System.out.println(e.toString());
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		char[] sharay = new char[sharray.size()];
		for(int i = 0; i < sharay.length; i++) {
			sharay[i] = sharray.get(i);
		}
		return sharay;
	}
	*/
	
	
	
}
