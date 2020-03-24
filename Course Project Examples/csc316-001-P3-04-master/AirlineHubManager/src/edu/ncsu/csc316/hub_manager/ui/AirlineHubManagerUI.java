package edu.ncsu.csc316.hub_manager.ui;

import java.util.Scanner;

import edu.ncsu.csc316.hub_manager.manager.AirlineHubManager;

/**
 * Allows the user to interact with the program AirlineHubManager
 * @author Aasiyah Feisal
 *
 */
public class AirlineHubManagerUI {
	
	/**
	 * The main method which starts interaction between the user
	 * and the implemented methods within AirlineHubManager
	 * @param args the argument parameter
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		
		boolean filesRead = false;
		AirlineHubManager manager = null;
		do {
    		System.out.print("Enter name of file: ");
    		String pathToAirportsFile = "input/" + console.next();
    
    		manager = new AirlineHubManager(pathToAirportsFile);
    		filesRead = manager.validRead();
		} while (!filesRead);
		
		
		boolean valid = true;
		int option = 0;
		
		System.out.print("Menu: \n[1] Generate Flight Connections\n[2] Produce Hub Report\n[3] Exit ");
		System.out.print("\nOption -> ");
		do {
			if (!console.hasNextInt()) {
				console.next();
				valid = false;
				System.out.println("Option is not an integer.");
				System.out.print("\nMenu: \n[1] Generate Flight Connections\n[2] Produce Hub Report\n[3] Exit ");
				System.out.print("\nOption -> ");
			} else {
				option = console.nextInt();
				if (option < 1 || option > 3) {
					valid = false;
					System.out.println("Invalid option.");
					System.out.print("\nMenu: \n[1] Generate Flight Connections\n[2] Produce Hub Report\n[3] Exit ");
					System.out.print("\nOption -> ");
				} else {
					valid = true;
				}
			}
		} while(!valid);
		
		if (option == 1) {
			System.out.print("\n" + manager.getMinimumFlights());
		} else if (option == 2) {
			System.out.print("\n" + manager.getPossibleHubs());
		} else {
			System.out.println("\nGoodbye!");
		}
	}
	
}
