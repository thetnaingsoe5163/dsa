package testpackage.dsaImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.dsaImpl.linkedList.DoublyLinkedList;
import com.tns.dsa.dsaImpl.linkedList.LinkedList;
import com.tns.dsa.utility.ArrayUtility;

import junit.framework.Assert;

class DoublyLinkedListTest {
	/*
	 * Test 1
	 * This is Testing Add method without index and get method with index
	 */
	
	/* peekPreviousWithIndex
	 * getWithIndex
	 * peekNextWithIndex
	 */
	@Test
	void testAddNone() {
		DoublyLinkedList doubly = new DoublyLinkedList();
		Assertions.assertEquals(-1, doubly.peekPreviousWithIndex(0));
		Assertions.assertEquals(-1, doubly.getWithIndex(0));
		Assertions.assertEquals(-1, doubly.peekNextWithIndex(0));
	}
	
	@Test
	void testAddOne() {
		DoublyLinkedList doubly = new DoublyLinkedList();
		doubly.add(10);
		Assertions.assertEquals(-1, doubly.peekPreviousWithIndex(0));
		Assertions.assertEquals(10, doubly.getWithIndex(0));
		Assertions.assertEquals(-1, doubly.peekNextWithIndex(0));
	}
	
	/*
	 * add(item)
	 * peekPreviousWithIndex
	 * getWithIndex
	 * peekNextWithIndex
	 */
	@Test
	void testMultipleAddWithRandomData() {
		DoublyLinkedList doubly = new DoublyLinkedList();
		int[] randomData = ArrayUtility.randomDataIntArray(100, 100);
		for(int i : randomData) {
			doubly.add(i);
		}
		doubly.iterate();
		System.out.println("================================");
		int length = randomData.length;
		if(length == 0) {
			int previous = doubly.peekPreviousWithIndex(0);
			int current = doubly.getWithIndex(0);
			int next = doubly.peekNextWithIndex(0);
			Assertions.assertEquals(previous, -1);
			Assertions.assertEquals(current, -1);
			Assertions.assertEquals(next, -1);
			return;
		}
		if(length == 1) {
			int previous = doubly.peekPreviousWithIndex(0);
			int current = doubly.getWithIndex(0);
			int next = doubly.peekNextWithIndex(0);
			Assertions.assertEquals(previous, -1);
			Assertions.assertEquals(current, randomData[0]);
			Assertions.assertEquals(next, -1);
			return;
		}
		if (length == 2) {
			int previous = doubly.peekPreviousWithIndex(1);
			int current = doubly.getWithIndex(1);
			int next = doubly.peekNextWithIndex(1);
			Assertions.assertEquals(previous, randomData[0]);
			Assertions.assertEquals(current, randomData[1]);
			Assertions.assertEquals(next, -1);
			return;
		}
		for(int i = 1; i < length-1; i++) {
			int previous = randomData[i-1];
			int current = randomData[i];
			int next = randomData[i+1];
			System.out.println(doubly.peekPreviousWithIndex(i)+ "\t" + doubly.getWithIndex(i)+ "\t" +doubly.peekNextWithIndex(i));
			Assertions.assertEquals(previous, doubly.peekPreviousWithIndex(i));
			Assertions.assertEquals(current, doubly.getWithIndex(i));
			Assertions.assertEquals(next, doubly.peekNextWithIndex(i));
		}
		int previous = doubly.peekPreviousWithIndex(0);
		int current = doubly.getWithIndex(0);
		int next = doubly.peekNextWithIndex(0);
//		System.out.printf("Node->\tP: %d\tC: %d\tN: %d\n", previous, current, next);
//		System.out.printf("Array->\tP: %d\tC: %d\tN: %d\n", randomData[0], randomData[1],);
		Assertions.assertEquals(previous, -1);
		Assertions.assertEquals(current, randomData[0]);
		Assertions.assertEquals(next, randomData[1]);
		
		int previous2 = doubly.peekPreviousWithIndex(length-1);
		int current2 = doubly.getWithIndex(length-1);
		int next2 = doubly.peekNextWithIndex(length-1);
		Assertions.assertEquals(previous2, randomData[length-2]);
		Assertions.assertEquals(current2, randomData[length-1]);
		Assertions.assertEquals(next2, -1);
	}
	// Test 1 completed
	
// ------------------------------------------------------------------------------------------------------------------------------------
	
	// Test 2
	
	/*
	 * This is testing addWitIndex
	 */
	
	@Test
	void addWithIndex1() {
		LinkedList doubly = new DoublyLinkedList();
		doubly.add(0, 1);
		Assertions.assertEquals(1, doubly.getWithIndex(0));
		Assertions.assertEquals(1, doubly.getSize());
		
		doubly.add(0, 2);
		Assertions.assertEquals(2, doubly.getWithIndex(0));
		Assertions.assertEquals(2, doubly.getSize());
		doubly.iterate();
		
		doubly.add(1, 3);
		
		doubly.iterate();
		Assertions.assertEquals(3, doubly.getWithIndex(1));
		Assertions.assertEquals(1, doubly.getWithIndex(2));
		Assertions.assertEquals(3, doubly.getSize());
		
		doubly.add(3, 10);
		Assertions.assertEquals(10, doubly.getWithIndex(3));
		Assertions.assertEquals(-1, doubly.getWithIndex(4));
		
		doubly.add(5, 20);
		Assertions.assertEquals(10, doubly.get());
		Assertions.assertEquals(-1, doubly.getWithIndex(5));
		
		doubly.iterate();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Test 3
	
	/*
	 * get()
	 * add(item)
	 * peekPrevious()
	 * peekNextWithIndex();
	 * 
	 */
	@Test
	void testGetMethodWithNoParametersAddingNoData() {
		LinkedList doubly = new DoublyLinkedList();
		Assertions.assertEquals(-1, doubly.get());
	}

	@Test
	void testGetMethodWithNoParametersAddingData() {
		LinkedList doubly = new DoublyLinkedList();
		int length = 10; 
		for(int i = 1; i <= length; i++) {
			doubly.add(i);
			if( i == 1) {
				Assertions.assertEquals(-1, doubly.peekPrevious());
				Assertions.assertEquals(i, doubly.get());
				Assertions.assertEquals(-1, doubly.peekNextWithIndex(i-1));
			}
			
			else if(i == length) {
				Assertions.assertEquals(length-1, doubly.peekPrevious());
				Assertions.assertEquals(i, doubly.get());
				Assertions.assertEquals(-1, doubly.peekNextWithIndex(i-1));
			}
			
			else {
				Assertions.assertEquals(i-1, doubly.peekPrevious());
				Assertions.assertEquals(i, doubly.get());
				Assertions.assertEquals(-1, doubly.peekNextWithIndex(i-1));
			}
			
		}
		
		Assertions.assertEquals(length-1, doubly.peekPrevious());
		Assertions.assertEquals(length, doubly.get());
	}
}
