package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.io.CustomerReader;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * Tests CustomerReader class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class CustomerReaderTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.io.CustomerReader#readCustomerFile(java.lang.String)}.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testReadCustomerFile() throws FileNotFoundException {
		ArrayBasedList<Customer> customers = new CustomerReader().readCustomerFile("input/customerFile.txt");
		assertEquals(10, customers.size());
		
		Customer test = new Customer("Erick", "Mcfarland", "12/20/2015", "UA346", "ORD", "MIA");
		assertEquals(test.getLastName(), customers.get(0).getLastName());
		
		assertEquals("Stiltner", customers.get(customers.size() - 1).getLastName());
	}

}
