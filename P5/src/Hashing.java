import java.io.*;
import java.math.*;
import java.util.*;
import java.net.URL;

public class Hashing {

	static int n;
	static int p;
	static final int[] aValues = {10, 33, 37, 39, 41};
	static final int numWords = 466500;
	static final int[] alphaValues = {10000, 100000, 200000};
	static final int[] betaValues = {50000, 150000};
	static Hashtable<Long, Integer> table = new Hashtable<>();
	static int[] totals;
	static int[] maxes;

	static long hashPolynomial(String s, int a) {
		int k = s.length();
		long hash = 0;
		for(int i = 0; i < k; i++) {
			long check = (long) (s.charAt(i) * Math.pow(a, k - (i+1)));
			hash += check;
		}
		return hash;//TO DO MODIFY TO ANSWER THE LAB QUESTION
	}
	static void performTasksPart1() throws IOException {
		for(int i = 0; i < aValues.length; i++) {
			Object[] nums = io(aValues[i]);
			System.out.println(aValues[i] + "                                 " + nums[0] + "                            " + nums[1]);
			table.clear();
		}
	}
	
	static Object[] io(int a) throws IOException {
		int num = 0;
		int max = 1;
		long index = 0;
		URL url = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt");
		try(Scanner sc = new Scanner(url.openStream())){
			while(sc.hasNext()) {
				String s = sc.next();
				long l = hashPolynomial(s, a);
				table.put(l, Integer.sum(table.getOrDefault(l, 0).intValue(), 1));
				int value = table.get(l).intValue();
				if(value == 2){
					num++;
				}
				if(value > max) {
					max = value;
					index = l;
				}
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return new Object[] {num, max, index};
	}
	static long compressionMAD(long i, int alpha, int beta) {
		return (((alpha * i) + beta) % p) % n;
	}
	
	static void performTasksPart2() throws IOException{
		for(int i = 0; i < alphaValues.length; i++) {
			for(int j = 0; j < betaValues.length; j++) {
				Object[] nums = io2(alphaValues[i], betaValues[j]);
				System.out.println(alphaValues[i] + "                          " + betaValues[j] + "                               " + nums[0] + "                              " + nums[1]);
				table.clear();
			}
		}
	}
	
	static Object[] io2(int alpha, int beta) throws IOException{
		int num = 0;
		int max = 1;
		long index = 0;
		URL url = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt");
		try(Scanner sc = new Scanner(url.openStream())){
			while(sc.hasNext()) {
				String s = sc.next();
				long polyL = hashPolynomial(s, 41);
				long l = compressionMAD(polyL, alpha, beta);
				table.put(l, Integer.sum(table.getOrDefault(l, 0).intValue(), 1));
				int value = table.get(l).intValue();
				if(value == 2) {
					num++;
				}
				if(value > max) {
					max = value;
					index = l;
				}
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		return new Object[] {num, max, index};
	}
	static void setNP() {
		n = (int) ((double) numWords * 1.2);
		int temp = n % 1000;
		if(temp >= 500) {n += (1000 - temp);}
		else { n -= temp;}
		BigInteger b = BigInteger.valueOf(n);
		p = b.nextProbablePrime().intValue();
	} 
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		performTasksPart1();
		setNP();
		performTasksPart2();
	}

}