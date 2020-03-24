/**
 * 
 */
package edu.ncsu.csc316.customer_service.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Customer class methods as well as the CustomerComparator class methods
 * @author Aasiyah Feisal
 *
 */
public class CustomerTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.customer_service.data.Customer#Customer(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCustomer() {
		Customer customer = new Customer("Bob", "Smith");
		assertEquals("Bob", customer.getFirstName());
		assertEquals("Smith", customer.getLastName());
		
		Customer customer2 = new Customer("Suzanne", "Smith");
		assertEquals("Suzanne", customer2.getFirstName());
		assertEquals("Smith", customer2.getLastName());
		
		CustomerComparator comparator = new CustomerComparator();
		int comparison = comparator.compareByName(customer, customer2);
		
		boolean valid = false;
		if (comparison < 0) {
			valid = true;
		}
		
		assertTrue(valid);
	}

}
