package edu.ncsu.csc316.hub_manager.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the AirlineHubManager class
 * @author Aasiyah Feisal
 *
 */
public class AirlineHubManagerTest {

	/**
	 * Tests methods within AirportHubManager
	 */
	@Test
	public void test() {
		AirlineHubManager manager = new AirlineHubManager("input/airports.txt");
		AirlineHubManager empty = new AirlineHubManager("input/empty.txt");
		
		
		AirlineHubManager invalid = new AirlineHubManager("");
		if(invalid.validRead()) {
			fail();
		}
		
		String minFlights = "FlightList[\n";
        minFlights += "   Flight[airport1=ORH, airport2=RDU, distance=576.4],\n";
        minFlights += "   Flight[airport1=SEA, airport2=SFO, distance=679.6],\n";
        minFlights += "   Flight[airport1=MIA, airport2=RDU, distance=702.8],\n";
        minFlights += "   Flight[airport1=DFW, airport2=RDU, distance=1059.7],\n";
        minFlights += "   Flight[airport1=DFW, airport2=SFO, distance=1462.3]\n";
        minFlights += "]";
		String valid = manager.getMinimumFlights();
        
        assertEquals(minFlights, valid);
        
        
        minFlights = "FlightList[\n";
        minFlights += "      No flights connect the provided airports.\n";
        minFlights += "]";
		valid = empty.getMinimumFlights();
		assertEquals(minFlights, valid);
		
		
		
		String hubs = "HubReport[\n";
        hubs += "   RDU has 3 connections.\n";
        hubs += "]";
        valid = manager.getPossibleHubs();
        assertEquals(hubs, valid);
        
        hubs = "HubReport[\n";
        hubs += "   No airports have at least 3 connecting flights.\n";
        hubs += "]";
        valid = empty.getPossibleHubs();
        assertEquals(hubs, valid);
	}

}
