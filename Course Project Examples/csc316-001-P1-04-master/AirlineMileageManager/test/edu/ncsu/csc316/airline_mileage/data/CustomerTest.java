package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;

/**
 * Tests Customer class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class CustomerTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.data.Customer#Customer(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCustomer() {
		Customer bob = new Customer("Bob", "Rocks", "12/30/2015", "UA346", "ORD", "MIA");
		assertEquals(bob.getFirstName(), "Bob");
		assertEquals(bob.getLastName(), "Rocks");
		assertEquals(bob.getDate(), "12/30/2015");
		assertEquals(bob.getAirline(), "UA346");
		assertEquals(bob.getOrigin(), "ORD");
		assertEquals(bob.getDestination(), "MIA");
	}

}
