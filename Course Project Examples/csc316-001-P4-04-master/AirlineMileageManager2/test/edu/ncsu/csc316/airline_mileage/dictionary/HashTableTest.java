package edu.ncsu.csc316.airline_mileage.dictionary;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.io.CustomerReader;

/**
 * Tests HashTable class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class HashTableTest {

	private HashTable<Customer> customers;
	
	/**
	 * Tests get and remove methods within HashTable
	 */
	@Test
	public void test() {
		  try {
			  customers = new CustomerReader().readCustomerFile("input/customerFile.txt");
		  } catch (FileNotFoundException e) {
			  // catches exception if file cannot be read or does not exist
			  throw new IllegalArgumentException("Invalid file.");
		  }

		  String travelData = this.customers.get("McfarlandErick").getDate();
		  assertEquals(travelData, customers.remove("McfarlandErick").getDate());
		  
		  travelData = this.customers.get("McfarlandErick").getDate();
		  assertEquals(travelData, customers.remove("McfarlandErick").getDate());
	}

}
