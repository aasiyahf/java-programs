package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.io.FlightReader;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * Tests FlightReader class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class FlightReaderTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.io.FlightReader#readFlightFile(java.lang.String)}.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testReadFlightFile() throws FileNotFoundException {
		ArrayBasedList<Flight> flights = new FlightReader().readFlightFile("input/flightFile.txt");
		assertEquals(3, flights.size());
		
		Flight test = new Flight(2015, 12, 20, 7, "UA", "346", "ORD", "MIA", 0730, 0730, 1197, 1139, -20);
		assertEquals(test.getAirline(), flights.get(0).getAirline());
	}

}
