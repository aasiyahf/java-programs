package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.io.AirlineReader;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * Tests AirlineReader class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class AirlineReaderTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.io.AirlineReader#readAirlineFile(java.lang.String)}.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testReadAirlineFile() throws FileNotFoundException {
		ArrayBasedList<Airline> airlines = new AirlineReader().readAirlineFile("input/airlineFile.txt");
		assertEquals(3, airlines.size());
		
		Airline test = new Airline("United Airlines", "UA", "UNITED", "United States");
		assertEquals(test.getName(), airlines.get(0).getName());
	}

}
