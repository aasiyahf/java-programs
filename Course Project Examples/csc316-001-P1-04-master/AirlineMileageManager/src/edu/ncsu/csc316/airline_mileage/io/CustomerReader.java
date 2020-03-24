package edu.ncsu.csc316.airline_mileage.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * CustomerReader reads a file of customer information
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class CustomerReader {

	/**
	 * Reads customers from a file and generates a list of given cardholders. If the file to 
	 * read cannot be found, a File NotFoundException is thrown.
	 * @param file the file to read customer information from
	 * @return a list of customers
	 * @throws FileNotFoundException if the file cannot be found or read
	 */
	public ArrayBasedList<Customer> readCustomerFile(String file) throws FileNotFoundException {
		Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Invalid file");
		}
		
		ArrayBasedList<Customer> customers = new ArrayBasedList<Customer>();
		fileReader.nextLine(); //skips first line
		
		int iterator = 0;
		while (fileReader.hasNextLine()) {
			try {
				Customer currentCustomer = readCustomer(fileReader.nextLine());
				customers.add(iterator, currentCustomer);
				iterator++;
			} catch (IllegalArgumentException e) {
				//skip the line
			}
		}
		
		fileReader.close();
		
		customers = sort(customers);
		
		return customers;
	}

	/**
	 * Uses bubble sort to sort customers alphabetically
	 * @param customers the list of customer information
	 * @return a sorted list
	 */
	private ArrayBasedList<Customer> sort(ArrayBasedList<Customer> customers) {
		for (int i = customers.size() - 1; i >= 0; i--) {
		    for (int j = 1; j <= i; j++) {
		        if (customers.get(j - 1).getLastName().compareTo(customers.get(j).getLastName()) > 0) {
		             Customer temp = customers.get(j - 1);
		             
		             customers.set(j - 1, customers.get(j));
		             customers.set(j, temp);
		        } 
		    } 
		}
		
		return customers;
	}

	/**
     * Reads a single line of code to create a customer object
     * @param line the line to be read
     * @return the customer created from the line
     * @throws IllegalArgumentException if a customer object cannot be created
     */
	private static Customer readCustomer(String line) throws IllegalArgumentException {
		Customer currentCustomer = null;
		String[] tokens = line.split(",");
		if (tokens.length == 6)
			currentCustomer = new Customer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
		
		if (currentCustomer == null)
			throw new IllegalArgumentException();

		return currentCustomer;
	}
}
