package testpackage.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.search.LinearSearch;
import com.tns.dsa.search.Searchable;

class LinearSearchTest {

	@Test
	void searchBestCase() {
		int[] arr = {3, 5, 2, 1, 7, 9};
		Searchable linear = new LinearSearch(arr);
		Assertions.assertEquals(0, linear.search(3));
	}
	
	@Test
	void searchAverageCase() {
		int[] arr = {3, 5, 2, 1, 7, 9};
		Searchable linear = new LinearSearch(arr);
		Assertions.assertEquals(2, linear.search(2));
	}
	
	@Test
	void searchWorseCase() {
		int[] arr = {3, 5, 2, 1, 7, 9};
		Searchable linear = new LinearSearch(arr);
		Assertions.assertEquals(-1, linear.search(12));
	}
}
