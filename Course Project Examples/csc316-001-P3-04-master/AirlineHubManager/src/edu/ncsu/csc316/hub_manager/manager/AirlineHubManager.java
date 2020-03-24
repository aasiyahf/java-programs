package edu.ncsu.csc316.hub_manager.manager;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.AirportHub;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;
import edu.ncsu.csc316.hub_manager.io.AirportReader;
import edu.ncsu.csc316.hub_manager.list.MultiPurposeList;
import edu.ncsu.csc316.hub_manager.util.MinimumSpanningTreeFinder;

/**
 * Creates an instance of an airline hub manager to keep
 * track of airports and flights
 * @author Aasiyah Feisal
 *
 */
public class AirlineHubManager {
	/** List of airports in the file */
	public MultiPurposeList<Airport> ports;
	/** List of flight between airports */
	public MultiPurposeList<FlightLeg> flights;
	/** Minimum spanning tree finder */
	public MinimumSpanningTreeFinder mstFinder;
	/** List of edges for the minimum spanning tree */
	public MultiPurposeList<FlightLeg> mst;
	/** List of potential hubs */
	public MultiPurposeList<AirportHub> hubs;
	/** Tests if the file was read correctly */
	boolean read;
	
	/**
	 * Starts the manager by attempting to open the specified file and
	 * initializing the state fields
	 * @param fileName the file to be opened
	 */
	public AirlineHubManager(String fileName) {
		AirportReader reader = new AirportReader();
		this.read = false;
		ports = new MultiPurposeList<Airport>();
		
		try {
			ports = reader.getAirports(fileName);
			this.read = true;
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be opened.");
			System.out.println();
		}
		
		flights = reader.getEdgeList(ports);
		mstFinder = new MinimumSpanningTreeFinder();
		mst = mstFinder.kruskalMST(flights, ports);
	}
	
	/**
	 * Returns a string representation of the minimum flight connections
	 * within a file
	 * @return the string representation of connections
	 */
	public String getMinimumFlights() {
		String minFlights = "";
		minFlights = "FlightList[\n";
		
		
		if(mst.size() == 0) {
			minFlights += "      No flights connect the provided airports.\n";
		    minFlights += "]";
			return minFlights;
		}
		
		for(int i = 0; i < mst.size(); i++) {
			String origin = mst.get(i).getOrigin().getAirportCode();
			String dest = mst.get(i).getDestination().getAirportCode();
			
			if(dest.compareTo(origin) < 0) {
				String temp = origin;
				origin = dest;
				dest = temp;
			}
			
			DecimalFormat df = new DecimalFormat("#.0");
			minFlights += "   Flight[airport1=" + origin + ", airport2=" + dest + ", distance=" + df.format(mst.get(i).getDistance());
			if((i + 1) != mst.size()) {
				minFlights += "],\n";
			} else {
				minFlights += "]\n";
			}
		}
		
		minFlights += "]";
		return minFlights;
	}
	
	/**
	 * Returns a string representation of the possible airport hubs
	 * within a file
	 * @return the string representation of airport hubs
	 */
	public String getPossibleHubs() {
		hubs = new MultiPurposeList<AirportHub>();
		String hubString = "";
		
		for(int i = 0; i < ports.size(); i++) {
			AirportHub hub = new AirportHub(ports.get(i), 0);
			hubs.add(i, hub);
		}
		
		for(int i = 0; i < hubs.size(); i++) {
			for(int j = 0; j < mst.size(); j++) {
				String portCode = hubs.get(i).getPotentialHub().getAirportCode();
				String origin = mst.get(j).getOrigin().getAirportCode();
				String dest = mst.get(j).getDestination().getAirportCode();
				
				if(portCode.compareTo(origin) == 0) {
					hubs.get(i).incConnections();
				}
				
				if(portCode.compareTo(dest) == 0) {
					hubs.get(i).incConnections();
				}
			}
		}
		
		hubString = "HubReport[\n";
		for(int i = 0; i < hubs.size(); i++) {
			if(hubs.get(i).getConnections() > 2) {
				hubString += "   " + hubs.get(i).getPotentialHub().getAirportCode() + " has ";
				hubString += hubs.get(i).getConnections() + " connections.\n";
			}
		}
		
		if(hubString.compareTo("HubReport[\n") == 0) {
			hubString += "   No airports have at least 3 connecting flights.\n";
			hubString += "]";
			return hubString;
		} else {
			hubString += "]";
		}
		
		return hubString;
		
	}
	
	/**
	 * Checks if the file was read correctly
	 * @return true if valid read, false otherwise
	 */
	public boolean validRead() {
		return read;
	}
}
