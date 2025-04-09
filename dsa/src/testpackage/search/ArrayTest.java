package testpackage.search;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.search.Array;

class ArrayTest {

	@Test
	void get() {
		int[] arr = {1, 2, 3, 4, 5};
		Array items = new Array(arr);
		Assertions.assertEquals(5, items.get(4));
	}

}
