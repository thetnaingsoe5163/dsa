package testpackage.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.sorting.Bubble;
import com.tns.dsa.sorting.Sortable;
import com.tns.dsa.utility.ArrayUtility;

class BubbleTest {

	@Test
	void test() {
		Sortable bubble = new Bubble();
		int[] unsortedArr = ArrayUtility.randomDataIntArray(100, 10);
		ArrayUtility.print(unsortedArr, "Before");
		int[] sortedArr = bubble.sortArray(unsortedArr);
		ArrayUtility.print(sortedArr, "After");
		
		Assertions.assertTrue(ArrayUtility.isArraySorted(sortedArr));
	}

}
