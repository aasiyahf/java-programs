package edu.ncsu.csc316.customer_service.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.customer_service.data.Customer;
import edu.ncsu.csc316.customer_service.data.HelpTicket;
import edu.ncsu.csc316.customer_service.io.HelpTicketReader;
import edu.ncsu.csc316.customer_service.tree.BinarySearchTree;

/**
 * Manages the data and io classes in order to allow the ui to call simplified functions 
 *  and allow for easier operation
 * @author Aasiyah Feisal
 *
 */
public class CustomerServiceManager {
	/** A binary search tree of help tickets */
	public BinarySearchTree<HelpTicket> tree;
	
	/**
	 * Constructs a CustomerServiceManager
	 * 
	 * @param pathToHelpTicketsFile - path to the help ticket information file
	 * @throws FileNotFoundException if file cannot be opened or read
	 */
	public CustomerServiceManager(String pathToHelpTicketsFile) {
	    HelpTicketReader reader = new HelpTicketReader();
	    try {
			tree = reader.readHelpTickets(pathToHelpTicketsFile);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Cannot open file.");
		}
	}
	
	/**
	 * Outputs the customer's place in line in the help queue,
	 * along with the help ticket information in the format
	 * (with 2nd line indentation of 4 spaces and NO newline at the end):
	 *
	 * Bob Baker is number 3 in the queue:
	 *     Priority 2 submmited on 08/14/2017 at 06:54:00: Can I change my flight?
	 * 
	 * @param firstName - the customer's first name
	 * @param lastName - the customer's last name
	 * @return the customer's place in line and help ticket information
	 */
	public String getPlaceInLine(String firstName, String lastName) {
		Customer customer = new Customer(firstName, lastName);
		HelpTicket ticket = null;
		int steps = tree.lookUpCustomer(customer, 0);
		
		try {
			ticket = tree.lookUpTicket(customer);
		} catch (IllegalArgumentException e) {
			return "User has no active help tickets";
		}
		
		String output = firstName + " " + lastName + " is number" + steps + " in the queue:\n";
		output += "    Priority " + ticket.getPriority() + " submitted on ";
		output += ticket.getTime().getDay() + "/" + ticket.getTime().getMonth() + "/";
		output += ticket.getTime().getYear() + " at " + ticket.getTime().getHour() + ":";
		output += ticket.getTime().getMinute() + ":" + ticket.getTime().getSecond() + ":";
		output += ticket.getQuestion();
		
		return output;
	}
	
	/**
	 * Retrieves the complete help ticket queue, sorted in order 
	 * that the customers will be served. Higher priority is served 
	 * first, and (if priorities are the same) the help ticket
	 * with the earlier submission timestamp is serviced first.
	 * 
	 * The help queue is returned in the following format
	 * (with indentation of 4 spaces and NO newline at the very end):
	 *
	 * Priority 8: submitted at 11/11/2017 23:45:00 by John Smith, Question: How much does it cost to change flights on the same day?
	 * Priority 5: submitted at 09/03/2017 10:00:00 by Suzanne Smith, Question: How do I check my mileage balance?
	 * Priority 2: submitted at 10/14/2017 06:54:00 by Bob Baker, Question: Can I change my flight?
	 * 
	 * @return the help ticket queue listed in the order customers will be serviced
	 */
	public String getHelpTicketQueue() {
		String fullString = tree.inOrder();
		return fullString;
	}
	
	/**
	 * Removes the customer from the help ticket software (for example,
	 * if the customer finds the answer to their question while waiting,
	 * they may cancel their help ticket instead of waiting to be serviced)
	 *
	 * @param firstName - the customer's first named
	 * @param lastName - the customer's last name
	 */
	public void removeCustomerFromQueue(String firstName, String lastName) {
	    Customer customer = new Customer(firstName, lastName);
	    tree.deleteCustomer(customer);
	}
}
