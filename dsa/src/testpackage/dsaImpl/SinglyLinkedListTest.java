package testpackage.dsaImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.dsaImpl.linkedList.LinkedList;
import com.tns.dsa.dsaImpl.linkedList.SinglyLinkedList;
import com.tns.dsa.utility.ArrayUtility;

/*
 * completed testing
 */
class SinglyLinkedListTest {

	/*
	 * getSize
	 * getWithIndex
	 * add without index;
	 */
//	@Test
	void generalTest() {
		LinkedList singly = new SinglyLinkedList();
		singly.add(1);
		singly.add(2);
		singly.add(3);
		singly.add(4);
		;
		
		Assertions.assertEquals(4, singly.getSize());
		Assertions.assertEquals(1, singly.getWithIndex(0));
		Assertions.assertEquals(2, singly.getWithIndex(1));
		Assertions.assertEquals(3, singly.getWithIndex(2));
		Assertions.assertEquals(4, singly.getWithIndex(3));
		Assertions.assertEquals(-1, singly.getWithIndex(10));
		
		//need to check
		Assertions.assertEquals(1, singly.removeWithItem(1));
//		
		// success
//		Assertions.assertEquals(4, singly.remove(4));
//		Assertions.assertEquals(3, singly.remove(3));
		
		Assertions.assertEquals(-1, singly.removeWithItem(10));
		
		System.out.println("");
		;
	}
	
	// Manual Testing
//	@Test
	void getAndDelete() {
		Scanner input = new Scanner(System.in);
		LinkedList singly = new SinglyLinkedList();
		int[] randomData = ArrayUtility.randomDataIntArray(100, 10);
		for(int i : randomData) {
			singly.add(i);
		}
		;
		
		// Testing get with index 
		boolean decision = true;
		System.out.println("");
		while(decision) {
			System.out.print("Enter index: ");
			int index = Integer.parseInt(input.nextLine());
			System.out.printf("Index: %d = %d%n", index, singly.getWithIndex(index));
			System.out.print("Do you want to exit y/n : ");
			decision = !input.nextLine().equalsIgnoreCase("y");
		}
		
		// Testing remove with item
//		decision = true;
//		while(decision) {
//			System.out.print("Enter item to be removed : ");
//			int item = Integer.parseInt(input.nextLine());
//			System.out.println("");
//			int beforeSize = singly.getSize();
//			System.out.print("Item " + singly.removeWithItem(item) + " is removed");
//			int afterSize = singly.getSize();
//			Assertions.assertEquals(beforeSize-1, afterSize);
//			;
//			System.out.print("Do you want to exit y/n : ");
//			decision = !input.nextLine().equalsIgnoreCase("y");
//		}
		
		// Testing get with no parameter
		int item = singly.get();
		System.out.println("Item : " + item);
	}
	
