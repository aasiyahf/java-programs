package edu.ncsu.csc316.hub_manager.disjoint_set;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.disjoint_set.UpTree.Node;
import edu.ncsu.csc316.hub_manager.flight.Airport;

/**
 * Tests the UpTree class
 * @author Aasiyah Feisal
 *
 */
public class UpTreeTest {

	/**
	 * Tests the methods within UpTree
	 */
	@Test
	public void test() {
		UpTree tree = new UpTree();
		Airport origin = new Airport("DFW", 32.89680099487305, -97.03800201416016);
		Airport destination = new Airport("MIA", 25.79319953918457, -80.29060363769531);
		
		Node first = tree.makeSet(origin);
		assertNull(first.getParent());
		assertEquals(1, first.getCount());
		
		Node second = tree.makeSet(destination);
		
		assertEquals(first, tree.find(first));
		assertEquals(second, tree.find(second));
		
		tree.union(first, second);
		assertEquals(first, tree.find(first));
		assertEquals(2, tree.find(first).getCount());
		assertEquals(first, tree.find(second));
		assertEquals(2, tree.find(first).getCount());
	}

}
