package p3arboles;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTreeTest {

	@Test
	public void test() {
		BSTree<Integer> bst=new BSTree<Integer>();
		
		bst.addNode(5);
		assertTrue(bst.addNode(3));
		bst.addNode(4);
		assertTrue(bst.addNode(7));
		assertTrue(bst.addNode(9));
		
		System.out.print(bst.toString());
	}

}
