package edu.ncsu.csc316.airline_mileage.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * FlightReader reads a file of flight information
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class FlightReader {

	/**
	 * Reads flights from a file and generates a list of given flights. If the file to 
	 * read cannot be found, a File NotFoundException is thrown.
	 * @param file the file to read flight information from
	 * @return a list of flights
	 * @throws FileNotFoundException if the file cannot be found or read
	 */
	public ArrayBasedList<Flight> readFlightFile(String file) throws FileNotFoundException {
        Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Invalid file");
		}
		
		ArrayBasedList<Flight> flights = new ArrayBasedList<Flight>();
		fileReader.nextLine(); //skips first line
		
		int iterator = 0;
		while (fileReader.hasNextLine()) {
			try {
				Flight currentFlight = readFlight(fileReader.nextLine());
				flights.add(iterator, currentFlight);
				iterator++;
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
			currentFlight = new Flight(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), 
					Integer.parseInt(tokens[3]), tokens[4], tokens[5], tokens[6], tokens[7], Integer.parseInt(tokens[8]), 
					Integer.parseInt(tokens[9]), Integer.parseInt(tokens[10]), Integer.parseInt(tokens[11]), 
					Integer.parseInt(tokens[12]));
		
		if (currentFlight == null)
			throw new IllegalArgumentException();
		
		return currentFlight;
	}
}
