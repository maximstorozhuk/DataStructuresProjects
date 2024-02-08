import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * For a bonus 2 marks explain why each test either passes or fails, please do this
 * in a separate text document submitted to Canvas
 */
public class BonusTest {
	static int [] A = {4, 5, 1, 3, 9, -1, 0};
    static int [] ASorted = {-1, 0, 1, 3, 4, 5, 9};
    static int [] B;

    @BeforeAll
    static void initialize() {
        B = A.clone();
        Arrays.sort(B);
    }

    @Test
    void testSortIntArrayEquals() {
        assertTrue(Arrays.equals(ASorted,B));
    }
    @Test
    void testSortIntArrayDeepEquals() {
        assertTrue(Objects.deepEquals(ASorted,B));
    }
    @Test
    void testSortIntAssertArrayEquals() {
        assertArrayEquals(ASorted,B);
    }
    @Test
    void testSortIntEquals() {
        assertFalse(B.equals(ASorted));
    }
    @Test
    void testSortIntAssertEquals() {
        assertNotEquals(ASorted, B);
    }
    @Test
    void testSortIntAssertIterableEquals() {
    	//if you are not familiar with autoboxing, the following line convert int to Integer
    	//see https://stackoverflow.com/questions/2607289/converting-array-to-list-in-java for the various
    	//methods to create an Iterable object
    	List<Integer> AS = Arrays.stream(ASorted).boxed().toList();
    	List<Integer> BS = Arrays.stream(B).boxed().toList();
    	assertIterableEquals(AS, BS);
    }
    @Test
    void testSortIntAssertDeepEquals() {
        //convert to Object[] to use deepEquals
        Integer[] ASortedo = new Integer[ASorted.length];
        for (int i=0; i < ASorted.length ; i++) ASortedo[i] = ASorted[i];
        Integer[] Bo = new Integer[B.length];
        for (int i=0; i < B.length ; i++) Bo[i] = B[i];
        assertTrue(Arrays.deepEquals(ASortedo,Bo));
    }
}
