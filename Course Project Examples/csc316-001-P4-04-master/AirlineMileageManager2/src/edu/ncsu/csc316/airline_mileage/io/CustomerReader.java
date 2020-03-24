package edu.ncsu.csc316.airline_mileage.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.dictionary.ArrayBasedList;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;


/**
 * CustomerReader reads a file of customer information
 * @author Aasiyah Feisal (anfeisal)
 * 
 * I modeled this off of previous IO files I have written.
 *
 */
public class CustomerReader {
	
	ArrayBasedList<String> array = new ArrayBasedList<String>();

	/**
	 * Reads customers from a file and generates a list of given cardholders. If the file to 
	 * read cannot be found, a File NotFoundException is thrown.
	 * @param file the file to read customer information from
	 * @return a list of customers
	 * @throws FileNotFoundException if the file cannot be found or read
	 */
	public HashTable<Customer> readCustomerFile(String file) throws FileNotFoundException {
		Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Invalid file");
		}
		
		HashTable<Customer> customers = new HashTable<Customer>();
		fileReader.nextLine(); //skips first line

		while (fileReader.hasNextLine()) {
			try {
				Customer currentCustomer = readCustomer(fileReader.nextLine());
				customers.put(currentCustomer.getKey(), currentCustomer);
				
				String first = currentCustomer.getFirstName();
				String last = currentCustomer.getLastName();
//				Name value = new Name(first, last);
				if(!array.contains(first + " " + last)) {
					array.add(first + " " + last);
				}
			} catch (IllegalArgumentException e) {
				//skip the line
			}
		}
		
		fileReader.close();
		
		return customers;
	}
	
	/**
	 * Returns list of names within file
	 * @return array based list of name from file
	 */
	public ArrayBasedList<String> getNames() {
		return array;
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
