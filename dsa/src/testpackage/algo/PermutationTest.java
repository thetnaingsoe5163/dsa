package testpackage.algo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.tns.dsa.algo.Permutation;
import com.tns.dsa.utility.General;

class PermutationTest {
	
	Permutation p = new Permutation();
	
	@Test
	void testSwap() {
		StringBuilder sb1 = new StringBuilder("Hello");
		StringBuilder sb2 = new StringBuilder("leHlo");
		assertTrue(p.swap(sb1, 0, 2).toString().equals(sb2.toString()));
	}
	
	@Test
	void testGetChild() {
		StringBuilder sb1 = new StringBuilder("ABCD");
		var list = p.getChildSwappedValues(sb1, 0);
		assertEquals(4, list.size());
		
//		for(var l : list) {
//			System.out.println(l);
//		}
		
		assertEquals("ABCD", list.get(0).toString());
		assertEquals("BACD", list.get(1).toString());
		assertEquals("CBAD", list.get(2).toString());
		assertEquals("DBCA", list.get(3).toString());
		
		StringBuilder sb2 = new StringBuilder("AB");
		var list2 = p.getChildSwappedValues(sb2, 0);
		assertEquals(2, list2.size());
		
//		for(var l : list2) {
//			System.out.println(l);
//		}
		
		assertEquals("AB", list2.get(0).toString());
		assertEquals("BA", list2.get(1).toString());
		
		StringBuilder sb3 = new StringBuilder("ABCD");
		var list3 = p.getChildSwappedValues(sb1, 1);
		assertEquals(3, list3.size());
		
//		for(var l : list3) {
//			System.out.println(l);
//		}
		
		assertEquals("ABCD", list3.get(0).toString());
		assertEquals("ACBD", list3.get(1).toString());
		assertEquals("ADCB", list3.get(2).toString());
		
		StringBuilder sb4 = new StringBuilder("ABCD");
		var list4 = p.getChildSwappedValues(sb1, 2);
		assertEquals(2, list4.size());
		
//		for(var l : list4) {
//			System.out.println(l);
//		}
		
		assertEquals("ABCD", list4.get(0).toString());
		assertEquals("ABDC", list4.get(1).toString());
	}
	
	@Test
	void testFactorial() {
		assertEquals(1, General.factorial(1));
		assertEquals(2, General.factorial(2));
		
		assertEquals(6, General.factorial(3));
		assertEquals(24, General.factorial(4));
	}
	
	@Test
	void testUniqueData() {
		ArrayList<String> list = new ArrayList();
		list.add("AB");
		list.add("AC");
		list.add("AD");
		assertEquals(true, General.uniqueData(list));
		
		list.add("AB");
		assertEquals(false, General.uniqueData(list));
	}
	
	@Test
	void testPermuteBaseCase() {
		var list = p.permute("AB", 0);
		assertEquals(2, list.size());
		
		assertEquals("AB", list.get(0));
		assertEquals("BA", list.get(1));
		
		assertEquals(true, General.uniqueData(list));
	}
	
	@Test
	void testPermuteNormalCase() {
		var list = p.permute("ABC", 0);
		assertEquals(6, list.size());
		
		assertEquals("ABC", list.get(0));
		assertEquals("ACB", list.get(1));
		assertEquals("BAC", list.get(2));
		assertEquals("BCA", list.get(3));
		assertEquals("CBA", list.get(4));
		assertEquals("CAB", list.get(5));
		
		assertEquals(true, General.uniqueData(list));
	}
	
	@Test
	void testPermuteCompelex() {
		var list = p.permute("ABCD", 0);
		assertEquals(General.factorial(4), list.size());
		
		assertEquals(true, General.uniqueData(list));
	}
	
	@Test
	void testPermuteMoreComplex() {
		var list = p.permute("ABCDEF", 0);		
		assertEquals(General.factorial(6), list.size());
		
		assertEquals(true, General.uniqueData(list));
		
		list.add("ADCBEF");
		assertEquals(false, General.uniqueData(list));
	}

}
