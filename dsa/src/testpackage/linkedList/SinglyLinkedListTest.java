package testpackage.linkedList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.linkedlist.LinkedList;
import com.tns.dsa.linkedlist.impl.SinglyLinkedList;

class SinglyLinkedListTest {
	
	@Test
	void testInsertFirst1() {
		LinkedList<Character> s = new SinglyLinkedList();

		Assertions.assertEquals(0, s.size());
		Assertions.assertEquals(null, s.getFirst());
		Assertions.assertEquals(null, s.getLast());

		s.insertFirst('A');
		Assertions.assertEquals('A', s.getFirst());
		Assertions.assertEquals('A', s.getLast());
		Assertions.assertEquals(1, s.size());

		s.insertFirst('B');
		Assertions.assertEquals('B', s.getFirst());
		Assertions.assertEquals('A', s.getLast());
		Assertions.assertEquals(2, s.size());

		s.insertFirst('C');
		Assertions.assertEquals('C', s.getFirst());
		Assertions.assertEquals('A', s.getLast());
		Assertions.assertEquals(3, s.size());

		Iterator<Character> i = s.iterator();
		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals('C', i.next());

		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals('B', i.next());

		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals('A', i.next());

		Assertions.assertEquals(false, i.hasNext());
		Assertions.assertEquals(null, i.next());
	}

	@Test
	void testInsertLast1() {
		LinkedList<Character> singly = new SinglyLinkedList();
		Iterator<Character> i1 = singly.iterator();

		Assertions.assertEquals(false, i1.hasNext());
		singly.insertLast('A');
		singly.insertLast('B');
		singly.insertLast('C');
		singly.show();

		Iterator<Character> i = singly.iterator();
		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals('A', i.next());
		Assertions.assertEquals('B', i.next());
		Assertions.assertEquals('C', i.next());
		Assertions.assertEquals(false, i.hasNext());

	}

	@Test
	void insertFirstAndLast1() {
		LinkedList<Integer> s = new SinglyLinkedList();

		Assertions.assertEquals(0, s.size());
		Assertions.assertEquals(null, s.getFirst());
		Assertions.assertEquals(null, s.getLast());

		s.insertFirst(1);
		Assertions.assertEquals(1, s.size());
		Assertions.assertEquals(1, s.getFirst());
		Assertions.assertEquals(1, s.getLast());

		s.insertLast(2);
		Assertions.assertEquals(2, s.size());
		Assertions.assertEquals(1, s.getFirst());
		Assertions.assertEquals(2, s.getLast());

		s.insertFirst(3);
		Assertions.assertEquals(3, s.size());
		Assertions.assertEquals(3, s.getFirst());
		Assertions.assertEquals(2, s.getLast());

		s.insertLast(4);
		Assertions.assertEquals(4, s.size());
		Assertions.assertEquals(3, s.getFirst());
		Assertions.assertEquals(4, s.getLast());

		// 3 1 2 4
		Iterator<Integer> i = s.iterator();
		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals(3, i.next());
		Assertions.assertEquals(4, s.size());

		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals(1, i.next());
		Assertions.assertEquals(4, s.size());

		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals(2, i.next());
		Assertions.assertEquals(4, s.size());

		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals(4, i.next());
		Assertions.assertEquals(4, s.size());

		Assertions.assertEquals(false, i.hasNext());
		Assertions.assertEquals(null, i.next());
		Assertions.assertEquals(4, s.size());
	}

	@Test
	void testGetFirst1() {
		LinkedList<Character> singly = new SinglyLinkedList();
		Assertions.assertEquals(null, singly.getFirst());

		singly.insertLast('A');
		Assertions.assertEquals('A', singly.getFirst());

		singly.insertLast('B');
		Assertions.assertEquals('A', singly.getFirst());

		Iterator<Character> i = singly.iterator();
		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals('A', i.next());
		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals('B', i.next());
		Assertions.assertEquals(false, i.hasNext());
	}

	@Test
	void testGetLast1() {
		LinkedList<Character> singly = new SinglyLinkedList();
		Assertions.assertEquals(null, singly.getLast());

		singly.insertLast('A');
		Assertions.assertEquals('A', singly.getFirst());
		Assertions.assertEquals('A', singly.getLast());

		singly.insertLast('B');
		Assertions.assertEquals('A', singly.getFirst());
		Assertions.assertEquals('B', singly.getLast());

		Iterator<Character> i = singly.iterator();
		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals('A', i.next());
		Assertions.assertEquals(true, i.hasNext());
		Assertions.assertEquals('B', i.next());
	}

