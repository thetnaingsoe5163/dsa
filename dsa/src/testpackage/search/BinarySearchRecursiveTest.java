package testpackage.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.search.BinarySearchRecursive;
import com.tns.dsa.search.Searchable;

class BinarySearchRecursiveTest {
	
	@Test
	void testNoData() {
		int[] arr = new int[] {};
		Searchable binary = new BinarySearchRecursive(arr);
		Assertions.assertEquals(-1, binary.search(10));
	}
	
	@Test
	void testManualy() {
		int[] arr = new int[] {1, 2, 3};
		Searchable binary = new BinarySearchRecursive(arr);
		
		Assertions.assertEquals(-1, binary.search(10));
		Assertions.assertEquals(0, binary.search(1));
		Assertions.assertEquals(1, binary.search(2));
		Assertions.assertEquals(2, binary.search(3));
	}
	
	@Test
	void testAuto() {
		int length = 100;
		int[] arr = new int[length];
		for(int i = 0; i < 100; i++) {
			arr[i] = i+1;
		}
		
		Searchable binary = new BinarySearchRecursive(arr);
		// in order
		for(int i = 0; i < length; i++) {
			Assertions.assertEquals(i, binary.search(i+1));
		}
		
		// reverse
		int value = length;
		for(int i = length-1; i >= 0; i--) {
			Assertions.assertEquals(i, binary.search(value--));
		}
	}

}
