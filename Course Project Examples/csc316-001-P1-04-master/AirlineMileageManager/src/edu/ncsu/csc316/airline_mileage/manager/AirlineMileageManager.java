package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.data.Miles;
import edu.ncsu.csc316.airline_mileage.io.AirlineReader;
import edu.ncsu.csc316.airline_mileage.io.CustomerReader;
import edu.ncsu.csc316.airline_mileage.io.FlightReader;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * AirlineMileageManager manges the mileage reports and queries for individual
 * cardholders
 * @author Aasiyah Feisal (anfeisal)
 */
public class AirlineMileageManager {

	private ArrayBasedList<Airline> airlines;
	private ArrayBasedList<Customer> customers;
	private ArrayBasedList<Flight> flights;
	private ArrayBasedList<Miles> milesList;
	
	/**
	 * Constructs an AirlineMileageManager
	 * 
	 * @param pathToAirlineFile - path to the airline information file
	 * @param pathToCustomerFile - path to the customer information file
	 * @param pathToFlightFile - path to the flight information file
	 */
	public AirlineMileageManager(String pathToAirlineFile, String pathToCustomerFile, String pathToFlightFile)
	{	
	  try {
		  airlines = new AirlineReader().readAirlineFile(pathToAirlineFile);
	  } catch (FileNotFoundException e) {
		  // catches exception if file cannot be read or does not exist
		  throw new IllegalArgumentException("Invalid file.");
	  }
	  
	  try {
		  customers = new CustomerReader().readCustomerFile(pathToCustomerFile);
	  } catch (FileNotFoundException e) {
		  // catches exception if file cannot be read or does not exist
		  throw new IllegalArgumentException("Invalid file.");
	  }
	  
	  try {
		  flights = new FlightReader().readFlightFile(pathToFlightFile);
	  } catch (FileNotFoundException e) {
		  // catches exception if file cannot be read or does not exist
		  throw new IllegalArgumentException("Invalid file.");
	  }
	  
	  this.milesList = new ArrayBasedList<Miles>();
	   
	}
	
	/**
	 * Produces the mileage report for all cardholders
	 * as a String, sorted alphabetically by cardholder
	 * last name.
	 * 
	 * @return the mileage report for all customers
	 */
	public String getMileageReport() {
		ArrayBasedList<Customer> filteredCustomerList = customers; 
		filteredCustomerList = concatenateCustomers(filteredCustomerList); //combines duplicate names
		
		String report = "";
		
		for (int i = 0; i < filteredCustomerList.size(); i++) {
			report += getMiles(filteredCustomerList.get(i).getFirstName(), 
			  filteredCustomerList.get(i).getLastName());
			report += "\n";
		}
		
		return report;
	}

	/**
	 * Shortens customer list with one instance of every cardholder
	 * @param customerList the list of customers to be shortened
	 * @return a shortened array-based list with one instance of every cardholder
	 */
	private ArrayBasedList<Customer> concatenateCustomers(ArrayBasedList<Customer> customerList) {
		
        for (int i = 0; i < customerList.size(); i++) {
        	for (int j = 0; j < customerList.size(); j++) {
	        	if (customerList.get(i).getFirstName().equals(customerList.get(j).getFirstName()) &&
	        	customerList.get(i).getLastName().equals(customerList.get(j).getLastName())) {
	        		customerList.remove(j);
	        	}
	        }
		}
        
		return customerList;
		
	}

	/**
	 * Retrieves the frequent flier mileage for the specified
	 * cardholder with the given first name and last name.
	 * Miles are listed in descending order by distance
	 * 
	 * @param firstName - the cardholder's first name
	 * @param lastName - the cardholder's last name
	 * @return the frequent flier mileage information for the cardholder
	 */
	public String getMiles(String firstName, String lastName) {
		
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getFirstName().equals(firstName) && 
			  customers.get(i).getLastName().equals(lastName)) {
				for (int j = 0; j < flights.size(); j++) {
					if (customers.get(i).getAirline().equals(flights.get(j).getAirline() + flights.get(j).getFlightNumber()) &&
							customers.get(i).getOrigin().equals(flights.get(j).getOrigin()) &&
							customers.get(i).getDestination().equals(flights.get(j).getDestination())) {
						
						Miles miles = new Miles(flights.get(j).getAirline(), flights.get(j).getDistance());
						milesList.add(j, miles);
					}
				}
			}
		}
		
		if (milesList == null) {
			return "No miles";
		}
		
		ArrayBasedList<Miles> newMilesList = sortMilesList(concatenateMiles(milesList));
		
		String miles = firstName + " " + lastName + " earned\n";
		for (int i = newMilesList.size() - 1; i >= 0; i--) {
			for (int j = 0; j < airlines.size(); j++) {
				if (newMilesList.get(i).getAirline().equals(airlines.get(j).getCode())) {
					String name = airlines.get(j).getName();
					String code = airlines.get(j).getCode();
					miles += "    " + newMilesList.get(i).getMiles() + " miles with " + name + " (" + code + ")\n";
				}
			}
		}
		
		return miles;
	}

	/**
	 * Sorts an array-based list of miles from lowest amount to highest
	 * @param newMilesList the list of miles to be sorted
	 * @return a sorted list
	 */
	private ArrayBasedList<Miles> sortMilesList(ArrayBasedList<Miles> newMilesList) {
		//bubble sort
		for (int i = newMilesList.size() - 1; i >= 0; i--) {
		    for (int j = 1; j <= i; j++) {
		        if (newMilesList.get(j - 1).getMiles() > newMilesList.get(j).getMiles()) {
		             Miles temp = newMilesList.get(j - 1);
		             
		             newMilesList.set(j - 1, newMilesList.get(j));
		             newMilesList.set(j, temp);
		        } 
		    } 
		}
		
		return newMilesList;
	}

	/**
	 * Shortens list of miles by combining miles with like airlines
	 * @param list of miles
	 * @return a list of miles with each index specifying an airline
	 */
	private ArrayBasedList<Miles> concatenateMiles(ArrayBasedList<Miles> list) {
		ArrayBasedList<Miles> newMilesList = new ArrayBasedList<Miles>();
		
		int numberOfAirlines = 0;
		while (numberOfAirlines != airlines.size()) {
			Miles miles = new Miles(airlines.get(numberOfAirlines).getCode(), 0);
			for (int i = 0; i < list.size(); i++) {
			    if (airlines.get(numberOfAirlines).getCode().equals(list.get(i).getAirline())) {
			    	miles.addMiles(list.get(i).getMiles());
			    }
		    }
			
			newMilesList.add(numberOfAirlines, miles);
			numberOfAirlines++;
		}
		
		
		return newMilesList;
	}
}
