package testpackage.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.sorting.Insertion;
import com.tns.dsa.sorting.Sortable;
import com.tns.dsa.utility.ArrayUtility;

class InsertionTest {

	@Test
	void test() {
		Sortable insertion = new Insertion();
		int[] unsortedArr = ArrayUtility.randomDataIntArray(100, 10);
		ArrayUtility.print(unsortedArr, "Before");
		int[] sortedArr = insertion.sortArray(unsortedArr);
		
		// if we write code in here instead of writing above sorted and unsorted data will be same
		// this is because they are referencing the same array object.
//		ArrayUtility.print(unsortedArr, "Before");
		
		ArrayUtility.print(sortedArr, "After");
		
		Assertions.assertEquals(true, ArrayUtility.isArraySorted(sortedArr));
	}

}
