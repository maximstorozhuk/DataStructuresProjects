import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/**
 * Note that an array of integers are expected
 * 
 * Remember to site sources if you use code from online!
 */

// Used https://www.vogella.com/tutorials/JUnit4/article.html for the IntSortTest.java class
public class IntSort {

	//you may use this to check that your test cases are correct
    public static int[] sort(int[] arr){
    	int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        return arrCopy;
    }

    public static int[] InsertionSort(int[] orgArr){
        //TODO: implement insertion sort as described at https://en.wikipedia.org/wiki/Insertion_sort
    	int[] arr = orgArr.clone();
    	for(int i = 1; i < orgArr.length; i++)
    	{
    		int elem = orgArr[i];
    		int temp = 0;
    		int idx = 0;
    		do {if(arr[idx] > elem) {
    			while(idx < orgArr.length) {
    				temp = arr[idx];
    				arr[idx] = elem;
    				elem = temp;
    				idx++;
    			}
    			break;
    		}
    		idx++;	
    		}while(idx < i);
    	}
    	// return arr sorted
        return arr;
    }
    
    // assumes values in array range from [0,numBuckets]
    public static int[] CountingSort(int[] array, int numBuckets){
    //TODO: implement counting sort as described at any of the following links:
	//http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/countingSort.htm
	//https://en.wikipedia.org/wiki/Counting_sort
    	
    	int[] counter = new int[numBuckets + 1];
    	int[] sorted = new int[array.length];
    	for(int i = 0; i < array.length; i++)
    	{
    		counter[array[i]]++;
    	}
    	for(int i = 1; i < counter.length; i++)
    	{
    		counter[i] = counter[i] + counter[i-1];
    	}
    	for(int i = array.length - 1; i >= 0; i--) {
    		sorted[counter[array[i]]-- - 1] = array[i]; 
    	}
    	// Ensure not to alter the original array
    	return sorted;
    }
    //Data structure and sorting algorithms are visualized at https://cmps-people.ok.ubc.ca/ylucet/DS/Algorithms.html
	//in particular see insertion and counting sort

}
