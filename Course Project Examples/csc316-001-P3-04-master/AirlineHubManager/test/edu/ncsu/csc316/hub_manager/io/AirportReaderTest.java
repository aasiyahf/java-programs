package edu.ncsu.csc316.hub_manager.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;
import edu.ncsu.csc316.hub_manager.list.MultiPurposeList;

/**
 * Tests the AirportReader class
 * @author Aasiyah Feisal
 *
 */
public class AirportReaderTest {

	/**
	 * Tests methods within AirportReader
	 */
	@Test
	public void test() {
		AirportReader reader = new AirportReader();
		MultiPurposeList<Airport> ports = new MultiPurposeList<Airport>();
		
		try {
			ports = reader.getAirports("input/airports.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be opened");
		}
		
		MultiPurposeList<FlightLeg> flights = reader.getEdgeList(ports);
		
		assertEquals(6, ports.size());
		assertEquals(15, flights.size());
	}

}
