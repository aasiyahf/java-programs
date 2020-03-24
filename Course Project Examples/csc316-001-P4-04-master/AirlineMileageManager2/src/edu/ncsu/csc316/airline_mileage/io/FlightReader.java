package edu.ncsu.csc316.airline_mileage.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * FlightReader reads a file of flight information
 * @author Aasiyah Feisal (anfeisal)
 *
 * I modeled this off of previous IO files I have written.
 */
public class FlightReader {

	/**
	 * Reads flights from a file and generates a list of given flights. If the file to 
	 * read cannot be found, a File NotFoundException is thrown.
	 * @param file the file to read flight information from
	 * @return a list of flights
	 * @throws FileNotFoundException if the file cannot be found or read
	 */
	public HashTable<Flight> readFlightFile(String file) throws FileNotFoundException {
        Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Invalid file");
		}
		
		HashTable<Flight> flights = new HashTable<Flight>();
		fileReader.nextLine(); //skips first line

		while (fileReader.hasNextLine()) {
			try {
				Flight currentFlight = readFlight(fileReader.nextLine());
				flights.put(currentFlight.getKey(), currentFlight);
			} catch (IllegalArgumentException e) {
				//skip the line
			}
		}
		
		fileReader.close();
		return flights;
	}

	/**
     * Reads a single line of code to create a flight object
     * @param line the line to be read
     * @return the flight created from the line
     * @throws IllegalArgumentException if a flight object cannot be created
     */
	private static Flight readFlight(String line) throws IllegalArgumentException {
		Flight currentFlight = null;
		String[] tokens = line.split(",");
		if (tokens.length == 13)
			currentFlight = new Flight(tokens[4], tokens[5], tokens[6], tokens[7], Integer.parseInt(tokens[10]));
		
		if (currentFlight == null)
			throw new IllegalArgumentException();
		
		return currentFlight;
	}
	
}
