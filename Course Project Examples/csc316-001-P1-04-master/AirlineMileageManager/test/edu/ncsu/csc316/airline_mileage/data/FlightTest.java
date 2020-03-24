package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Flight;

/**
 * Tests Flight class
 * @author Aasiyah Feisal (anfeisal)
 *
 */
public class FlightTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.airline_mileage.data.Flight#Flight(int, int, int, int, java.lang.String, int, java.lang.String, java.lang.String, int, int, int, int, int)}.
	 */
	@Test
	public void testFlight() {
		Flight flight = new Flight(2015, 12, 20, 7, "UA", "346", "ORD", "MIA", 0730, 0730, 1197, 1139, -20);
		assertEquals(2015, flight.getYear());
		assertEquals(12, flight.getMonth());
		assertEquals(20, flight.getDay());
		assertEquals(7, flight.getDayOfWeek());
		assertEquals("UA", flight.getAirline());
		assertEquals("346", flight.getFlightNumber());
		assertEquals("ORD", flight.getOrigin());
		assertEquals("MIA", flight.getDestination());
		assertEquals(0730, flight.getScheduledDeparture());
		assertEquals(0730, flight.getDeparture());
		assertEquals(1197, flight.getDistance());
		assertEquals(1139, flight.getScheduledArrival());
		assertEquals(-20, flight.getArrivalDelay());
		
	}

}
