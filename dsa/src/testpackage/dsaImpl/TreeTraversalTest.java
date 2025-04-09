package testpackage.dsaImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.tns.dsa.dsaImpl.tree.Node;
import com.tns.dsa.dsaImpl.tree.TreeTraversal;

class TreeTraversalTest {

	@Test
	void testNoNode() {
		TreeTraversal traverse = new TreeTraversal();

		System.out.print("Preorder: ");
		traverse.preOrder(null);
		System.out.println();

		System.out.print("Preorder Iterative: ");
		traverse.preOrderIterative(null);
		System.out.println();
	}
	
	@Test
	void testOneNode() {
		Node a = new Node('A');
		TreeTraversal traverse = new TreeTraversal();

		System.out.print("Preorder: ");
		traverse.preOrder(a);
		System.out.println();

		System.out.print("Preorder Iterative: ");
		traverse.preOrderIterative(a);
		System.out.println();
	}

	@Test
	void testMultipleNodes() {
		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		Node d = new Node('D');
		Node e = new Node('E');

		a.addChild(b);
		a.addChild(c);

		c.addChild(d);
		c.addChild(e);

		TreeTraversal traverse = new TreeTraversal();

		System.out.print("Preorder: ");
		traverse.preOrder(a);
		System.out.println();

		System.out.print("Preorder Iterative: ");
		traverse.preOrderIterative(a);
		System.out.println();

		/*
		 * System.out.print("Inorder: "); traverse.inOrder(a, null);
		 * System.out.println();
		 * 
		 * System.out.print("Postorder: "); traverse.postOrder(a); System.out.println();
		 */
	}

	@Test
	void testMultipleNodes2() {
		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		Node d = new Node('D');
		Node e = new Node('E');
		Node f = new Node('F');
		Node g = new Node('G');
		Node h = new Node('H');
		Node i = new Node('I');

		a.addChild(b);
		a.addChild(c);

		b.addChild(d);
		b.addChild(e);
		
		c.addChild(f);
		c.addChild(g);
		
		d.addChild(h);
		d.addChild(i);

		TreeTraversal traverse = new TreeTraversal();

		System.out.print("Preorder: ");
		traverse.preOrder(a);
		System.out.println();

		System.out.print("Preorder Iterative: ");
		traverse.preOrderIterative(a);
		System.out.println();

		/*
		 * System.out.print("Inorder: "); traverse.inOrder(a, null);
		 * System.out.println();
		 * 
		 * System.out.print("Postorder: "); traverse.postOrder(a); System.out.println();
		 */
	}

}
