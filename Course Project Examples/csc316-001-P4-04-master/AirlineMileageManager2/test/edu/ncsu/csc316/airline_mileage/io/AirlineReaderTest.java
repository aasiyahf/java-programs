package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * Tests AirlineReader class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class AirlineReaderTest {

	/**
	 * Tests methods for AirlineReader class
	 * @throws FileNotFoundException if file cannot be read
	 */
	@Test
	public void testReadAirlineFile() throws FileNotFoundException {
		HashTable<Airline> airlines = new AirlineReader().readAirlineFile("input/airlineFile.txt");
		assertEquals(3, airlines.size());
		
		Airline test = new Airline("United Airlines", "UA", "UNITED", "United States");
		assertEquals(test.getName(), airlines.get("UA").getName());
		
		try {
			@SuppressWarnings("unused")
			HashTable<Airline> airline = new AirlineReader().readAirlineFile("blargh");
			fail();
		} catch (IllegalArgumentException e) {
			//catches exception
		}
	}

}
