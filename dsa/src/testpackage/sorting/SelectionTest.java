package testpackage.sorting;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.text.Utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.sorting.Selection;
import com.tns.dsa.sorting.Sortable;
import com.tns.dsa.utility.ArrayUtility;

class SelectionTest {

	@Test
	void testGeneral() {
		
		// testing isArraySorted Utility 
		Assertions.assertEquals(false, ArrayUtility.isArraySorted(new int[] {}));
		Assertions.assertEquals(false, ArrayUtility.isArraySorted(new int[] {1, 4, 2, 3, 5}));
		
		Assertions.assertEquals(true, ArrayUtility.isArraySorted(new int[] {1}));
		Assertions.assertEquals(true, ArrayUtility.isArraySorted(new int[] {1, 2, 2, 3, 4}));
		
		Assertions.assertEquals(true, ArrayUtility.isArraySorted(new int[] {4, 3, 2, 2, 1}));
		
		// testing print and random generate array
//		int[] arr = ArrayUtility.randomDataIntArray(100, 10);
//		ArrayUtility.print(arr, "Testing");
	}
	
	@Test 
	void testSorting() {
		Sortable selection = new Selection();
		
		int[] unsortedArr = ArrayUtility.randomDataIntArray(100, 10);
		int[] sortedArr = selection.sortArray(unsortedArr);
		ArrayUtility.print(unsortedArr, "Before sort");
		ArrayUtility.print(sortedArr, "After sort");
		Assertions.assertEquals(true, ArrayUtility.isArraySorted(sortedArr));
	}

}
