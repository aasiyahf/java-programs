package edu.ncsu.csc316.airline_mileage.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * AirlineReader reads a file of airline information
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class AirlineReader {

	/**
	 * Reads airlines from a file and generates a list of given airlines. If the file to 
	 * read cannot be found, a File NotFoundException is thrown.
	 * @param file the file to read airline information from
	 * @return a list of airlines
	 * @throws FileNotFoundException if the file cannot be found or read
	 */
	public ArrayBasedList<Airline> readAirlineFile(String file) throws FileNotFoundException {
        Scanner fileReader = null;
		
		try {
		    fileReader = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Invalid file");
		}
		
		ArrayBasedList<Airline> airlines = new ArrayBasedList<Airline>();
		fileReader.nextLine(); //skips first line
		
		int iterator = 0;
		while (fileReader.hasNextLine()) {
			try {
				Airline currentAirline = readAirline(fileReader.nextLine());
				airlines.add(iterator, currentAirline);
				iterator++;
			} catch (IllegalArgumentException e) {
				//skip the line
			}
		}
		fileReader.close();
		return airlines;
	}

	/**
	 * Reads a single line of code to create an airline object
	 * @param line the line to be read
	 * @return the airline created from the line
	 * @throws IllegalArgumentException if an airline object cannot be created
	 */
	private static Airline readAirline(String line) throws IllegalArgumentException {
		Airline currentAirline = null;
		String[] tokens = line.split(",");
		if (tokens.length == 4)
			currentAirline = new Airline(tokens[0], tokens[1], tokens[2], tokens[3]);
		
		if (currentAirline == null)
			throw new IllegalArgumentException();
		
		return currentAirline;
	}

}