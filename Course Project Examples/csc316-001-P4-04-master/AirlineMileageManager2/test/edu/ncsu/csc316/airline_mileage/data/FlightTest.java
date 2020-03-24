package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Flight class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class FlightTest {

	/**
	 * Tests methods for Flight class 
	 */
	@Test
	public void testFlight() {
		Flight flight = new Flight("UA", "346", "ORD", "MIA", 1197);
		assertEquals("UA", flight.getAirline());
		assertEquals("346", flight.getFlightNumber());
		assertEquals("ORD", flight.getOrigin());
		assertEquals("MIA", flight.getDestination());
		assertEquals(1197, flight.getDistance());
		
	}

}
