package edu.ncsu.csc316.airline_mileage.ui;

import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.manager.AirlineMileageManager;

/**
 * AirlineManagerUI provides a basis of interaction between the program and
 * the user.
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class AirlineMileageUI {

	/**
	 * The main method which starts interaction between the user
	 * and the implemented methods within AirlineMileageManager
	 * @param args the argument parameter
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		boolean filesRead = false;
		AirlineMileageManager manager = null;
		do {
    		System.out.print("Enter name of airline file: ");
    		String pathToAirlineFile = "input/" + console.next();
    		
    		System.out.print("Enter name of cardholder file: ");
    		String pathToCustomerFile = "input/" + console.next();
    		
    		System.out.print("Enter name of flight file: ");
    		String pathToFlightFile = "input/" + console.next();
    
    		try {
    		    manager = new AirlineMileageManager(pathToAirlineFile, pathToCustomerFile, pathToFlightFile);
    		    filesRead = true;
    		} catch (IllegalArgumentException e) {
    		    System.out.println("One or more files were invalid, try again\n");
    		}
		} while (!filesRead);
		    
		String answer = "n";
		do {
			System.out.print("\nQuery for cardholder mileage? (y/n) ");
			answer = console.next();
			if (answer.equalsIgnoreCase("y")) {
				System.out.print("Cardholder first name: ");
				String firstName = console.next();
				System.out.print("Cardholder last name: ");
				String lastName = console.next();
				
				System.out.println("\n" + manager.getMiles(firstName, lastName));
			} else if (answer.equalsIgnoreCase("n")) {
				System.out.println("Produce mileage report? (y/n) ");
				answer = console.next();
				if (answer.equalsIgnoreCase("y")) {
					System.out.print("\n" + manager.getMileageReport());
				} else if (answer.equalsIgnoreCase("n")) {
					System.out.print("Quit? (y/n) ");
					answer = console.next();
				}
			}
		} while (answer.equalsIgnoreCase("n"));
		
		System.out.println("Goodbye!");
	}

}
