package edu.ncsu.csc316.hub_manager.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;
import edu.ncsu.csc316.hub_manager.list.MultiPurposeList;

/**
 * Reads parameters from a file into a list of airports
 * @author Aasiyah Feisal
 *
 */
public class AirportReader {
	
	/**
	 * Reads the file for airports into a list
	 * @param file the file to be read
	 * @return a list of airports elements
	 * @throws FileNotFoundException if the file given cannot be read or does not exist
	 */
	public MultiPurposeList<Airport> getAirports(String file) throws FileNotFoundException {
        Scanner fileReader = null;
        MultiPurposeList<Airport> vertices = new MultiPurposeList<Airport>();
        
		try {
		    fileReader = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Invalid file");
		}
		
		//BinarySearchTree<HelpTicket> tickets = new BinarySearchTree<HelpTicket>();
		if(fileReader.hasNextLine()) {
			fileReader.nextLine(); //skips first line
		}
		
		while (fileReader.hasNextLine()) {
			try {
				Airport airport = readAirport(fileReader.nextLine());
				vertices.add(airport);
			} catch (IllegalArgumentException e) {
				//skip the line
			}
		}
		
		fileReader.close();
		
		return vertices;
	}

	/**
	 * Creates a list of edges from the given list of vertices
	 * @param vertices a list of vertices from the file
	 * @return a list of edges for the given vertices
	 */
	public MultiPurposeList<FlightLeg> getEdgeList(MultiPurposeList<Airport> vertices) {
		MultiPurposeList<FlightLeg> edges = new MultiPurposeList<FlightLeg>();
		
		for (int i = 0; i < vertices.size() - 1; i++) {
			for (int j = vertices.size() - 1; j > i; j--) {
				FlightLeg flightLeg = new FlightLeg(vertices.get(i), vertices.get(j));
				edges.add(flightLeg);
			}
		}
		
		return edges;
	}

	/**
	 * Reads a line of the file
	 * @param line the line to be read into an airport object
	 * @return the airport created
	 * @throws IllegalArgumentException if the airport cannot be created
	 */
	private static Airport readAirport(String line) throws IllegalArgumentException {
		Airport airport = null;
		String[] tokens = line.split(",");
		if (tokens.length == 3)
			airport = new Airport(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
		
		if (airport == null)
			throw new IllegalArgumentException();
		
		return airport;
	}
}