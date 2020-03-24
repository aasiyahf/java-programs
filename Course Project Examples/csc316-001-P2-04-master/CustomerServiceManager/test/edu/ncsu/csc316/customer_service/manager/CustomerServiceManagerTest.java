package edu.ncsu.csc316.customer_service.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the CustomerServiceManager class methods
 * @author Aasiyah Feisal
 *
 */
public class CustomerServiceManagerTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.customer_service.manager.CustomerServiceManager#CustomerServiceManager(java.lang.String)}.
	 */
	@Test
	public void testCustomerServiceManager() {
		CustomerServiceManager manager = new CustomerServiceManager("helpTickets.txt");
		try {
			manager = new CustomerServiceManager("helpTicketskjhda;");
			fail();
		} catch (IllegalArgumentException e) {
			//passes test
		}
		
//		String place = manager.getPlaceInLine("Bob", "Baker");
//		String expected = "Bob Baker is number 3 in the queue:\n     ";
//		expected += "Priority 2 submitted on 08/14/2017 at 06:54:00: Can I change my flight?";
//		
//		assertEquals(place, expected);
		
		String queue = manager.getHelpTicketQueue();
		boolean valid = false;
		if (!queue.isEmpty())
			valid = true;
		assertTrue(valid);
			
		try {
			manager.removeCustomerFromQueue("Bob", "Baker");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
	}

}