	@Test
	void testDeleteFirst1() {
		LinkedList<Integer> s = new SinglyLinkedList();

		Assertions.assertEquals(null, s.deleteFirst());
		s.insertFirst(1);
		Assertions.assertEquals(1, s.size());
		Assertions.assertEquals(1, s.deleteFirst());
		Assertions.assertEquals(0, s.size());
		Assertions.assertEquals(null, s.deleteFirst());
		Assertions.assertEquals(null, s.getFirst());
		Assertions.assertEquals(null, s.getLast());

		s.insertLast(1);
		s.insertFirst(2);
		Assertions.assertEquals(2, s.size());
		Assertions.assertEquals(2, s.getFirst());
		Assertions.assertEquals(1, s.getLast());
		Assertions.assertEquals(2, s.deleteFirst());
		Assertions.assertEquals(1, s.getFirst());
		Assertions.assertEquals(1, s.getLast());
		Assertions.assertEquals(1, s.size());
		Assertions.assertEquals(1, s.deleteFirst());
		Assertions.assertEquals(null, s.getFirst());
		Assertions.assertEquals(null, s.getLast());
		Assertions.assertEquals(null, s.deleteFirst());
		Assertions.assertEquals(0, s.size());

		// 2 1 4
		s.insertLast(1);
		s.insertFirst(2);
		s.insertLast(4);

		Assertions.assertEquals(3, s.size());
		Assertions.assertEquals(2, s.getFirst());
		Assertions.assertEquals(4, s.getLast());

		Assertions.assertEquals(2, s.deleteFirst());
		Assertions.assertEquals(1, s.getFirst());
		Assertions.assertEquals(4, s.getLast());
		Assertions.assertEquals(2, s.size());

		Assertions.assertEquals(1, s.deleteFirst());
		Assertions.assertEquals(4, s.getFirst());
		Assertions.assertEquals(4, s.getLast());
		Assertions.assertEquals(1, s.size());

		Assertions.assertEquals(4, s.deleteFirst());
		Assertions.assertEquals(null, s.getFirst());
		Assertions.assertEquals(null, s.getLast());
		Assertions.assertEquals(0, s.size());

	}
	
	@Test
	void testDeleteLast() {
		LinkedList<Integer> s = new SinglyLinkedList();
		
		Assertions.assertEquals(null, s.deleteLast());
		s.insertFirst(1);
		Assertions.assertEquals(1, s.size());
		Assertions.assertEquals(1, s.deleteLast());
		Assertions.assertEquals(0, s.size());
		Assertions.assertEquals(null, s.deleteLast());
		Assertions.assertEquals(null, s.getFirst());
		Assertions.assertEquals(null, s.getLast());
		
		s.insertLast(1);
		s.insertFirst(2);
		Assertions.assertEquals(2, s.size());
		Assertions.assertEquals(2, s.getFirst());
		Assertions.assertEquals(1, s.getLast());
		
		Assertions.assertEquals(1, s.deleteLast());
		Assertions.assertEquals(2, s.getFirst());
		Assertions.assertEquals(2, s.getLast());
		Assertions.assertEquals(1, s.size());
		
		Assertions.assertEquals(2, s.deleteLast());
		Assertions.assertEquals(0, s.size());
		Assertions.assertEquals(null, s.getFirst());
		Assertions.assertEquals(null, s.getLast());
		Assertions.assertEquals(null, s.deleteFirst());
		Assertions.assertEquals(0, s.size());
		
		// 2 1 4
		s.insertLast(1);
		s.insertFirst(2);
		s.insertLast(4);

		Assertions.assertEquals(3, s.size());
		Assertions.assertEquals(2, s.getFirst());
		Assertions.assertEquals(4, s.getLast());

		Assertions.assertEquals(4, s.deleteLast());
		Assertions.assertEquals(2, s.getFirst());
		Assertions.assertEquals(1, s.getLast());
		Assertions.assertEquals(2, s.size());

		Assertions.assertEquals(1, s.deleteLast());
		Assertions.assertEquals(2, s.getFirst());
		Assertions.assertEquals(2, s.getLast());
		Assertions.assertEquals(1, s.size());

		Assertions.assertEquals(2, s.deleteLast());
		Assertions.assertEquals(null, s.getFirst());
		Assertions.assertEquals(null, s.getLast());
		Assertions.assertEquals(null, s.deleteLast());
		Assertions.assertEquals(null, s.deleteFirst());
		Assertions.assertEquals(0, s.size());
	}

}