	// Auto Testing
	@Test
	void get() {
		LinkedList singly = new SinglyLinkedList();
		int[] randomData = ArrayUtility.randomDataIntArray(100, 500);
		for(int i : randomData) {
			singly.add(i);
		}
		int length = randomData.length;
		for(int i = 0; i < length; i++) {
			Assertions.assertEquals(singly.getWithIndex(i), randomData[i]);
		}
	}
	
//	@Test
//	void clear() {
//		LinkedList singly = new SinglyLinkedList();
//		Scanner sc = new Scanner(System.in);
//		int[] randomData = ArrayUtility.randomDataIntArray(100, 500);
//		for(int i : randomData) {
//			singly.add(i);
//		}
//		;
//		System.out.print("Clear? y/n: ");
//		if(sc.nextLine().equalsIgnoreCase("y")) {
//			singly.clear();
//			;
//		} else {
//			System.out.println("Not Clear");
//		}
//	}
	
//	@Test
//	void addWithIndex() {
//		Scanner input = new Scanner(System.in);
//		LinkedList singly = new SinglyLinkedList();
//		boolean decision = true;
//		int[] randomData = ArrayUtility.randomDataIntArray(100, 10);
//		
//		for(int i : randomData) {
//			singly.add(i);
//		}
//		;
//		
//		while(decision) {
//			System.out.print("Enter index to add : ");
//			int index = Integer.parseInt(input.nextLine());
//			System.out.print("Enter item to be add : ");
//			int item = Integer.parseInt(input.nextLine());
//			singly.add(index, item);
//			;
//			System.out.print("Do you want to exit y/n : ");
//			decision = !input.nextLine().equalsIgnoreCase("y");
//		}
//		
//	}
	
//	@Test
//	void peekNext() {
//		Scanner input = new Scanner(System.in);
//		LinkedList singly = new SinglyLinkedList();
//		boolean decision = true;
//		int[] randomData = ArrayUtility.randomDataIntArray(100, 10);
//		
//		for(int i : randomData) {
//			singly.add(i);
//		}
//		;
//		
//		while(decision) {
//			System.out.print("Enter item to peek : ");
//			int item = Integer.parseInt(input.nextLine());
//			int peekedItem = singly.peekNext(item);
//			System.out.println("\nPeek Next Item : " + peekedItem);
//			System.out.print("Do you want to exit y/n : ");
//			decision = !input.nextLine().equalsIgnoreCase("y");
//		}		
//	}
	
//	@Test
//	void remove() {
//		Scanner sc = new Scanner(System.in);
//		LinkedList singly = new SinglyLinkedList();
//		boolean decision = true;
//		int[] randomData = ArrayUtility.randomDataIntArray(100, 2000);
//		
//		for(int i : randomData) {
//			singly.add(i);
//		}
////		;
//		
//		int length = randomData.length;
//		for(int i = 0; i < length; i++) {
//			int data = singly.removeWithItem(randomData[i]);
//			System.out.println("Ran: " + randomData[i] + "\tRemove: " + data);
//			Assertions.assertEquals(randomData[i], data); 
//		}
//		;
//		
//	}
	
	/*
	 * add without index and add with index
	 * get size
	 * get with no parameter
	 * get with index
	 * get with item
	 */
	@Test
	public void addAndGet() {
		LinkedList singly = new SinglyLinkedList();
		int beforeSize = 0;
		int afterSize = 0;
		
		for(int i = 1; i <= 100; i++) {
			beforeSize = singly.getSize();
			singly.add(i);
			afterSize = singly.getSize();
			Assertions.assertEquals(beforeSize+1, afterSize);
			Assertions.assertEquals(i, singly.get());
		}
		
		// getWithItem
		for(int i = 1; i <= 100; i++) {
			Assertions.assertEquals(i, singly.getWithItem(i));
		}
		
		// worse case no item found
		Assertions.assertEquals(-1, singly.getWithItem(101));
		
		// Adding last position
		int lastItem = singly.get();
		beforeSize = singly.getSize();
		singly.add(99, 78);
		afterSize = singly.getSize();
		Assertions.assertEquals(78, singly.getWithIndex(99));
		Assertions.assertEquals(lastItem, singly.get());
		Assertions.assertEquals(lastItem, singly.getWithIndex(100));
		Assertions.assertEquals(beforeSize+1, afterSize);
		
		
		// Adding at the first positon
		int firstItem = singly.getWithIndex(0);
		beforeSize = singly.getSize();
		singly.add(0, 213);
		afterSize = singly.getSize();
		
		Assertions.assertEquals(213, singly.getWithIndex(0));
		Assertions.assertEquals(firstItem, singly.getWithIndex(1));
		
		Assertions.assertEquals(beforeSize+1, afterSize);
		
	}
	
	@Test
	void addWithIndex1() {
		LinkedList singly = new SinglyLinkedList();
		singly.add(0, 10);
		System.out.println("Adding 0 index");
		singly.iterate();
		
		singly.add(0, 20);
		System.out.println("Adding 20 at 0 index");
		singly.iterate();
		Assertions.assertEquals(20, singly.getWithIndex(0));
		Assertions.assertEquals(10, singly.getWithIndex(1));
	}
	
	@Test
	void addWithIndex2() {
		LinkedList singly = new SinglyLinkedList();
		singly.add(0, 1);
		Assertions.assertEquals(1, singly.get());
		Assertions.assertEquals(1, singly.getSize());
		Assertions.assertEquals(1, singly.getWithIndex(0));
	}
	
