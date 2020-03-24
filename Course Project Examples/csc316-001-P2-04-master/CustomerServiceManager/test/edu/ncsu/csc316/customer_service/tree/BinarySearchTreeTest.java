/**
 * 
 */
package edu.ncsu.csc316.customer_service.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.customer_service.data.Customer;
import edu.ncsu.csc316.customer_service.data.HelpTicket;
import edu.ncsu.csc316.customer_service.data.Timestamp;

/**
 * Tests the BinarySearchTree class methods in order to figure out if it is 
 *  functioning correctly
 * @author Aasiyah Feisal
 *
 */
public class BinarySearchTreeTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.customer_service.tree.BinarySearchTree#BinarySearchTree()}.
	 */
	@Test
	public void testBinarySearchTree() {
		BinarySearchTree<HelpTicket> tree = new BinarySearchTree<HelpTicket>();
		assertTrue(tree.isEmpty());
		
		Timestamp time = new Timestamp("09/03/2017 10:00:00");
		HelpTicket ticket = new HelpTicket(time, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		tree.insert(ticket);
		
		assertTrue(tree.searchForCustomer(new Customer("Suzanne", "Smith")));
		assertEquals(1, tree.lookUpCustomer(new Customer("Suzanne", "Smith"), 0));
		assertEquals(ticket, tree.lookUpTicket(new Customer("Suzanne", "Smith")));
		
		tree.inOrder();
		
		tree.deleteCustomer(new Customer("Suzanne", "Smith"));
		assertTrue(tree.isEmpty());
		try {
			tree.deleteCustomer(new Customer("Suzanne", "Smith"));
			fail();
		} catch (IllegalArgumentException e) {
			//passes test
		}
		
		Timestamp time2 = new Timestamp("09/03/2017 10:00:00");
		HelpTicket ticket2 = new HelpTicket(time2, 5, "Suzanne" , "Smith" , "How do I check my mileage balance?");
		tree.insert(ticket2);
		assertEquals(1, tree.size());
		assertTrue(!tree.isEmpty());
	}

}
