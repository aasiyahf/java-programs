package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * Tests FlightReader class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class FlightReaderTest {

	/**
	 * Tests methods for FlightReader class
	 * @throws FileNotFoundException if file cannot be read
	 */
	@Test
	public void testReadFlightFile() throws FileNotFoundException {
		HashTable<Flight> flights = new FlightReader().readFlightFile("input/flightFile.txt");
		assertEquals(3, flights.size());
		
		Flight test = new Flight("UA", "346", "ORD", "MIA", 1197);
		assertEquals(test.getAirline(), flights.get(test.getKey()).getAirline());
		
		try {
			@SuppressWarnings("unused")
			HashTable<Flight> flight = new FlightReader().readFlightFile("blargh");
			fail();
		} catch (IllegalArgumentException e) {
			//catches exception
		}
	}

}