	@Test
	void addWithIndex3() {
		LinkedList singly = new SinglyLinkedList();
		singly.add(1, 1);
		Assertions.assertEquals(1, singly.get());
		Assertions.assertEquals(1, singly.getSize());
		Assertions.assertEquals(1, singly.getWithIndex(0));
	}
	
	@Test
	void addWithIndex4() {
		LinkedList singly = new SinglyLinkedList();
		int length = 100;
		int beforeSize = 0;
		int aferSize = 0;
		
		for(int i = 1; i <= length; i++) {
			singly.add(i-1, i);
			Assertions.assertEquals(++beforeSize, singly.getSize());
		}
		
		int item = length;
		for(int i = 0; i < length; i++) {
			Assertions.assertEquals(item, singly.getWithIndex(item-1));
			item--;
		}
	}
	
	@Test
	void addWithIndex5() {
		LinkedList singly = new SinglyLinkedList();
		singly.add(1);
		singly.add(2);
		singly.add(3);
		singly.add(4);
		singly.add(5);
		
		Assertions.assertEquals(3, singly.getWithIndex(2));
		
		singly.add(2, 30);
		Assertions.assertEquals(30, singly.getWithIndex(2));
		Assertions.assertEquals(3, singly.getWithIndex(3));
		Assertions.assertEquals(5, singly.getWithIndex(5));
		
		singly.add(0, 10);
		Assertions.assertEquals(10, singly.getWithIndex(0));
		Assertions.assertEquals(1, singly.getWithIndex(1));
		Assertions.assertEquals(5, singly.getWithIndex(6));
		
		singly.add(6, 50);
		Assertions.assertEquals(50, singly.getWithIndex(6));
		Assertions.assertEquals(5, singly.getWithIndex(7));
		
	}
	
	/*
	 * peekNextWithIndex/ Item;
	 * No node and one node;
	 */
	@Test
	public void peekNextForNoNodeAndOneNode() {
		LinkedList singly = new SinglyLinkedList();
		Assertions.assertEquals(-1, singly.peekNextWithIndex(0));
		Assertions.assertEquals(-1, singly.peekNextWithItem(0));
		singly.add(1);
		Assertions.assertEquals(-1, singly.peekNextWithIndex(0));
		Assertions.assertEquals(-1, singly.peekNextWithItem(1));
	}
	/*
	 * add with item
	 * peekNextWithIndex
	 */
	@Test
	public void peekNextWithIndex() {
		LinkedList singly = new SinglyLinkedList();
		int[] arr = ArrayUtility.randomDataIntArray(500, 100);
		int length = arr.length;
		for(int i = 0; i < length; i++) {
			singly.add(arr[i]);
		}
//		;
		for(int i = 0; i < length-1; i++) {
			int listPeek = singly.peekNextWithIndex(i);
			int arrPeek = arr[i+1];
//			System.out.println("List Peek : " + listPeek + " Arr Peek: " + arrPeek);
			Assertions.assertEquals(listPeek, arrPeek);
		}
		
		// Testing next item of the last index 
		Assertions.assertEquals(-1, singly.peekNextWithIndex(length-1));
	}
	
	/*
	 * add with item
	 * getSize
	 * peekNextWithItem
	 */
	@Test
	public void peekNextWithItem() {
		LinkedList singly = new SinglyLinkedList();
		for(int i = 1; i <= 100; i++) {
			singly.add(i);
		}
		int size = singly.getSize();
		Assertions.assertEquals(100, size);
		
		for(int i = 1; i < size; i++) {
			Assertions.assertEquals(i+1, singly.peekNextWithItem(i));
		}
		
		// worse case putting not exist item found
		Assertions.assertEquals(-1, singly.peekNextWithItem(101));
		
		// worse case peeking next of last item
		Assertions.assertEquals(-1, singly.peekNextWithItem(100));
	}
	/*
	 * Remove 0 item 1 item 2 item
	 */
	@Test
	public void remove() {
		LinkedList singly = new SinglyLinkedList();
		int beforeSize = singly.getSize();
		Assertions.assertEquals(-1, singly.remove());
		int afterSize = singly.getSize();
		Assertions.assertEquals(beforeSize, afterSize);
		
		singly.add(1);
		beforeSize = singly.getSize();
		Assertions.assertEquals(1, singly.remove());
		afterSize = singly.getSize();
		Assertions.assertEquals(beforeSize-1, afterSize);
		
		singly.add(1);
		singly.add(2);
		beforeSize = singly.getSize();
		Assertions.assertEquals(2, singly.remove());
		Assertions.assertEquals(1, singly.remove());
		afterSize = singly.getSize();
		Assertions.assertEquals(beforeSize-2, afterSize);
		
	}
	
