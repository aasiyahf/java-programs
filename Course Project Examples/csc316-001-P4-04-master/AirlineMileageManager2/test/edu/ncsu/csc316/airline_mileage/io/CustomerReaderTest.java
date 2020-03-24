package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * Tests CustomerReader class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class CustomerReaderTest {

	/**
	 * Test method for CustomerReader class
	 * @throws FileNotFoundException if file cannot be read
	 */
	@Test
	public void testReadCustomerFile() throws FileNotFoundException {
		HashTable<Customer> customers = new CustomerReader().readCustomerFile("input/customerFile.txt");
		assertEquals(10, customers.size());
		
		Customer test = new Customer("Erick", "Mcfarland", "12/20/2015", "UA346", "ORD", "MIA");
		assertEquals(test.getAirline(), customers.get("McfarlandErick").getAirline());
		assertEquals(test.getDate(), customers.get("McfarlandErick").getDate());
		
		Customer removed = customers.remove("McfarlandErick");
		assertEquals(test.getAirline(), removed.getAirline());
		
		try {
			@SuppressWarnings("unused")
			HashTable<Customer> customer = new CustomerReader().readCustomerFile("blargh");
			fail();
		} catch (IllegalArgumentException e) {
			//catches exception
		}
	}

}
