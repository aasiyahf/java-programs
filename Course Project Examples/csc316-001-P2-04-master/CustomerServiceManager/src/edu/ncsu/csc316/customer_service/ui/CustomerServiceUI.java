package edu.ncsu.csc316.customer_service.ui;

import java.util.Scanner;

import edu.ncsu.csc316.customer_service.manager.CustomerServiceManager;

/**
 * This class allows a user to interact with the program and perform multiple fucntions
 * @author Aasiyah Feisal
 *
 */
public class CustomerServiceUI {

	/**
	 * The UI which interacts with the user to view a query for a customer,
	 * produce a help ticket, or remove a customer from the query.
	 */
	@SuppressWarnings("resource")
	public CustomerServiceUI() {
		Scanner console = new Scanner(System.in);
		
		boolean filesRead = false;
		CustomerServiceManager manager = null;
		do {
    		System.out.print("Enter name of file: ");
    		String pathToHelpTicketsFile = console.next();
    
    		try {
    		    manager = new CustomerServiceManager(pathToHelpTicketsFile);
    		    filesRead = true;
    		} catch (IllegalArgumentException e) {
    		    System.out.println("One or more files were invalid, try again");
    		}
		} while (!filesRead);
		
		
		System.out.print("Options: \n[1] Query Customer \n[2] Remove Customer \n[3] Produce Ticket Report \n[4] Exit ");
		while (!console.hasNextInt()) {
			System.out.println("Option is not an integer");
			System.out.print("Options: \n[1] Query Customer \n[2] Remove Customer \n[3] Produce Ticket Report \n[4] Exit ");
		}
		
		int option = console.nextInt();
		while (option < 1 || option > 4) {
			System.out.println("Invalid option");
			System.out.print("Options: \n[1] Query Customer \n[2] Remove Customer \n[3] Produce Ticket Report \n[4] Exit ");
			option = console.nextInt();
		}
		
		if (option == 1) {
			System.out.print("Enter first name: ");
    		String firstName = console.next();
    		System.out.print("Enter last name: ");
    		String lastName = console.next();
    		try {
    			System.out.println(manager.getPlaceInLine(firstName, lastName));
    		} catch (IllegalArgumentException e) {
    			System.out.println("User has no active help tickets");
    		}
		} else if (option == 2) {
			System.out.print("Enter first name: ");
    		String firstName = console.next();
    		System.out.print("Enter last name: ");
    		String lastName = console.next();
    		
    		try {
    			manager.removeCustomerFromQueue(firstName, lastName);
    			System.out.println("User has been removed");
    		} catch (IllegalArgumentException e) {
    			System.out.println("User has no active help tickets");
    		}
		} else if (option == 3) {
			try {
    			System.out.println(manager.getHelpTicketQueue());
    		} catch (IllegalArgumentException e) {
    			System.out.println(e.getMessage());
    		}
		} else {
			System.out.println("Goodbye!");
		}
	}
}