	@Test
	public void removeManyitem() {
		LinkedList singly = new SinglyLinkedList();
		for(int i = 1; i <= 100; i++) {
			singly.add(i);
		}
		int originalSize = singly.getSize();
		Assertions.assertEquals(100, originalSize);
		
		int offset = 100;
		while(singly.getSize() != 0) {
			Assertions.assertEquals(offset--, singly.remove());
			Assertions.assertEquals(offset, singly.getSize());
		}
	}
	
	@Test
	public void removeWithIndex1() {
		LinkedList singly = new SinglyLinkedList();
		int length = 100;
		int beforeSize = -1;
		int afterSize = -1;
		for(int i = 1; i <= length; i++) {
			singly.add(i);
		}
		int i = 1;
		while(singly.getSize() != 0) {
			beforeSize = singly.getSize();
			
			int removedItem = singly.removeWithIndex(0);
			
			afterSize = singly.getSize();
			
			 // removedItem == random[i];
			Assertions.assertEquals(removedItem, i++);
			Assertions.assertNotEquals(i+1, singly.getWithIndex(0));
			
//			 beforeSize-1 == afterSize;
			Assertions.assertEquals(beforeSize-1, afterSize);
		}
		
		beforeSize = singly.getSize();
		Assertions.assertEquals(-1, singly.removeWithIndex(0));
		afterSize = singly.getSize();
		Assertions.assertEquals(beforeSize, afterSize);
	}
	/*
	@Test
	void removeWithIndex2() {
		LinkedList singly = new SinglyLinkedList();
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] random = ArrayUtility.randomDataIntArray(101, 10);
		for(int i : random) {
			list.add(i);
			singly.add(i);
		}
		;
		System.out.println();
		String decision = null;
		do {
			System.out.print("Enter index : ");
			int index = Integer.parseInt(sc.nextLine());
			int removedFromSingly = singly.removeWithIndex(index);
			int removedFromList = list.remove(index);
			System.out.println(removedFromSingly + "is removed");
			Assertions.assertEquals(removedFromList, removedFromSingly);
			System.out.println();
			;
			System.out.println("Continue? y/n: ");
			decision = sc.nextLine();
		} while("y".equalsIgnoreCase(decision));
	}
	*/
	
	/*
	 * add (no index)
	 * getWithItem
	 * removeWithIndex
	 * getSize
	 * removeWithItem
	 * 
	 */
	
	@Test
	void removeWithItem() {
		LinkedList singly = new SinglyLinkedList();
		int length = 100;
		singly.add(1);
		Assertions.assertEquals(1, singly.getWithItem(1));
		Assertions.assertEquals(1, singly.removeWithIndex(0));
		Assertions.assertEquals(-1, singly.removeWithIndex(0));
		
		for(int i = 1; i <= length; i++) {
			singly.add(i);
		}
		
		;
		Assertions.assertEquals(100, singly.removeWithItem(100));
		Assertions.assertEquals(99, singly.getSize());
		singly.add(100);
		Assertions.assertEquals(100, singly.getSize());
		
		int count = 1;
		while(singly.getSize() != 0) {
			int removed = singly.removeWithItem(count);
			Assertions.assertEquals(count, removed);
			count++;
		}
		
		Assertions.assertEquals(0, singly.getSize());
		
	}
	
	@Test
	void clear() {
		LinkedList singly = new SinglyLinkedList();
		int length = 100;
		
		for(int i = 1; i <= length; i++) {
			singly.add(i);
		}
		
		Assertions.assertEquals(length, singly.getSize());
		
		singly.clear();
		Assertions.assertEquals(0, singly.getSize());
		
		System.out.println("Clear Done");
		singly.iterate();
	}
	
}

