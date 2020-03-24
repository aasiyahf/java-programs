package edu.ncsu.csc316.customer_service.data;

/**
 * Compares two customers, first by last name and then by first
 * @author Aasiyah Feisal
 *
 */
public class CustomerComparator {
	/**
	 * Compares two given customers by name, last name first
	 * @param customer1 the first customer to compare
	 * @param customer2 the second customer to compare
	 * @return n greater than 0 if customer one is before customer 2, 
	 *  less than 0 if vice versa, and 0 if they are the same
	 */
	public int compareByName(Customer customer1, Customer customer2) {
		if (customer1.getLastName().compareTo(customer2.getLastName()) == 0) {
			return customer1.getFirstName().compareTo(customer2.getFirstName());
		} else {
			return customer1.getLastName().compareTo(customer2.getLastName());
		}
	}
}
