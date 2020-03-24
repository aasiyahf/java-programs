package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.data.Miles;
import edu.ncsu.csc316.airline_mileage.data.Name;
import edu.ncsu.csc316.airline_mileage.io.AirlineReader;
import edu.ncsu.csc316.airline_mileage.io.CustomerReader;
import edu.ncsu.csc316.airline_mileage.io.FlightReader;
import edu.ncsu.csc316.airline_mileage.dictionary.ArrayBasedList;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * Manages the files specified in order to calculate mileage for every customer or
 * just one specified person
 * @author Aasiyah Feisal
 * 
 * My constructor mirrors the logic from my Project 1 
 * AirlineMileageManager constructor method.
 *
 */
public class AirlineMileageManager {
	
	private HashTable<Airline> airlines;
	private HashTable<Customer> customers;
	private HashTable<Flight> flights;
	private ArrayBasedList<String> names;
	private ArrayBasedList<Name> nameArray;
	
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
			  CustomerReader reader = new CustomerReader();
			  customers = reader.readCustomerFile(pathToCustomerFile);
			  names = reader.getNames();
			  nameArray = new ArrayBasedList<Name>();
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
	}
	
	/**
	 * Produces the mileage report for all cardholders
	 * as a String, sorted alphabetically by cardholder
	 * last name.
	 * 
	 * @return the mileage report for all customers
	 */
	public String getMileageReport()
	{
		String mileage = "";
		
		for (int i = 0; i < names.size(); i++) {
			if(names.get(i) != null) {
				String fullName = names.get(i);
				String[] tokens = fullName.split(" ");
				
				String first = tokens[0];
				String last = tokens[1];
				
				nameArray.add(new Name(first, last));
			}
		}
		
		nameArray = sortNames(nameArray);
		
		for(int i = 0; i < nameArray.size(); i++) {
			mileage += this.getMiles(nameArray.get(i).getFirstName(), nameArray.get(i).getLastName()) + "\n";
		}
		
		return mileage;
	}
	
	/**
	 * Sorts the names within the given array list, by last name and then by first
	 * @param original the original array list of names to sort
	 * @return a sorted array list of names
	 */
	public ArrayBasedList<Name> sortNames(ArrayBasedList<Name> original) {
	    ArrayBasedList<Name> leftArray = new ArrayBasedList<Name>();
	    ArrayBasedList<Name> rightArray = new ArrayBasedList<Name>();
	    int middle = original.size() / 2;
	 
	    if (original.size() == 1) {    
	        return original;
	    }
	        
	    for (int i = 0; i < middle; i++) {
	    	leftArray.add(original.get(i));
	    }
	    
	    for (int i = middle; i < original.size(); i++) {
	        rightArray.add(original.get(i));
	    }

        leftArray  = sortNames(leftArray);
        rightArray = sortNames(rightArray);

        mergeNames(original, leftArray, rightArray);
	    return original;
	}
	
	/**
	 * Merges the full lists and sub lists of a list of names
	 * @param left the left sub-array of the whole array
	 * @param right the right sub-array of the whole array
	 * @param original the original array
	 */
	private void mergeNames(ArrayBasedList<Name> original, ArrayBasedList<Name> left, ArrayBasedList<Name> right) {
	    int leftIndex = 0;
	    int rightIndex = 0;
	    int finalIndex = 0;

	    while (leftIndex < left.size() && rightIndex < right.size()) {
	        if ((left.get(leftIndex).getLastName().compareTo(right.get(rightIndex).getLastName())) < 0) {
	            original.set(finalIndex, left.get(leftIndex));
	            leftIndex++;
	        } else if ((left.get(leftIndex).getLastName().compareTo(right.get(rightIndex).getLastName())) > 0) {
	            original.set(finalIndex, right.get(rightIndex));
	            rightIndex++;
	        } else {
	        	 if ((left.get(leftIndex).getFirstName().compareTo(right.get(rightIndex).getFirstName())) < 0) {
	        		 original.set(finalIndex, left.get(leftIndex));
	 	             leftIndex++;
	        	 } else {
	        		 original.set(finalIndex, right.get(rightIndex));
	 	             rightIndex++;
	        	 }
	        }
	        finalIndex++;
	    }
	 
	    ArrayBasedList<Name> other = null;
	    int index = 0;
	    if (leftIndex >= left.size()) {
	        other = right;
	        index = rightIndex;
	    } else {
	        other = left;
	        index = leftIndex;
	    }

	    for (int i = index; i < other.size(); i++) {
	        original.set(finalIndex, other.get(i));
	        finalIndex++;
	    }
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
		HashTable<Miles> milesList = new HashTable<Miles>();
		ArrayBasedList<Miles> milesArray = new ArrayBasedList<Miles>();
		
		String totalMiles = firstName + " " + lastName + " earned\n";
	    String nameKey = lastName + firstName;
	    
	    Customer travelData = this.customers.get(nameKey);
	    while (travelData != null) {
	    	String key = travelData.getAirline().substring(0, 2); //key for miles to add
	    	
	    	if (milesList.get(key) != null) { //Airline exists in miles list
	    		int miles = flights.get(travelData.getAirline()).getDistance();
	    		
	    		milesList.get(key).addMiles(miles); //add miles to existing airline instance
	    		
	    	} else {
	    		int miles = flights.get(travelData.getAirline()).getDistance();
	    		Miles value = new Miles(key, miles); //create new instance of miles
	    		
	    		milesList.put(key, value); //add to miles list
	    		milesArray.add(value); //add to array to sort
	    	}
	    	
	    	customers.remove(nameKey);
	    	travelData = this.customers.get(nameKey);
	    }
	    
	    for (int i = 0; i < milesArray.size(); i++) {
	    	String key = milesArray.get(i).getKey();
	    	Miles instance = milesList.remove(key);
	    	
	    	milesArray.set(i, instance);
	    }
	    
	    if (milesArray.size() == 0) {
	    	totalMiles += "    no miles.";
	    	return totalMiles;
	    }
	  
	    milesArray = sortMiles(milesArray);
	    
	    for (int i = 0; i < milesArray.size(); i++) {
	    	String code = milesArray.get(i).getAirline();
	    	String name = airlines.get(code).getName();
	    	int  miles = milesArray.get(i).getMiles();
			
	    	totalMiles += "    " + miles + " miles with " + name + " (" + code + ")\n";
		}

		return totalMiles;
	}

	/**
	 * Sorts the miles within the given array list, most miles first, and then
	 * by airline code alphabetically
	 * @param original the original array list of miles to sort
	 * @return a sorted array list of miles
	 */
	public ArrayBasedList<Miles> sortMiles(ArrayBasedList<Miles> original) {
	    ArrayBasedList<Miles> left = new ArrayBasedList<Miles>();
	    ArrayBasedList<Miles> right = new ArrayBasedList<Miles>();
	    int middle = 0;
	 
	    if (original.size() == 1) {    
	        return original;
	    }

        middle = original.size() / 2;
        for (int i = 0; i < middle; i++) {
                left.add(original.get(i));
        }

        for (int i = middle; i < original.size(); i++) {
                right.add(original.get(i));
        }

        left  = sortMiles(left);
        right = sortMiles(right);

        mergeMiles(original, left, right);
	    return original;
	}
	
	/**
	 * Merges the full lists and sub lists of a list of miles
	 * @param left the left sub-array of the whole array
	 * @param right the right sub-array of the whole array
	 * @param original the original array
	 */
	private void mergeMiles(ArrayBasedList<Miles> original, ArrayBasedList<Miles> left, ArrayBasedList<Miles> right) {
	    int leftIndex = 0;
	    int rightIndex = 0;
	    int finalIndex = 0;

	    while (leftIndex < left.size() && rightIndex < right.size()) {
	        if (left.get(leftIndex).getMiles() > right.get(rightIndex).getMiles()) {
	            original.set(finalIndex, left.get(leftIndex));
	            leftIndex++;
	        } else if (left.get(leftIndex).getMiles() < right.get(rightIndex).getMiles()) {
	            original.set(finalIndex, right.get(rightIndex));
	            rightIndex++;
	        } else {
	        	 if ((left.get(leftIndex).getAirline().compareTo(right.get(rightIndex).getAirline())) < 0) {
	        		 original.set(finalIndex, left.get(leftIndex));
	 	             leftIndex++;
	        	 } else {
	        		 original.set(finalIndex, right.get(rightIndex));
	 	             rightIndex++;
	        	 }
	        }
	        finalIndex++;
	    }
	 
	    ArrayBasedList<Miles> other = null;
	    int index = 0;
	    if (leftIndex >= left.size()) {
	        other = right;
	        index = rightIndex;
	    } else {
	        other = left;
	        index = leftIndex;
	    }

	    for (int i = index; i < other.size(); i++) {
	        original.set(finalIndex, other.get(i));
	        finalIndex++;
	    }
	}
}
