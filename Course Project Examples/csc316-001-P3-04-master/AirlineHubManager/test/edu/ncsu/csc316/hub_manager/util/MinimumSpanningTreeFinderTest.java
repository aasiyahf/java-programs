package edu.ncsu.csc316.hub_manager.util;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;
import edu.ncsu.csc316.hub_manager.io.AirportReader;
import edu.ncsu.csc316.hub_manager.list.MultiPurposeList;

/**
 * Tests the MinimumSpanningTreeFinder class
 * @author Aasiyah Feisal
 *
 */
public class MinimumSpanningTreeFinderTest {

	/**
	 * Tests methods within MinimumSpanningTreeFinder
	 */
	@Test
	public void test() {
		MinimumSpanningTreeFinder mstFinder = new MinimumSpanningTreeFinder();
		
		AirportReader reader = new AirportReader();
		MultiPurposeList<Airport> ports = new MultiPurposeList<Airport>();
		
		try {
			ports = reader.getAirports("input/airports.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be opened");
		}
		
		MultiPurposeList<FlightLeg> flights = reader.getEdgeList(ports);
		
		MultiPurposeList<FlightLeg> mstEdges = mstFinder.kruskalMST(flights, ports);
		assertEquals(5, mstEdges.size());
		assertEquals("ORH", mstEdges.get(0).getOrigin().getAirportCode());
		assertEquals("RDU", mstEdges.get(0).getDestination().getAirportCode());
	}

}
