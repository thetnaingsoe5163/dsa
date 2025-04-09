package testpackage.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.sorting.QuickSort;
import com.tns.dsa.sorting.Sortable;
import com.tns.dsa.utility.ArrayUtility;

class QuickSortTest {

	Sortable quick = new QuickSort();
	
//	@Test
//	void test2Elements() {
//		int[] arr = {4,2};
//		arr = quick.sortArray(arr); 
//		Assertions.assertEquals(2, arr[0]);
//		Assertions.assertEquals(4, arr[1]);
//	}
	
	@Test
	void testBaseCase() {
		int[] arr = {5, 200, 25, 4, 13, 40, 20};
		arr = quick.sortArray(arr);
		Assertions.assertEquals(true, ArrayUtility.isArraySorted(arr));
	}

}
