package testpackage.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.search.BinarySearch;
import com.tns.dsa.search.Searchable;

class BinarySearchTest {
	
	@Test
	void searchBestCase() {
		int[] arr = {1, 2, 3, 4, 5};
		Searchable binary = new BinarySearch(arr);
		Assertions.assertEquals(2, binary.search(3));
	}
	
	@Test
	void searchAverageCase() {
		int[] arr = {1, 2, 3, 4, 5};
		Searchable binary = new BinarySearch(arr);
		Assertions.assertEquals(1, binary.search(2));
	}
	
	@Test
	void searchWorseCase() {
		int[] arr = {1, 2, 3, 4, 5};
		Searchable binary = new BinarySearch(arr);
		Assertions.assertEquals(4, binary.search(5));
	}
}
