import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class IntSortTest {

	static IntSort sort;
	static int[] arr1 = {1, 4, 5, 3, 2};
	static int[] arr2 = {1, 2, 3, 4, 5};
	static int[] arr3 = {5, 4, 3, 2, 1};
	static int[] arr4 = new int[1];
	static int numBuckets = 5;
	@Before
	public void setUp() {
		sort = new IntSort();
	}
	
	@Test
	public void testInsertionSort1() {
		int[] results = sort.InsertionSort(arr1);
		int[] expected = sort.sort(arr1);
		assertArrayEquals(results, expected);
	}
	
	@Test
	public void testInsertionSort2() {
		int[] results = sort.InsertionSort(arr2);
		int[] expected = sort.sort(arr2);
		assertArrayEquals(results,expected);
	}
	
	@Test
	public void testInsertionSort3() {
		int[] results = sort.InsertionSort(arr3);
		int[] expected = sort.sort(arr3);
		assertArrayEquals(results, expected);
	}
	
	@Test
	public void testInsertionSort4() {
		int[] results = sort.InsertionSort(arr4);
		int[] expected = sort.sort(arr4);
		assertArrayEquals(results, expected);
	}
	
	@Test
	public void testCountingSort1() {
		int[] results = sort.CountingSort(arr1, numBuckets);
		int[] expected = sort.sort(arr1);
		assertArrayEquals(results, expected);
	}
	
	@Test
	public void testCountingSort2() {
		int[] results = sort.CountingSort(arr2, numBuckets);
		int[] expected = sort.sort(arr2);
		assertArrayEquals(results,expected);
	}
	
	@Test
	public void testCountingSort3() {
		int[] results = sort.CountingSort(arr3, numBuckets);
		int[] expected = sort.sort(arr3);
		assertArrayEquals(results, expected);
	}
	
	@Test
	public void testCountingSort4() {
		int[] results = sort.CountingSort(arr4, numBuckets);
		int[] expected = sort.sort(arr4);
		assertArrayEquals(results, expected);
	}
	
	
	
}
